package org.starichkov.java.spring.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Vadim Starichkov
 * @since 14.02.2015
 */
@Aspect
public class BeforeAfterAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeforeAfterAspect.class);

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
