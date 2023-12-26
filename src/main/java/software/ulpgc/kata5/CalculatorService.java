package software.ulpgc.kata5;

import spark.Request;

public class CalculatorService implements Service{

    public String getCalculatorPage(){
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

    public String calculateFactorial(Request req){
        String numberParam = req.queryParams("number");
        try {
            int number = Integer.parseInt(numberParam);
            long factorial = calculateFactorial(number);
            return "Factorial of " + number + " is: " + factorial;
        }catch (NumberFormatException e){
            return "Invalid number format. Please enter a valid integer.";
        }
    }

    public long calculateFactorial(int number) {
        if(number == 0 || number == 1){
            return 1;
        }else{
            return number*calculateFactorial(number-1);
        }
    }
}