package nl.lengrand.patterns.command.api;

public class Light {

    private String room;

    public Light(String room){
        this.room = room;
    }

    public void on(){
        System.out.println("Light on in " + room);
    }

    public void off(){
        System.out.println("Light off in " + room);
    }
}
