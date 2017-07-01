package app.model.interfaces;

/**
 * Markiert ein Model, dessen Inhalte gelöscht werden können. Bei Models, die Kind-Models enthalten, sollte der Aufruf auf jene ebenfalls getan werden.
 */
public interface I_Clearable {
    /**
     * Löscht alle Daten, die zur Laufzeit erstellt wurden. Auch für die Kind-Models.
     */
    void removeExistingData();
}
