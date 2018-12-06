package patterns;/**
 * @author: Quinten Mortier
 **/

import model.Racecircuit;
import model.Racecircuits;
import model.RacecircuitsInterface;

import java.util.List;
import java.util.TreeSet;
import java.util.logging.Logger;

public class UnmodifiableRacecircuits implements RacecircuitsInterface {
    public static final Logger L = Logger.getLogger(UnmodifiableRacecircuits.class.getName());

    Racecircuits racecircuits;
    public UnmodifiableRacecircuits(Racecircuits racecircuits) {
    this.racecircuits = racecircuits;
    }

    @Override
    public TreeSet<Racecircuit> getCircuits() {
        return racecircuits.getCircuits();
    }

    @Override
    public boolean voegToe(Racecircuit racecircuit) {
        return racecircuits.voegToe(racecircuit);
    }

    @Override
    public boolean verwijder(String naam) {
        return false;
    }

    @Override
    public Racecircuit zoek(String naam) {
        return null;
    }

    @Override
    public int getAantal() {
        return 0;
    }

    @Override
    public List<Racecircuit> gesorteerdOpLengte() {
        return null;
    }

    @Override
    public List<Racecircuit> gesorteerdOpNaam() {
        return null;
    }

    @Override
    public List<Racecircuit> gesorteerdOpLocatie() {
        return null;
    }
}
