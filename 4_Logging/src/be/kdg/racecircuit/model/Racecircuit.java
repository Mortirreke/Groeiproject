package be.kdg.racecircuit.model;

import com.sun.xml.internal.bind.v2.TODO;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author: Quinten Mortier
 **/
public class Racecircuit implements Comparable<Racecircuit> {
    private static Logger logger = Logger.getLogger(Racecircuit.class.getName());
    private String naam;
    private int aantalBochten;
    private String locatie;
    private double aantalKM;
    private TypeCircuit type;
    private LocalDate bouwjaar;


    public Racecircuit(String naam, int aantalBochten, String locatie, double aantalKM, TypeCircuit type, LocalDate bouwjaar) {
        this.setNaam(naam);
        this.setAantalBochten(aantalBochten);
        this.locatie = locatie;
        this.setAantalKM(aantalKM);
        this.setType(type);
        this.setBouwjaar(bouwjaar);
    }



    public boolean equals(Racecircuit racecircuit) {
        return naam.equals(racecircuit.naam);
    }

    public int hashCode(){
        int hash = 0;
        for (int i = 0; i < naam.length(); i++) {
            hash += naam.charAt(i);
        }
        return hash;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setAantalBochten(int aantalBochten) {
        if (aantalBochten > 1000 || aantalBochten < 0){
            logger.log(Level.SEVERE, "je hebt een foutief aantal (" + aantalBochten + ") voor " + this.getNaam());
        } else {
            this.aantalBochten = aantalBochten;
        }

    }

    public void setAantalKM(double aantalKM) {
        if (aantalKM < 0){
            logger.log(Level.SEVERE, "aantalKM (" + aantalKM +") kan niet onder 0 zijn voor " + this.getNaam());
        } else {
            this.aantalKM = aantalKM;
        }
    }

    public void setType(TypeCircuit type) {
        this.type = type;
    }

    public void setBouwjaar(LocalDate bouwjaar) {
        if (bouwjaar.isBefore(LocalDate.now())) this.bouwjaar = bouwjaar;
        else {
            logger.log(Level.SEVERE,bouwjaar +" is een foutief jaar voor "+ this.getNaam() +" want dat ligt na " + LocalDate.now().getYear());
        }
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


    @Override
    public int compareTo(Racecircuit o) {
        return this.naam.compareTo(o.naam);
    }
}
