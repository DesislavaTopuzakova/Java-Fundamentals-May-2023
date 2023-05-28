package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. входни данни
        int [] numbers = Arrays.stream(scanner.nextLine()   // "1 4 3 2"
                          .split(" "))                 //["1", "4", "3", "2"]
                          .mapToInt(Integer::parseInt)      //[1, 4, 3, 2]
                          .toArray();

        //!!! последния елемент винаги е топ число -> отпечатваме
        for (int index = 0; index < numbers.length - 1; index++) {
            //всички числа без последното и ги проверяваме дали са топ числа
            int currentNumber = numbers[index]; //число на текущия индекс

            boolean isBigger = true;
            //true -> текущото число е по-голямо от всички в дясно
            //false -> текущото число не е по-голямо

            for (int i = index + 1; i <= numbers.length - 1; i++) {
                //всички елементи след моя до последния включително
                int numberAfter = numbers[i];
                if (currentNumber <= numberAfter) {
                    isBigger = false;
                    break;
                    //моето число е по-малко от някое след него
                }
            }

            if (isBigger) {
                //моето число винаги е било по-голямо от числото след него
                //топ число
                System.out.print(currentNumber + " ");
            }
            
        }

        //винаги отпечатваме последното число, защото то е топ число без да го проверяваме
        System.out.print(numbers[numbers.length - 1]);
    }
}
