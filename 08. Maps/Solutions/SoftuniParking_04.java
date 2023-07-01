package maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftuniParking_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countCommands = Integer.parseInt(scanner.nextLine());

        //собственик -> номер на колата
        Map<String, String> parkingData = new LinkedHashMap<>();

        for (int count = 1; count <= countCommands; count++) {
            String command = scanner.nextLine();
            //1. command = "register {username} {licensePlateNumber}"
            //2. command = "unregister {username}"
            String [] commandParts = command.split(" ");
            //commandParts = ["register", "{username}", "{licensePlateNumber}"]
            //commandParts = ["unregister", "{username}"]
            String commandName = commandParts[0]; //име на команда: "register" или "unregister"
            String username = commandParts[1]; //име на собственик

            switch (commandName) {
                case "register":
                    String carNumber = commandParts[2]; //номер на колата
                    //1. имаме такъв собственик
                    if (parkingData.containsKey(username)) {
                        System.out.printf("ERROR: already registered with plate number %s%n", parkingData.get(username));
                    }
                    //2. нямаме такъв собственик
                    else {
                        parkingData.put(username, carNumber);
                        System.out.printf("%s registered %s successfully%n", username, carNumber);
                    }
                    break;
                case "unregister":
                    //1. имали сме такъв собственик
                    if (parkingData.containsKey(username)) {
                        parkingData.remove(username);
                        System.out.printf("%s unregistered successfully%n", username);
                    }
                    //2. нямали сме такъв собственик
                    else {
                        System.out.printf("ERROR: user %s not found%n", username);
                    }
                    break;
            }
        }

        //map: собственик (ключ) -> номер на колата (value)
        //собственика => номер
        parkingData.forEach((key, value) -> System.out.println(key + " => " + value));

        //3 начин за отпечатване
        //entry: key(username) -> value(car number)
        //parkingData.entrySet().forEach(entry -> System.out.println(entry.getKey() + " => " + entry.getValue()));
    }
}
