package model;

import Reflection.CanRun;

import java.time.LocalDate;

/**
 * @author: Quinten Mortier
 **/
public class Racecircuit extends Circuit implements Comparable<Racecircuit> {

    private TypeCircuit type;
    private LocalDate bouwjaar;


    public Racecircuit(String naam, int aantalBochten, String locatie, double aantalKM, TypeCircuit type, LocalDate bouwjaar) {
        super.setNaam(naam);
        super.setAantalBochten(aantalBochten);
        super.setLocatie(locatie);
        super.setAantalKM(aantalKM);
        this.setType(type);
        this.setBouwjaar(bouwjaar);
    }

    public Racecircuit() {
    }

    public boolean equals(Racecircuit racecircuit) {
        return super.getNaam().equals(racecircuit.getNaam());
    }

    public int hashCode(){
        int hash = 0;
        for (int i = 0; i < super.getNaam().length(); i++) {
            hash += super.getNaam().charAt(i);
        }
        return hash;
    }


    public void setType(TypeCircuit type) {
        this.type = type;
    }

    public void setBouwjaar(LocalDate bouwjaar) {
        this.bouwjaar = bouwjaar;
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
        return String.format("| %-25s | %-25d | %-25s |  %-25.2f| %-25s | %-25s | \n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------", super.getNaam(),super.getAantalBochten(),super.getLocatie(),super.getAantalKM(),this.type, this.bouwjaar);

    }


    @Override
    public int compareTo(Racecircuit o) {
        return super.getNaam().compareTo(o.getNaam());
    }
}
