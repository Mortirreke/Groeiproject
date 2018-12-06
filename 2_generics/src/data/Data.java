package data;

import racecircuit.Racecircuit;
import racecircuit.TypeCircuit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Quinten Mortier
 **/
public class Data {
    private static List<Racecircuit> list = new ArrayList();

    public Data() {
        fillCircuit();
    }

    public void fillCircuit(){
        Racecircuit spa = new Racecircuit("Spa",15,"Spa",7.8, TypeCircuit.FORMULE_1, LocalDate.of(2018,8,26));
        Racecircuit zolder = new Racecircuit("Zolder", 10,"Heusden-Zolder",4.01, TypeCircuit.MOTORSPORT,LocalDate.of(2017,5,2));
        Racecircuit coa = new Racecircuit("Circuit of the Americas", 20  ,"Austin, Texas",5.47, TypeCircuit.FORMULE_1,LocalDate.of(2017,12,23));
        Racecircuit Lemans = new Racecircuit("Circuit de la Sarthe", 21,"Le Mans",13.63, TypeCircuit.ENDURANCE,LocalDate.of(1921,3,11));
        Racecircuit monaco = new Racecircuit("Circuit de Monaco", 18,"Monte Carlo",3.34, TypeCircuit.FORMULE_1,LocalDate.of(1921,6,30));

        list.add(spa);
        list.add(zolder);
        list.add(coa);
        list.add(Lemans);
        list.add(monaco);
    }

    public List<Racecircuit> getList() {
        return list;
    }
}
