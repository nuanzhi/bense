package com.lsege.controller.sys;

import com.google.gson.reflect.TypeToken;
import com.lsege.entity.JsonResult;
import com.lsege.entity.sys.Menu;
import com.lsege.entity.sys.Role;
import com.lsege.entity.vo.RMRelate;
import com.lsege.service.sys.RoleService;
import com.lsege.util.GsonUtil;
import com.lsege.util.MenuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xuzhongyao on 2017/5/13.
 */
@RestController
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping(value = "/getRoleList")
    public JsonResult getRoleList(){
        JsonResult json = new JsonResult();
        List<Role> roles = roleService.getRoleList();
        json.setData(roles);
        json.setSuccess(true);
        json.setMessage("获取成功");
        return json;
    }

    @PostMapping(value = "/addRole")
    public JsonResult addRole(Role role){
        JsonResult json = new JsonResult();
        if(StringUtils.isEmpty(role.getrName())){
            json.setMessage("缺少参数");
            json.setSuccess(false);
        }else{
            roleService.addRole(role);
            json.setSuccess(true);
            json.setData(role);
            json.setMessage("添加成功");
        }

        return json;
    }

    @PostMapping(value = "/editRole")
    public JsonResult editRole(Role role){
        JsonResult json = new JsonResult();
        if(StringUtils.isEmpty(role.getrId())){
            json.setMessage("缺少参数");
            json.setSuccess(false);
        }else{
            roleService.editRole(role);
            json.setSuccess(true);
            json.setData(role);
            json.setMessage("修改成功");
        }
        return json;
    }

    @PostMapping(value = "/removeRole")
    public JsonResult removeRole(Long rId){
        JsonResult json = new JsonResult();
        if(StringUtils.isEmpty(rId)){
            json.setMessage("缺少参数");
            json.setSuccess(false);
        }else{
            Long userCount = roleService.getUserByRoleId(rId);
            if(userCount==0){
                List<Menu> menus = roleService.getMenuByRId(rId);
                if(menus.size()==0){
                    roleService.removeRole(rId);
                    json.setSuccess(true);
                    json.setMessage("删除成功");
                }else{
                    json.setSuccess(false);
                    json.setMessage("请先与菜单解除关联");
                }

            }else{
                json.setSuccess(false);
                json.setMessage("已有\n"+userCount+"\n位用户使用该角色，无法删除");
            }
        }
        return json;
    }

    @GetMapping(value = "/associatedMenu")
    public JsonResult associatedMenu(Long rId){
        JsonResult json = new JsonResult();
        if(StringUtils.isEmpty(rId)){
            json.setMessage("缺少参数");
            json.setSuccess(false);
        }else{
            List<Menu> hasMenu = roleService.associatedMenu(rId);
            hasMenu = MenuUtil.beautifyMenu(hasMenu);
            List<Long> hasMenuMId = MenuUtil.getHasMenu(hasMenu);
            Map<String,Object> map = new HashMap<>();
            map.put("menus",hasMenu);
            map.put("menusMId",hasMenuMId);
            json.setData(map);
            json.setMessage("查询成功");
            json.setSuccess(true);
        }
        return json;
    }

    @PostMapping(value = "/associatedMenuUpdate")
    public JsonResult associatedMenuUpdate(Long rId,String str){
        JsonResult json = new JsonResult();
        if(StringUtils.isEmpty(str) || StringUtils.isEmpty(rId)){
            json.setMessage("缺少参数");
            json.setSuccess(false);
        }else{
            List<RMRelate> menuIds = GsonUtil.getIstance().fromJson(str,new TypeToken<List<RMRelate>>(){}.getType());
            roleService.associatedMenuUpdate(rId,menuIds);
            json.setMessage("关联成功");
            json.setSuccess(true);
        }

        return json;
    }

}
