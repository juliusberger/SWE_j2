package app.model.implementation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import app.model.interfaces.I_ModelEntryFactory;
import app.model.interfaces.I_ModelPropertyAdaptor;
import app.model.interfaces.I_ObservableDataAdaptor;

import java.util.ArrayList;

/**
 * Alle Klassen, die eine {@link ObservableList} des jeweiligen Typs halten, und Einträge dynamisch verwalten erben von dieser Klasse.
 * Nützlich ist dies in Verbindung mit der Verwendung von {@link javafx.scene.control.TableView}s über das {@link app.helpers.TableBinding}.
 */
public abstract class ObservableEntryHolder<S extends I_ModelPropertyAdaptor> implements I_ModelEntryFactory<S>, I_ObservableDataAdaptor<S> {
    /**
     * Für das in {@link javafx.scene.control.TableView}s eingesetzte Databinding wird die von JavaFX bereitgestellte observableArrayList verwendet.
     */
    private final ObservableList<S> _entries = FXCollections.observableArrayList();

    @Override
    public ObservableList<S> getEntries() {
        return _entries;
    }

    @Override
    public void addEntryWithProperties(ArrayList<String> propertyStrings) {
        S entry = createEntry();
        entry.setAllProperties(propertyStrings);

        getEntries().add(entry);
    }
}
