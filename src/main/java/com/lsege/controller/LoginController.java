package com.lsege.controller;

import com.lsege.entity.JsonResult;
import com.lsege.entity.Key;
import com.lsege.entity.User;
import com.lsege.mapper.LoginMapper;
import com.lsege.util.CreateSecrteKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * 创建人: 徐众垚
 * 创建时间: 2017/4/15
 * 公司: 唐山徕思歌科技有限公司
 * 描述:
 */
@RestController
public class LoginController {

    @Autowired
    LoginMapper loginMapper;

    private Map<String, String> loginReqKey = new HashMap<>();

    @GetMapping(value = "/loginRequest")
    public JsonResult loginRequest(){

        JsonResult jsonResult = new JsonResult();
        Map<String, Object> keyMap = null;
        try {
            keyMap = CreateSecrteKey.initKey();
            String publicKey = CreateSecrteKey.getPublicKey(keyMap);
            String privateKey = CreateSecrteKey.getPrivateKey(keyMap);
            jsonResult.setData(new Key(publicKey,"ㄟ(▔,▔)ㄏ"));
            jsonResult.setSuccess(true);
            jsonResult.setMessage("获取密钥成功");
            loginReqKey.put(publicKey,privateKey);
        } catch (Exception e) {
            e.printStackTrace();
            jsonResult.setSuccess(false);
            jsonResult.setMessage("获取密钥失败");
        }

        return jsonResult;
    }

    /**
     * 登录
     * @param account 账号
     * @param password SHA1密码
     * @return JsonResult
     */
    @PostMapping(value = "/toLogin")
    public JsonResult toLogin(String account, String password){
        boolean parameter = true;
        JsonResult<Map<String,Object>> jsonResult = new JsonResult<>();
        if(StringUtils.isEmpty(account)){
            jsonResult.setSuccess(false);
            jsonResult.setMessage("请输入用户名");
            parameter = false;
        }
        if(StringUtils.isEmpty(password)){
            jsonResult.setSuccess(false);
            jsonResult.setMessage("请输入密码");
            parameter = false;
        }
        if(parameter){
            User user = loginMapper.login(account);
            if(user==null){
                jsonResult.setSuccess(false);
                jsonResult.setMessage("未找到该用户");
            }else{
                if(user.getuPassword().equals(password)){
                    jsonResult.setSuccess(true);
                    jsonResult.setMessage("登录成功");
                    Map<String,Object> map = new HashMap<>();
                    String token = UUID.randomUUID().toString().replaceAll("-","");
                    map.put("uName",user.getuName());
                    map.put("uAccount",user.getuAccount());
                    map.put("token", token);
                    jsonResult.setData(map);
                }else {
                    jsonResult.setSuccess(false);
                    jsonResult.setMessage("密码错误");
                }
            }
        }

        return jsonResult;
    }


}
