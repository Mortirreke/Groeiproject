package model;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * @author: Quinten Mortier
 **/
public interface RacecircuitsInterface {
    TreeSet<Racecircuit> getCircuits();

    boolean voegToe(Racecircuit racecircuit);

    boolean verwijder(String naam);

    Racecircuit zoek(String naam);

    int getAantal();

    List<Racecircuit> gesorteerdOpLengte();

    List<Racecircuit> gesorteerdOpNaam();

    List<Racecircuit> gesorteerdOpLocatie();

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
