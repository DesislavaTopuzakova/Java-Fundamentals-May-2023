package maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //материали
        //shards -> количество
        //fragments -> количество
        //motes -> количество

        Map<String, Integer> materials = new LinkedHashMap<>(); //материали, които са ни нужни
        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);

        Map<String, Integer> junks = new LinkedHashMap<>(); //материали, които са боклуци

        boolean isWin = false;
        //isWin = false -> не сме спечелили и играта продължава
        //isWin = true -> сме спечелили и играта приключва
        while (!isWin) {
            String input = scanner.nextLine();
            //input = "6 leathers 255 fragments 7 Shards"
            String [] inputData = input.split("\\s+");
            //inputData = ["6", "leathers", "255", "fragments", "7", "shards"]

            for (int index = 0; index <= inputData.length - 1; index += 2) {
                    int quantity = Integer.parseInt(inputData[index]); //количество
                    String material = inputData[index + 1].toLowerCase(); //материал

                    //проверка на материала -> събрали сме го
                    if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                        //валиден материал -> събираме
                        int currentQuantity = materials.get(material);
                        materials.put(material, currentQuantity + quantity);
                    } else {
                        //боклук
                        if (junks.containsKey(material)) {
                            int currentQuantity = junks.get(material);
                            junks.put(material, currentQuantity + quantity);
                        } else {
                            junks.put(material, quantity);
                        }
                    }

                    //проверка дали сме спечелили легендарен предмет
                    if (materials.get("shards") >= 250) {
                        //печелим Shadowmourne
                        System.out.println("Shadowmourne obtained!");
                        materials.put("shards", materials.get("shards") - 250);
                        isWin = true;
                        break;
                    } else if (materials.get("fragments") >= 250) {
                        //печелим Valanyr
                        System.out.println("Valanyr obtained!");
                        materials.put("fragments", materials.get("fragments") - 250);
                        isWin = true;
                        break;
                    } else if (materials.get("motes") >= 250) {
                        //печелим Dragonwrath
                        System.out.println("Dragonwrath obtained!");
                        materials.put("motes", materials.get("motes") - 250);
                        isWin = true;
                        break;
                    }
            }

            if (isWin) {
                break;
            }
        }

        //всички валидни материали -> materials
        //entry: key (материал) -> value (количество)
        materials.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        //всички боклуци -> junks
        //entry: key (боклук) -> value (количество)
        junks.entrySet().forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

    }
}
