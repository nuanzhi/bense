package com.lsege.controller;

import com.lsege.entity.JsonResult;
import com.lsege.entity.Menu;
import com.lsege.entity.Role;
import com.lsege.entity.User;
import com.lsege.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 创建人: 徐众垚
 * 创建时间: 2017/4/15
 * 公司: 唐山徕思歌科技有限公司
 * 描述:
 */
@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 登录
     *
     * @param account  账号
     * @param password SHA1密码
     * @return JsonResult
     */
    @PostMapping(value = "/toLogin")
    public JsonResult toLogin(String account, String password) {
        boolean parameter = true;
        JsonResult<Map<String, Object>> jsonResult = new JsonResult<>();
        if (StringUtils.isEmpty(account)) {
            jsonResult.setSuccess(false);
            jsonResult.setMessage("请输入用户名");
            parameter = false;
        }
        if (StringUtils.isEmpty(password)) {
            jsonResult.setSuccess(false);
            jsonResult.setMessage("请输入密码");
            parameter = false;
        }
        if (parameter) {
            User user = loginService.toLogin(account);
            if (user == null) {
                jsonResult.setSuccess(false);
                jsonResult.setMessage("未找到该用户");
            } else {
                if (user.getuPassword().equals(password)) {
                    jsonResult.setSuccess(true);
                    jsonResult.setMessage("登录成功");
                    /*获取用户角色信息*/
                    List<Role> roles = loginService.getUserRoles(user.getuId());
                    /*获取角色菜单列表*/
                    List<Menu> hasMenu = new ArrayList<>();
                    for (Role r : roles) {
                        hasMenu.addAll(loginService.getRoleHasMenu(r.getrId()));
                    }
                    Map<String, Object> map = new HashMap<>();
                    String token = UUID.randomUUID().toString().replaceAll("-", "");
                    map.put("uName", user.getuName());
                    map.put("uAccount", user.getuAccount());
                    map.put("token", token);
                    map.put("hasMenu", hasMenu);
                    map.put("timestamp", System.currentTimeMillis());
                    jsonResult.setData(map);
                    /*存入redis缓存*/
                    ValueOperations<String, Map<String, Object>> operations = redisTemplate.opsForValue();
                    operations.set(user.getuAccount() + "_token", map, 5, TimeUnit.MINUTES);
                } else {
                    jsonResult.setSuccess(false);
                    jsonResult.setMessage("密码错误");
                }
            }
        }

        return jsonResult;
    }


}
