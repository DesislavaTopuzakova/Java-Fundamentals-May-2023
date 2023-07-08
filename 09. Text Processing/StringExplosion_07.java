package textProcessing;

import java.util.Scanner;

public class StringExplosion_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //входни данни
        String input = scanner.nextLine(); //"abv>1>1>2>2asdasd"
        StringBuilder textBuilder = new StringBuilder(input); //"abv>1>1>2>2asdasd"

        int totalStrength = 0; //обща сила на експлозията
        for (int position = 0; position <= textBuilder.length() - 1; position++) {
            char currentSymbol = textBuilder.charAt(position);
            if (currentSymbol == '>') {
                //експлозия
                //char '1' -> string "1" -> int 1
                int explosionStrength = Integer.parseInt(textBuilder.charAt(position + 1) + ""); //сила на експлозия
                totalStrength += explosionStrength;
            } else if (currentSymbol != '>' && totalStrength > 0){
                //премахвам
                textBuilder.deleteCharAt(position);
                totalStrength--;
                position--; //да се мине отново през текущата позиция
            }
        }

        System.out.println(textBuilder);
    }
}
