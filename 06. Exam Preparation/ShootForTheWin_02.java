package ExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //входни данни
        int [] targets = Arrays.stream(scanner.nextLine()     //"24 50 36 70"
                        .split(" "))                    //["24", "50", "36", "70"]
                        .mapToInt(Integer::parseInt)           //[24, 50, 36, 70]
                        .toArray();
        int countShotTargets = 0; //брой успешни уцелени мишени

        String input = scanner.nextLine(); //"End" или индекс под формата на текст
        while (!input.equals("End")) {
            int shotIndex = Integer.parseInt(input); //целя мишената на дадения индекс

            //проверка дали индексът е валиден
            //валиден индекс: [0; length - 1]
            if (shotIndex >= 0 && shotIndex <= targets.length - 1) {
                int shotTarget = targets[shotIndex]; //мишена, която е уцелена

                //преди уцелването -> променяме всички останали мишени
                for (int i = 0; i <=  targets.length - 1; i++) {
                    int currentTarget = targets[i];
                    //всички мишени
                    //променяме само:
                    //1. мишени, които не са моята, която ще целя
                    //2. мишени, които не са -1
                    //мишена = -1 -> УЦЕЛЕНА
                    if (i != shotIndex && currentTarget != -1) {
                        if (currentTarget > shotTarget) {
                            currentTarget -= shotTarget;
                        } else {
                            //currentTarget <= shotTarget
                            currentTarget += shotTarget;
                        }
                        targets[i] = currentTarget; //слагаме новата стойност
                    }

                }

                //целя мишената на дадения индекс -> след промяната на останалите мишени
                targets[shotIndex] = -1;
                countShotTargets++;
            }

            input = scanner.nextLine();
        }


        //финална информация
        //1. брой на успешни мишени
        //2. масив с мишените и техните стойности

        System.out.print("Shot targets: " + countShotTargets + " -> ");
        for (int target : targets) {
            System.out.print(target + " ");
        }

    }
}
