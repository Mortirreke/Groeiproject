package model;

import java.util.*;

/**
 * @author: Quinten Mortier
 **/
public class Racecircuits implements RacecircuitsInterface {
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


}
