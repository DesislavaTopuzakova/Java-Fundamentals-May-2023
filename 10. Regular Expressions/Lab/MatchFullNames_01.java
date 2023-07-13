package regex_lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullNames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        //"Ivan Ivanov, Ivan ivanov, ivan Ivanov, IVan Ivanov, Georgi Georgiev, Ivan	Ivanov"
        String regex = "\\b(?<firstName>[A-Z][a-z]+) (?<lastName>[A-Z][a-z]+)\\b"; //текст на шаблона
        Pattern pattern = Pattern.compile(regex); //шаблон
        Matcher matcher = pattern.matcher(text); //съвкупност от текстовете от променливата text, които отговарят на шаблона
        //matcher = {"Ivan Ivanov", "Georgi Georgiev"}

       // matcher.find() -> true ако имаме намерени текстове, false ако нямаме намерени текстове
        while (matcher.find()) {
            System.out.println("First name: " + matcher.group("firstName"));
            System.out.println("Last name: " + matcher.group("lastName"));
        }

    }
}
