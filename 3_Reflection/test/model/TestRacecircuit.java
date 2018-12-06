package model;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

/**
 * @author: Quinten Mortier
 **/
public class TestRacecircuit {
    private Racecircuit spa;
    private Racecircuit zolder;

    @Before
    public void setUp() throws Exception {
        spa = new Racecircuit("Spa",15,"Spa",7.8, TypeCircuit.FORMULE_1, LocalDate.of(2018,8,26));
        zolder = new Racecircuit("Zolder", 10,"Heusden-Zolder",4.01, TypeCircuit.MOTORSPORT,LocalDate.of(2017,5,2));
    }

    @Test
    public void testEquals(){
        Racecircuit spa1 = spa;
        Racecircuit spa2 = spa;
        Racecircuit zolder1 = zolder;
        boolean ok = false;
        if (spa1.equals(spa2) && !(spa1.equals(zolder1))){
            ok = true;
        }
        Assert.assertTrue("probleem met de equals",ok);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testOngeldig(){
        spa = new Racecircuit("Spa",15,"Spa",-1, TypeCircuit.FORMULE_1, LocalDate.of(2018,8,26));
    }

    @Test
    public void testGeldig(){
        try{
            spa = new Racecircuit("Spa",15,"Spa",15, TypeCircuit.FORMULE_1, LocalDate.of(2018,8,26));
        } catch (IllegalArgumentException iae){
            Assert.fail("probleem met het aanmaken van een object");
        }
    }
    @Test
    public void testCompareTo(){

        if (!(spa.compareTo(spa) == 0)){
            Assert.fail("probleem met de CompareTo methode");
        }
    }
    @Test
    public void assertEquals(){
        Assert.assertEquals(2.4,1.4,1);
    }
}