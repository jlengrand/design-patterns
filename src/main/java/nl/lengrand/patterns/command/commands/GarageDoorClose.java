package nl.lengrand.patterns.command.commands;

import nl.lengrand.patterns.command.apis.GarageDoor;

public class GarageDoorClose implements Command{

    private final GarageDoor garageDoor = new GarageDoor();

    @Override
    public void execute() {
        garageDoor.close();
    }

    @Override
    public void undo() {
        garageDoor.open();
    }
}
