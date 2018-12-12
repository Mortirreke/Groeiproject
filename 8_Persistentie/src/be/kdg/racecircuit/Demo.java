package be.kdg.racecircuit;

import be.kdg.racecircuit.data.Data;
import be.kdg.racecircuit.model.Racecircuit;
import be.kdg.racecircuit.model.Racecircuits;

/**
 * @author: Quinten Mortier
 **/
public class Demo {
    @SuppressWarnings({"unchecked" , "unused","checked"})
    public static void main(String[] args) {


        Racecircuit.header();
        Data data = new Data();
        Racecircuits racecircuits = new Racecircuits();

        for (Racecircuit racecircuit : data.getList()) {
            racecircuits.voegToe(racecircuit);
        }
        
        for (Racecircuit racecircuit : racecircuits.gesorteerdOpNaam()) {
            System.out.println(racecircuit);
        }


    }
}
