package org.example;

interface Command {
    void execute(String[] args) throws CommandException;
}
