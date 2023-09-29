package com.intellekta.generics.middleearth;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Army<T extends Unit & SpecificUnit> {

    private List<T> army;
    private static Random random = new Random();

    public Army() {
        army = new ArrayList<>();
    }

    public List<T> getCavalry() {
        return army.stream().filter(unit -> unit instanceof Cavalry).collect(Collectors.toList());
    }

    public List<T> getInfantry() {
        return army.stream().filter(unit -> unit instanceof Infantry).collect(Collectors.toList());
    }

    public boolean recruit(T unit) {
        if (unit == null)
            return false;
        else
            return army.add(unit);
    }

    public void print() {
        getCavalry().forEach(System.out::println);
        getInfantry().forEach(System.out::println);
    }

    public boolean release(T unit) {
        if (unit == null)
            return false;
        else
            return army.remove(unit);
    }

    public T getRandomUnit() {
        int index = random.nextInt(army.size());
        return index < army.size() ? army.get(index) : null;
    }

    public T getRandomUnit(T unit) {
        if (unit == null)
            return null;
        else if (unit instanceof Cavalry) {
            var cavalry = getCavalry();
            return cavalry.get(random.nextInt(cavalry.size()));
        } else if (unit instanceof Infantry) {
            var infantry = getInfantry();
            return infantry.get(random.nextInt(infantry.size()));
        } else return null;
    }
}
