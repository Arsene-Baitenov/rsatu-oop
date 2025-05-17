package library.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library<T extends Publication> implements Iterable<T> {
    private final List<T> publications = new ArrayList<>();

    public void addPublication(T publication) {
        publications.add(publication);
    }

    public void removePublication(T publication) {
        publications.remove(publication);
    }

    public Library<T> getPublicationsByAuthor(String author) {
        Library<T> publicationsByAuthor = new Library<>();

        this.forEach(publicationsByAuthor::addPublication);

        return publicationsByAuthor;
    }

    public List<T> toList() {
        return publications;
    }

    @Override
    public Iterator<T> iterator() {
        return publications.iterator();
    }
}
