package model;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

/**
 * @author: Quinten Mortier
 **/
public class TestRacecircuits {
    private Racecircuit spa;
    private Racecircuit zolder;
    private Racecircuits racecircuits;

    @Before
    public void setUp() throws Exception {
        racecircuits = new Racecircuits();
        spa = new Racecircuit("Spa",15,"Spa",7.8, TypeCircuit.FORMULE_1, LocalDate.of(2018,8,26));
        zolder = new Racecircuit("Zolder", 10,"Heusden-Zolder",4.01, TypeCircuit.MOTORSPORT,LocalDate.of(2017,5,2));
    }

    @Test
    public void TestVoegToe(){
        try{
            racecircuits.voegToe(spa);
        } catch (Exception e){
            Assert.fail("er ging iets mis bij het toevoegen van en circuit");
        }
    }

    @Test
    public void TestVerwijder(){
        try{
            racecircuits.voegToe(spa);
            racecircuits.verwijder("Spa");
        } catch (Exception e){
            Assert.fail("er ging iets mis bij het verwijderen van en circuit");
        }
    }
}