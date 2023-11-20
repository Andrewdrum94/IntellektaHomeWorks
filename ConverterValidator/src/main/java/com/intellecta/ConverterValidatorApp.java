package com.intellecta;

import com.intellecta.model.User;
import com.intellecta.service.UserFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ConverterValidatorApp {

    public static void main(String[] args) {
        SpringApplication.run(ConverterValidatorApp.class, args);

        ApplicationContext context = new AnnotationConfigApplicationContext(ConverterValidatorApp.class);
        UserFactory factory = context.getBean(UserFactory.class);
        User p = factory.convert("fasdg234 23");
        if(p != null)
            System.out.printf("%s is %d years old with email %s",p.getName(), p.getAge(), p.getEmail() );
    }
}
