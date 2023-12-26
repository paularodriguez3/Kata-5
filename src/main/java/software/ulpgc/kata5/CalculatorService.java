package software.ulpgc.kata5;

import spark.Request;

public class CalculatorService implements Service {

    @Override
    public String getCalculatorPage() {
        return "<html>" +
                "<body>" +
                "<h2>Factorial Calculator</h2>" +
                "<form action='/calculate' method='post'>" +
                "   Enter a number: <input type='text' name='number'>" +
                "   <input type='submit' value='Calculate'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    @Override
    public String calculateFactorial(Request request) {
        String numberParams = request.queryParams("number");
        try {
            int number = Integer.parseInt(numberParams);
            long factorial = calculateFactorial(number);
            return "Factorial de " + number + "es: " + factorial;
        } catch (NumberFormatException e) {
            return "Formato inválido. Introduce un número válido.";
        }
    }

    @Override
    public long calculateFactorial(int number) {
        if (number == 0 || number == 1){
            return 1;
        } else {
            return number * calculateFactorial(number-1);
        }
    }
}
