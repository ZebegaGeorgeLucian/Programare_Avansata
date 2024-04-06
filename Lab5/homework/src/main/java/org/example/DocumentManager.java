package org.example;

import java.io.File;
import java.io.IOException;

public class DocumentManager {

    private static final String MASTER_DIRECTORY = "master_directory";

    public DocumentManager() {
        // Ensure the master directory exists
        File masterDir = new File(MASTER_DIRECTORY);
        if (!masterDir.exists()) {
            masterDir.mkdir();
        }
    }

    public void addDocument(Person person, Document document, byte[] data) {
        String personDirectory = getPersonDirectory(person);
        File documentFile = new File(personDirectory, document.name());
        try {
            // Write document data to file
            // Example: Files.write(documentFile.toPath(), data);
            System.out.println("Document added: " + documentFile.getAbsolutePath());
        } catch (Exception e) {
            System.err.println("Failed to add document: " + e.getMessage());
        }
    }
    private String getPersonDirectory(Person person) {
        return MASTER_DIRECTORY + File.separator + person.id();
    }
}