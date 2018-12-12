/**
 * @author: Quinten Mortier
 **/

import model.Racecircuits;
import patterns.UnmodifiableRacecircuits;

import java.util.logging.Logger;

public class Demo_6 {
    public static final Logger L = Logger.getLogger(Demo_6.class.getName());



    public static void main(String[] args) {
        Racecircuits racecircuits = new Racecircuits();
        UnmodifiableRacecircuits urc = new UnmodifiableRacecircuits(racecircuits);
        urc.verwijder("spa");
    }
}
