package org.starichkov.java.spring.aop.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author Vadim Starichkov
 * @since 14.02.2015
 */
@Aspect
public class AfterThrowingAspect extends AbstractAspect {

    @Pointcut("execution(* org.starichkov.java.spring.aop.controller.AspectsController.showAfterThrowing())")
    public void afterThrowing() {
    }

    @Pointcut("execution(* org.starichkov.java.spring.aop.controller.AspectsController.showAfterThrowingNone())")
    public void afterThrowingNone() {
    }

    @AfterThrowing(value = "afterThrowing()")
    public void afterThrowingHandler() {
        LOGGER.info("AFTER THROWING afterThrowing");
    }

    @AfterThrowing(value = "afterThrowingNone()")
    public void afterThrowingNoneHandler() {
        LOGGER.info("AFTER THROWING afterThrowingNone");
    }
}
