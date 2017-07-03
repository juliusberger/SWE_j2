package app.model.interfaces;

import app.components.tableBinding.TableBinding;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Dieses Interface ist für Klassen gedacht, die eine {@link ObservableList} an Daten des entsprechenden Typs enthalten.
 * Es wird z.B. im {@link TableBinding} benutzt, um generisch Daten hinzuzufügen, zu ändern oder zu löschen.
 */
public interface I_ObservableDataAdaptor<S extends I_ModelPropertyAdaptor> extends I_Clearable {
    /**
     * Erstellt ein Objekt des Typs S und setzt die Properties gemäß {@link I_ModelPropertyAdaptor#setAllProperties(ArrayList)}.
     *
     * @param propertyStrings s. setAllProperties in {@link I_ModelPropertyAdaptor#setAllProperties(ArrayList)}
     */
    void addEntryWithProperties(ArrayList<String> propertyStrings);

    /**
     * @return Liefert die {@link ObservableList} der Items des Typs S. Die Entries sind die von einer Klasse gehaltenen Einträge variabler Anzahl. Bsp.: Glossar hält verschieden viele GlossarEinträge.
     */
    ObservableList<S> getEntries();

    /**
     * @return Liefert die Namen der Variablen aller Properties, benötigt zum Populieren von TableViews in JavaFX.
     */
    String[] getPropertyNames();

}
