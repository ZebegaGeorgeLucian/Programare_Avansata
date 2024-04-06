package org.example;

import java.util.Scanner;

class Shell {
    private Scanner scanner;

    public Shell() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine();

            try {
                String[] parts = input.split("\\s+");
                String commandName = parts[0];

                Command command = null;
                switch (commandName) {
                    case "view":
                        command = new ViewCommand();
                        break;
                    case "report":
//                        command = new ReportCommand();
                        break;
                    case "export":
//                        command = new ExportCommand();
                        break;
                    default:
                        throw new CommandException("Invalid command: " + commandName);
                }

                String[] commandArgs = new String[parts.length - 1];
                System.arraycopy(parts, 1, commandArgs, 0, commandArgs.length);

                command.execute(commandArgs);
            } catch (CommandException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}