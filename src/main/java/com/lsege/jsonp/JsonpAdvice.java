package com.lsege.jsonp;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * 创建人: 徐众垚
 * 创建时间: 2017/5/10
 * 公司: 唐山徕思歌科技有限公司
 * 描述:
 */
@ControllerAdvice(basePackages = {"com.lsege.controller", "com.lsege.exception"})
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {
    public JsonpAdvice() {

        super("callback", "jsonp");
    }
}
