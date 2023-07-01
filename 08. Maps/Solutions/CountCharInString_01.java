package maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharInString_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().replaceAll(" ",""); //текст -> "Desi".toCharArray() -> ['D', 'e', 's', 'i']

        //запис: символ -> бр. срещания
        Map<Character, Integer> symbolsCount = new LinkedHashMap<>();
        //HashMap -> нямаме конкретна подредба на записите
        //LinkedHashMap -> редът зависи от реда на доабвянето
        //TreeMap -> нарежда записите по стойността на ключа

        for (char symbol : input.toCharArray()) {
            //проверка за интервал
            if (symbol == ' ') {
                continue;
            }
            //проверка дали вече сме го срещали
            if (symbolsCount.containsKey(symbol)) {
                int currentCount = symbolsCount.get(symbol);
                symbolsCount.put(symbol, currentCount + 1);
            }
            //проверка дали не сме го срещали
            else {
                symbolsCount.put(symbol, 1);
            }
        }

        //map: key(символ) -> value(бр. срещания)
        //символ -> бр. срещания

        //1 начин за отпечатване
        for (Map.Entry<Character, Integer> entry : symbolsCount.entrySet()) {
            //entry
            //entry.getKey() -> символ
            //entry.getValue() -> бр. срещания
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        //2 начин за отпечатване
        //symbolsCount.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
