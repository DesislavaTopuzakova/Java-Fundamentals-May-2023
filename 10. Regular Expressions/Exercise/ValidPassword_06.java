package regex_exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPassword_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine()); //брой на въведените редове
        String passwordRegex = "_\\.+(?<passwordText>[A-Z][A-Za-z0-9]{4,}[A-Z])_\\.+";
        Pattern pattern = Pattern.compile(passwordRegex);

        for (int row = 1; row <= n; row++) {
            String password = scanner.nextLine(); //"_...ChelseA_."
            //проверка дали въведената парола е валидна
            Matcher matcher = pattern.matcher(password);
            //matcher = ["_...ChelseA_."]

            if (matcher.find()) {
                //валидна парола -> категоризация в група
                String textPassword = matcher.group("passwordText"); //"ChelseA"
                StringBuilder sbCategory = new StringBuilder(); //долепям намерените цифри
                //категория = съвкупността от всички цифри
                for (char symbol : textPassword.toCharArray()) {
                    if (Character.isDigit(symbol)) {
                        //цифра
                        sbCategory.append(symbol);
                    }
                }
                //isEmpty <=> дължина == 0
                if (sbCategory.length() == 0) {
                    //нямаме цифри в паролата
                    System.out.println("Group: default");
                } else {
                    //имаме цифри в паролата
                    System.out.println("Group: " + sbCategory.toString());
                }

            } else {
                System.out.println("Invalid pass!");
            }
        }
    }
}
