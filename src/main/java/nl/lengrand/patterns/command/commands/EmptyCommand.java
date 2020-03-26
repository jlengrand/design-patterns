package nl.lengrand.patterns.command.commands;

public class EmptyCommand implements Command{
    @Override
    public void execute() {
        System.out.println("No Command");
    }

    @Override
    public void undo() {
        System.out.println("No Command undo");
    }
}
