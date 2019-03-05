package com.objectified.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class AspectConfig {
	 @Bean
     public TransactionBeginAspect myAspect() {
         return new TransactionBeginAspect();
     }
}  