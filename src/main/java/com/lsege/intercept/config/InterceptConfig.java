package com.lsege.intercept.config;

import com.lsege.intercept.DomainIntercept;
import com.lsege.intercept.RequestIntercept;
import com.lsege.intercept.UrlIntercept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 创建人: 徐众垚
 * 创建时间: 2017/4/15
 * 公司: 唐山徕思歌科技有限公司
 * 描述:
 */
@Configuration
public class InterceptConfig extends WebMvcConfigurerAdapter {

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        /*配置跨域拦截器*/
        registry.addInterceptor(new DomainIntercept())
                .addPathPatterns("/**");

        /*安全认证拦截器*/
        registry.addInterceptor(new RequestIntercept(redisTemplate))
                .addPathPatterns("/**")
                .excludePathPatterns("/toLogin");

        /*操作权限拦截器*/
        registry.addInterceptor(new UrlIntercept(redisTemplate))
                .addPathPatterns("/**")
                .excludePathPatterns("/toLogin")
                .excludePathPatterns("/getRedisToken");

        super.addInterceptors(registry);
    }

}
