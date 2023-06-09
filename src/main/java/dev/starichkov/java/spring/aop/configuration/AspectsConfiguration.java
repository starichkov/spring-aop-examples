package dev.starichkov.java.spring.aop.configuration;

import dev.starichkov.java.spring.aop.aspect.AfterReturningAspect;
import dev.starichkov.java.spring.aop.aspect.AfterThrowingAspect;
import dev.starichkov.java.spring.aop.aspect.AroundAspect;
import dev.starichkov.java.spring.aop.aspect.BeforeAfterAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Vadim Starichkov
 * @since 19.12.2014
 */
@Configuration
@EnableAspectJAutoProxy
public class AspectsConfiguration {

    @Bean
    public AfterReturningAspect afterReturningAspect() {
        return new AfterReturningAspect();
    }

    @Bean
    public AfterThrowingAspect afterThrowingAspect() {
        return new AfterThrowingAspect();
    }

    @Bean
    public AroundAspect aroundAspect() {
        return new AroundAspect();
    }

    @Bean
    public BeforeAfterAspect beforeAfterAspect() {
        return new BeforeAfterAspect();
    }
}
