package nl.lengrand.patterns.command;

import nl.lengrand.patterns.command.api.Light;

import java.util.HashMap;
import java.util.Map;

public class RemoteControl {

    private Map<String, Command> commands = new HashMap<>();

    public void addCommand(String commandName, Command command){
        commands.put(commandName, command);
    }

    public void pressCommand(String commandName){
        commands.getOrDefault(commandName, new EmptyCommand()).execute();
    }

    @Override
    public String toString() {
        return "RemoteControl{" +
                "buttons=" + commands +
                '}';
    }

    public static void main(String[] args) {
        System.out.println("Picking up Remote Control");
        RemoteControl rc = new RemoteControl();

        rc.addCommand("BathroomLightOn", new LightOn(new Light("Bathroom")));
        rc.addCommand("BathroomLightOff", new LightOff(new Light("Bathroom")));

        System.out.println(rc);
        rc.pressCommand("BathroomLightOn");
        rc.pressCommand("Null check");
    }
}
