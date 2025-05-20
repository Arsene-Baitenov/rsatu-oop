package library.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;

import java.net.URL;


public class GuiLauncher extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL fxml = getClass().getResource("/library/view/library_view.fxml");
        System.out.println("1 FXML URL: " + fxml);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/library/view/library_view.fxml"));

        System.out.println("2 FXML URL: " + fxml);


        Parent root = loader.load();

        System.out.println("3 FXML URL: " + fxml);


        primaryStage.setTitle("Library");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public static void run(String[] args) {
        launch(args);
    }
}

//        String javaVersion = System.getProperty("java.version");
//        String javafxVersion = System.getProperty("javafx.version");
//        Label label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java" + javaVersion);
//        Scene scene = new Scene(new StackPane(label), 640, 480);
//        primaryStage.setScene(scene);
//        primaryStage.show();