package library.application;

import library.controller.ConsoleController;
import library.view.ConsoleView;

public class ConsoleApp {
    public static void run(String[] args) {
        ConsoleView view = new ConsoleView();
        ConsoleController controller = new ConsoleController(view);
        controller.start();
    }
}
