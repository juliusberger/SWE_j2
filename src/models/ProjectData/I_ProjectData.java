package models.ProjectData;

import javafx.beans.property.SimpleStringProperty;

/**
 * Erstellt von Julius am 29/04/2017.
 */
public interface I_ProjectData {
    String getName();

    SimpleStringProperty nameProperty();

    void setName(String name);

    String getDueDate();

    SimpleStringProperty dueDateProperty();

    void setDueDate(String dueDate);

    I_ProjectEditor getProjectEditor();

    I_Customer getCustomer();
}
