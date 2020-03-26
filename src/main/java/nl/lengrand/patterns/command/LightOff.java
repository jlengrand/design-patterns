package nl.lengrand.patterns.command;

import nl.lengrand.patterns.command.api.Light;

public class LightOff implements Command {

    private Light light;

    public LightOff(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
