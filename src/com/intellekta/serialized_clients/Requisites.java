package com.intellekta.serialized_clients;

import java.io.Serializable;

@SuppressWarnings("unused")
public class Requisites implements Serializable {

    private String name;
    private String value;

    public Requisites(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Requisites{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Requisites() {}
}
