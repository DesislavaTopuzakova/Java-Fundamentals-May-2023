package methods;

import java.util.Scanner;

public class FactorialDivision_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. входни данни -> 2 числа
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());

        //2. факториел на първото число
        long factFirstNumber = calculateFactorial(firstNumber);

        //3. факториел на второто число
        long factSecondNumber = calculateFactorial(secondNumber);

        //4. ф1 / ф2 = дробно число -> %.2f
        double result = factFirstNumber * 1.0 / factSecondNumber;
        System.out.printf("%.2f", result);
    }

    //метод, който връща резултат (факториел на дадено число)
    //!!! изчисленият факториел може да бъде много голямо число!!!
    public static long calculateFactorial (int number) {
        //number = 7
        //7! = 1 * 2 * 3 * 4 * 5 * 6 * 7
        long fact = 1; //стойността на факториел
        for (int i = 1; i <= number; i++) {
            fact = fact * i;
        }

        return fact;
    }
}
