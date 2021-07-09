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
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ItemListController implements Initializable {
    private final ItemListManager itemListManager = new ItemListManager();
    private String dueDate = "";

    private final ObservableList<Item> itemsData = FXCollections.observableArrayList();
    ObservableList<Item> itemsDataIncomplete= FXCollections.observableArrayList();
    ObservableList<Item> itemsDataComplete= FXCollections.observableArrayList();

    @FXML
    private TableView<Item> itemTableView;

    @FXML
    private MenuBar menuBar;

    @FXML
    private MenuItem closeMenu;

    @FXML
    private MenuItem newMenu;

    @FXML
    private MenuItem openMenu;

    @FXML
    private DatePicker dueDatePicker;

    @FXML
    private MenuItem showCompleteItemsMenu;

    @FXML
    private MenuItem showIncompleteItemsMenu;

    @FXML
    private MenuItem saveTaskMenu;

    @FXML
    private MenuItem saveItemsMenu;

    @FXML
    private TableColumn toDoColumn;

    @FXML
    private TableColumn Items;

    @FXML
    private TableColumn descriptionColumn;

    @FXML
    private TableColumn dueDateColumn;

    @FXML
    private TextField addToDoListText;

    @FXML
    private Button AddTaskButton;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private TextField itemNameTextField;

    @FXML
    private TextField description;

    @FXML
    private Button addItem;


    @FXML
    public void addItemClicked(ActionEvent actionEvent) {

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
            alert.setHeaderText("Please enter a valid due date.");
            alert.setContentText("Your date could have an incorrect format.\n " +
                    "Format should be YYYY-MM-DD.\n \nYour date could be in the past.");
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

    }

    @FXML
    void saveItemsMenuClicked(ActionEvent event) {

        // get The variable of the Observable Collection data of the list
        // get the selected cell from observable collection
        // create object of the todoTask
        // call remove function of the observable collection

    }

    // Load multiple application with different data files
    @FXML
    void newMenuClicked(ActionEvent event) {
        // the method new of the todolistTableManager

    }

    @FXML
    void setStatusCompleteClicked(ActionEvent event) {
        // call changeStatus method of the todolistTableManager
    }

    @FXML
    void setStatusIncompleteClicked(ActionEvent event) {
        // call changeStatus method of the todolistTableManager
        itemListManager.changeStatus("incomplate");
    }

    // Load existing data files
    @FXML
    void openMenuClicked(ActionEvent event) {
        // the method open of the todolistTableManager

    }


    @FXML
    void closeMenuClicked(ActionEvent event) {
        // the method close of the todolistTableManager


    }

    @FXML
    void showCompleteMenuClicked(ActionEvent event) {
        // call show showIncompleteItems method of the todolistTableManager.

    }

    @FXML
    void showIncompleteMenuClicked(ActionEvent event) {
        // call show showIncompleteItems method of the todolistTableManager.
    }

    @FXML
    void showAllItemsMenuClicked(ActionEvent event) {
        // call show showAllItems method of the todolistTableManager.
        itemListManager.showAllItems();
    }

    @FXML
    void saveTaskMenuClicked(ActionEvent event) {

        // Get the Observable data collection of the task list
        // call the save function in the ToDoListManager
    }

    @FXML
    public void deleteItemClicked(ActionEvent actionEvent) {
        // call the method delete of the todolistTaskManager
        itemListManager.delete( itemTableView, itemsData);
    }

    @FXML
    void ClearClicked(ActionEvent event) {

    }

    @FXML
    void dueDateSelectClicked(ActionEvent event) {
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
    void mouseClicked(MouseEvent event) {

    }

}
