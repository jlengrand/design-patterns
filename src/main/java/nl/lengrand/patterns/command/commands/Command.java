package nl.lengrand.patterns.command.commands;

public interface Command {

    void execute();

    void undo();
}
