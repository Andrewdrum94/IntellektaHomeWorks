package com.intellekta.work_with_git.dto;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Viewer {

    private String nickname;
    private int age;
    private final List<Cinema> cinemas = new ArrayList<>();

    private int numberOfWatchedFilms;


    public Viewer(String nickname, int age, List<Cinema> films) {
        this.nickname = nickname != null && !nickname.trim().isEmpty() ? nickname : "Viewer";
        this.age = Math.max(age, 0);
        if (films != null && !films.isEmpty()) {
            for (Cinema film : films) {
                if (film != null)
                    cinemas.add(film);
            }
        }
        this.numberOfWatchedFilms = cinemas.size();
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

    public void setCinemas(List<Cinema> films) {
        if (films != null && !films.isEmpty()) {
            for (Cinema film : films) {
                if (film != null)
                    cinemas.add(film);
            }
        }
        numberOfWatchedFilms = cinemas.size();
    }

    public void setCinemas(Cinema film) {
        if (film != null)
            cinemas.add(film);
        numberOfWatchedFilms = cinemas.size();
    }

    public List<Cinema> getCinemas() {
        return cinemas;
    }

    @Override
    public String toString() {
        return "Viewer{" +
                "nickname='" + nickname + '\'' +
                ", age=" + age +
                ", numberOfWatchedFilms=" + numberOfWatchedFilms +
                ", cinemas=" + cinemas +
                '}';
    }
}
