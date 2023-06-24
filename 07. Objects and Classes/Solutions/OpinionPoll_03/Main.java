package opinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main { //решаваме задачата
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine()); //бр. редове с лична информация

        List<Person> peopleList = new ArrayList<>();

        for (int row = 1; row <= n; row++) {
            String data = scanner.nextLine();
            //data = "Peter 12".split(" ") -> ["Peter", "12"]
            String name = data.split(" ")[0]; //въведено име
            int age = Integer.parseInt(data.split(" ")[1]); //въведена възраст

            if (age > 30) {
                Person person = new Person(name, age); //обект от класа
                peopleList.add(person);
            }
        }

        //списък с хората
        //всеки един човек -> отпечатваме
        for (Person person : peopleList) {
            //име - възраст
            System.out.println(person.getName() + " - " + person.getAge());
        }
    }
}


