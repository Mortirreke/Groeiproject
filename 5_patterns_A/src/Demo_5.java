import model.Racecircuit;
import model.RacecircuitFactory;
import model.Racecircuits;
import model.TypeCircuit;
import patterns.ObservableRacecuits;
import patterns.RacecuircuitsObserver;

import java.time.LocalDate;

/**
 * @author: Quinten Mortier
 **/
public class Demo_5 {

    public static void main(String[] args) {
        Racecircuits racecircuits = new Racecircuits();
        RacecuircuitsObserver observer = new RacecuircuitsObserver();
        ObservableRacecuits observableRacecuits = new ObservableRacecuits(racecircuits);
        observableRacecuits.addObserver(observer);

        Racecircuit spa = new Racecircuit("Spa",15,"Spa",7.8, TypeCircuit.FORMULE_1, LocalDate.of(2018,8,26));
        Racecircuit zolder = new Racecircuit("Zolder", 10,"Heusden-Zolder",4.01, TypeCircuit.MOTORSPORT,LocalDate.of(2017,5,2));
        Racecircuit coa = new Racecircuit("Circuit of the Americas", 20  ,"Austin, Texas",5.47, TypeCircuit.FORMULE_1,LocalDate.of(2017,12,23));
        Racecircuit Lemans = new Racecircuit("Circuit de la Sarthe", 21,"Le Mans",13.63, TypeCircuit.ENDURANCE,LocalDate.of(1921,3,11));
        Racecircuit monaco = new Racecircuit("Circuit de Monaco", 18,"Monte Carlo",3.34, TypeCircuit.FORMULE_1,LocalDate.of(1921,6,30));




        observableRacecuits.voegToe(spa);
        observableRacecuits.voegToe(zolder);
        observableRacecuits.voegToe(coa);
        observableRacecuits.voegToe(Lemans);
        observableRacecuits.voegToe(monaco);

        observableRacecuits.verwijder("Spa");
        observableRacecuits.verwijder("Zolder");
        observableRacecuits.verwijder("Circuit of the Americas");
        observableRacecuits.verwijder("Circuit de la Sarthe");
        observableRacecuits.verwijder("Circuit de Monaco");

        for (int i = 0; i < 5; i++) {
            System.out.println(RacecircuitFactory.newRandomRacecircuit().toString());
        }

    }
}
