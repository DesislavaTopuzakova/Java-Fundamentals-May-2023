package basicSyntax;

import java.util.Scanner;

public class StrongNumber_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int startNumber = number; //първоначалната стойност на числото

        int sumFact = 0; //сума на факториелитеч

        //стоп: число <= 0 -> нямаме повече цифри
        //продължавм: число > 0 -> имаме цифри в числото
        while (number > 0) {
            //1. последната цифра
            int lastDigit = number % 10; //взимаме последна или единствена цифра
            //2. факториел
            int fact = 1; //факториел на числото
            for (int i = 1; i <= lastDigit ; i++) {
                fact = fact * i;
            }
            //3. сумираме факториела
            sumFact += fact;
            //4. премахваме последната цифра
            number = number / 10; //number /= 10;
        }

        //проверка дали числото е силно или не
        //сума от факториелите == първоначалното число
        if (sumFact == startNumber) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
