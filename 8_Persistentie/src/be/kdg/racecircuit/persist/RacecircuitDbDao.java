package be.kdg.racecircuit.persist;/**
 * @author: Quinten Mortier
 **/

import be.kdg.racecircuit.model.Racecircuit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.TreeSet;
import java.util.logging.Logger;

public class RacecircuitDbDao implements RacecircuitDao {
    public static final Logger L = Logger.getLogger(RacecircuitDbDao.class.getName());
    private Connection connection;


    public RacecircuitDbDao(String url) {
        try {
            connection = DriverManager.getConnection(url, "admin", "admin");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        maakTabel();
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void maakTabel(){
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.execute("DROP TABLE racecircuittable IF EXISTS ");
            statement.execute("CREATE TABLE racecircuittable (id INTEGER IDENTITY, naam VARCHAR(30),aantalBochten INTEGER , aantalKM INTEGER )");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public TreeSet<Racecircuit> getCircuits() {
        return null;
    }

    @Override
    public boolean voegToe(Racecircuit racecircuit) {
        return false;
    }

    @Override
    public boolean verwijder(String naam) {
        return false;
    }

    @Override
    public Racecircuit zoek(String naam) {
        return null;
    }

    @Override
    public int getAantal() {
        return 0;
    }

    @Override
    public List<Racecircuit> gesorteerdOpLengte() {
        return null;
    }

    @Override
    public List<Racecircuit> gesorteerdOpNaam() {
        return null;
    }

    @Override
    public List<Racecircuit> gesorteerdOpLocatie() {
        return null;
    }
}
