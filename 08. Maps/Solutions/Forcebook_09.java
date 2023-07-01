package maps;

import java.util.*;

public class Forcebook_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        //отбор -> списък с играчите
        Map<String, List<String>> teams = new LinkedHashMap<>();

        while (!input.equals("Lumpawaroo")) {
            if (input.contains(" | ")) {
                //input = "{force_side} | {force_user}".split(" | ") -> ["{force_side}", "{force_user}"]
                String team = input.split(" \\| ")[0];
                String player = input.split(" \\| ")[1];
                //проверка за отбора
                //1. нямаме такъв отбор
                if (!teams.containsKey(team)) {
                    teams.put(team, new ArrayList<>());
                }
                //2. имаме такъв отбор
                //добавяме играча към отбора, ако го няма в някой друг отбор
                boolean isExist = false; //играча го има в друг отбор
                //isExist = true -> играчът го има в друг отбор
                //isExist = false -> играчът го няма в друг отбор
                for (List<String> list : teams.values()) {
                    if (list.contains(player)) {
                        isExist = true;
                        break;
                    }
                }

                if (!isExist) {
                    teams.get(team).add(player);
                }
            } else if (input.contains(" -> ")) {
                //input = "{force_user} -> {force_side}".split(" -> ") -> ["{force_user}", "{force_side}"]
                String player = input.split(" -> ")[0]; //играч, който се мести
                String team = input.split(" -> ")[1]; //отбор, в който се мести

                //1. премахваме играча ако го има в някой отбор
                teams.entrySet().forEach(entryTeam -> entryTeam.getValue().remove(player));

                //2. преместване в новия отбор
                //2.1. има ли такъв отбор -> няма
                if (!teams.containsKey(team)) {
                    teams.put(team, new ArrayList<>());
                    teams.get(team).add(player);
                }
                //2.2. има ли такъв отбор -> има
                else {
                    teams.get(team).add(player);
                }

                System.out.printf("%s joins the %s side!%n", player, team);
            }
            input = scanner.nextLine();
        }

        //print
        //премахваме отборите без играчи
        teams.entrySet().stream().filter(teamEntry -> teamEntry.getValue().size() > 0) //оставяме само тези записи, които отговарят на условието
                .forEach(entry -> {
                    //entry: key (team) -> value (list of players)
                    //"Side: {forceSide}, Members: {forceUsers.Count}
                    System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
                    entry.getValue().forEach(player -> System.out.println("! " + player));
                });
    }
}
