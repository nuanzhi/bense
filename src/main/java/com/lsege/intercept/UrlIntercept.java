package com.lsege.intercept;

import com.lsege.entity.Menu;
import com.lsege.util.MenuUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by xuzhongyao on 2017/5/20.
 */
public class UrlIntercept implements HandlerInterceptor {

    private RedisTemplate redisTemplate = null;

    public UrlIntercept(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String token = httpServletRequest.getParameter("token");
        String path = httpServletRequest.getServletPath();
        ValueOperations<String, Map<String, Object>> operations = redisTemplate.opsForValue();
        Map<String, Object> redis = operations.get(token);
        List<Menu> hasMenu = (List<Menu>) redis.get("hasMenu");
        List<String> rexs = MenuUtil.getInterceptUrl(hasMenu);
        boolean pass = false;
        for (String rex : rexs) {
            if (path.matches(rex)) {
                pass = true;
                continue;
            }
        }
        if(!pass){
            httpServletResponse.setStatus(401);
        }
        return pass;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
