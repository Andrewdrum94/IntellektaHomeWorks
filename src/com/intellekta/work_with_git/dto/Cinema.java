package com.intellekta.work_with_git.dto;

public class Cinema {

    private String name;
    private String genre;
    private double duration;

    public Cinema() {
        name = "Some film";
        genre = "Some genre";
        duration = 0;
    }

    public Cinema(String name, String genre, double duration) {
        this.name = name != null && !name.trim().isEmpty() ? name : "Some film";
        this.genre = genre != null && !genre.trim().isEmpty() ? genre : "Some genre";
        this.duration = duration > 0 ? duration : 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name != null && !name.trim().isEmpty() ? name : "Some film";
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre != null && !genre.trim().isEmpty() ? genre : "Some genre";
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration > 0 ? duration : 0;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                '}';
    }
}
