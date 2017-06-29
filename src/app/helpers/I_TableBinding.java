package app.helpers;

import javafx.scene.control.Button;

/**
 * Created by Julius on 26.06.17.
 */
public interface I_TableBinding {
    void bindAll(Button addButton,
                 Button editButton,
                 Button deleteButton);
    void bindTableToData();
}
