package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        //повтарящо се действие: въвеждаме команди
        //стоп: входни данни == "end"
        //продължаваме: входни данни != "end"
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            //command != "end" -> валидна команда от условието
            if (command.contains("swap")) {
                //моята команда е swap: command == "swap 2 4".split(" ") -> ["swap", "2", "4"]
                int index1 = Integer.parseInt(command.split(" ")[1]); //parse("2") -> 2
                int index2 = Integer.parseInt(command.split(" ")[2]); //parse("4") -> 4

                int firstIndexNumber = numbers[index1];
                int secondIndexNumber = numbers[index2];

                numbers[index1] = secondIndexNumber;
                numbers[index2] = firstIndexNumber;

            } else if (command.contains("multiply")) {
                //моята команда е multiply: command = "multiply 3 6".split(" ") -> ["multiply", "3", "6"]
                int index1 = Integer.parseInt(command.split(" ")[1]); //parse("2") -> 2
                int index2 = Integer.parseInt(command.split(" ")[2]); //parse("4") -> 4

                int firstIndexNumber = numbers[index1];
                int secondIndexNumber = numbers[index2];

                int product =  firstIndexNumber * secondIndexNumber;
                numbers[index1] = product;

            } else if (command.equals("decrease")) {
                //моята команда е decrease: command == "decrease"
                //обхождаме всички елементи -> -1
                for (int index = 0; index <= numbers.length - 1; index++) {
                    numbers[index]--;
                    //numbers[index] -= 1;
                }
            }
            command = scanner.nextLine();
        }

        //отпечатваме числата в масива разделени с ", "
        //[34, 56, 76, 87].toString() -> "[34, 56, 76, 87]"

        //1-ви начин
       /* System.out.println(Arrays.toString(numbers)             //"[34, 56, 76, 87]"
                            .replace("[", "")   //"34, 56, 76, 87]"
                            .replace("]", "")); //"34, 56, 76, 87"
        */

        //2-ри начин
        //след всяко число то масива слагаме ", ", без след последното
        for (int index = 0; index <= numbers.length - 1; index++) {
            int currentNumber = numbers[index];
            if (index != numbers.length - 1) {
                System.out.print(currentNumber + ", ");
            } else { //index == numbers.length - 1
                //последния индекс -> последното число в масива
                System.out.print(currentNumber);
            }
        }


    }
}
