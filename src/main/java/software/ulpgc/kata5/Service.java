package software.ulpgc.kata5;

import spark.Request;

public interface Service {

    String getCalculatorPage();
    String calculateFactorial(Request req);
    long calculateFactorial(int number);
}