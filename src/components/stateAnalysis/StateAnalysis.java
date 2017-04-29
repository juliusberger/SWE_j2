package components.stateAnalysis;

import helpers.TableBinding;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import models.Analysis.I_AnalysisEntry;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class StateAnalysis implements Initializable {

    public TableView<I_AnalysisEntry> stateAnalysisTable;

    public Button addEntryButton;
    public Button editEntryButton;
    public Button deleteEntryButton;

    private final models.Analysis.I_Analysis data = new models.Analysis.StateAnalysis();


    @Override
    public void initialize(URL location,
                           ResourceBundle resources) {


        TableBinding<I_AnalysisEntry> tableBinding = new TableBinding<>(this.stateAnalysisTable,
                this.data,
                "entryName",
                "description");
        tableBinding.bindAll(this.addEntryButton,
                this.editEntryButton,
                this.deleteEntryButton);

    }
}
