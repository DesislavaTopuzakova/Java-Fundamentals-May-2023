package ExamPreparation;

import java.util.Scanner;

public class SoftUniReception_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. входни данни
        int firstEmployeeStudents = Integer.parseInt(scanner.nextLine()); //брой студенти, които обслужва първия служител на час
        int secondEmployeeStudents = Integer.parseInt(scanner.nextLine()); //брой студенти, които обслужва втория служител на час
        int thirdEmployeeStudents = Integer.parseInt(scanner.nextLine());  //брой студенти, които обслужва третия служител на час
        int studentsCount = Integer.parseInt(scanner.nextLine()); //общ брой студенти, които трябва да бъдат обслужени

        int studentsPerHour = firstEmployeeStudents + secondEmployeeStudents + thirdEmployeeStudents; //брой студенти, обслужени за 1 час
        int totalHours = 0; //брой часове, нужни за обслужването на всички студенти

        //повтаряме: обслужваме максималния брой студенти за служител
        //спираме: студенти <= 0
        //продължаваме: студенти > 0

        while (studentsCount > 0) {
            //обслужване
            totalHours++;
            if (totalHours % 4 == 0) {
                continue;
            }
            //общ брой студенти, обслужени за 1 час
            studentsCount -= studentsPerHour;
        }

        System.out.printf("Time needed: %dh.", totalHours);
    }
}
