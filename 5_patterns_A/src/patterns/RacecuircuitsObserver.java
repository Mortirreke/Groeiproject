package patterns;

import model.Racecircuit;
import model.Racecircuits;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * @author: Quinten Mortier
 **/
public class RacecuircuitsObserver implements Observer{
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(arg);
    }
}
