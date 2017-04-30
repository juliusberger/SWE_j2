package models;

import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Dieses Interface ist für Klassen gedacht, die eine {@link ObservableList} an Daten des entsprechenden Typs enthalten.
 * Es wird z.B. im {@link helpers.TableBinding} benutzt, um generisch Daten hinzuzufügen, zu Ändern oder zu Löschen.
 */
public interface I_ObservableDataAdaptor<S extends I_ModelPropertyAdaptor> {
    /**
     * Erstellt ein Objekt des Typs S und setzt die Properties gemäß setAllProperties.
     *
     * @param propertyStrings s. setAllProperties
     */
    void addEntryWithProperties(ArrayList<String> propertyStrings);

    /**
     * @return Liefert die {@link ObservableList} der Items des Typs S
     */
    ObservableList<S> getEntries();
}
