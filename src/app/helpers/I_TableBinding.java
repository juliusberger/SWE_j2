package app.helpers;

import javafx.scene.control.Button;

/**
 * Created by Julius on 26.06.17.
 */
public interface I_TableBinding {

    /**
     * Binden der typischen Aktionen der Tabelle (CRUD).
     * Binden der Buttons an die jeweiligen Aktionen.
     */
    void bindAll(Button addButton, Button editButton, Button deleteButton);

    /**
     * Bindet die Tabellenpopulation an das Datenmodel.
     */
    void bindTableToData();
}
