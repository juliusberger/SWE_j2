package app.model.interfaces;

/**
 * Factory für die Erstellung von ModelEntry-Typen unter Verwendung der generischen Interfaces {@link I_ModelPropertyAdaptor} und {@link I_ObservableDataAdaptor}
 */
public interface I_ModelEntryFactory<S extends I_ModelPropertyAdaptor> {
    /**
     * @return Gibt eine Neue Instanz des generischen Typs S zurück.
     */
    S createEntry();
}
