package library;

import java.util.Arrays;

import library.application.ConsoleApp;
import library.application.GuiLauncher;


public class App {
    public static void main(String[] args) {
        String[] appArgs = Arrays.stream(args, 1, args.length).toArray(String[]::new);

        if (args.length > 0 && args[0].equalsIgnoreCase("cli")) {
            runConsole(appArgs);
        } else if (args.length > 0 && args[0].equalsIgnoreCase("gui")) {
            runGui(appArgs);
        } else {
            System.out.println("Incorrect cli arguments (choice cli | gui)");
        }
    }

    private static void runConsole(String[] args) {
        ConsoleApp.run(args);
    }

    private static void runGui(String[] args) {
        GuiLauncher.run(args);
    }
}
