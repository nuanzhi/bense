package com.lsege.controller.sys;

import com.lsege.entity.JsonResult;
import com.lsege.entity.Menu;
import com.lsege.entity.Role;
import com.lsege.mapper.sys.MenuMapper;
import com.lsege.service.sys.MenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建人: 徐众垚
 * 创建时间: 2017/5/3
 * 公司: 唐山徕思歌科技有限公司
 * 描述:
 */
@RestController
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ApiOperation(value="获取菜单列表", notes="")
    @GetMapping(value = "/getMenuList")
    public JsonResult getMenuList() {
        JsonResult json = new JsonResult();
        List<Menu> menus = menuService.getMenuList();
        json.setData(menus);
        json.setSuccess(true);
        json.setMessage("获取成功");
        return json;
    }

    @GetMapping(value = "/getTopMenuList")
    public JsonResult getTopMenuList() {
        JsonResult json = new JsonResult();
        List<Menu> menus = menuService.getTopMenuList();
        json.setData(menus);
        json.setSuccess(true);
        json.setMessage("获取成功");
        return json;
    }

    @GetMapping(value = "/getMenuChildById")
    public JsonResult getMenuChildById(Long mId) {
        JsonResult json = new JsonResult();
        if(StringUtils.isEmpty(mId)){
            json.setMessage("缺少参数");
            json.setSuccess(false);
        }else{
            List<Menu> menus = menuService.getMenuChildById(mId);
            json.setData(menus);
            json.setSuccess(true);
            json.setMessage("获取成功");
        }
        return json;
    }

    @GetMapping(value = "/addMenu")
    public JsonResult addMenu(String mName,String mUrl,Long mPId,Long mShowId){
        JsonResult json = new JsonResult();
        Menu menu = new Menu(mName,mUrl,mPId,null,mShowId);
        if(mPId==1){
            menu.setmTag("top");
        }else{
            menu.setmTag("secondary");
        }
        menuService.addMenu(menu);
        json.setData(menu);
        json.setSuccess(true);
        json.setMessage("添加成功");
        return json;
    }

    @GetMapping("/editMenu")
    public JsonResult editMenu(Menu menu){
        JsonResult json = new JsonResult();
        if(StringUtils.isEmpty(menu.getmId())){
            json.setMessage("缺少参数");
            json.setSuccess(false);
        }else{
            menuService.editMenu(menu);
            /*List<Menu> menus = new ArrayList<>();
            if(menu.getmTag().equals("top")){
                menus = menuService.getTopMenuListNotRoot();
            }else{
                menus = menuService.getMenuChildByIdNotSelf(menu.getmPId());
            }
            json.setData(menus);*/
            json.setData(menu);
            json.setSuccess(true);
            json.setMessage("修改成功");
        }
        return json;
    }

    @GetMapping("/removeMenu")
    public JsonResult removeMenu(Long mId){
        JsonResult json = new JsonResult();
        if(StringUtils.isEmpty(mId)){
            json.setMessage("缺少参数");
            json.setSuccess(false);
        }else{
            List<Menu> menus = menuService.getMenuChildByIdNotSelf(mId);
            if(menus.size()==0){
                List<Role> roles = menuService.getRoleByMid(mId);
                if(roles.size()==0){
                    menuService.removeMenu(mId);
                    List<Menu> topMenuList = menuService.getTopMenuList();
                    json.setData(topMenuList);
                    json.setMessage("删除成功");
                    json.setSuccess(true);
                }else{
                    json.setMessage("请先与角色解除关联");
                    json.setSuccess(false);
                }
            } else{
                json.setMessage("请先删除子节点");
                json.setSuccess(false);
            }
        }
        return json;
    }

}
