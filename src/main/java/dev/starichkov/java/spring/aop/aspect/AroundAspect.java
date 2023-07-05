package dev.starichkov.java.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.http.HttpServletRequest;

/**
 * @author Vadim Starichkov
 * @since 19.12.2014
 */
@Aspect
public class AroundAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(AroundAspect.class);

    @Pointcut(value = "execution(* dev.starichkov.java.spring.aop.controller.AspectsController.showAround(jakarta.servlet.http.HttpServletRequest, String)) && args(request, arg))", argNames = "request, arg")
    public void showAround(HttpServletRequest request, String arg) {
    }

    @Around(value = "showAround(request, arg)", argNames = "joinPoint, request, arg")
    public Object aroundHandler(ProceedingJoinPoint joinPoint, HttpServletRequest request, String arg) throws Throwable {
        LOGGER.info("AROUND HANDLER - BEFORE showAround, ARG: {}", arg);
        Object result = joinPoint.proceed();
        LOGGER.info("AROUND HANDLER - AFTER showAround, ARG: {}", arg);
        LOGGER.info("AROUND HANDLER - AFTER showAround, RESULT: {}", result);
        return result;
    }

    @Pointcut(value = "execution(* dev.starichkov.java.spring.aop.controller..*.*(jakarta.servlet.http.HttpServletRequest, ..)) && args(request, ..))", argNames = "request")
    public void aroundMultiple(HttpServletRequest request) {
    }

    @Around(value = "aroundMultiple(request)", argNames = "joinPoint, request")
    public Object aroundMultipleHandler(ProceedingJoinPoint joinPoint, HttpServletRequest request) throws Throwable {
        LOGGER.info("AROUND HANDLER - BEFORE showAround");
        Object result = joinPoint.proceed();
        LOGGER.info("AROUND HANDLER - AFTER showAround");
        LOGGER.info("AROUND HANDLER - AFTER showAround, RESULT: {}", result);
        return result;
    }
}
