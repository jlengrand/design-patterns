package nl.lengrand.patterns.command;

import nl.lengrand.patterns.command.api.Light;

public class LightOn implements Command {

    private Light light;

    public LightOn(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
