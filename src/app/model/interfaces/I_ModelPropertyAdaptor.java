package app.model.interfaces;

import java.util.ArrayList;

/**
 * Adapter, der beim Aufruf von setAllProperties die besetzten Properties setzt, bzw. bei getAllProperties alle Properties des Models zurückgibt.
 *
 * Dieses Interface ist Voraussetzung für alle Models, die mit Elementhaltern des {@link I_ObservableDataAdaptor} verknüpft sind
 */
public interface I_ModelPropertyAdaptor {
    /**
     * Methode, um alle Properties einer Klasse zu setzen.
     * Ein Unterschreiten der benötigten Länge von propertyStrings für die Anzahl der Properties ist zu prüfen oder per try-catch zu ignorieren.
     *
     * @param propertyStrings Enthält die zu setzenden Properties in der korrekten Reihenfolge.
     */
    void setAllProperties(ArrayList<String> propertyStrings);

    /**
     * @return Liefert alle Property-Strings der jew. in der Klasse angegebenen Properties.
     */
    ArrayList<String> getAllProperties();
}
