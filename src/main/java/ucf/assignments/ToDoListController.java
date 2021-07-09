package ucf.assignments;
/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Asad merouani
 */

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ToDoListController implements Initializable {
    TodolistTableManager todolistTableManager = new TodolistTableManager();
    ObservableList<TaskItem> todoItemsData;
    ObservableList<ToDoTask> taskDataList;
    ObservableList<TaskItem> todoItemsDataIncomplete;
    ObservableList<TaskItem> todoItemsDataComplete;
    @FXML
    private TableView<ToDoTask> toDoTaskTableView;

    @FXML
    private TableView<TaskItem> taskItemTableView;

    @FXML
    private MenuBar menuBar;

    @FXML
    private MenuItem closeMenu;

    @FXML
    private MenuItem newMenu;

    @FXML
    private MenuItem openMenu;

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
    private TextField itemName;

    @FXML
    private TextField description;

    @FXML
    private Button addItem;

    @FXML
    private TextField dueDate;

    @FXML
    void AddTaskButtonClicked(ActionEvent event) {

        // get the the textField content
        // call add method of TodolistManager to set the the new content into the todolist.
        // clear the textField
        //final ObservableList<ToDoTask> data = TasksTableView.getItems();

    }

    @FXML
    public void addItemClicked(ActionEvent actionEvent) {

        // get the the textField content
        // call TodolistManager to set the the new content into the todolist.
        // clear the textField

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
        todolistTableManager.changeStatus("incomplate");
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
        todolistTableManager.showAllItems();
    }
    @FXML
    void saveTaskMenuClicked(ActionEvent event) {

        // Get the Observable data collection of the task list
        // call the save function in the ToDoListManager
    }

    @FXML
    public void deleteTaskClicked(ActionEvent actionEvent) {
        // call the method delete of the todolistTaskManager

    }

    @FXML
    public void deleteItemClicked(ActionEvent actionEvent) {
        // call the method delete of the todolistTaskManager

    }

}
