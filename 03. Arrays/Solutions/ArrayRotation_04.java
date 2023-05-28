package arrays;

import java.util.Scanner;

public class ArrayRotation_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1. входни данни
        String [] array = scanner.nextLine() // "51 47 32 61 21"
                            .split(" "); //["51", "47", "32", "61", "21"]
        int countRotation = Integer.parseInt(scanner.nextLine());

        for (int rotation = 1; rotation <=  countRotation; rotation++) {
            //ротация на масив
            //1. взимаме първия елемент
            String firstElement = array[0]; //"51"

            //2. преместване на елементите наляво
            //["51", "47", "32", "61", "21"] -> ["47", "32", "61", "21", "21"]
            for (int index = 0; index < array.length - 1; index++) {
                    array[index] = array[index + 1];
            }

            //3. поставям първия елемент на последно място
            //["47", "32", "61", "21", "51"]
            array[array.length - 1] = firstElement;
        }

        //приключваме с ротациите -> принтираме елементите на масива
        /*for (String element : array) {
            System.out.print(element + " ");
        }*/
        //["47", "32", "61", "21", "51"] -> "47 32 61 21 51"
        System.out.println(String.join(" ", array)); //работи само за масив от текстове
    }
}
