package textProcessing;

import java.util.Scanner;

public class CaesarCipher_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //входни данни -> текст
        String text = scanner.nextLine(); //"Programming is cool!"

        for (char symbol : text.toCharArray()) {
            //'A' -> 'D'
            char encryptSymbol = (char) (symbol + 3);
            System.out.print(encryptSymbol);
        }
    }
}
