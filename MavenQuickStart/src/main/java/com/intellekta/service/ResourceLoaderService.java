package com.intellekta.service;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class ResourceLoaderService implements ResourceLoaderAware {

    private ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void showResourceDataUsingFilePath() {
        Resource resource = resourceLoader.getResource("classpath:users.txt");
        try {
            File file = resource.getFile();
            if (file.exists() && file.canRead()) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
                String input;
                while ((input = reader.readLine()) != null) {
                    if (!input.trim().isEmpty())
                        System.out.println(input);
                }
                reader.close();
            }
        } catch (IOException e) {
            System.out.println("Файл не найден или недоступен для чтения");
        }
    }
}
