package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class EqualsSums_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int index = 0; index <= numbers.length - 1; index++) {
                int currentNumber = numbers[index];

                int leftSum = 0; //сума на елементите в ляво
                int rightSum = 0; //сума на елементите в дясно

                //1. намеря сумата на елементите в ляво
                //лява сума: всички елементи от първия (0) до моя (не вкл.)
                for (int leftIndex = 0; leftIndex < index; leftIndex++) {
                    leftSum += numbers[leftIndex];
                }

                //2. намеря сумата на елементие в дясно
                //дясна сума: всички елементи след моя и до последния
                for (int rightIndex = index + 1; rightIndex <= numbers.length - 1; rightIndex++) {
                    rightSum += numbers[rightIndex];
                }

                //3. проверка дали са равни двете суми -> имам намерено число
                if (leftSum == rightSum) {
                    System.out.println(index);
                   return; //прекратява цялата програма
                }
        }

        //обходили всички числа и нито едно не е отговаряло на условието
        System.out.println("no");
    }
}
