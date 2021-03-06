package ucf.assignments;
/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Asad merouani
 */


import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class Item {
    //  class instance variable
    //  itemName : SimpleStringProperty
    //  description : SimpleStringProperty
    //  dueDate : SimpleDateFormat
    //  status SimpleStringProperty="Incomplete";

    // constructors
    //  TaskItem(String itemName, String description, String dueDate, String status) {
    //  TaskItem(String itemName, String description, String dueDate)

    // Methods
    //private void setDueDate(String dueDate)
    //public String getItemName()
    //public static SimpleDateFormat getDueDate()
    //public void setItemName(String itemName)
    //public String getDescription()
    //public void setDescription(String description)
    //public String getStatus()
    //public void setStatus(String status)
    private final SimpleStringProperty itemName = new SimpleStringProperty();
    private final SimpleStringProperty description = new SimpleStringProperty();
    private final SimpleStringProperty dueDate = new SimpleStringProperty();
    private final SimpleStringProperty status = new SimpleStringProperty("Incomplete");

    public Item( String itemName, String description, String dueDate,String status) {
        setDescription(description);
        setDueDate(dueDate);
        setItemName(itemName);
        setStatus(status);
    }

    public Item(String itemName, String description, String dueDate) {
        setDescription(description);
        setDueDate(dueDate);
        setItemName(itemName);

    }

    public String getItemName() {
        return itemName.get();
    }

    public SimpleStringProperty itemNameProperty() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName.set(itemName);
    }

    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getDueDate() {
        return dueDate.get();
    }

    public SimpleStringProperty dueDateProperty() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate.set(dueDate);
    }

    public String getStatus() {
        return status.get();
    }

    public SimpleStringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }
    public LocalDate getDateAsLocal(){
       return LocalDate.parse(dueDate.get());
    }
}
