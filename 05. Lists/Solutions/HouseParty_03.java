package lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> guestsList = new ArrayList<>(); //списък с гостите

        //1. входни данни
        int countCommands = Integer.parseInt(scanner.nextLine());
        for (int count = 1; count <= countCommands; count++) {
            String command = scanner.nextLine();
            String[] commandParts = command.split(" "); //брой думи на командата
            String name = commandParts[0]; //име на човека, който трябва да премахна / добавя
            if (command.contains("not")) { //commandPart.length ==  4
                //command = "{name} is not going!".split(" ") -> ["{name}", "is", "not", "going!"]
                //премахваме от списъка
                //1. има такъв човек в списъка
                if (guestsList.contains(name)) {
                    guestsList.remove(name);
                }
                //2. няма такъв човек в списъка
                else {
                    System.out.println(name + " is not in the list!");
                }
            } else {
                //command = "{name} is going!".split(" ") -> ["{name}", "is", "going!"]
                //добавяме към списъка
                //1. има такъв човек в списъка
                if (guestsList.contains(name)) {
                    System.out.println(name + " is already in the list!");
                }
                //2. няма такъв човек в списъка
                else {
                    guestsList.add(name);
                }
            }
        }

        //списък с гостите
        for (String guestName : guestsList) {
            System.out.println(guestName);
        }
    }
}
