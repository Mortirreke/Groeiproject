package be.kdg.racecircuit.threading;/**
 * @author: Quinten Mortier
 **/

import be.kdg.racecircuit.model.Racecircuit;
import be.kdg.racecircuit.model.RacecircuitFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacecircuitRunnable implements Runnable{
    public static final Logger L = Logger.getLogger(RacecircuitRunnable.class.getName());

    Predicate predicate;
    List<Racecircuit> racecircuitList = new ArrayList<>();
    public RacecircuitRunnable(Predicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public void run() {
        racecircuitList = Stream.generate(RacecircuitFactory::newRandomRacecircuit).filter(predicate).limit(1000).collect(Collectors.toList());
    }
}
