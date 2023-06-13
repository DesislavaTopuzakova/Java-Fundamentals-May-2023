package lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine() //"4 5 6 7 2 3"
                        .split(" "))//["4", "5", "6", "7", "2", "3"]
                .map(Integer::parseInt)// [4, 5, 6, 7, 2, 3]
                .collect(Collectors.toList());// {4, 5, 6, 7, 2, 3}

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] commandParts = command.split(" ");
            String commandName = commandParts[0]; //"Add", "Insert", "Remove", "Shift"
            switch (commandName) {
                case "Add":
                    //command = "Add {number}".split(" ")            -> ["Add", "{number}"]
                    int numberToAdd = Integer.parseInt(commandParts[1]);
                    numbers.add(numberToAdd);
                    break;
                case "Insert":
                    //command = "Insert {number} {index}".split(" ") -> ["Insert", "{number}", "{index}"]
                    int numberForInsert = Integer.parseInt(commandParts[1]);
                    int indexForInsert = Integer.parseInt(commandParts[2]);
                    //проверка дали дадения индекс е валиден -> индекс е [0; size - 1]
                    if (isValidIndex(indexForInsert, numbers.size())) {
                        numbers.add(indexForInsert, numberForInsert);
                    } else {
                        //невалиден индекс
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    //command = "Remove {index}".split(" ")          -> ["Remove", "{index}"]
                    int indexToRemove = Integer.parseInt(commandParts[1]);
                    //проверка дали дадения индекс е валиден -> индекс е [0; size - 1]
                    if (isValidIndex(indexToRemove, numbers.size())) {
                        numbers.remove(indexToRemove);
                        //remove index -> numbers.remove((int) index);
                        //remove element -> numbers.remove(Integer.valueOf(number));
                    } else {
                        //невалиден индекс
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    String direction = commandParts[1]; //посока: "left" или "right"
                    int countTimes = Integer.parseInt(commandParts[2]); //брой на пътите, в които правите промяна
                    if (direction.equals("left")) {
                        //command = "Shift left {count}".split(" ")     -> ["Shift", "left", "{count}"]
                        for (int i = 1; i <= countTimes; i++) {
                            //повтаряме: първия елемент става последен
                            //{3, 4, 5, 7, 8}
                            //1. взимам първия елемент -> 3
                            int firstElement = numbers.get(0);
                            //2. премахвам го -> {4, 5, 7, 8}
                            numbers.remove(0);
                            //3. поставям го като последен -> {4, 5, 7, 8, 3}
                            numbers.add(firstElement);
                        }
                    } else if (direction.equals("right")) {
                        //command = "Shift right {count}".split(" ")      -> ["Shift", "right", "{count}"]
                        for (int i = 1; i <= countTimes; i++) {
                            //повтаряме: последния елемент става първи
                            //{8, 4, 5, 6, 2}
                            //1. взимаме последния елемент -> 2
                            int lastElement = numbers.get(numbers.size() - 1);
                            //2. премахваме последния елемент -> {8, 4, 5, 6}
                            numbers.remove(numbers.size() - 1);
                            //3. добавяме в началото -> {2, 8, 4, 5, 6}
                            numbers.add(0, lastElement);
                        }
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        //краен списък -> отпечатвам
        for (int number : numbers) {
            System.out.print(number + " ");
        }

    }

    //метод, който проверява дали даден индекс е валиден
    //true -> ако индексът е валиден
    //false -> ако индексът не е валиден
    public static boolean isValidIndex (int index, int size) {
        return index >= 0 && index <= size - 1;
    }
}
