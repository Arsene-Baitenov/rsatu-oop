package library.model;

public class Book extends Publication {
    private final String genre;

    public Book(String title, String author, int year, String genre) {
        super(title, author, year);
        this.genre = genre;
    }

    @Override
    public String getInfo() {
        return String.format("Book: %s by %s (%d), Genre: %s", title, author, year, genre);
    }

    public String getGenre() {
        return genre;
    }
}
