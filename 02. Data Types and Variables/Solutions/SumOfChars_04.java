package dataTypes;

import java.util.Scanner;

public class SumOfChars_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); //брой на символи

        //за всеки символ от първия до последния поватаряме:
        //1. прочитам стойността на символа от конзолата
        //2. сумирам аски кода на символа

        int sum = 0; //сума от аски кодовете на символите
        for (int count = 1; count <= n; count++) {
            char symbol = scanner.nextLine().charAt(0);//въведения символ
            sum += symbol;
        }

        System.out.println("The sum equals: " + sum);
    }
}
