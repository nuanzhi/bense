package com.lsege.intercept;

import com.google.gson.reflect.TypeToken;
import com.lsege.entity.Menu;
import com.lsege.util.CreateSecrteKey;
import com.lsege.util.GsonUtil;
import com.lsege.util.MenuUtil;
import com.lsege.util.SignUtil;
import org.omg.PortableServer.POAManagerPackage.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.SessionProperties;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.crypto.Cipher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Key;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建人: 徐众垚
 * 创建时间: 2017/4/15
 * 公司: 唐山徕思歌科技有限公司
 * 描述:
 */
public class RequestIntercept implements HandlerInterceptor {

    private RedisTemplate redisTemplate = null;

    public RequestIntercept(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        Map<String, String> params = new HashMap<>();
        String psign = httpServletRequest.getParameter("sign");
        String token = httpServletRequest.getParameter("token");
        Enumeration<String> paraNames = httpServletRequest.getParameterNames();
        for (Enumeration<String> e = paraNames; e.hasMoreElements(); ) {
            String thisName = e.nextElement();
            String thisValue = httpServletRequest.getParameter(thisName);
            if ("sign".equals(thisName)) {
                continue;
            }
            params.put(thisName, thisValue);
        }
        String sign = SignUtil.createSign(params, false);
        if(psign.equals(sign)){
            return true;
        }else{
            httpServletResponse.setStatus(403);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
