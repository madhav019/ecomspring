package com.madhav.ecomspring.productservice.advice;

import com.madhav.ecomspring.productservice.config.ApiResponseProperties;
import com.madhav.ecomspring.productservice.dto.response.ErrorResponse;
import com.madhav.ecomspring.productservice.dto.response.SuccessResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class ApiResponseAdvisor implements ResponseBodyAdvice<Object> {

    private final AntPathMatcher pathMatcher = new AntPathMatcher();
    private final ApiResponseProperties apiResponseProperties;

    public ApiResponseAdvisor(ApiResponseProperties apiResponseProperties) {
        this.apiResponseProperties = apiResponseProperties;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {

        Class<?> controllerClass = returnType.getContainingClass();
        if (!controllerClass.isAnnotationPresent(RestController.class)) {
            return false;
        }

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String requestPath = attributes.getRequest().getRequestURI();

        for(String excluded: apiResponseProperties.getExcludedPaths()) {
            if(pathMatcher.match(excluded, requestPath)) {
                return false;
            }
        }

        // TODO: Exclude specific paths if needed

        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        if (body instanceof SuccessResponse || body instanceof ErrorResponse) {
            return body;
        }

        return new SuccessResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), request.getURI().getPath(), body);
    }
}
