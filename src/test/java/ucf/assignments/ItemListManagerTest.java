package ucf.assignments;

import org.junit.jupiter.api.Test;

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

    }

    @Test
    void changeStatus() {
        // Given
        // create  an object TodoListTableManager
        // expectedData observable  collection
        // add object incomplete item tags.
        // create identical actualData Observable Collection with complete status.

        // when...
        // call method changeStatus  to change expectedData

        // then
        //assertEquals(expectedData,actualData);

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
}