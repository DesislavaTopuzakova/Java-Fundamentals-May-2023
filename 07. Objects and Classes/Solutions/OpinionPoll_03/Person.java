package opinionPoll;

public class Person {
    //описва всеки един човек

    //полета -> характеристики (име, възраст)
    private String name;
    private int age;

    //конструктор -> метод, чрез който създаваме обект от класа
    public Person(String name, int age) {
        //нов празен обект
        this.name = name;
        this.age = age;
    }

    //методи -> действия;
    //getters -> методи, които използваме, за да достъпваме/взимаме стойностите на полетата

    //1. getter на полето name -> взимам стойността на полето name
    public String getName() {
        return this.name;
    }

    //2. getter на полето age -> взимам стойността на полето age
    public int getAge() {
        return this.age;
    }

}
