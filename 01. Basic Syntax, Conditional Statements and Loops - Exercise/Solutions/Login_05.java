package basicSyntax;

import java.util.Scanner;

public class Login_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //профил
        String username = scanner.nextLine(); //потребителско име -> "Desi1998"
        String password = ""; //парола -> username обърнат на обратно
        //последната към първата
        for (int position = username.length() - 1; position >= 0; position--) {
            char currentSymbol = username.charAt(position);
            password += currentSymbol;
        }

        //повтаряме: въвеждаме парола
        //стоп: въведената парола == password
        //продължаваме: въведената парола !=  password

        int countWrongPassword = 0; //брой грешни пароли
        String enteredPassword = scanner.nextLine(); //въведената парола

        while (!enteredPassword.equals(password)) {
            //грешна парола
            countWrongPassword++;
            //1. проверка дали имаме блокиране -> неуспешни опити = 4
            if (countWrongPassword == 4) {
                System.out.printf("User %s blocked!", username);
                break;
            }
            //2. ОПИТАЙ ОТНОВО
            System.out.println("Incorrect password. Try again.");
            enteredPassword = scanner.nextLine();
        }

        //вярна парола
        if (enteredPassword.equals(password)) {
            System.out.printf("User %s logged in.", username);
        }

    }
}
