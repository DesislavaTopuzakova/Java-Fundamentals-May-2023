package dataTypes;

import java.util.Scanner;

public class SumDigits_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int sum = 0; //сума от цифрите

        //повтаряме:
        //1. взимаме последната цифра
        //2. сумираме
        //3. премахваме последната цифра
        //стоп: число <= 0 нямам повече цифри
        //продължаваме: число > 0

        while (number > 0) {
            int lastDigit = number % 10;
            sum += lastDigit;
            number /= 10;
        }

        System.out.println(sum);
    }
}
