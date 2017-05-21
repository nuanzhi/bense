package com.lsege.intercept;

import com.lsege.util.GsonUtil;
import com.lsege.util.SignUtil;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
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
        if(StringUtils.isEmpty(token)){
            json(httpServletResponse,"overdue","utf-8");
            return false;
        }
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
            json(httpServletResponse,"ValidationFails","utf-8");
            return false;
        }
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
