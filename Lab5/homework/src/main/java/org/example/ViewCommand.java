package org.example;

import java.awt.*;
import java.io.File;
import java.io.IOException;

class ViewCommand implements Command {
    @Override
    public void execute(String[] args) throws CommandException {
        if (args.length != 1) {
            throw new CommandException("Usage: view <file_path>");
        }
        String filePath = args[0];
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new CommandException("File does not exist: " + filePath);
            }
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            throw new CommandException("Error opening file: " + e.getMessage());
        }
    }
}