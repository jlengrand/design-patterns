package nl.lengrand.patterns.command.commands;

import nl.lengrand.patterns.command.apis.Spotify;

public class SpotifyOff implements Command{

    private Spotify spotify = new Spotify();
    private int lastVolume = spotify.getVolume();

    @Override
    public void execute() {
        lastVolume = spotify.getVolume();
        spotify.stop();
    }

    @Override
    public void undo() {
        spotify.start();
        spotify.setVolume(lastVolume);
    }
}
