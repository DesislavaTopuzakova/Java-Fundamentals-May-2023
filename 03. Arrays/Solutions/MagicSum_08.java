package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MagicSum_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int targetSum = Integer.parseInt(scanner.nextLine());

        //обхождаме всички числа от масива
        for (int index = 0; index <= numbers.length - 1; index++) {
            int currentNumber = numbers[index]; //текущото число
            //обхождам всички числа след него
            for (int i = index + 1; i <= numbers.length - 1; i++) { //всички числа след моето
                int nextNumber = numbers[i]; //число, което е след моето

                if (currentNumber + nextNumber == targetSum) {
                    System.out.println(currentNumber + " " + nextNumber);
                }
            }
        }
    }
}
