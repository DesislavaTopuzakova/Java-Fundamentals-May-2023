package students;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine()); //бр. студенти

        List<Student> studentList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String data = scanner.nextLine();
            //data = "{firstName} {lastName} {grade}".split(" ") -> ["{fN}", "{lN}", "{gr}"]
            String firstName = data.split(" ")[0];
            String lastName = data.split(" ")[1];
            double grade =  Double.parseDouble(data.split(" ")[2]);

            Student student = new Student(firstName, lastName, grade);
            studentList.add(student);
        }

        //списък със студенти -> сортираме по оценка (descending order) -> отпечатваме
        Collections.sort(studentList, Comparator.comparingDouble(Student::getGrade) //ascending order
                                                                        .reversed()); //descending order

        for (Student student : studentList) {
            //име фамилия: оценка
            System.out.printf("%s %s: %.2f%n", student.getFirstName(), student.getLastName(), student.getGrade());
        }
    }
}
