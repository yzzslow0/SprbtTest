package com.yzz.springboot;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Yzz
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
@EnableTransactionManagement(proxyTargetClass=true)
@EnableJpaRepositories(basePackages={"com.yzz.**.repository"})
@EntityScan(basePackages={"com.yzz.**.bean"})

public class JpaConfiguration {
//    @Bean
//    PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor(){
//        return new PersistenceExceptionTranslationPostProcessor();
//    }
}