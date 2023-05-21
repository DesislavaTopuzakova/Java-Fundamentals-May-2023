package dataTypes;

import java.util.Scanner;

public class SumDigits_For_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int sum = 0; //сума от цифрите

        //1. int -> String
        //2. всички символи (цифри)
        //позиции от 0 до последната

        String numberAsString = "" + number; // "" + 543 = "543" -> String.valueOf(number)
        for (int position = 0; position <= numberAsString.length() - 1; position++) {
            char currentSymbol = numberAsString.charAt(position); //'5'
            //char -> String -> int
            //'5' -> 5
            int currentDigit = Integer.parseInt(currentSymbol + "");
            sum += currentDigit;
        }

        System.out.println(sum);

    }
}
