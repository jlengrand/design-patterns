package nl.lengrand.patterns.facade;

public class MovieExample {

    public static void main(String[] args) {
        HomeCinema cinema = new HomeCinema();
        cinema.startMovie();
        cinema.getLight().switchOn();
        cinema.stopMovie();
    }
}
