package com.lsege.intercept;

import com.lsege.util.SignUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        Map<String, String> params = new HashMap<>();
        String psign = "";
        Enumeration<String> paraNames = httpServletRequest.getParameterNames();
        for (Enumeration<String> e = paraNames; e.hasMoreElements(); ) {
            String thisName = e.nextElement();
            String thisValue = httpServletRequest.getParameter(thisName);
            if ("sign".equals(thisName)) {
                psign = thisValue;
                continue;
            }
            params.put(thisName, thisValue);
            //System.out.println("key:" + thisName + "--------------value:" + thisValue);
        }

        String sign = SignUtil.createSign(params, true);

        System.out.println(psign);
        System.out.println(sign);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
