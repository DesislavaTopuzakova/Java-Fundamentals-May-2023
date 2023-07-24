package exam_prepration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String allDestinations = scanner.nextLine(); //всички дестинации

        String regex = "([=\\/])(?<destination>[A-Z][a-zA-Z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(allDestinations);
        //съвкупност от текстовете, които отговарят на шаблона -> валидни дестинации
        //"=Hawai=/Cyprus/=Invalid/invalid==i5valid=/I5valid/=i="
        //matcher = ["=Hawai=", "/Cyprus/"]

        List<String> validDestinations = new ArrayList<>();
        while(matcher.find()) {
            //matcher.group -> "=Hawai=" -> "destination" -> "Hawai"
            String destination = matcher.group("destination");
            validDestinations.add(destination);
        }

        System.out.println("Destinations: " + String.join(", ", validDestinations));

        int travelPoints = 0;
        for (String destination : validDestinations) {
            travelPoints += destination.length();
        }

        System.out.println("Travel Points: " + travelPoints);





    }
}
