package ucf.assignments;
/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Asad merouani
 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.DefaultStringConverter;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ItemListController implements Initializable {
    private final ItemListManager itemListManager = new ItemListManager();
    private String dueDate = "";

    private ObservableList<Item> itemsData = FXCollections.observableArrayList();
    ObservableList<Item> dataIncomplete = FXCollections.observableArrayList();
    ObservableList<Item> dataComplete = FXCollections.observableArrayList();

    private int clickCount = 0;

    @FXML
    private TableView<Item> itemTableView;

    @FXML
    private MenuBar menuBar;

    @FXML
    private MenuItem openMenu;

    @FXML
    private DatePicker dueDatePicker;

    @FXML
    private MenuItem showCompleteItemsMenu;

    @FXML
    private MenuItem showIncompleteItemsMenu;

    @FXML
    private MenuItem saveItemsMenu;

    @FXML
    private TableColumn Items;

    @FXML
    private TextField dueDatePreview;

    @FXML
    private TableColumn statusColumn;

    @FXML
    private TableColumn descriptionColumn;

    @FXML
    private TableColumn dueDateColumn;

    @FXML
    private DatePicker dueDatePreviewPicker;

    @FXML
    private TextArea previewDescription;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private TextField itemNameTextField;

    @FXML
    private void addItemClicked(ActionEvent actionEvent) {

        // get the the textField content
        // call TodolistManager to set the the new content into the todolist.
        // clear the textField

        String itemName = itemNameTextField.getText();
        String fieldDescription = descriptionTextArea.getText();

        if (fieldDescription.equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Missing information.");
            alert.setHeaderText("");
            alert.setContentText("Please enter a description for the item.");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
        } else if (itemName.equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Missing information.");
            alert.setHeaderText("");
            alert.setContentText("Please enter a title for the item.");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
        } else if (dueDate.equals("")) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Missing information.");
            alert.setHeaderText("Due Date Field is required.\n");
            alert.setContentText("*Your date could have an incorrect format.\n " +
                    "  - Format should be YYYY-MM-DD.\n \n* Your date could be in the past.");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
        } else {
            itemsData.add(new Item(itemName, fieldDescription, dueDate));
            itemTableView.setItems(itemsData);

            itemNameTextField.clear();
            descriptionTextArea.clear();
            dueDatePicker.setValue(null);
            dueDate = "";
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // populates the tableView// has the capacity to store at lease 100 tasks.
        // toDoTaskTableView.getItems();
        // populates the tableView for items// has the capacity to store at lease 100 items.
        // Set the cells todoTasks  table to be editable
        // Call setEditable function to make the title editable.
        // call setEditable function to make description and and due date editable
        itemTableView.setEditable(true);
        itemTableView.getSelectionModel().setCellSelectionEnabled(false);
        itemTableView.setPlaceholder(new Label(" No Data To display"));

        descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        //dueDateColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        ObservableList<String> cbValues = FXCollections.observableArrayList("Incomplete", "Complete");
        statusColumn.setCellFactory(ComboBoxTableCell.forTableColumn(new DefaultStringConverter(), cbValues));
        itemTableView.getSelectionModel().cellSelectionEnabledProperty().set(true);

    }

    // Load existing data files
    @FXML
    private void openMenuClicked(ActionEvent event) {
        // the method open of the todolistTableManager
        itemsData = itemListManager.open();
        itemTableView.setItems(itemsData);
    }


    @FXML
    private void closeMenuClicked(ActionEvent event) {
        // the method close of the todolistTableManager


    }

    @FXML
    private void showCompleteMenuClicked(ActionEvent event) {
        // call show showIncompleteItems method of the todolistTableManager.
        dataComplete = FXCollections.observableArrayList(itemsData);

        dataComplete = itemListManager.showCompleteItems(dataComplete);
        itemTableView.setItems(dataComplete);

    }

    @FXML
    private void showIncompleteMenuClicked(ActionEvent event) {
        // call show showIncompleteItems method of the todolistTableManager.

        dataIncomplete = FXCollections.observableArrayList(itemsData);

        dataIncomplete = itemListManager.showIncompleteItems(dataIncomplete);
        itemTableView.setItems(dataIncomplete);
    }

    @FXML
    private void showAllItemsMenuClicked(ActionEvent event) {
        // call show showAllItems method of the todolistTableManager.
        itemTableView.setItems(itemListManager.showAllItems(itemsData));
    }

    @FXML
    private void saveItemsClicked(ActionEvent event) {

        // Get the Observable data collection of the task list
        // call the save function in the ToDoListManager
        itemListManager.save(itemsData);
    }

    @FXML
    private void deleteItemClicked(ActionEvent actionEvent) {
        // call the method delete of the todolistTaskManager

        int index = itemTableView.getSelectionModel().getSelectedIndex();
        itemTableView.setItems(itemListManager.delete(itemsData, index));
    }

    @FXML
    private void clearClicked(ActionEvent event) {
        // call the itemsListManger object to clear the Dat
        itemsData = itemListManager.clear(itemsData);
        itemTableView.setItems(itemsData);
    }

    @FXML
    private void dueDateSelectClicked(ActionEvent event) {
        LocalDate localDate = dueDatePicker.getValue();

        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);

        try {
            if (localDate != null && localDate.isAfter(yesterday)) {
                dueDate = localDate.toString();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();

        }
    }

    @FXML
    private void mouseClicked(MouseEvent event) {
        int index = 0;
        index = itemTableView.getSelectionModel().getSelectedIndex();

        if (index >= 0) {
            previewDescription.setText(itemsData.get(index).getDescription());
            final DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(itemsData.get(index).getDueDate());
            dueDatePreviewPicker.setValue(localDate);

        }

    }

    @FXML
    private void keyBordPressedDescription(KeyEvent event) {
        int index = itemTableView.getSelectionModel().getSelectedIndex();
        if (event.getCode().equals(KeyCode.ENTER)) {
            previewDescription.setEditable(false);
            itemsData.get(index).setDescription(previewDescription.getText());
        }
    }

    @FXML
    private void descriptionPreviewMouseClicked(MouseEvent event) {
        int index = itemTableView.getSelectionModel().getSelectedIndex();

        clickCount++;
        if (clickCount % 2 == 0 && index >= 0) {
            previewDescription.setEditable(true);
            clickCount = 0;
        }
    }

    @FXML
    private void datePickerPreviewClicked(MouseEvent event) {
        int index = itemTableView.getSelectionModel().getSelectedIndex();

        clickCount++;

        if (clickCount % 2 == 0 && index >= 0) {
            clickCount = 0;
        }

    }

    @FXML
    private void datePickerPreviewKey(KeyEvent event) {
        int index = itemTableView.getSelectionModel().getSelectedIndex();
        if (index >= 0) {
            if (event.getCode().equals(KeyCode.ENTER)) {
                itemsData.get(index).setDueDate(dueDatePreviewPicker.getValue().toString());
            }
        }
    }
}
