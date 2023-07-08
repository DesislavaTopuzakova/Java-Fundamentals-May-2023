package textProcessing;

import java.util.Scanner;

public class ValidUsernames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //входни данни
        String input = scanner.nextLine(); //"sh, too_long_username, !lleg@l ch@rs, jeffbutt"
        String[] usernames = input.split(", "); //["sh", "too_long_username", "!lleg@l ch@rs", "jeffbutt"]

        //обходя всички username
        for (String username : usernames) {
            //проверка дали е валидно -> принт
            if (isValidUsername(username)) {
                System.out.println(username);
            }
        }
    }
    //метод, който проверява дали username е валидно
    //true -> ако е валидно
    //false -> ако не е валидно
    public static boolean isValidUsername (String username) {
        //1. валидна дължина
        //[3; 16] -> валиден
        if (username.length() < 3 || username.length() > 16) {
            //невалидна дължина -> невалиден username
            return false;
        }
        //дължина е [3;16] -> валидна дължина

        //2. валидно съдържание -> букви, цифри, -, _
        //username = "TestUser".toCharArray() -> ['T', 'e', 's', 't', 'U', 's', 'e', 'r']
        for (char symbol : username.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol) && symbol != '-' && symbol != '_') {
                //невалиден символ -> невалиден username
                return false;
            }
        }

        //валидно съдържание и валидна дължина -> валиден username
        return true;


    }
}
