package cn.wocloud.demo.common.advice;

import cn.wocloud.demo.common.annotation.IgnoreResponseAdvice;
import cn.wocloud.demo.common.result.CommonResult;
import cn.wocloud.demo.common.result.DefaultErrorResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Author: zyp
 * @Date: 2021/8/9 19:17
 * @Param
 * @return
 * @Version 1.0
 */
@ControllerAdvice
public class ResponseResultAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        if (methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }
        if (methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object object, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (object instanceof CommonResult)
            return object;
        if (object instanceof DefaultErrorResult) {
            DefaultErrorResult defaultErrorResult = DefaultErrorResult.class.cast(object);
            return new CommonResult(defaultErrorResult.getCode(),defaultErrorResult.getMessage(),defaultErrorResult.getErrors());
        }
        return CommonResult.success(object);
    }
}
