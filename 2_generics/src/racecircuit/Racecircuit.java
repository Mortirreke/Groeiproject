package racecircuit;

import java.time.LocalDate;

/**
 * @author: Quinten Mortier
 * @version 0.2
 * @see "https://nl.wikipedia.org/wiki/Dictator_(modern)"
 **/
public class Racecircuit {
    private String naam;
    private int aantalBochten;
    private String locatie;
    private double aantalKM;
    private TypeCircuit type;
    private LocalDate bouwjaar;

    /**
     * @
     * @param naam
     * @param aantalBochten
     * @param locatie
     * @param aantalKM
     * @param type
     * @param bouwjaar
     */
    public Racecircuit(String naam, int aantalBochten, String locatie, double aantalKM, TypeCircuit type, LocalDate bouwjaar) {
        this.setNaam(naam);
        this.setAantalBochten(aantalBochten);
        this.locatie = locatie;
        this.setAantalKM(aantalKM);
        this.setType(type);
        this.setBouwjaar(bouwjaar);
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setAantalBochten(int aantalBochten) {
        if (aantalBochten > 1000){
            throw new IllegalArgumentException("fout aantal");
        } else {
            this.aantalBochten = aantalBochten;
        }
    }

    public void setAantalKM(double aantalKM) {
        this.aantalKM = aantalKM;
    }

    public void setType(TypeCircuit type) {
        this.type = type;
    }

    public void setBouwjaar(LocalDate bouwjaar) {
        this.bouwjaar = bouwjaar;
    }


    public String getNaam() {
        return naam;
    }

    public int getAantalBochten() {
        return aantalBochten;
    }

    public String getLocatie() {
        return locatie;
    }

    public double getAantalKM() {
        return aantalKM;
    }

    public TypeCircuit getType() {
        return type;
    }

    public LocalDate getBouwjaar() {
        return bouwjaar;
    }

    public static void header(){
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(String.format("| %-25s | %-25s | %-25s | %-25s | %-25s | %-25s | \n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------" , "Naam","Aantal Bochten","Locatie","Aantal KM","Type Circuit","Bouwjaar"));
    }
    @Override
    public String toString() {
        return String.format("| %-25s | %-25d | %-25s |  %-25.2f| %-25s | %-25s | \n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------", naam,aantalBochten,locatie,aantalKM,type, bouwjaar);

    }



}
