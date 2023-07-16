package regex_exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        //да намерим валидните имейли във въведения текст
        //text = "Just send email to s.miller@mit.edu and j.hopking@york.ac.uk for more information."
        String regexUsername = "[A-Za-z0-9]+[\\.\\-\\_]?[A-Za-z0-9]+";
        String regexHost = "[A-Za-z]+\\-?[A-Za-z]+(\\.[A-Za-z]+\\-?[A-Za-z]+)+";
        String fullRegex = regexUsername + "@" + regexHost;
        Pattern pattern = Pattern.compile(fullRegex);

        Matcher matcher = pattern.matcher(text);
        //text = "Just send email to s.miller@mit.edu and j.hopking@york.ac.uk for more information."
        //matcher -> всички текстове, които ми отговарят на шаблона -> всички валидни имейли
        //matcher = ["s.miller@mit.edu", "j.hopking@york.ac.uk"]

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }
}
