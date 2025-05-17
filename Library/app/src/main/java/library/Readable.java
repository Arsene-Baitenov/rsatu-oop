package library;

import java.util.function.Consumer;


public interface Readable {
    void read(Consumer<String> consumer);
}
