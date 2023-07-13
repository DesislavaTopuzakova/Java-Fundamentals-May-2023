package regex_lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        //"+359 2 222 2222,359-2-222-2222, +359/2/222/2222, +359-2 222 2222 +359 2-222-2222, +359-2-222-222, +359-2-222-22222 +359-2-222-2222"
        //+359{разделител}{areaCode = 2}{разделител}{3 цифри}{разделител}{4 цифри}
        String regex = "\\+359([ -])2\\1\\d{3}\\1\\d{4}\\b"; //текст на шаблона
        Pattern pattern = Pattern.compile(regex); //шаблон
        Matcher matcher = pattern.matcher(text); //съвкупност от текстовете от промениливата text, които отговарят на шаблона
        //matcher = {"+359 2 222 2222", "+359-2-222-2222"}

        List<String> validPhoneNumbers = new ArrayList<>(); //валидни номера
        while (matcher.find()) {
            validPhoneNumbers.add(matcher.group());
        }

        System.out.println(String.join(", ", validPhoneNumbers));
    }
}
