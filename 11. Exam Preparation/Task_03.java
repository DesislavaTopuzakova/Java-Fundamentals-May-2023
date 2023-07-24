package exam_prepration;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Task_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1 ЧАСТ: ПОДГОТОВКА ЗА ЗАПОЧВАНЕ НА ИГРА
        //име на героя -> hp
        Map<String, Integer> heroesHP = new LinkedHashMap<>();
        //име на героя -> mp
        Map<String, Integer> heroesMP = new LinkedHashMap<>();

        int countHeroes = Integer.parseInt(scanner.nextLine()); //брой на героите
        for (int hero = 1; hero <= countHeroes; hero++) {
            String heroInfo = scanner.nextLine(); //информация за героя
            //"Solmyr 85 120".split(" ") -> ["Solmyr", "86", "120"]
            String[] heroData = heroInfo.split("\\s+"); //["Solmyr", "86", "120"]
            String heroName = heroData[0]; //име на героя
            int hp = Integer.parseInt(heroData[1]); //хит точки на героя
            int mp = Integer.parseInt(heroData[2]); //мана точки на героя

            //проверка за hp -> hp <= 100
            if (hp <= 100) {
                //име на играча -> hp
                heroesHP.put(heroName, hp);
            }

            //проверка за mp -> mp <= 200
            if (mp <= 200) {
                //име на герой -> mp
                heroesMP.put(heroName, mp);
            }
        }

        //heroesHP: всеки един герой колко hp има
        //heroesMP: всеки един герой колко mp има

        //2 ЧАСТ: ЗАПОЧВАМЕ ИГРАТА
        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String [] commandParts = command.split("\\s+-\\s+");
            String commandName = commandParts[0]; //име на командата: "CastSpell", "TakeDamage", "Recharge", "Heal"
            String heroName = commandParts[1]; //име на героя

            switch (commandName) {
                case "CastSpell":
                    //command = "CastSpell – {hero name} – {MP needed} – {spell name}"
                    //commandParts = ["CastSpell", "{hero name}", "{MP needed}", "{spell name}"]
                    int mpNeeded = Integer.parseInt(commandParts[2]); //нужни мана точки за магията
                    String spellName = commandParts[3]; //име на магията
                    int currentMP = heroesMP.get(heroName); //текущите мана точки на героя

                    //1. можем да правим магията -> currentMP >= mpNeeded
                    if (currentMP >= mpNeeded) {
                        //ПРАВИМ МАГИЯТА
                        int mpLeft = currentMP - mpNeeded; //мана точки, останали след магията
                        heroesMP.put(heroName, mpLeft);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, mpLeft);
                    }
                    //2. НЕ можем да правим магията -> currentMP < mpNeeded
                    else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }
                    break;
                case "TakeDamage":
                    //command = "TakeDamage – {hero name} – {damage} – {attacker}"
                    //commandParts = ["TakeDamage", "{hero name}", "{damage}", "{attacker}"]
                    int damage = Integer.parseInt(commandParts[2]); //отнети точки при атака
                    String attacker = commandParts[3]; //атакуващ

                    int currentHP = heroesHP.get(heroName); //текущи хит точки
                    //АТАКА -> намаляваме текущите точки с отнети точки при атака
                    currentHP -= damage;

                    //дали е жив
                    if (currentHP > 0) {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, currentHP);
                        heroesHP.put(heroName, currentHP);
                    }
                    //дали е умрял -> currentHP <= 0
                    else {
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                        heroesHP.remove(heroName);
                        heroesMP.remove(heroName);
                    }
                    break;
                case "Recharge":
                    //command = "Recharge – {hero name} – {amount}"
                    //commandParts = ["Recharge", "{hero name}", "{amount}"]
                    int amount = Integer.parseInt(commandParts[2]); //количество за възстановяване(MP)
                    int currentMPHero = heroesMP.get(heroName); //текущите MP
                    //възстановяване на MP
                    currentMPHero += amount;

                    if(currentMPHero > 200) {
                        currentMPHero = 200;
                    }

                    //с колко се е увеличило: увеличеното - първоначалното
                    System.out.printf("%s recharged for %d MP!%n", heroName, currentMPHero - heroesMP.get(heroName));
                    heroesMP.put(heroName, currentMPHero);
                    break;
                case "Heal":
                    //command = "Heal – {hero name} – {amount}"
                    //commandParts = ["Heal", "{hero name}", "{amount}"]
                    int amountHeal = Integer.parseInt(commandParts[2]); //количество за възстановяване за HP
                    int currentHPHero = heroesHP.get(heroName); //теукущите HP

                    //възстановяване на HP
                    currentHPHero += amountHeal;

                    if (currentHPHero > 100) {
                        currentHPHero = 100;
                    }
                    //с колко се е увеличило: увеличеното - първоначалното
                    System.out.printf("%s healed for %d HP!%n", heroName, currentHPHero - heroesHP.get(heroName));
                    heroesHP.put(heroName, currentHPHero);

                    break;
            }
            command = scanner.nextLine();
        }

        //heroesHP: име на играч -> хит точки
        //heroesMP: име на играч -> мана точки


        heroesHP.entrySet()
        //(key) име на играч -> (value) хит точки
                .forEach(entry -> {
                    String heroName = entry.getKey();
                    System.out.println(heroName); //име на играча
                    System.out.println(" HP: " + entry.getValue()); //HP
                    System.out.println(" MP: " + heroesMP.get(heroName));
                });
    }
}
