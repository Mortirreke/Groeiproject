import Reflection.ReflectionTools;
import be.kdg.racecircuit.model.TypeCircuit;
import model.Circuit;
import model.Racecircuit;
import model.Racecircuits;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;

/**
 * @author: Quinten Mortier
 **/
public class Demo_3 {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ReflectionTools.classAnalysis(Racecircuit.class);
        System.out.println();
        ReflectionTools.classAnalysis(Racecircuits.class);
        System.out.println();
        ReflectionTools.classAnalysis(Circuit.class);

        Racecircuit.header();
        System.out.println(ReflectionTools.runAnnotated(Racecircuit.class));


    }
}
