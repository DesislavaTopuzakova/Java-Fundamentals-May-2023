package methods;

import java.util.Scanner;

public class VowelsCount_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().toLowerCase();
        //"Test".toLowerCase() -> "test"
        //"ElizA".toLowerCase() -> "eliza"

        printCountVowels(text);

    }

    //метод, който отпечатва брой на малките гласни букви в текста
    public static void printCountVowels (String text) {
        int count = 0; //брой гласните букви
        //text = "eliza".toCharArray() -> ['e', 'l', 'i', 'z', 'a']
        for (char symbol : text.toCharArray()) {
            //гласни букви: a, e, i, o, u
            if (symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u') {
                count++;
            }
        }
        System.out.println(count);
    }
}
