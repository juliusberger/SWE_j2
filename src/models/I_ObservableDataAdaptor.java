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
     * @param dataStrings s. setAllProperties
     */
    void addAllProperties(ArrayList<String> dataStrings);

    /**
     * Methode, um alle Properties einer Klasse zu setzen. Der Aufruf wird i.d.R. an die Methode setAllProperties der Instanz entry weitergereicht, die das Interface {@link I_ModelPropertyAdaptor} implementiert.
     * Für mehr Informationen zur Funktion, siehe {@link I_ModelPropertyAdaptor}.
     *
     * @param dataStrings Enthält die zu setzenden Properties in der korrekten Reihenfolge.
     */
    void setAllProperties(S entry,
                          ArrayList<String> dataStrings);

    /**
     * Ruft alle Property-Strings des Objekts entry ab. Der Aufruf wird i.d.R. an die Methode getAllProperties der Instanz entry weitergereicht, die das Interface {@link I_ModelPropertyAdaptor} implementiert.
     *
     * @param entry Instanz der Klasse S, die die benötigten Properties enthält.
     * @return Liefert alle Property-Strings der jew. in der Klasse angegebenen Properties, i.d.R. weitergereicht von getAllProperties von entry.
     */
    ArrayList<String> getAllProperties(S entry);

    /**
     * @return Liefert die {@link ObservableList} der Items des Typs S
     */
    ObservableList<S> getEntries();
}
