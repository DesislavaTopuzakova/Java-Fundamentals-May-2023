package methods;

import java.util.Scanner;

public class MiddleCharacters_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        printMiddleCharacters(text);
    }

    //метод, който принтира средния символ
    public static void printMiddleCharacters (String text) {
        int length = text.length();
        //нечетна дължина -> 1 среден символ
        if (length % 2 != 0) {
            //"aString" -> ['a', 'S', 't', 'r', 'i', 'n', 'g']
            int indexOfMiddleCharacter = length / 2;
            System.out.println(text.charAt(indexOfMiddleCharacter));
        }
        //четна дължина -> 2 средни символа
        else {
            //"someText" -> 8 символа -> eT (index: 3 и 4)
            //"dogs" -> 4 символа -> og (index: 1 и 2)
            int indexFirstMiddleCharacter = length / 2 - 1;
            int indexSecondMiddleCharacter = length / 2;

            System.out.print(text.charAt(indexFirstMiddleCharacter));
            System.out.print(text.charAt(indexSecondMiddleCharacter));
        }
    }
}
