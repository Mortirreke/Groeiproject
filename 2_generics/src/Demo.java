import data.Data;
import racecircuit.Racecircuit;
import racecircuit.TypeCircuit;

import java.time.LocalDate;
import java.util.TreeSet;

/**
 * @author: Quinten Mortier
 **/
public class Demo {
    public static void main(String[] args) {

        Racecircuit.header();
        Data data = new Data();

        for (Racecircuit racecircuit : data.getList()) {
            System.out.println(racecircuit.toString());
        }
    }
}
