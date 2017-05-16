package com.lsege.controller.sys;

import com.lsege.entity.JsonResult;
import com.lsege.entity.Menu;
import com.lsege.entity.Role;
import com.lsege.entity.User;
import com.lsege.service.sys.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping(value = "/addRole")
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

    @GetMapping(value = "/editRole")
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

    @GetMapping(value = "/removeRole")
    public JsonResult removeRole(Long rId){
        JsonResult json = new JsonResult();
        if(StringUtils.isEmpty(rId)){
            json.setMessage("缺少参数");
            json.setSuccess(false);
        }else{
            Long userCount = roleService.getUserByRoleId(rId);
            if(userCount==0){
                roleService.removeRole(rId);
                json.setSuccess(true);
                json.setMessage("删除成功");
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
           List<Menu> menus = roleService.associatedMenu(rId);
        }
        return json;
    }

}
