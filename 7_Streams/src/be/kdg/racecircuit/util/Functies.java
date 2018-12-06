package be.kdg.racecircuit.util;/**
 * @author: Quinten Mortier
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.logging.Logger;

public class Functies {
    public static final Logger L = Logger.getLogger(Functies.class.getName());


    public static <T> List<T> filteredList(List<T> racecuitcuitList, Predicate<T> predicate){
        List<T> lijst = new ArrayList<>();

        for (T match : racecuitcuitList) {
            if (predicate.test(match)) {
                lijst.add(match);
            }
        }

        return lijst;
    }

    public static <T> Double average (List<T> racecircuitList, ToDoubleFunction<T> mapper){

        double average = 0;

        for (T t : racecircuitList) {

                average += mapper.applyAsDouble(t);
            }
        average = average / racecircuitList.size();

        return average;
    }

    public static <T> long countIf(List<T> racecircuitList, Predicate<T> predicate){
        long count = 0;
        for (T match : racecircuitList) {
            if (predicate.test(match)) {
                count ++;
            }
        }
        return count;
    }
}
