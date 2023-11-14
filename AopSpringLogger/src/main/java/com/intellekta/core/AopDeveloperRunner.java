package com.intellekta.core;

import com.intellekta.target.Developer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.FileSystemXmlApplicationContext;

@Configuration
@EnableAspectJAutoProxy
public class AopDeveloperRunner {

    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("classpath:developer.xml");
        Developer dev = context.getBean(Developer.class);
        System.out.println(dev);
    }
}
