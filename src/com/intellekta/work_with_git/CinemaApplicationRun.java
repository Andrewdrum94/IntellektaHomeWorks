package com.intellekta.work_with_git;

import com.intellekta.work_with_git.dto.Viewer;
import com.intellekta.work_with_git.service.ViewerStatistics;

import java.util.ArrayList;
import java.util.List;

public class CinemaApplicationRun {

    public static void main(String[] args) {
        List<Viewer> viewers = new ArrayList<>(List.of(
                new Viewer("John", 25, null),
                new Viewer("Sarah", 18, List.of(new Cinema(), new Cinema("Harry Potter", "fantasy", 2.5))),
                new Viewer("Bill", 39, List.of(new Cinema(), new Cinema(), new Cinema("Lord of the Rings", "fantasy", 3))),
                new Viewer("Purl", 89, null),
                new Viewer("Kitty", 13, List.of(new Cinema("Puaro Agata Kristi", "detective", 2), new Cinema()))
        ));

        System.out.println(ViewerStatistics.averageAge(viewers));
    }
}
