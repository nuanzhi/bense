package com.lsege.controller;

import com.lsege.entity.JsonResult;
import com.lsege.entity.sys.Menu;
import com.lsege.entity.sys.Role;
import com.lsege.entity.sys.User;
import com.lsege.service.LoginService;
import com.lsege.util.MenuUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
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
public class LoginController extends BaseController{

    @Autowired
    LoginService loginService;

    @GetMapping(value = "/getRedisToken")
    public JsonResult getRedisToken(String token) {
        JsonResult<Map<String, Object>> jsonResult = new JsonResult<>();
        if (!StringUtils.isEmpty(token)) {
            /*获取redis缓存*/
            ValueOperations<String, Map<String, Object>> operations = redisTemplate.opsForValue();
            jsonResult.setData(operations.get(token));
            jsonResult.setMessage("获取成功");
            jsonResult.setSuccess(true);
        } else {
            jsonResult.setMessage("缺少参数");
            jsonResult.setSuccess(false);
        }
        return jsonResult;
    }

    /**
     * 登录
     *
     * @param account  账号
     * @param password SHA1密码
     * @return JsonResult
     */
    @PostMapping(value = "/toLogin")
    public JsonResult toLogin(String account, String password) throws Exception {
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
                jsonResult.setMessage("用户名或密码错误");
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
                    hasMenu = MenuUtil.beautifyMenu(hasMenu);
                    Map<String, Object> map = new HashMap<>();
                    String token = UUID.randomUUID().toString().replaceAll("-", "");
                    map.put("uId", user.getuId());
                    map.put("uName", user.getuName());
                    map.put("uAccount", user.getuAccount());
                    map.put("token", token);
                    map.put("timestamp", System.currentTimeMillis());
                    map.put("hasMenu", hasMenu);
                    jsonResult.setData(map);
                    /*存入redis缓存*/
                    ValueOperations<String, Map<String, Object>> operations = redisTemplate.opsForValue();
                    operations.set(token, map, 30, TimeUnit.MINUTES);
                    /*移除uid*/
                    map.remove("uId");
                } else {
                    jsonResult.setSuccess(false);
                    jsonResult.setMessage("用户名或密码错误");
                }
            }
        }

        return jsonResult;
    }


}
