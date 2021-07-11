package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

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
        expectedData.add(item1);
        expectedData.add(item2);

        actualData = itemListManager.showAllItems(actualData);

        assertEquals(expectedData, actualData);

    }

    @Test
    void Open() {

        // load File
        // create an object of type ItemListManger
        // call function process file
        // create new expected and actual data collection
        // assert this two data collections
        ItemListManager itemListManager = new ItemListManager();

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("TestFile.json").getFile());

        ObservableList<Item> expectedData = FXCollections.observableArrayList();
        ObservableList<Item> actualData = FXCollections.observableArrayList();

        Item item = new Item("test", "test description", "2021-07-16", "Complete");
        Item item1 = new Item("Shop", "test description", "2021-07-23", "Incomplete");
        Item item2 = new Item("Sleep", "Get enough sleep", "2021-08-07", "Complete");

        expectedData.add(item);
        expectedData.add(item1);
        expectedData.add(item2);

        actualData = itemListManager.processFile(file.getPath());
        for (int i = 0; i < 3; i++) {
            assertEquals(expectedData.get(i).getItemName(),actualData.get(i).getItemName());
            assertEquals(expectedData.get(i).getDescription(),actualData.get(i).getDescription());
            assertEquals(expectedData.get(i).getDueDate(),actualData.get(i).getDueDate());
            assertEquals(expectedData.get(i).getStatus(),actualData.get(i).getStatus());
        }

    }

    @Test
    void save() {
        // Given
        // create  an object TodoListTableManager
        // expectedData observable  collection
        // create identical actualData Observable Collection with expected.

        // when...
        // call method SaveInJsonFile  to change expectedData

        // then
        //assertEquals(expectedData,actualData);
        ItemListManager itemListManager = new ItemListManager();

        ObservableList<Item> expectedData = FXCollections.observableArrayList();
        ObservableList<Item> actualData = FXCollections.observableArrayList();

        Item item = new Item("test", "test description", "2021-07-16", "Complete");
        Item item1 = new Item("Shop", "test description", "2021-07-23", "Incomplete");
        Item item2 = new Item("Sleep", "Get enough sleep", "2021-08-07", "Complete");

        actualData.add(item);
        actualData.add(item1);
        actualData.add(item2);

        itemListManager.saveInJsonFile("src/test/resources/TestFileSave",actualData);
        String actual="";

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("TestFileSave.json").getFile());

            actual = FileUtils.readFileToString(new File(file.getPath()), StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
        }
        String expected ="[{\n" +
                "  \"itemName\": \"test\",\n" +
                "  \"description\": \"test description\",\n" +
                "  \"dueDate\": \"2021-07-16\",\n" +
                "  \"status\": \"Complete\"\n" +
                "},{\n" +
                "  \"itemName\": \"Shop\",\n" +
                "  \"description\": \"test description\",\n" +
                "  \"dueDate\": \"2021-07-23\",\n" +
                "  \"status\": \"Incomplete\"\n" +
                "},{\n" +
                "  \"itemName\": \"Sleep\",\n" +
                "  \"description\": \"Get enough sleep\",\n" +
                "  \"dueDate\": \"2021-08-07\",\n" +
                "  \"status\": \"Complete\"\n" +
                "}]";

        assertEquals(expected,actual);
    }

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
        ItemListManager itemListManager = new ItemListManager();
        ItemListController controller = new ItemListController();

        ObservableList<Item> expectedData = FXCollections.observableArrayList();
        ObservableList<Item> actualData = FXCollections.observableArrayList();

        Item item = new Item("test", "test description", "2021-07-16", "Complete");
        Item item1 = new Item("Shop", "test description", "2021-07-23", "Incomplete");
        Item item2 = new Item("Sleep", "Get enough sleep", "2021-08-07", "Complete");

        expectedData.add(item);
        expectedData.add(item1);
        expectedData.add(item2);

        actualData.add(item1);
        actualData.add(item2);
        actualData.add(item);

        actualData= itemListManager.sort(actualData);

        for (int i = 0; i < 3; i++) {
            assertEquals(expectedData.get(i).getItemName(),actualData.get(i).getItemName());
            assertEquals(expectedData.get(i).getDescription(),actualData.get(i).getDescription());
            assertEquals(expectedData.get(i).getDueDate(),actualData.get(i).getDueDate());
            assertEquals(expectedData.get(i).getStatus(),actualData.get(i).getStatus());
        }

    }

}