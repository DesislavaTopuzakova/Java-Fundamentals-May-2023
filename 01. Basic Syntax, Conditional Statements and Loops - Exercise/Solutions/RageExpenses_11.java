package basicSyntax;

import java.util.Scanner;

public class RageExpenses_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //крайна сума = сума за слушалки (бр. слушалки * цена за 1 слушалки)
                    // + сума за мишки  (бр. мишки * цена за 1 мишка)
                    // + сума за клавиатури (бр. клавиатури * цена за 1 клавиатура)
                    // + сума за монитори   (бр. монитори * цена за 1 монитор)

        int countLoseGames = Integer.parseInt(scanner.nextLine()); //брой загубени игри
        double priceHeadset = Double.parseDouble(scanner.nextLine()); //цена за 1 слушалки
        double priceMouse = Double.parseDouble(scanner.nextLine()); //цена за 1 мишка
        double priceKeyboard = Double.parseDouble(scanner.nextLine()); //цена за 1 клавиатура
        double priceDisplay = Double.parseDouble(scanner.nextLine()); //цена за 1 монитор

        int countHeadset = 0; //бр. слушалки
        int countMouse = 0; //бр. мишки
        int countKeyboard = 0; //бр. калвиатури
        int countDisplay = 0; //бр. монитори

        for (int loseGame = 1; loseGame <= countLoseGames; loseGame++) {
            if (loseGame % 2 == 0) {
                //всяка втора игра -> слушалки
                countHeadset++;
            }
            if (loseGame % 3 == 0) {
                //всяка трета игра -> мишка
                countMouse++;
            }
            if (loseGame % 6 == 0) {
                //всяка шеста игра -> калвиатура
                countKeyboard++;
            }
            if (loseGame % 12 == 0) {
                //всяка дванадесета игра -> монитор
                countDisplay++;
            }
        }

        double totalPrice = (countHeadset * priceHeadset)
                + (countMouse * priceMouse)
                + (countKeyboard * priceKeyboard)
                + (countDisplay * priceDisplay);

        System.out.printf("Rage expenses: %.2f lv.", totalPrice);


    }
}
