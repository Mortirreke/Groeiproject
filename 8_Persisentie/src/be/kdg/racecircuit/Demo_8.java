package be.kdg.racecircuit;/**
 * @author: Quinten Mortier
 **/

import be.kdg.racecircuit.data.Data;
import be.kdg.racecircuit.model.Racecircuit;
import be.kdg.racecircuit.model.Racecircuits;

import java.io.*;
import java.util.logging.Logger;

public class Demo_8 {
    public static final Logger L = Logger.getLogger(Demo_8.class.getName());

    public static void main(String[] args) {

        Data data = new Data();
        Racecircuits racecircuits = new Racecircuits();

        for (Racecircuit racecircuit : data.getList()) {
            racecircuits.voegToe(racecircuit);
        }

        try(FileOutputStream fileOutputStream = new FileOutputStream("8_Persisentie/db/persoon.ser")){
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(racecircuits);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("voor het wegschrijven van de klasse: \n");
        Racecircuit.header();
        for (Racecircuit racecircuit : racecircuits.gesorteerdOpNaam()) {
            System.out.println(racecircuit);
        }


        System.out.println("na het wegschrijven van de klasse: \n");


        try(FileInputStream fileInputStream = new FileInputStream("8_Persisentie/db/persoon.ser")){
            ObjectInputStream in = new ObjectInputStream(fileInputStream);
            Racecircuits inputRacecircuits = (Racecircuits) in.readObject();

            Racecircuit.header();
            for (Racecircuit circuit : inputRacecircuits.circuits) {
                System.out.println(circuit);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (Racecircuit racecircuit : racecircuits.gesorteerdOpNaam()) {
            System.out.println(racecircuit);
        }

    }
}
