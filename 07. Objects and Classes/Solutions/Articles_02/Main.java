package articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String articleData = scanner.nextLine(); //"{title}, {content}, {author}".split(", ") -> ["{title}", "{content}", "{author}"]
        String title = articleData.split(", ")[0]; //заглавие на статия
        String content = articleData.split(", ")[1]; //съдържанието на статия
        String author = articleData.split(", ")[2]; //автор на статия

        //статия -> title, content, author
        Article article = new Article(title, content, author);

        int countCommands = Integer.parseInt(scanner.nextLine()); //бр. команди
        for (int count = 1; count <= countCommands; count++) {
            String command = scanner.nextLine(); //текст на командата
            //command = "Edit: {new content}".split(": ") -> ["Edit", "{new content}"]
            //command = "ChangeAuthor: {new author}".split(": ") -> ["ChangeAuthor", "{new author}"]
            //command = "Rename: {new title}".split(": ") -> ["Rename", "{new title}"]

            String commandName = command.split(": ")[0]; // "Edit", "ChangeAuthor", "Rename"
            String commandParam = command.split(": ")[1];

            switch (commandName) {
                case "Edit":
                    //commandParam = "{new content}"
                    //сменя съдържанието на статията
                    article.edit(commandParam);
                    break;
                case "ChangeAuthor":
                    //commandParam = "{new author}"
                    //сменя автора на статията
                    article.changeAuthor(commandParam);
                    break;
                case "Rename":
                    //commandParam = "{new title}"
                    //сменя заглавието на статията
                    article.rename(commandParam);
                    break;
            }
        }

        //принтиране на статията
        //"{title} - {content}: {author}"
        System.out.println(article.toString());
    }
}
