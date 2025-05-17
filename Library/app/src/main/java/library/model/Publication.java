package library.model;

import java.util.function.Consumer;

public abstract class Publication implements Readable {
    protected String title;
    protected String author;
    protected int year;

    public Publication(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public abstract String getInfo();

    @Override
    public void read(Consumer<String> consumer) {
        consumer.accept(String.format("Reading %s by %s.", title, author));
    }
}
