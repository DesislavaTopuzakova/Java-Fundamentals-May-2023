package lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1. входни данни -> списък от цели числа
        List<Integer> numbers = Arrays.stream(scanner.nextLine() //"1 2 3 4 5 5 5 6"
                                .split(" "))  //["1", "2", "3", "4", "5", "5", "5", "6"]
                                .map(Integer::parseInt) //[1, 2, 3, 4, 5, 5, 5, 6]
                                .collect(Collectors.toList()); //{1, 2, 3, 4, 5, 5, 5, 6}

        //2. получаваме команди -> "end"
        String command = scanner.nextLine(); //"end" или валидна команда
        //repeat: въвеждаме нова команда
        //stop: command == "end"
        //continue: command != "end"
        while (!command.equals("end")) {
            //1. command = "Delete 4".split(" ") -> ["Delete", "4"]
            if (command.contains("Delete")) {
                int numberForRemove = Integer.parseInt(command.split(" ")[1]); //число, което ще премахваме
                //премахнем всички елементи в списъка, които са равни на numberForRemove
                numbers.removeAll(Arrays.asList(numberForRemove));
            }
            //2. command = "Insert 3 1".split(" ") -> ["Insert", "3", "1"]
            else if (command.contains("Insert")) {
                //insert element at the given position
                int element = Integer.parseInt(command.split(" ")[1]);
                int position = Integer.parseInt(command.split(" ")[2]);
                numbers.add(position, element);
            }
            command = scanner.nextLine();
        }

        //списък с числа -> печатаме -> {3, 4, 5, 6}
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}
