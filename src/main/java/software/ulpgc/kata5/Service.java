package software.ulpgc.kata5;

import spark.Request;

public interface Service {
    String getCalculatorPage();
    String calculateFactorial(Request request);
    long calculateFactorial(int number);
}
