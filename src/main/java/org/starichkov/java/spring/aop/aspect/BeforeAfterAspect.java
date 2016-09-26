package org.starichkov.java.spring.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author Vadim Starichkov
 * @since 14.02.2015
 */
@Aspect
public class BeforeAfterAspect extends AbstractAspect {

    @Pointcut("execution(* org.starichkov.java.spring.aop.controller.AspectsController.printWelcome(..))")
    public void printWelcome() {
    }

    @Before("printWelcome()")
    public void beforePrintWelcome() {
        LOGGER.info("BEFORE printWelcome");
    }

    @After("printWelcome()")
    public void afterPrintWelcome() {
        LOGGER.info("AFTER printWelcome");
    }
}
