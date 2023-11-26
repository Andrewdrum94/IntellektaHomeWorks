package com.intellekta.work_with_git;

import com.intellekta.work_with_git.dto.Viewer;
import com.intellekta.work_with_git.service.ViewerStatistics;

import java.util.ArrayList;
import java.util.List;

public class CinemaApplicationRun {

    public static void main(String[] args) {
        List<Viewer> viewers = new ArrayList<>(List.of(
                new Viewer("John", 25, 5),
                new Viewer("Sarah", 18, 12),
                new Viewer("Bill", 39, 173),
                new Viewer("Purl", 89, 205),
                new Viewer("Kitty", 13, 4)
        ));

        System.out.println(ViewerStatistics.averageAge(viewers));
    }
}
