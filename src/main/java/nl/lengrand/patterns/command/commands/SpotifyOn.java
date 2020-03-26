package nl.lengrand.patterns.command.commands;

import nl.lengrand.patterns.command.apis.Spotify;

public class SpotifyOn implements Command{

    private Spotify spotify = new Spotify();

    @Override
    public void execute() {
        spotify.start();
        spotify.setVolume(50);
    }

    @Override
    public void undo() {
        spotify.stop();
    }
}
