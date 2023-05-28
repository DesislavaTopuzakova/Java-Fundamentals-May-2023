package arrays;

import java.util.Scanner;

public class CommonElements_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1. входни данни

        String [] firstArray = scanner.nextLine().split("\\s+"); // "Hey hello 2 4" -> ["Hey", "hello", "2", "4"]
        String [] secondArray = scanner.nextLine().split(" "); //"10 hey 4 hello" -> ["10", "hey", "4", "hello"]

        //за всеки елемент на втория масив -> проверка дали го има в първия масив
        for (String el2 : secondArray) {
            for (String el1 : firstArray) {
                if (el2.equals(el1)) {
                    System.out.print(el1 + " ");
                }
            }
        }
    }
}
