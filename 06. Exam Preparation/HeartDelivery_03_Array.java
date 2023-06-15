package ExamPreparation;
import java.util.Arrays;
import java.util.Scanner;
public class HeartDelivery_03_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //входни данни
        int [] houses = Arrays.stream(scanner.nextLine() //"10@10@10@2"
                        .split("@")) //["10", "10", "10", "2"]
                .mapToInt(Integer::parseInt) //[10, 10, 10, 2]
                .toArray();

        int currentIndex = 0; //на коя къща се намира Купидон

        String command = scanner.nextLine();

        while (!command.equals("Love!")) {
            //command = "Jump 3".split(" ") -> ["Jump", "3"]
            int jumpLength = Integer.parseInt(command.split(" ")[1]);
            //скача
            currentIndex += jumpLength;

            //проверка дали е извън квартала
            if (currentIndex > houses.length - 1) {
                currentIndex = 0;
            }

            //къщата, в която отива -> проверка има ли нужда -> дава сърца
            if (houses[currentIndex] != 0) { //имаме нужда от сърца, защото бр. нужни сърца != 0
                houses[currentIndex] -= 2;
                //ако след даването вече нямаме нужда
                if (houses[currentIndex] == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", currentIndex);
                }
            } else {
                //къщата, в която отива -> брой нужни сърца = 0
                System.out.printf("Place %d already had Valentine's day.%n", currentIndex);
            }
            command = scanner.nextLine();
        }

        //къща = 0 -> няма нужда да и даваме -> може да празнува празника
        //къща != 0 -> има нужда от даване на сърца
        System.out.printf("Cupid's last position was %d.%n", currentIndex);
        //успешна мисия -> всички стойности на къщите да са 0
        boolean isFailed = false;
        //isFailed = true -> провал
        //isFailed = false -> успешна
        int countFailedHouse = 0;
        for (int house : houses) {
            if (house != 0) {
                isFailed = true;
                countFailedHouse++;
            }
        }
        //isFailed = false -> преминали през всички къщи = 0
        if (isFailed) {
            System.out.printf("Cupid has failed %d places.%n", countFailedHouse);
        } else {
            //isFailed = false
            System.out.println("Mission was successful.");
        }
    }
}
