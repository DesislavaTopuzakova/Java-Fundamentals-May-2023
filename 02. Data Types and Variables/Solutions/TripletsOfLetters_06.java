package dataTypes;

import java.util.Scanner;

public class TripletsOfLetters_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (char letter1 = 'a'; letter1 < 'a' + n; letter1++) { //първата буква в тройката
            for (char letter2 = 'a'; letter2 < 'a' + n; letter2++) { //втората буква в тройката
                for (char letter3 = 'a'; letter3 < 'a' + n; letter3++) { //третата буква в тройката
                    //{letter1}{letter2}{letter3}
                    System.out.printf("%c%c%c%n", letter1, letter2, letter3);
                }
            }
        }
    }
}
