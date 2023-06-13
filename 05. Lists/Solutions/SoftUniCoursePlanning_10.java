package lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1. входни данни -> списък с теми на занятия
        List<String> topics = Arrays.stream(scanner.nextLine()   //"Data Types, Objects, Lists"
                                .split(", "))               //["Data Types", "Objects", "Lists"]
                                .collect(Collectors.toList());    //{"Data Types", "Objects", "Lists"}

        String command = scanner.nextLine();
        while (!command.equals("course start")) {
            //1. command = "Add:{lessonTitle}".split(":")            -> ["Add", "{lessonTitle}"]
            //2. command = "Insert:{lessonTitle}:{index}".split(":") -> ["Insert", "{lessonTitle}", "{index}"]
            //3. command = "Remove:{lessonTitle}".split(":")         -> ["Remove", "{lessonTitle}"]
            //4. command = "Swap:{lessonTitle}:{lessonTitle}".split()-> ["Swap", "{lessonTitle1}", "{lessonTitle2}"]
            //5. command = "Exercise:{lessonTitle}".split(":")       -> ["Exercise", "{lessonTitle}"]
            String [] commandParts = command.split(":");
            String commandName = commandParts[0]; //"Add", "Insert", "Remove", "Swap", "Exercise"
            String topic = commandParts[1]; //тема / лекция

            switch (commandName) {
                case "Add":
                    //"Add:Databases"
                    //добавяме темата, ако я няма
                    if (!topics.contains(topic)) {
                        topics.add(topic);
                    }
                    break;
                case "Insert":
                    //"Insert:Databases:3"
                    int index = Integer.parseInt(commandParts[2]);
                    //добавяме темата на индекс, ако я няма
                    if (!topics.contains(topic)) {
                        topics.add(index, topic);
                    }
                    break;
                case "Remove":
                    //List, Array, Databases
                     //"Remove:Databases"
                    //премахваме темата (topic), ако я има
                    if (topics.contains(topic)) {
                        int indexTopic = topics.indexOf(topic); //мястото на темата
                        String exercise = topic + "-Exercise"; //име на упражнение
                        boolean hasExercise = indexTopic != topics.size() - 1 && topics.get(indexTopic + 1).equals(exercise);
                        //true -> имаме упражнение към темата
                        //false -> нямаме упражнение към темата
                        topics.remove(topic);
                        //премахвам упражнението към тази тема -> само ако го има
                        if (hasExercise) {
                            topics.remove(exercise);
                            //topics.remove(indexTopic + 1);
                        }
                    }

                    break;
                case "Swap":
                    //разменяме местата на двете дадени теми: topic, topic2
                    //{Arrays, Arrays-Exercise, Lists, Methods, Methods-Exercise}
                    //"Swap:Arrays:Methods"
                    //topic -> първата тема -> "Arrays"
                    //topic2 -> втората тема -> "Methods"
                    String topic2 = commandParts[2];
                    if (topics.contains(topic) && topics.contains(topic2)) {
                        int indexFirst = topics.indexOf(topic); // 0
                        int indexSecond = topics.indexOf(topic2); // 3

                        topics.set(indexFirst, topic2); //{Methods, Arrays-Exercise, Lists, Methods, Methods-Exercise}
                        topics.set(indexSecond, topic); //{Methods, Arrays-Exercise, Lists, Arrays, Methods-Exercise}

                        //{Methods, Arrays-Exercise, Lists, Arrays, Methods-Exercise}
                        //размяна и на упражненията
                        String exFirst = topic + "-Exercise"; //упражнение за първата тема
                        String exSecond = topic2 + "-Exercise"; //упражнение за втората тема

                        if (topics.contains(exFirst)) {
                            topics.remove(exFirst); //{Methods, Lists, Arrays, Methods-Exercise}
                            topics.add(topics.indexOf(topic) + 1, exFirst);
                        }

                        if (topics.contains(exSecond)) {
                            topics.remove(exSecond);
                            topics.add(topics.indexOf(topic2) + 1, exSecond);
                        }
                    }
                    break;
                case "Exercise":
                    //име на темата -> topic
                    String exerciseName = topic + "-Exercise"; //име на упражнението
                    //добавяме за съответната тема упражнение
                    //{Arrays, Lists, Methods}
                    //Exercise:Lists
                    //{Arrays, Lists, Lists-Exercise, Methods}

                    //1. проверка дали тази тема, за която ще добавям упражнение, съществува
                    if (topics.contains(topic)) {
                        //имам такава тема -> добавям упражнение
                        //проверка дали имам вече упражнение
                        int index1 = topics.indexOf(topic);
                        if (index1 == topics.size() - 1) {
                            //моята тема е последна в списъка -> НЯМАМЕ УПРАЖНЕНИЕ СЛЕД НЕЯ
                            topics.add(index1 + 1, exerciseName);
                        } else if (!topics.get(index1 + 1).equals(exerciseName)) {
                            //след моята тема няма упражнение
                            topics.add(index1 + 1, exerciseName);
                        }
                    } else {
                        //нямаме такава тема -> 1. добавяме темата в края на списъка  2. добавяме упражнение
                        topics.add(topic); //добавяме темата
                        topics.add(exerciseName); //добавяме и упражнение веднага след темата

                    }

                    break;
            }

            command = scanner.nextLine();
        }

        //списък с темите
        //номер.тема
        int count = 1;
        for (String topic : topics) {
            System.out.println(count + "." + topic);
            count++;
        }
    }
}
