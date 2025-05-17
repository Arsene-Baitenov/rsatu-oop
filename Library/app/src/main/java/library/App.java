package library;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library<Publication> library = new Library<>();

        while (true) {
            System.out.println("1. Add Book\n2. Add Magazine\n3. Show All\n4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Genre: ");
                    String genre = scanner.nextLine();
                    library.addPublication(new Book(title, author, year, genre));
                }
                case 2 -> {
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Year: ");
                    int year = scanner.nextInt();
                    System.out.print("Issue Number: ");
                    int issue = scanner.nextInt();
                    scanner.nextLine();
                    library.addPublication(new Magazine(title, author, year, issue));
                }
                case 3 -> library.forEach(p -> System.out.println(p.getInfo()));
                case 4 -> {
                    System.out.println("Bye!");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
