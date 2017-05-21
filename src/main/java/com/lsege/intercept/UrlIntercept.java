package com.lsege.intercept;

import com.lsege.entity.sys.Menu;
import com.lsege.util.GsonUtil;
import com.lsege.util.MenuUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
        if(StringUtils.isEmpty(token)){
            json(httpServletResponse,"overdue","utf-8");
            return false;
        }
        ValueOperations<String, Map<String, Object>> operations = redisTemplate.opsForValue();
        Map<String, Object> redis = operations.get(token);
        if(redis==null){
            json(httpServletResponse,"overdue","utf-8");
            return false;
        }
        List<Menu> hasMenu = (List<Menu>) redis.get("hasMenu");
        List<String> rexs = MenuUtil.getInterceptUrl(hasMenu);
        boolean pass = false;
        for (String rex : rexs) {
            if (path.matches(rex)) {
                pass = true;
                continue;
            }
        }

        if(pass){
            operations.set(token, redis, 30, TimeUnit.MINUTES);
        }else{
            json(httpServletResponse,"unauthorized","utf-8");
            return false;
        }

        return pass;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    public static void json(HttpServletResponse response, Object data, String encoding){
        //设置编码格式
        response.setContentType("text/plain;charset=" + encoding);
        response.setCharacterEncoding(encoding);

        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.write(GsonUtil.getIstance().toJson(data));
            out.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
