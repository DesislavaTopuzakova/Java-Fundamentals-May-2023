package students;

public class Student {
    //описание на всеки студент
    //полета -> характеристики
    private String firstName;
    private String lastName;
    private double grade;

    //конструктор -> метод, чрез който създаваме обекти от класа
    public Student (String firstName, String lastName, double grade) {
        //нов празен обект
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    //методи -> действия
    //1. getter за полето grade -> достъп до стойността на полето
    public double getGrade() {
        return this.grade;
    }

    //2. getter за полето firstName
    public String getFirstName() {
        return this.firstName;
    }

    //3. getter за полето lastName
    public String getLastName() {
        return this.lastName;
    }
}
