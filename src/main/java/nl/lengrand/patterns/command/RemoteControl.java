package nl.lengrand.patterns.command;

import nl.lengrand.patterns.command.apis.Light;
import nl.lengrand.patterns.command.commands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    This class demos a simple 'Remote Control' that allows you to set buttons with a label and couple them with an action.
    Pressing the button will then call the given action
 */
public class RemoteControl {

    private Map<String, Command> commands = new HashMap<>();
    private Command lastCommand = new EmptyCommand();

    public void addCommand(String commandName, Command command){
        commands.put(commandName, command);
    }

    public void pressCommand(String commandName){
        System.out.println("---");
        Command command = commands.getOrDefault(commandName, new EmptyCommand());
        command.execute();
        lastCommand = command;
    }

    public void undo(){
        lastCommand.undo();
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
        rc.addCommand("SpotifyOn", new SpotifyOn());
        rc.addCommand("SpotifyOff", new SpotifyOff());

        rc.addCommand("ArrivedHomeSequence", new MetaCommand(
                Stream.of(new GarageDoorOpen(), new SpotifyOn(), new LightOn(new Light("Garage"))).collect(Collectors.toList())
        ));

        rc.addCommand("LeftHomeSequence", new MetaCommand(
                Stream.of(new GarageDoorClose(), new SpotifyOff(), new LightOff(new Light("Garage"))).collect(Collectors.toList())
        ));

        System.out.println(rc);
        rc.pressCommand("BathroomLightOn");
        rc.pressCommand("BathroomLightOff");
        rc.pressCommand("SpotifyOn");
        rc.undo();
        rc.pressCommand("Null check");
        rc.pressCommand("ArrivedHomeSequence");
        rc.pressCommand("LeftHomeSequence");
    }
}
