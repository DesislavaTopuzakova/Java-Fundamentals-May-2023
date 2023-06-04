package methods;

import java.util.Scanner;

public class TopNumber_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int number = 8; number <= n; number++) {
            //проверка дали е топ
            //1. сумата от цифрите му да се дели на 8 -> checkSumDigitsIsDivisibleBy8
            //2. съдържа поне една нечетна цифра -> checkContainsOddDigit
            boolean isValidSumDigits = checkSumDigitsIsDivisibleBy8(number);
            if (isValidSumDigits) {
                boolean isContainsOddDigit = checkContainsOddDigit(number);
                if (isContainsOddDigit) {
                    //топ число
                    System.out.println(number);
                }
            }
        }
    }

    //метод, който проверява дали сумата от цифрите на числото се дели на 8
    //true -> сумата се дели на 8
    //false -> сумата не се дели на 8
    public static boolean checkSumDigitsIsDivisibleBy8 (int num) {
        //1. сума от цифрите на числото
        int sum = 0; //сума от цифрите
        while (num > 0) {
            int lastDigit = num % 10; //последна цифра
            sum += lastDigit; //сумираме последна цифра
            num = num / 10; //премахваме последната цифра
        }
        //2. проверка дали сумата се дели на 8
        return sum % 8 == 0;

        /*if (sum % 8 == 0){
            return true;
        } else {
            return false;
        }*/
    }

    //метод, който проверява дали имаме поне една нечетна цифра в числото
    //true -> ако имаме поне една нечетна цифра
    //false -> ако нямаме нито една нечетна цифра
    public static boolean checkContainsOddDigit (int number) {
        //3657
        while (number > 0) {
            int lastDigit = number % 10; //последна цифра
            if (lastDigit % 2 != 0) {
                //нечетна цифра -> поне една нечетна
                return true;
            } else {
                //четна цифра -> премахваме
                number = number / 10;
            }
        }
        //проверили всички цифри и никоя не е била нечетна
        return false;
    }
}
