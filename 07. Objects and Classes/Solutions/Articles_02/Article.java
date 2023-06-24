package articles;

public class Article {
    //описание на статия
    //полета -> характеристики
    private String title;
    private String content;
    private String author;

    //конструктор -> метод, чрез който създаваме обекти от класа

    //меню за генериране на методи
    //ALT + INSERT
    //десен бутон някъде в класа -> Generate
    public Article(String title, String content, String author) {
        //създава нов празен обект
        this.title = title;
        this.content = content;
        this.author = author;
    }

    //getters -> методи, чрез които си даваме достъп до стойността на поле
    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public String getAuthor() {
        return this.author;
    }

    //методи -> действия

    //1. edit -> променя съдържанието
    public void edit (String newContent) {
        this.content = newContent;
    }

    //2. change author -> променя автора
    public void changeAuthor (String newAuthor) {
        this.author = newAuthor;
    }

    //3. rename -> променя заглавие
    public void rename (String newTitle) {
        this.title = newTitle;
    }

    //вградени методи -> toString
    //метод toString -> метод, който ми показва как да изглежда обекта под формата на текст
    //default: "{package}.{class}@{address}"
    //искам: "{title} - {content}: {author}"

    @Override //пренаписване на вграден метод
    public String toString() {
        return this.title + " - " + this.content + ": " + this.author;
    }
}
