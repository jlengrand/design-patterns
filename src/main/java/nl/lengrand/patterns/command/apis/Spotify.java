package nl.lengrand.patterns.command.apis;

public class Spotify {

    private int volume = 20;

    public void start(){
        System.out.println("Starting spotify");
    }

    public void stop(){
        System.out.println("Stopping Spotify");
    }

    public void setVolume(int newVolume){
        if(newVolume >100) {
            volume = 100;
        }
        else if(newVolume < 0){
            volume = 0;
        }
        else{
            volume = newVolume;
        }
    }

    public int getVolume() { return volume;}

}
