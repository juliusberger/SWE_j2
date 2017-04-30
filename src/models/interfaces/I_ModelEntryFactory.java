package models.interfaces;

/**
 * Factory für die Erstellung von ModelEntry-Typen unter Vewendung der generischen Interfaces {@link I_ModelPropertyAdaptor} und {@link I_ObservableDataAdaptor}
 */
public interface I_ModelEntryFactory<S> {
    /**
     * @return Gibt eine Neue Instanz des generischen Typs S zurück.
     */
    S createEntry();
}
