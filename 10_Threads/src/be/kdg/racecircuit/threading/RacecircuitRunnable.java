package be.kdg.racecircuit.threading;/**
 * @author: Quinten Mortier
 **/

import be.kdg.racecircuit.model.RacecircuitFactory;

import java.util.function.Predicate;
import java.util.logging.Logger;

public class RacecircuitRunnable implements Runnable{
    public static final Logger L = Logger.getLogger(RacecircuitRunnable.class.getName());

    public RacecircuitRunnable(Predicate predicate) {
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            RacecircuitFactory.newRandomRacecircuit();
        }
    }
}
