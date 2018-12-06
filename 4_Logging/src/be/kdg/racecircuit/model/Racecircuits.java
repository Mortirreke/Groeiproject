package be.kdg.racecircuit.model;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author: Quinten Mortier
 **/
public class Racecircuits {
    private static Logger logger = Logger.getLogger(Racecircuits.class.getName());
    public TreeSet<Racecircuit> circuits = new TreeSet<>();

    public TreeSet<Racecircuit> getCircuits() {
        return circuits;
    }



    public boolean voegToe(Racecircuit racecircuit){
        logger.log(Level.FINER,racecircuit.getNaam() + "wordt toegevoegd uit de treeset");
            return circuits.add(racecircuit);
    }

    public boolean verwijder(String naam){
        logger.log(Level.FINER,naam + "wordt verwijderd uit de treeset");
        for (Racecircuit circuit : circuits) {
            if (naam.equals(circuit.getNaam())){
                return circuits.remove(circuit);
            }
        }
        return false;
    }

    public Racecircuit zoek(String naam){
        for (Racecircuit circuit : circuits) {
            if (naam.equals(circuit.getNaam())){
                return circuit;
            }
        }
        return null;
    }

    public int getAantal(){
        return circuits.size();
    }

    public List<Racecircuit> gesorteerdOpLengte(){
        List<Racecircuit> ll = new LinkedList<>();
        ll.addAll(circuits);

        Collections.sort(ll, new Comparators.SortOnLengte());
        return ll;
    }

    public List<Racecircuit> gesorteerdOpNaam(){
        List<Racecircuit> ll = new LinkedList<>();
        ll.addAll(circuits);

        Collections.sort(ll, new Comparators.SortOnNaam());
        return ll;
    }
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
