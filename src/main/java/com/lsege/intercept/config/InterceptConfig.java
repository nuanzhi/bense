package com.lsege.intercept.config;

import com.lsege.intercept.DomainIntercept;
import com.lsege.intercept.RequestIntercept;
import org.springframework.context.annotation.Configuration;
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

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        /*配置跨域拦截器*/
        registry.addInterceptor(new DomainIntercept())
                .addPathPatterns("/**");

        /*安全认证拦截器*/
        registry.addInterceptor(new RequestIntercept())
                .addPathPatterns("/**")
                .excludePathPatterns("/toLogin");

        super.addInterceptors(registry);
    }

}
