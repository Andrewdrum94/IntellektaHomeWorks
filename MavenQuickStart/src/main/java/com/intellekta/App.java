package com.intellekta;

import com.intellekta.service.ResourceLoaderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);

        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        ResourceLoaderService service = context.getBean(ResourceLoaderService.class);
        service.showResourceDataUsingFilePath();
    }
}
