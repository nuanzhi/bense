package com.lsege.controller.sys;

import com.lsege.entity.JsonResult;
import com.lsege.entity.Menu;
import com.lsege.service.sys.MenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
