package nl.lengrand.patterns.facade;

public class HomeCinema {

    Light light;
    Netflix netflix;
    SoundSystem soundSystem;
    Television television;

    public HomeCinema(){
        this(new Light(), new Netflix(), new SoundSystem(), new Television());
    }

    public HomeCinema(Light light, Netflix netflix, SoundSystem soundSystem, Television television) {
        this.light = light;
        this.netflix = netflix;
        this.soundSystem = soundSystem;
        this.television = television;
    }

    public void startMovie(){
        light.switchOff();
        television.switchOn();
        soundSystem.blast();
        netflix.start();
    }

    public void stopMovie(){
        netflix.stop();
        soundSystem.stop();
        television.switchOff();
        light.switchOn();
    }

    public Light getLight() {
        return light;
    }

    public Netflix getNetflix() {
        return netflix;
    }

    public SoundSystem getSoundSystem() {
        return soundSystem;
    }

    public Television getTelevision() {
        return television;
    }
}
