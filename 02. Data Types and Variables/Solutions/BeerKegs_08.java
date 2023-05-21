package dataTypes;

import java.util.Scanner;

public class BeerKegs_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countKegs = Integer.parseInt(scanner.nextLine()); //брой кегове

        //за всеки един кег от 1 до последния (countKegs):
        //1. модел -> String
        //2. радиус -> double
        //3. височина -> int
        //4. обем = пи * радиус * радиус * височина

        double maxVolume = 0; //максималния обем
        String maxModel = ""; //модел на кега, който е с най-голям обем

        for (int keg = 1; keg <= countKegs; keg++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            double volume = Math.PI * Math.pow(radius, 2) * height;

            //проверка дали изчисления обем е максимален
            if (volume >  maxVolume) {
                maxVolume = volume;
                maxModel = model;
            }
        }

        System.out.println(maxModel);

    }
}
