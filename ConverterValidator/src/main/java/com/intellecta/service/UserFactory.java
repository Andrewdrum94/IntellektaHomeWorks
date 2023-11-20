package com.intellecta.service;

import com.intellecta.model.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;
import org.springframework.validation.DataBinder;

@Service
public class UserFactory implements Converter<String, User> {

    private final UserValidator validator;

    public UserFactory(UserValidator userValidator) {
        validator = userValidator;
    }

    @Override
    public User convert(String source) {
        if (source == null || source.trim().length() == 0) {
            return null;
        } else {
            String[] parts = source.split(" ");
            User user = new User();
            if (parts.length == 3) {
                try {
                    user = new User(parts[0],
                            Integer.parseInt(parts[1]),
                            parts[2]);
                } catch (NumberFormatException e) {
                    System.out.println("Second argument must be a number");
                    return null;
                }
            } else {
                if (!parts[0].matches("-?\\d+(\\.\\d+)?")) {
                    user.setName(parts[0]);
                    if (parts.length > 1) {
                        if (parts[1].matches("-?\\d+(\\.\\d+)?"))
                            user.setAge(Integer.parseInt(parts[1]));
                    }
                } else {
                    user.setName(null);
                    user.setAge(Integer.parseInt(parts[0]));
                }
            }
            DataBinder dataBinder = new DataBinder(user);
            dataBinder.addValidators(validator);
            dataBinder.validate();
            if (!dataBinder.getBindingResult().hasErrors())
                return user;
            else {
                dataBinder.getBindingResult().getAllErrors().forEach(objectError -> System.out.printf("%s: %s\n", objectError.getClass().getSimpleName(), objectError.getCode()));
                return null;
            }
        }
    }
}
