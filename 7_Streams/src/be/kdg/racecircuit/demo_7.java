package be.kdg.racecircuit;/**
 * @author: Quinten Mortier
 **/

import be.kdg.racecircuit.data.Data;
import be.kdg.racecircuit.model.Racecircuit;
import be.kdg.racecircuit.model.Racecircuits;
import be.kdg.racecircuit.util.Functies;
import com.sun.xml.internal.bind.v2.TODO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class demo_7 {
    public static final Logger L = Logger.getLogger(demo_7.class.getName());

    public static void main(String[] args) {
        Racecircuits racecircuits = new Racecircuits();



        Data data = new Data();
        for (Racecircuit racecircuit : data.getList()) {
            racecircuits.voegToe(racecircuit);
        }


        System.out.println("\nDictators gesorteerd op naam:");
        for (Racecircuit racecircuit : racecircuits.gesorteerdOp(Racecircuit::getAantalKM)) { System.out.println(racecircuit); }


       List<Racecircuit> racecircuitlijst = Functies.filteredList(racecircuits.getCircuits(), rc -> rc.getAantalBochten() <= 10);

        System.out.println('\n');
        racecircuitlijst.forEach(System.out::println);

        System.out.println('\n');
        System.out.println('\n');

        System.out.println("average: "  + Functies.average(racecircuits.getCircuits(), rc -> rc.getAantalBochten()));

        System.out.println('\n');
        System.out.println('\n');

        System.out.println("aantal racecircuits met 14 bochten of meer: "  + Functies.countIf(racecircuits.getCircuits(), rc -> rc.getAantalBochten() > 14));

        //STREAMS

        Racecircuits racecircuits1 = new Racecircuits();
        List<Racecircuit> dataStream = new ArrayList<>();

        for (Racecircuit racecircuit : data.getList()) {
            racecircuits1.voegToe(racecircuit);
        }

        System.out.println("\n");
        dataStream = racecircuits1.circuits;

        System.out.println("aantal racecircuits boven de 10 km: "+dataStream.stream().filter(r -> r.getAantalKM() > 10).count());


        System.out.println("racecircuits gesorteerd op type en op aantal bochten");
        dataStream.stream().sorted(Comparator.comparing(Racecircuit::getType).thenComparing(Racecircuit::getAantalBochten)).forEach(System.out::println);
        System.out.println("\n");


        dataStream.stream().sorted(Comparator.comparing(Racecircuit::getLocatie).reversed()).distinct().forEach(r -> System.out.print(r.getLocatie().toUpperCase()+","));

        System.out.println("\n\neen random racecircuit gebouwd voor het jaar 2000");
        System.out.println(dataStream.stream().filter(rc -> rc.getBouwjaar().isBefore(LocalDate.of(2000, 1, 1))).findAny().get());

        System.out.println("\n\nhet langste racecircuit: ");
        System.out.println(dataStream.stream().max(Comparator.comparingDouble(Racecircuit::getAantalKM)).get().getNaam());

        System.out.println("\n\nList met gesorteerde racecircuitnamen die beginnen met 'C':");
        dataStream.stream()
                .filter(rc->rc.getNaam().startsWith("C"))
                .sorted(Comparator.comparing(Racecircuit::getNaam))
                .map(Racecircuit::getNaam)
                .collect(Collectors.toList())
                .forEach(name -> System.out.print(name+ ","));

        System.out.println("\n\n");

        /*TODO niet volledig*/
        dataStream.stream().sorted(Comparator.comparing(Racecircuit::getBouwjaar)).forEach(racecircuit -> {
            boolean header1 = false;
            boolean header2 = false;
            if (racecircuit.getBouwjaar().isBefore(LocalDate.of(2000,1,1))){
                if (!header1){
                    System.out.println("sublist met racecircuits gemaakt voor 2000");
                    header1 = true;
                }
                System.out.println(racecircuit.toString());
            } else {
                if (!header2){
                    System.out.println("sublist met racecircuits gemaakt na 2000");
                    header2 = true;
                }
            }
        });
    }
}
