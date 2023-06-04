package methods;

import java.util.Scanner;

public class PalindromeIntegers_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            //input = "3456"
            //проверка дали въведения текст е палиндром
            System.out.println(checkPalindrome(input));
            input = scanner.nextLine();
        }
    }

    //метод, който проверява дали даден тескт е палиндром
    //true -> текстът е палиндром
    //false -> текстът не е палиндром
    public static boolean checkPalindrome (String text) {
        //text = "Desi"
        //reversedText = "iseD"
        //палиндром е всеки текст, кой е еднакъв с обърнатия си на обратно

        String reversedText = ""; //текстът, обърнат на обратно
        for (int index = text.length() - 1; index >= 0; index--) {
            reversedText += text.charAt(index);
        }

        return text.equals(reversedText);
    }

}
