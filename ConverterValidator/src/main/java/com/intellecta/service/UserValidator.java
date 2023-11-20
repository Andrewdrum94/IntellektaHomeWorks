package com.intellecta.service;

import com.intellecta.model.User;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Service
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        User user = (User) target;
        if (user.getAge() < 0)
            errors.rejectValue("age", "negativeValue");
        else if (user.getAge() > 120)
            errors.rejectValue("age", "too.darn.old");
    }
}
