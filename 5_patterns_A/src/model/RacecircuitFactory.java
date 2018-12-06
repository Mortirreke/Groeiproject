package model;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.*;

/**
 * @author: Quinten Mortier
 **/
public class RacecircuitFactory {
    static Random random = new Random();
    private RacecircuitFactory() {
    }

    public static Racecircuit newEmptyRacecircuit(){
        return new Racecircuit();
    }

    public static Racecircuit newFilledRacecircuit(String naam, int aantalBochten, String locatie, double aantalKM, TypeCircuit type, LocalDate bouwjaar) {
       Racecircuit racecircuit = new Racecircuit();
        racecircuit.setNaam(naam);
        racecircuit.setAantalBochten(aantalBochten);
        racecircuit.setLocatie(locatie);
        racecircuit.setAantalKM(aantalKM);
        racecircuit.setType(type);
        racecircuit.setBouwjaar(bouwjaar);
        return racecircuit;
    }

    public static String generateString(int maxWordLength, int wordCount, boolean camelCase){
        char[] klinkers = "aeiou".toCharArray();
        char[] medeklinkers = "zrtpqdfghjklmwcvbn".toCharArray();
        StringBuilder stringBuilder = new StringBuilder();

        for (int y = 0; y < wordCount; y++) {
            for (int i = 0; i < random.nextInt(maxWordLength) + 4; i++) {
                if (random.nextInt(3) == 0) {
                    if (i == 0 && camelCase){
                        stringBuilder.append(Character.toUpperCase(klinkers[random.nextInt(5)]));
                    }else {
                        stringBuilder.append(klinkers[random.nextInt(5)]);
                    }

                } else {
                    if (i == 0 && camelCase){
                        stringBuilder.append(Character.toUpperCase(klinkers[random.nextInt(5)]));
                    } else {
                        stringBuilder.append(medeklinkers[random.nextInt(17)]);
                    }

                }

            }
            if (wordCount != 1) stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
    public static Racecircuit newRandomRacecircuit(){

        Racecircuit racecircuit = new Racecircuit();
        racecircuit.setLocatie(generateString(9, 2,true));
        racecircuit.setAantalBochten(random.nextInt(20)+2);
        racecircuit.setAantalKM(random.nextDouble());
        racecircuit.setBouwjaar(generateDate());
        racecircuit.setNaam(generateString(9,2,true));
        List<TypeCircuit> typeCircuits = new ArrayList<>();
        racecircuit.setType(TypeCircuit.values()[random.nextInt(TypeCircuit.values().length)]);
        return racecircuit;
    }

    public static LocalDate generateDate(){
        LocalDate date = LocalDate.of(random.nextInt(LocalDate.now().getYear()-1900)+1900,random.nextInt(11)+1,random.nextInt(29)+1);
        return date;
    }



}
