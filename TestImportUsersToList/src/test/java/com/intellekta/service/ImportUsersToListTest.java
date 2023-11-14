package com.intellekta.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class ImportUsersToListTest {

    public static String PATH = "src/main/resources/users.txt";


    @Test
    public void importUsersToListTestWithNullParam() {
        Assertions.assertDoesNotThrow(() -> ImportUsersToList.importUsersToList(null));
    }

    @Test
    public void importUsersToListWrongPathTest() {
        Assertions.assertDoesNotThrow(() -> ImportUsersToList.importUsersToList("troll"));
    }

    @Test
    public void importUsersToListFileUnreadableFileTest() {
        Assertions.assertDoesNotThrow(() -> ImportUsersToList.importUsersToList(PATH));
    }

    @Test
    public void importUsersToListFromEmptyFileTest() {
        File file = new File("src/main/resources/test.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("Created");
                file.deleteOnExit();
            } else
                System.out.println("Exists");
            Assertions.assertDoesNotThrow(() -> ImportUsersToList.importUsersToList(file.getPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
