package app.components.tableBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Hilfsklasse zur einheitlichen Erstellung von JavaFX-Dialogen. Wird durch {@link TableBinding} genutzt, um Kontextaktionen für Tabelleneinträge durchzuführen.
 */
interface I_AddEntryDialog {
    void show();

    boolean wasSaveClicked();

    ArrayList<String> getData();

    void setData(List<String> texts);
}
