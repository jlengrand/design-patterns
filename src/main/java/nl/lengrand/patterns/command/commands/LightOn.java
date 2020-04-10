package nl.lengrand.patterns.command.commands;

import nl.lengrand.patterns.command.apis.Light;

public class LightOn implements Command {

    private final Light light;

    public LightOn(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }

}
