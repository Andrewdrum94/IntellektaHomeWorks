package com.intellekta.work_with_git.service;

import com.intellekta.work_with_git.dto.Viewer;

import java.util.List;

public class ViewerStatistics {

    public static int averageAge(List<Viewer> list) {
        int averageAge = 0;
        int countOfViewers = 0;
        if (list == null || list.isEmpty()) {
            return 0;
        } else {
            for (Viewer viewer : list) {
                if (viewer != null) {
                    averageAge += viewer.getAge();
                    countOfViewers++;
                }
            }
        }
        return Math.round((float) averageAge / countOfViewers);
    }
}
