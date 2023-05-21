package dataTypes;

import java.util.Scanner;

public class Pokemon_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1. входни данни
        int power = Integer.parseInt(scanner.nextLine()); //текуща сила (N)
        int startPower = power; //първоначалната сила
        int distance = Integer.parseInt(scanner.nextLine()); //разстоянието между целите (M)
        int factor = Integer.parseInt(scanner.nextLine()); //фактор на изтощение (Y)

        //повтаряме:
        //1. power - distance -> стигаме до целта си
        //2. намушкваме целта
        //стоп: power < distance
        //продължава: power >= distance

        int count = 0; //брой намушканите
        while (power >= distance) {
            //1. отивам до целта -> намаляваме силата с изминатото разстояние
            power -= distance; //power = power - distance;
            //2. наушкваме целта
            count++;

            //проверка за умора
            if (power == startPower / 2) { //if (power == startPower / 2 && factor != 0)
                //текущата сила / фактор
                boolean isDivisible = factor != 0;
                //isDivisible = true -> можем да извършим делението
                //isDivisible = false -> не можем да извършим делението
                if (isDivisible) {
                    //възможна аритметична операция (деление)
                    power = power / factor; //power /= factor;
                }
            }
        }

        System.out.println(power);
        System.out.println(count);

    }
}
