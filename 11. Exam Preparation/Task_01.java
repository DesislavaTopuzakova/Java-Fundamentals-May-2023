package exam_prepration;

import java.util.Scanner;

public class Task_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encryptedMessage = scanner.nextLine(); //криптирано съобщение
        StringBuilder modifyMessage = new StringBuilder(encryptedMessage); //модифицирам криптираното съобщение

        String command = scanner.nextLine();
        while(!command.equals("Decode")) {
            if (command.contains("Move")) {
                //command = "Move|5".split("|") -> ["Move", "5"]
                int countLetters = Integer.parseInt(command.split("\\|")[1]);//брой на буквите, които трябва да взема от текста
                //"Desislava" -> първите 5 -> "Desis"
                String firstLetters = modifyMessage.substring(0, countLetters);
                //премахвам от текста
                modifyMessage.delete(0, countLetters); //премахвам взетите букви от началото -> "lava"
                //modifyMessage.replace(0, countLetters, "");
                //слагам накрая -> "lava" + "Desis" = "lavaDesis"
                modifyMessage.append(firstLetters);
            } else if (command.contains("Insert")) {
                //command = "Insert|2|Desi".split("|") -> ["Insert", "2", "Desi"]
                int index = Integer.parseInt(command.split("\\|")[1]); //индекс, на който искаме да вмъкнем
                String textToInsert = command.split("\\|")[2]; //текст за вмъкване
                if (index >= 0 && index <= modifyMessage.length() - 1) {
                    modifyMessage.insert(index, textToInsert);
                }
            } else if (command.contains("ChangeAll")) {
                //command = "ChangeAll|ab|vr".split("|") -> ["ChangeAll", "ab", "vr"]
                String textForChange = command.split("\\|")[1]; //текст, който трябва да се замени
                String replacement = command.split("\\|")[2]; //текст, който ще замества

                String currentMessage = modifyMessage.toString(); //моментно съобщение
                currentMessage = currentMessage.replace(textForChange, replacement); //замяна в текста
                modifyMessage = new StringBuilder(currentMessage);
            }

            command = scanner.nextLine();
        }

        System.out.println("The decrypted message is: " + modifyMessage);


    }
}
