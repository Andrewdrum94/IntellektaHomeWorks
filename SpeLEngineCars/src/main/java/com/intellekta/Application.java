package com.intellekta;

import com.intellekta.service.CarTester;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
        CarTester tester = context.getBean(CarTester.class);
        System.out.println(tester);
    }
}
