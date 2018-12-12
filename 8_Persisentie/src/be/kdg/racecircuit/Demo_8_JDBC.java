package be.kdg.racecircuit;/**
 * @author: Quinten Mortier
 **/

import be.kdg.racecircuit.persist.RacecircuitDbDao;

import java.util.logging.Logger;

public class Demo_8_JDBC {
    public static final Logger L = Logger.getLogger(Demo_8_JDBC.class.getName());

    public static void main(String[] args) {
        new RacecircuitDbDao("jdbc:hsqldb:file:/racecircuitdatabank/localhost");


    }

}
