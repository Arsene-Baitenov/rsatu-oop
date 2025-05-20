package library.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import library.model.Book;
import library.model.Library;
import library.model.Magazine;
import library.model.Publication;

public class GuiController {

    @FXML
    private ChoiceBox<String> typeChoiceBox;

    @FXML
    private TextField titleField;

    @FXML
    private TextField authorField;

    @FXML
    private TextField yearField;

    @FXML
    private TextField genreField;

    @FXML
    private TextField issueNumberField;

    @FXML
    private HBox genreBox;

    @FXML
    private HBox issueNumberBox;

    @FXML
    private TableView<Publication> publicationTable;

    @FXML
    private TableColumn<Publication, String> titleColumn;

    @FXML
    private TableColumn<Publication, String> authorColumn;

    @FXML
    private TableColumn<Publication, Integer> yearColumn;

    @FXML
    private TableColumn<Publication, String> typeColumn;

    @FXML
    private TableColumn<Publication, String> extraColumn;

    private final Library<Publication> library = new Library<>();

    private final ObservableList<Publication> observablePublications = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        typeChoiceBox.setItems(FXCollections.observableArrayList("Book", "Magazine"));
        typeChoiceBox.setValue("Book");

        typeChoiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            updateVisibleFields(newVal);
        });
        String selected = typeChoiceBox.getValue();
        updateVisibleFields(selected);

        titleColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitle()));
        authorColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAuthor()));
        yearColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getYear()).asObject());

        typeColumn.setCellValueFactory(cellData -> {
            Publication p = cellData.getValue();
            String type = (p instanceof Book) ? "Book" : (p instanceof Magazine) ? "Magazine" : "Unknown";
            return new javafx.beans.property.SimpleStringProperty(type);
        });

        extraColumn.setCellValueFactory(cellData -> {
            Publication p = cellData.getValue();
            if (p instanceof Book) {
                return new SimpleStringProperty(((Book) p).getGenre());
            } else if (p instanceof Magazine) {
                return new SimpleStringProperty(String.format("%d", ((Magazine) p).getIssueNumber()));
            } else {
                return new javafx.beans.property.SimpleStringProperty("");
            }
        });

        publicationTable.setItems(observablePublications);
    }

    @FXML
    private void onAddClicked() {
        try {
            String type = typeChoiceBox.getValue();
            Publication publication = getPublication(type);

            library.addPublication(publication);
            observablePublications.add(publication);

            clearInputFields();

        } catch (NumberFormatException e) {
            showAlert("Ошибка ввода", "Год должен быть числом.");
        } catch (Exception e) {
            showAlert("Ошибка", e.getMessage());
        }
    }

    private Publication getPublication(String type) {
        String title = titleField.getText().trim();
        String author = authorField.getText().trim();
        int year = Integer.parseInt(yearField.getText().trim());

        Publication publication;

        if ("Book".equals(type)) {
            String genre = genreField.getText().trim();
            publication = new Book(title, author, year, genre);
        } else {
            int issueNumber = Integer.parseInt(issueNumberField.getText().trim());
            publication = new Magazine(title, author, year, issueNumber);
        }
        return publication;
    }

    @FXML
    private void onDeleteClicked() {
        Publication selected = publicationTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            library.removePublication(selected);
            observablePublications.remove(selected);
        } else {
            showAlert("Внимание", "Выберите публикацию для удаления.");
        }
    }

    private void clearInputFields() {
        titleField.clear();
        authorField.clear();
        yearField.clear();
        genreField.clear();
        issueNumberField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void updateVisibleFields(String type) {
        if ("Book".equals(type)) {
            genreBox.setVisible(true);
            genreBox.setManaged(true);
            issueNumberBox.setVisible(false);
            issueNumberBox.setManaged(false);
        } else if ("Magazine".equals(type)) {
            genreBox.setVisible(false);
            genreBox.setManaged(false);
            issueNumberBox.setVisible(true);
            issueNumberBox.setManaged(true);
        } else {
            genreBox.setVisible(false);
            genreBox.setManaged(false);
            issueNumberBox.setVisible(false);
            issueNumberBox.setManaged(false);
        }
    }
}
