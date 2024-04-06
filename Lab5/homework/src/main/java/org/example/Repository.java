package org.example;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {
    private String directory;
    private Map<Person, List<Document>> documents = new HashMap<>();

    public Repository(String directory) {
        this.directory = directory;
        loadDocuments();
    }

    private void loadDocuments() {

        File mainDirectory = new File(directory);
        if (!mainDirectory.exists() || !mainDirectory.isDirectory()) {
            System.err.println("Invalid directory: " + directory);
            return;
        }

        File[] subDirectories = mainDirectory.listFiles(File::isDirectory);
        if (subDirectories != null) {
            for (File subDir : subDirectories) {
                File[] files = subDir.listFiles();
                if (files != null) {
                    for (File file : files) {
                        System.out.println("Document: " + file.getName());
                    }
                }
            }
        }
    }
}



