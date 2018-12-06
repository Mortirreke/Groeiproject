package model;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * @author: Quinten Mortier
 **/
public class TestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestSuite.class);


        System.out.println("failures: "+ result.getFailureCount());
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("succesful: " + result.wasSuccessful());
        System.out.println("Tijd: " + result.getRunTime() + " ms");

    }
}
