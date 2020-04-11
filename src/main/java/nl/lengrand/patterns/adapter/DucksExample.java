package nl.lengrand.patterns.adapter;

import nl.lengrand.patterns.adapter.ducks.Duck;
import nl.lengrand.patterns.adapter.ducks.MallardDuck;
import nl.lengrand.patterns.adapter.ducks.TurkeyAdapter;
import nl.lengrand.patterns.adapter.ducks.WildTurkey;

public class DucksExample {

    public static void main(String[] args) {
        MallardDuck duck = new MallardDuck();
        duck.quack();
        duck.fly();

        WildTurkey wildTurkey = new WildTurkey();
        wildTurkey.gobble();
        wildTurkey.fly();

        Duck turkey = new TurkeyAdapter(wildTurkey);
        turkey.quack();
        turkey.fly();
    }
}
