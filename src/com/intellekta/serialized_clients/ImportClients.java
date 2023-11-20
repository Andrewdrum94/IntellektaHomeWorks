package com.intellekta.serialized_clients;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ImportClients {

    @SuppressWarnings("unused")
    public static List<Clients> cardsToClients(String path) {
        List<Clients> clients = new ArrayList<>();
        if (path != null && !path.trim().isEmpty()) {
            List<String> fileNames = new ArrayList<>();
            File[] files = new File(path).listFiles();
            File zipFile = null;
            if (files != null && files.length != 0) {
                for (int i = 0; i < files.length && zipFile == null; i++) {
                    if (files[i] != null && files[i].getName().contains("zip"))
                        zipFile = files[i];
                }
                if (zipFile != null && zipFile.canRead() && zipFile.length() != 0) {
                    try (var zin = new ZipInputStream(new FileInputStream(zipFile))
                    ) {
                        ZipEntry entry;
                        String name;
                        while ((entry = zin.getNextEntry()) != null) {
                            name = entry.getName();
                            fileNames.add(name);
                            var out = new FileOutputStream(path + "/" + name);
                            for (int c = zin.read(), i = 0; c != -1; c = zin.read(), i++) {
                                out.write(c);
                            }
                            out.flush();
                            zin.closeEntry();
                            out.close();
                        }
                    } catch (IOException e) {
                        System.out.println("Files not extract");
                    }
                }
                for (String name : fileNames) {
                    try (var input = new ObjectInputStream(new FileInputStream(path + "/" + name))) {
                        Clients client;
                        if ((client = (Clients) input.readObject()) != null)
                            clients.add(client);
                    } catch (IOException | ClassNotFoundException e) {
                        return clients;
                    }
                }
            }
            return clients;
        }
        return clients;
    }

    public static void checkImport(List<Clients> clients) {
        if (clients == null || clients.isEmpty())
            System.out.println("Import failed");
        else {
            for (Clients client : clients) {
                if (client != null) {
                    Requisites inn = null;
                    Requisites okved = null;
                    for (Requisites requisite : client.getRequisites()) {
                        if (requisite.getName().equalsIgnoreCase("инн"))
                            inn = requisite;
                        if (requisite.getName().equalsIgnoreCase("оквэд"))
                            okved = requisite;
                    }
                    System.out.printf("%s, %s, %s, %s\n", client.getName(), client.getContactPerson().getName(),
                            inn != null ? inn.getValue() : "ИНН реквизиты не найдены",
                            okved != null ? okved.getValue() : "Реквизиты ОКВЭД не найдены");
                }
            }
        }
    }
}
