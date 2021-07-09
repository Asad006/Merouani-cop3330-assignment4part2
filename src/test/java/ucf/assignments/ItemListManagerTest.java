package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import org.junit.jupiter.api.Test;

import javax.swing.text.TabableView;

import static org.junit.jupiter.api.Assertions.*;

class ItemListManagerTest {

    @Test
    void add() {
        // Given
        // create  an object TodoListTableManager
        // expectedData observable  collection object set to empty
        // create actualData Observable Collection
        // when...
        // call method ADD to add new TodoTask object

        // then
        //assertEquals(expectedData,actualData);

        ItemListManager itemListManager = new ItemListManager();
        String nameItem = "Shop";
        String description = " make sure you do the groceries";
        String dueDate = " 2021-07-12";

        ObservableList<Item> expectedData = FXCollections.observableArrayList();
        Item item = new Item(nameItem, description, dueDate);
        expectedData.add(item);

        ObservableList<Item> actualData = FXCollections.observableArrayList();
        itemListManager.add(actualData, nameItem, description, dueDate);

        assertEquals(expectedData.get(0).getItemName(), actualData.get(0).getItemName());
        assertEquals(expectedData.get(0).getDescription(), actualData.get(0).getDescription());
        assertEquals(expectedData.get(0).getDueDate(), actualData.get(0).getDueDate());
        assertEquals(expectedData.get(0).getStatus(), actualData.get(0).getStatus());

    }

    @Test
    void delete() {
        // Given
        // create  an object TodoListTableManager
        // expectedData observable  collection object
        // add test objects to expectedData
        // create actualData Observable Collection with the deleted object

        // when...
        // get the row to be deleted.
        // call method deleted  to delete TodoTask object

        // then
        //assertEquals(expectedData,actualData);
        ItemListManager itemListManager = new ItemListManager();
        String nameItem = "Shop";
        String description = " make sure you do the groceries";
        String dueDate = " 2021-07-12";


        ObservableList<Item> expectedData = FXCollections.observableArrayList();
        ObservableList<Item> actualData = FXCollections.observableArrayList();

        Item item = new Item(nameItem, description, dueDate);
        actualData.add(item);
        int index = 0;

        itemListManager.delete(actualData, index);

        assertEquals(expectedData, actualData);

    }

    @Test
    void clear() {
        // Given
        // create  an object TodoListTableManager
        // expectedData observable  collection object
        // add test objects to expectedData
        // create actualData Observable Collection with the deleted object

        // when...
        // get the data be deleted.
        // call method  clear

        // then
        //assertEquals(expectedData,actualData);
        ItemListManager itemListManager = new ItemListManager();
        String nameItem = "Shop";
        String description = "make sure you do the groceries";
        String dueDate = "2021-07-12";


        ObservableList<Item> expectedData = FXCollections.observableArrayList();
        ObservableList<Item> actualData = FXCollections.observableArrayList();

        Item item = new Item(nameItem, description, dueDate);
        actualData.add(item);


        itemListManager.clear(actualData);

        assertEquals(expectedData, actualData);


    }

    @Test
    void showCompleteItems() {
        // Given
        // create  an object TodoListTableManager
        // expectedData observable  collection
        // add objects with complete  and incomplete item tags.
        // create actualData Observable Collection with only incomplete.

        // when...
        // call method showIncompleteItems to add new TodoTask object

        // then
        //assertEquals(expectedData,actualData);
        ItemListManager itemListManager = new ItemListManager();

        ObservableList<Item> expectedData = FXCollections.observableArrayList();
        ObservableList<Item> actualData = FXCollections.observableArrayList();

        Item item = new Item("test 1", "description test 1", "2021-07-11", "Complete");
        Item item1 = new Item("test 2", "description test 2", "2021-07-12", "Incomplete");
        Item item2 = new Item("test 3", "description test 3", "2021-07-13", "Incomplete");

        actualData.add(item);
        actualData.add(item1);
        actualData.add(item2);

        expectedData.add(item);

        actualData = itemListManager.showCompleteItems(actualData);

        assertEquals(expectedData, actualData);

    }
    @Test
    void showIncompleteItems() {
        // Given
        // create  an object TodoListTableManager
        // expectedData observable  collection
        // add objects with complete  and incomplete item tags.
        // create actualData Observable Collection with only incomplete.

        // when...
        // call method showIncompleteItems to add new TodoTask object

        // then
        //assertEquals(expectedData,actualData);
        ItemListManager itemListManager = new ItemListManager();

        ObservableList<Item> expectedData = FXCollections.observableArrayList();
        ObservableList<Item> actualData = FXCollections.observableArrayList();

        Item item = new Item("test 1", "description test 1", "2021-07-11", "Complete");
        Item item1 = new Item("test 2", "description test 2", "2021-07-12", "Incomplete");
        Item item2 = new Item("test 3", "description test 3", "2021-07-13", "Incomplete");

        actualData.add(item);
        actualData.add(item1);
        actualData.add(item2);

        expectedData.add(item1);
        expectedData.add(item2);

        actualData = itemListManager.showIncompleteItems(actualData);

        assertEquals(expectedData, actualData);

    }
    @Test
    void showAllItems() {
        // Given
        // create  an object TodoListTableManager
        // expectedData observable  collection
        // create identical actualData Observable Collection with expected.

        // when...
        // call method changeStatus  to change expectedData

        // then
        //assertEquals(expectedData,actualData);
    }
/*
    @Test
    void sort() {
        // Given
        // create an object TodoListTableManager
        // actualData Observable  Collection object set data
        // create actualData Observable Collection in lexicographic order

        // when...
        // call method sort to sort expectedData

        // then
        //assertEquals(expectedData,actualData);

    }

    @Test
    void setTableEditable() {
        // Given
        // create an object TodoListTableManager
        // actualData Observable  Collection object set data
        // create actualData Observable Collection in lexicographic order

        // when...
        // call setTableEditable() to edit the cell and change it to the expectedData

        // then
        //assertEquals(expectedData,actualData);
    }




    }*/
}