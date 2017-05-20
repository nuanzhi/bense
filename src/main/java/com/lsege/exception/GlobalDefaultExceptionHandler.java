package com.lsege.exception;

import com.lsege.entity.JsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 创建人: 徐众垚
 * 创建时间: 2017/4/18
 * 公司: 唐山徕思歌科技有限公司
 * 描述: 全局异常处理
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonResult defaultErrorHandler(HttpServletRequest req, Exception e)  {
        e.printStackTrace();
        JsonResult jsonResult = new JsonResult();
        jsonResult.setMessage("坏了报错了");
        jsonResult.setSuccess(false);
        return jsonResult;
    }

}
