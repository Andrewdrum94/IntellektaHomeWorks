package com.intellekta.work_with_git.dto;

@SuppressWarnings("unused")
public class Viewer {

    private String nickname;
    private int age;
    private int numberOfWatchedFilms;

    public Viewer(String nickname, int age, int numberOfWatchedFilms) {
        this.nickname = nickname != null && !nickname.trim().isEmpty() ? nickname : "Viewer";
        this.age = Math.max(age, 0);
        this.numberOfWatchedFilms = Math.max(numberOfWatchedFilms, 0);
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname != null && !nickname.trim().isEmpty() ? nickname : "Viewer";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = Math.max(age, 0);
    }

    public int getNumberOfWatchedFilms() {
        return numberOfWatchedFilms;
    }

    public void setNumberOfWatchedFilms(int numberOfWatchedFilms) {
        this.numberOfWatchedFilms = Math.max(numberOfWatchedFilms, 0);
    }
}
