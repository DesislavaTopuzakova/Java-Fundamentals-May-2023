package methods;

import java.util.Scanner;

public class AddAndSubtract_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1. входни данни -> 3 цели числа
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());
        //(firstNumber + secondNumber) - thirdNumber
        System.out.println(subtract(firstNumber, secondNumber, thirdNumber));

    }

    //метод, който сумира две цели числа и връща сумата
    public static int sum (int n1, int n2) {
        return n1 + n2;
    }

    //метод, който ще извади от сумата на две числа третото и връща резултат
    public static int subtract (int n1, int n2, int n3) {
        return sum(n1, n2) - n3;
    }


}
