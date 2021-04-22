package pk.ztp.springlibrary.beans;

public class Book {
    public static int i = 0;
    protected int id;
    protected String title;
    protected String author;
    protected int year;


    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.id = i;
        incrementI();
    }

    public static void incrementI() {
        Book.i++;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", author=" + author + ", year=" + year + '}';
    }
}