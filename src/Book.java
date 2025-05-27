public class Book {
    private String author;
    private String title;
    private int pages;
    private int year;

    public Book(String author, String title, int pages, int year) {
        this.author = author;
        this.title = title;
        this.pages = pages;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Автор: " + author + " название: " + title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPages() {
        return pages;
    }

    public int getYear() {
        return year;
    }
}
