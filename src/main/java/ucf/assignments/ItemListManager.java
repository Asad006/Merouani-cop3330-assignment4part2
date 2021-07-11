package ucf.assignments;
/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Asad merouani
 */

import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.hildan.fxgson.FxGson;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class ItemListManager {
    ItemListApp application = new ItemListApp();

    public ObservableList<Item> sort(ObservableList<Item> itemSorted) {
        // call the built in sort method of the Observable Object.
        return itemSorted;
    }

    public void save(ObservableList<Item> dataList) {
        // open json file
        // the data of the tableView
        // Do serialization of the object to json Object
        // write the data in the file
        // close the file
        File file = getFileChooser();
        String path = file.getPath();
        saveInJsonFile(path, dataList);

    }

    public void saveInJsonFile(String path, ObservableList<Item> dataList) {
        Gson gson = FxGson.coreBuilder().setPrettyPrinting().disableHtmlEscaping().create();

        if (!path.equals("")) {
            try {
                FileWriter file = new FileWriter(path + ".json");
                file.write("[");

                for (int i = 0; i < dataList.size(); i++) {
                    file.write(gson.toJson(dataList.get(i)));

                    if (i < dataList.size() - 1) {
                        file.write(",");
                    }
                }

                file.write("]");
                file.flush();
                file.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private File getFileChooser() {
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();

        fileChooser.setTitle("Save File");
        fileChooser.setSelectedExtensionFilter(new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json"));

        File file = fileChooser.showSaveDialog(stage);

        return file;
    }

    public ObservableList<Item> showIncompleteItems(ObservableList<Item> itemsData) {
        // Get Observable Collection data of the list.
        // Create an object of the class ToDoTask.
        // Set the object status to complete.
        // Get the TableView of the item.
        // Get the status column.
        // Get all the elements of the Observable collection that has a incomplete status.
        // Assign the incomplete items to the New observable collection data.
        // Load the new observable collection data to the TableView To display.
        ObservableList<Item> incomplete = FXCollections.observableArrayList();

        for (int i = 0; i < itemsData.size(); i++) {
            String status = itemsData.get(i).getStatus();
            if (status.equals("Incomplete")) {
                incomplete.add(itemsData.get(i));
            }
        }
        return incomplete;
    }

    public ObservableList<Item> showCompleteItems(ObservableList<Item> itemsData) {
        // Get Observable Collection data of the list.
        // Create an object of the class ToDoTask.
        // Set the object status to complete.
        // Get the TableView of the item.
        // Get the status column.
        // Get all the elements of the Observable collection that has a complete status.
        // Assign the completed items to the New observable collection data.
        // Load the new observable collection data to the TableView To display.
        // call show showIncompleteItems method of the todolistTableManager.
        ObservableList<Item> complete = FXCollections.observableArrayList();
        ;
        for (int i = 0; i < itemsData.size(); i++) {
            String status = itemsData.get(i).getStatus();
            if (status.equals("Complete")) {
                complete.add(itemsData.get(i));
            }
        }
        return complete;
    }

    public ObservableList<Item> showAllItems(ObservableList<Item> itemsData) {
        // Get Observable Collection data of the list.
        // Load the  observable collection data to the TableView To display.
        return itemsData;
    }

    public ObservableList<Item> open() {
        // open windows dialogue
        // enable the user navigate in folders
        // enable the user to select the file
        // open the Json data file
        // load the new data to the interface
        Stage stage = new Stage();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Files", "*.*"));
        File file = fileChooser.showOpenDialog(stage);

        ObservableList<Item> dateFile = processFile(file.getPath());

        return dateFile;
    }

    public ObservableList<Item> processFile(String path) {
        ObservableList<Item> dataList = FXCollections.observableArrayList();
        Item[] itemDataArray;

        Gson gson = FxGson.coreBuilder().setPrettyPrinting().disableHtmlEscaping().create();
        ;
        JSONParser jsonParser = new JSONParser();

        try {

            JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(path));

            String userJson = jsonArray.toJSONString();
            itemDataArray = gson.fromJson(userJson, Item[].class);
            dataList.addAll(Arrays.asList(itemDataArray));

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return dataList;
    }


    public void add(ObservableList<Item> itemsData, String itemName, String fieldDescription, String dueDate) {
        itemsData.add(new Item(itemName, fieldDescription, dueDate));
    }

    public ObservableList<Item> delete(ObservableList<Item> itemsData, int index) {
        // Get Observable Collection data of the list
        // get the selected cell from observable collection
        // create object of the todoTask
        // call remove function of the observable collection
        itemsData.remove(index);
        return itemsData;
    }

    public ObservableList<Item> clear(ObservableList<Item> itemsData) {
        for (int i = 0; i < itemsData.size(); i++) {
            itemsData.remove(i);
        }

        return itemsData;
    }
}
