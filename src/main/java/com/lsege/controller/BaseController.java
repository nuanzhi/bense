package com.lsege.controller;

import com.lsege.entity.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 创建人: 徐众垚
 * 创建时间: 2017/4/15
 * 公司: 唐山徕思歌科技有限公司
 * 描述:
 */
public class BaseController {

    @Autowired
    RedisTemplate redisTemplate;

    public Map<String,Object> getRedisUser(HttpServletRequest request){
        String token = request.getParameter("token");
        Map<String,Object> map = null;
        if (!StringUtils.isEmpty(token)) {
            ValueOperations<String, Map<String, Object>> operations = redisTemplate.opsForValue();
            map = operations.get(token);
        }
        return map;
    }

}
