package model;

import Reflection.CanRun;

/**
 * @author: Quinten Mortier
 **/
public class Circuit {
    private String naam;
    private int aantalBochten;
    private String locatie;
    private double aantalKM;

    public String getNaam() {
        return naam;
    }
    @CanRun("UNKNOWN")
    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getAantalBochten() {
        return aantalBochten;
    }

    public void setAantalBochten(int aantalBochten) {
        this.aantalBochten = aantalBochten;
    }

    public String getLocatie() {
        return locatie;
    }
    @CanRun("UNKNOWN")
    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    public double getAantalKM() {
        return aantalKM;
    }

    public void setAantalKM(double aantalKM) {
        if (aantalKM < 0){
            throw new IllegalArgumentException("kan niet onder 0 zijn");
        } else {
            this.aantalKM = aantalKM;
        }
    }
    @Override
    public String toString() {
        return String.format("| %-25s | %-25d | %-25s |  %-25.2f| \n-------------------------------------------------------------------------------------------------------------------------------------------------------------------------", getNaam(),getAantalBochten(),getLocatie(),getAantalKM());

    }
}
