package components.futureAnalysis;

import helpers.TableBinding;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import models.Analysis.AnalysisEntry;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class FutureAnalysis implements Initializable {

    public TableView<AnalysisEntry> futureAnalysisTable;

    public Button addEntryButton;
    public Button editEntryButton;
    public Button deleteEntryButton;

    private models.Analysis.FutureAnalysis data = new models.Analysis.FutureAnalysis();


    @Override
    public void initialize(URL location,
                           ResourceBundle resources) {

        TableBinding.bindTableToData(futureAnalysisTable,
                data.getEntries(),
                "entryName",
                "description");
        TableBinding.observeDisabledButtonState(futureAnalysisTable,
                editEntryButton,
                deleteEntryButton);

        TableBinding.bindTableDeleteButton(futureAnalysisTable,
                deleteEntryButton);

        // debug
        final int[] index = {0};
        addEntryButton.setOnAction(event -> data.getEntries()
                .add(new AnalysisEntry("test" + Integer.toString(index[0]),
                        "testDesc" + Integer.toString(index[0]++))));

    }
}
