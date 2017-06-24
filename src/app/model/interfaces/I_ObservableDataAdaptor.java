package app.model.interfaces;

import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Dieses Interface ist für Klassen gedacht, die eine {@link ObservableList} an Daten des entsprechenden Typs enthalten.
 * Es wird z.B. im {@link app.helpers.TableBinding} benutzt, um generisch Daten hinzuzufügen, zu ändern oder zu löschen.
 */
public interface I_ObservableDataAdaptor<S extends I_ModelPropertyAdaptor> {
    /**
     * Erstellt ein Objekt des Typs S und setzt die Properties gemäß setAllProperties.
     *
     * @param propertyStrings s. setAllProperties in {@link I_ModelPropertyAdaptor}
     */
    void addEntryWithProperties(ArrayList<String> propertyStrings);

    /**
     * @return Liefert die {@link ObservableList} der Items des Typs S
     */
    ObservableList<S> getEntries();

    /**
     *
     * @return Liefert die NAmen aller Property-Stings, benötigt zum Populieren von Tables.
     */
    String[] getPropertyNames();

}
