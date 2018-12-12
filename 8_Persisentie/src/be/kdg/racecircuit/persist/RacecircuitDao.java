package be.kdg.racecircuit.persist;

import be.kdg.racecircuit.model.Racecircuit;

import java.util.List;
import java.util.TreeSet;

/**
 * @author: Quinten Mortier
 **/
public interface RacecircuitDao {
    TreeSet<Racecircuit> getCircuits();

    boolean voegToe(Racecircuit racecircuit);

    boolean verwijder(String naam);

    Racecircuit zoek(String naam);

    int getAantal();

    List<Racecircuit> gesorteerdOpLengte();

    List<Racecircuit> gesorteerdOpNaam();

    List<Racecircuit> gesorteerdOpLocatie();
}
