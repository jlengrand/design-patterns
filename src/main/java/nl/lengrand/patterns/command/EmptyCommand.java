package nl.lengrand.patterns.command;

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
