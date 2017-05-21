package com.lsege.controller.sys;

import com.google.gson.reflect.TypeToken;
import com.lsege.controller.BaseController;
import com.lsege.entity.JsonResult;
import com.lsege.entity.sys.Role;
import com.lsege.entity.sys.User;
import com.lsege.service.sys.RoleService;
import com.lsege.service.sys.UserService;
import com.lsege.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by xuzhongyao on 2017/5/18.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @GetMapping(value = "/getUsers")
    public JsonResult getUsers() {
        JsonResult json = new JsonResult();
        List<User> users = userService.getUsers();
        json.setSuccess(true);
        json.setMessage("获取成功");
        json.setData(users);
        return json;
    }

    @GetMapping(value = "/getRoleList")
    public JsonResult getRoleList() {
        JsonResult json = new JsonResult();
        List<Role> roles = roleService.getRoleList();
        json.setData(roles);
        json.setSuccess(true);
        json.setMessage("获取成功");
        return json;
    }

    @PostMapping(value = "/addUser")
    public JsonResult addUser(String uAccount, String uName, String uPassword, String str, HttpServletRequest request) {
        JsonResult json = new JsonResult();

        if (StringUtils.isEmpty(uAccount) || StringUtils.isEmpty(uName) || StringUtils.isEmpty(uPassword)) {
            json.setSuccess(false);
            json.setMessage("缺少参数");
        } else {
            Map<String, Object> redisUserInfo = getRedisUser(request);
            Long uId = redisUserInfo.get("uId") != null ? (Long) redisUserInfo.get("uId") : null;
            List<Long> roleIds = GsonUtil.getIstance().fromJson(str, new TypeToken<List<Long>>() {
            }.getType());
            userService.addUser(new User(uAccount, uPassword, uName, uId), roleIds);
            json.setSuccess(true);
            json.setMessage("添加成功");
        }
        return json;
    }


}
