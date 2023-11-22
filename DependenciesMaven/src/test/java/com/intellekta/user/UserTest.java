package com.intellekta.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserTest {

    private User user;

    @BeforeEach
    public void createUser() {
        user = new User();
    }

    @ParameterizedTest
    @ValueSource(ints = {18, 25, 99})
    public void checkAgeCorrectionWorkTest(int age) {
        Assertions.assertTrue(user.checkAge(age));
    }

    @ParameterizedTest
    @ValueSource(ints = {-20, 17, 101})
    public void checkPersistentAge(int age) {
        Assertions.assertFalse(user.checkAge(age));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Pas$w0rd"})
    public void checkPasswordCorrectTest(String pass) {
        Assertions.assertTrue(user.checkPassword(pass));
    }

    @ParameterizedTest
    @ValueSource(strings = {"password13!"})
    public void checkPasswordWithoutCapitalLetter(String pass) {
        Assertions.assertFalse(user.checkPassword(pass));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Password!"})
    public void checkPasswordWithoutNumbers(String pass) {
        Assertions.assertFalse(user.checkPassword(pass));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Password123"})
    public void checkPasswordWithoutSpecialCharacters(String pass) {
        Assertions.assertFalse(user.checkPassword(pass));
    }

}
