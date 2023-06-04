package methods;

import java.util.Scanner;

public class SmallestOfThreeNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());

        printSmallestNumber(firstNumber, secondNumber, thirdNumber);

    }

    //метод, който принтира най-малкото от три зададени числa
    public static void printSmallestNumber (int n1, int n2, int n3) {
        if (n1 <= n2 && n1 < n3) {
            //първото да е най-малко
            System.out.println(n1);
        } else if (n2 <= n1 && n2 < n3) {
            //второто да е най-малко
            System.out.println(n2);
        } else {
            //третото да е най-малко
            System.out.println(n3);
        }
    }
}
