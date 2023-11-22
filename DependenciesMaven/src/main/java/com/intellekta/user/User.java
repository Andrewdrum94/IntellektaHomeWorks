package com.intellekta.user;

import java.util.Locale;
import java.util.regex.Pattern;

public class User {

    private String name;
    private int age;
    private String password;

    public User(String name, int age, String password) {
        this.name = name;
        this.age = checkAge(age) ? age : 0;
        this.password = checkPassword(password) ? password : "";
    }

    public User() {
    }

    public boolean checkAge(int age) {
        return age >= 18 && age < 100;
    }

    public boolean checkPassword(String password) {
        return !password.equals(password.toLowerCase(Locale.ROOT))
                && password.length() >= 8
                && Pattern.compile("\\p{Nd}").matcher(password).find()
                && Pattern.compile("[^a-z\\d ]", Pattern.CASE_INSENSITIVE).matcher(password).find();
    }

    public User checkUser() {
        if (this.age == 0 || this.password.isEmpty()) {
            return null;
        } else
            return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = checkAge(age) ? age : 0;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = checkPassword(password) ? password : "";
    }
}
