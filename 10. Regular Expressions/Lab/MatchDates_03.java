package regex_lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        //"13/Jul/1928, 10-Nov-1934, , 01/Jan-1951,f 25.Dec.1937 23/09/1973, 1/Feb/2016"
        String regex = "(?<day>\\d{2})(?<separator>[\\.\\-\\/])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})"; //текст на шаблона
        Pattern pattern = Pattern.compile(regex); //шаблон
        Matcher matcher = pattern.matcher(text); //текстовете от променливата text, които отговрят на шаблона
        //matcher = {"13/Jul/1928", "10-Nov-1934", "25.Dec.1937"}

        while (matcher.find()) {
            //"13/Jul/1928"
            String day = matcher.group("day"); //"13"
            String month = matcher.group("month"); //"Jul"
            String year = matcher.group("year"); //"1928"

            //Day: 13, Month: Jul, Year: 1928
            System.out.printf("Day: %s, Month: %s, Year: %s%n", day, month, year);

        }
    }
}
