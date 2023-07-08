package textProcessing;

import java.util.Scanner;

public class LettersChangeNumbers_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //входни данни
        String input = scanner.nextLine(); //"P34562Z q2576f   H456z"
        String[] codes = input.split("\\s+"); //["P34562Z", "q2576f", "H456z"]

        double totalSum = 0; //сума от модифицираните числа на всички кодове
        for (String code : codes) {
            //code: "{буква}{число}{буква}" => "А23r"
            //1. модифицирам числото в кода спрямо буквите
            double modifiedNumber = getModifiedNumber(code);
            //2. сумирам модифицираното число
            totalSum += modifiedNumber;
        }

        System.out.printf("%.2f", totalSum);
    }

    private static double getModifiedNumber(String code) {
        //код: "{буква}{число}{буква}" => "R234u"
        char letterBefore = code.charAt(0); //'R'
        char letterAfter = code.charAt(code.length() - 1); //'u'
        double number = Double.parseDouble(code.replace(letterBefore, ' ') //" 234u"
                            .replace(letterAfter, ' ')  //" 234 "
                            .trim()); //"234" -> parseDouble -> 234


        //модификация спрямо буквата преди -> letterBefore
        if (Character.isUpperCase(letterBefore)) {
            //главна -> А(65) до Z(90)
            int positionUpperLetter = (int) letterBefore - 64; //позиция на буквата в азбуката
            number /= positionUpperLetter;
            //number = number / positionUpperLetter;
        } else  {
            //малка -> a(97) до z(122)
            int positionLowerLetter = (int)letterBefore - 96; //позиция на буквата в азбуката
            number *= positionLowerLetter;
            //number = number * positionLowerLetter;
        }

        //модификация спрямо буквата след -> letterAfter
        if (Character.isUpperCase(letterAfter)) {
            //главна -> А(65) до Z(90)
            int positionUpperLetter = (int) letterAfter - 64; //позиция на буквата в азбуката
            number -= positionUpperLetter;
            //number = number - positionUpperLetter;
        } else {
            //малка -> a(97) до z(122)
            int positionLowerLetter = (int) letterAfter - 96; //позиция на буквата в азбуката
            number += positionLowerLetter;
            //number = number + positionLowerLetter;
        }

        return number;

    }
}
