package org.starichkov.java.spring.aop.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Vadim Starichkov
 * @since 14.02.2015
 */
@Aspect
public class AfterReturningAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(AfterReturningAspect.class);

    @Pointcut("execution(* org.starichkov.java.spring.aop.controller.AspectsController.showAfterReturning(Long)) && args(id))")
    public void afterReturning(Long id) {
    }

    @AfterReturning(value = "afterReturning(id)", argNames = "id")
    public void afterReturningHandler(Long id) {
        LOGGER.info("AFTER RETURNING afterReturning WITH PARAM id = {}", id);
    }
}
