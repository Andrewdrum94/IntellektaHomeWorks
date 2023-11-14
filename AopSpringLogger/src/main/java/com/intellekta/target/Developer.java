package com.intellekta.target;

@SuppressWarnings("unused")
public class Developer {

    private String name;
    private String specialization;
    private String experience;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return String.format("Developer:\nName: %s\nSpecialization: %s\nExperience: %s.", name, specialization, experience);
    }
}
