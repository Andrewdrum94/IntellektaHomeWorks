package com.intellekta;

import com.intellekta.service.ResourceLoaderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class ResourceLoaderApplication {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        SpringApplication.run(ResourceLoaderApplication.class, args);
        ApplicationContext context = new AnnotationConfigApplicationContext(ResourceLoaderApplication.class);

        ResourceLoaderService service = context.getBean(ResourceLoaderService.class);
        service.showResourceDataUsingFilePath();

    }
}
