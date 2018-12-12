package be.kdg.racecircuit.model;

import be.kdg.racecircuit.persist.RacecircuitDao;

import java.io.Serializable;
import java.util.*;

/**
 * @author: Quinten Mortier
 **/
public class Racecircuits implements Serializable, RacecircuitDao {
    public TreeSet<Racecircuit> circuits = new TreeSet<>();

    @Override
    public TreeSet<Racecircuit> getCircuits() {
        return circuits;
    }



    @Override
    public boolean voegToe(Racecircuit racecircuit){
            return circuits.add(racecircuit);
    }

    @Override
    public boolean verwijder(String naam){

        for (Racecircuit circuit : circuits) {
            if (naam.equals(circuit.getNaam())){
                return circuits.remove(circuit);
            }
        }
        return false;
    }

    @Override
    public Racecircuit zoek(String naam){
        for (Racecircuit circuit : circuits) {
            if (naam.equals(circuit.getNaam())){
                return circuit;
            }
        }
        return null;
    }

    @Override
    public int getAantal(){
        return circuits.size();
    }

    @Override
    public List<Racecircuit> gesorteerdOpLengte(){
        List<Racecircuit> ll = new LinkedList<>();
        ll.addAll(circuits);

        Collections.sort(ll, new Comparators.SortOnLengte());
        return ll;
    }

    @Override
    public List<Racecircuit> gesorteerdOpNaam(){
        List<Racecircuit> ll = new LinkedList<>();
        ll.addAll(circuits);

        Collections.sort(ll, new Comparators.SortOnNaam());
        return ll;
    }
    @Override
    public List<Racecircuit> gesorteerdOpLocatie(){
        List<Racecircuit> ll = new LinkedList<>();
        ll.addAll(circuits);

        Collections.sort(ll, new Comparators.SortOnLocatie());
        return ll;
    }


    public static class Comparators{
        public static class SortOnLengte implements Comparator<Racecircuit> {
            @Override
            public int compare(Racecircuit o1, Racecircuit o2) {
                return Double.compare(o1.getAantalKM(),o2.getAantalKM());
            }
        }
        public static class SortOnNaam implements Comparator<Racecircuit>{
            @Override
            public int compare(Racecircuit o1, Racecircuit o2) {
                return o1.getNaam().compareTo(o2.getNaam());
            }
        }
        public static class SortOnLocatie implements Comparator<Racecircuit>{
            @Override
            public int compare(Racecircuit o1, Racecircuit o2) {
                return o1.getLocatie().compareTo(o2.getLocatie());
            }
        }


    }
}
