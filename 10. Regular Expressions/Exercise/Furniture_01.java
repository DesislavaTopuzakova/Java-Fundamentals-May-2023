package regex_exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = ">>(?<furnitureName>[A-Za-z]+)<<(?<price>[0-9]+\\.?[0-9]*)!(?<quantity>[0-9]+)"; //текст на шаблона
        Pattern pattern = Pattern.compile(regex); //шаблон
        List<String> furniture = new ArrayList<>(); //закупените мебели
        double totalPrice = 0; //общо изхарчена сума за всички закупени мебели

        String input = scanner.nextLine(); //входни данни
        //">>{furniture name}<<{price}!{quantity}"
        while (!input.equals("Purchase")) {
            //input = ">>Sofa<<312.23!3"
            Matcher matcher = pattern.matcher(input);
            //matcher = [">>(?<furnitureName>TV)<<(?<price>312.23)!(?<quantity>3)"]
            //find
            //true -> ако input отговарят на regex
            //false -> ако input не отговарят
            if (matcher.find()) {
                //input отговаря на regex -> валидни входни данни -> купуваме мебели
                String furnitureName = matcher.group("furnitureName"); //мебел -> "TV"
                double price = Double.parseDouble(matcher.group("price")); //ед. цена -> "312.23" -> parse -> 312.23
                int quantity = Integer.parseInt(matcher.group("quantity")); //количество -> "3" -> parse -> 3

                furniture.add(furnitureName);
                //сума, която сме заплатили за текущата мебел
                double currentPrice = price * quantity; //заплатили за текущата мебел
                totalPrice += currentPrice;
            }
            input = scanner.nextLine();
        }

        //списък със закупените мебели
        System.out.println("Bought furniture:");
        for (String f : furniture) {
            System.out.println(f);
        }

        //обща сума за закупените мебели
        System.out.printf("Total money spend: %.2f", totalPrice);
    }
}
