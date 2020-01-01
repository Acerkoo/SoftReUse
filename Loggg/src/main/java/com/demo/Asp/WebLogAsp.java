package com.demo.Asp;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class WebLogAsp {

    private static Logger logger = LoggerFactory.getLogger(WebLogAsp.class);

    @Pointcut("execution(public * com.demo.controller.*.*(..))")
    public void controllerLog() {}

    @Before("controllerLog()")
    public void beforeAdvice(JoinPoint joinPoint) {
        logger.info("前置通知开始--->");

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();

        logger.info("URL-->" + request.getRequestURL().toString());
        logger.info("Ip-->" + request.getRemoteAddr());
        logger.info("HTTP_Method-->" + request.getMethod());
        logger.info("Request_args-->" + Arrays.toString(joinPoint.getArgs()));

        logger.info("前置通知结束--->");

    }

    @AfterReturning(value = "controllerLog()", returning = "obj")
    public void afterReturning(JoinPoint joinPoint, Object obj) {
        logger.info("后置通知正常返回-->" + obj);
    }
}
