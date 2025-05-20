package library.view;

import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("----------------------");
        System.out.println("1. Добавить публикацию");
        System.out.println("2. Показать все");
        System.out.println("3. Выход");
    }

    public int readChoice() {
        System.out.print("Выбор: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int readInt(String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(scanner.nextLine());
    }

}