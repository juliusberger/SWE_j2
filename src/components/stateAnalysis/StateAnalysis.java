package components.stateAnalysis;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class StateAnalysis implements Initializable {

    public TableView stateAnalysisTable;

    public Button addEntry;
    public Button editEntry;
    public Button deleteEntry;


    @Override
    public void initialize(URL location,
                           ResourceBundle resources) {


        //<editor-fold desc="'Projekt laden' Button Aktivieren, wenn Auswahl in Tabelle erfolgt">
        stateAnalysisTable.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, oldSelection, newSelection) ->
                {
                    if (newSelection != null)
                    {
                        editEntry.setDisable(false);
                        deleteEntry.setDisable(false);
                    } else
                    {
                        editEntry.setDisable(true);
                        deleteEntry.setDisable(true);
                    }
                });
        //</editor-fold>
    }
}
