package patterns;

import model.Racecircuit;
import model.Racecircuits;
import model.RacecircuitsInterface;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeSet;

/**
 * @author: Quinten Mortier
 **/
public class ObservableRacecuits extends Observable implements RacecircuitsInterface{

    Racecircuits racecircuits = new Racecircuits();

    public ObservableRacecuits(Racecircuits racecircuits) {
        this.racecircuits = racecircuits;
    }

    @Override
    public TreeSet<Racecircuit> getCircuits() {
        return racecircuits.getCircuits();
    }

    @Override
    public boolean voegToe(Racecircuit racecircuit) {
        boolean resultaat = racecircuits.voegToe(racecircuit);
        setChanged();
        notifyObservers("Observer meldt: Toegevoegd " + racecircuit.toString());
        return resultaat;
    }

    @Override
    public boolean verwijder(String naam) {
        Racecircuit racecircuit = zoek(naam);
        boolean resultaat = racecircuits.verwijder(naam);
        setChanged();
        notifyObservers("Observer meldt: Verwijderd " + racecircuit.toString());
        return resultaat;
    }

    @Override
    public Racecircuit zoek(String naam) {
        return racecircuits.zoek(naam);
    }

    @Override
    public int getAantal() {
        return racecircuits.getAantal();
    }

    @Override
    public List<Racecircuit> gesorteerdOpLengte() {
       return racecircuits.gesorteerdOpLengte();
    }

    @Override
    public List<Racecircuit> gesorteerdOpNaam() {
        return racecircuits.gesorteerdOpNaam();
    }

    @Override
    public List<Racecircuit> gesorteerdOpLocatie() {
       return racecircuits.gesorteerdOpLocatie();
    }

}
