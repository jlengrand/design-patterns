package nl.lengrand.patterns.command.commands;

import nl.lengrand.patterns.command.apis.GarageDoor;

public class GarageDoorOpen implements Command{

    private final GarageDoor garageDoor = new GarageDoor();

    @Override
    public void execute() {
        garageDoor.open();
    }

    @Override
    public void undo() {
        garageDoor.close();
    }
}
