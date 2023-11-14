package com.intellekta.service;

import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Logging {

    public void selectAllMethods() {}

    public void beforeAdvice() {
        System.out.println("Starting to initiate developer’s profile");
    }

    public void afterAdvice() {
        System.out.println("Profile has been initiated.");
    }

}
