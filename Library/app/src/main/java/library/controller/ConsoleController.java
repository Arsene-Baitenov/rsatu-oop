package library.controller;

import java.util.ArrayList;
import java.util.List;

import library.model.*;
import library.view.ConsoleView;

public class ConsoleController {
    private final ConsoleView view;
    //    private final List<Publication> publications = new ArrayList<>();
    private final Library<Publication> library = new Library<>();

    public ConsoleController(ConsoleView view) {
        this.view = view;
    }

    public void start() {
        while (true) {
            view.showMenu();
            int choice = view.readChoice();

            switch (choice) {
                case 1 -> addPublication();
                case 2 -> showAll();
                case 0 -> {
                    System.out.println("Выход...");
                    return;
                }
                default -> System.out.println("Неверный выбор.");
            }
        }
    }

    private void addPublication() {
        String type = view.readString("Тип (Книга/Журнал): ");
        String title = view.readString("Название: ");
        String author = view.readString("Автор: ");
        int year = view.readInt("Год: ");

        if ("Книга".equalsIgnoreCase(type)) {
            String genre = view.readString("Жанр: ");
            library.addPublication(new Book(title, author, year, genre));
        } else if ("Журнал".equalsIgnoreCase(type)) {
            int issueNumber = view.readInt("Выпуск №: ");
            library.addPublication(new Magazine(title, author, year, issueNumber));
        } else {
            System.out.println("Неизвестный тип.");
        }
    }

    private void showAll() {
        library.forEach(p -> System.out.printf(" - %s\n", p.getInfo()));
    }
}
