import exceptions.DifferentTypeOfReckoningException;
import exceptions.InvalidOperationFormatException;

import java.util.Scanner;

public class Main {

    static Calculator calculator = new Calculator();

    public static void main(String[] args) {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.print("Input a math formula: ");
            String inputLine = in.nextLine();
            try {
                System.out.println("Result: " + calc(inputLine));
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static String calc(String input) throws DifferentTypeOfReckoningException, InvalidOperationFormatException {
        return calculator.calc(input);
    }

}
