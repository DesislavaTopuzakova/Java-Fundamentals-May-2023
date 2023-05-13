package basicSyntax;

import java.util.Scanner;
public class PrintAndSum_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. принтираме числата от начално число до крайно число
        int startNumber = Integer.parseInt(scanner.nextLine()); //начало на интервала
        int endNumber = Integer.parseInt(scanner.nextLine()); //край на интервала

        //2. намерим сумата от числата в дадения интервал
        int sum = 0; //сумата на числата

        //FOR
        //повтаряме: отпечатваме число + интервал
        //начало: startNumber
        //край: endNumber
        //промяна: +1

        for (int number = startNumber; number <= endNumber; number++) {
            System.out.print(number + " ");
            sum = sum + number; //sum += number;
        }

        System.out.println(); //минава на нов ред
        System.out.println("Sum: " + sum);

    }
}
