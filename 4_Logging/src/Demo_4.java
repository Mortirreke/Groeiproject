import be.kdg.racecircuit.model.Racecircuit;
import be.kdg.racecircuit.model.Racecircuits;
import be.kdg.racecircuit.model.TypeCircuit;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.logging.LogManager;

/**
 * @author: Quinten Mortier
 **/
public class Demo_4 {
    public static void main(String[] args) {
        URL configURL = Demo_4.class.getResource("/logging.properties");
        if (configURL != null) {
            try (InputStream is = configURL.openStream()) {
                LogManager.getLogManager().readConfiguration(is);
            } catch (IOException e) {
                System.err.println("configbestand is corrupt");
            }
        } else {
            System.err.println("configbestand NIET GEVONDEN");
        }



        Racecircuit spa = new Racecircuit("Spa",-1,"Spa",7.8, TypeCircuit.FORMULE_1, LocalDate.of(2018,8,26));
        Racecircuit zolder = new Racecircuit("Zolder", 10000,"Heusden-Zolder",4.01, TypeCircuit.MOTORSPORT,LocalDate.of(2017,5,2));
        Racecircuit coa = new Racecircuit("Circuit of the Americas", 20  ,"Austin, Texas",5.47, TypeCircuit.FORMULE_1,LocalDate.of(2020,12,23));
        Racecircuit Lemans = new Racecircuit("Circuit de la Sarthe", 21,"Le Mans",13.63, TypeCircuit.ENDURANCE,LocalDate.of(1921,3,11));
        Racecircuit monaco = new Racecircuit("Circuit de Monaco", 18,"Monte Carlo",3.34, TypeCircuit.FORMULE_1,LocalDate.of(1921,6,30));


        Racecircuits racecircuits = new Racecircuits();

        racecircuits.voegToe(spa);
        racecircuits.voegToe(zolder);
        racecircuits.voegToe(coa);
        racecircuits.voegToe(Lemans);
        racecircuits.voegToe(monaco);
    }
}
