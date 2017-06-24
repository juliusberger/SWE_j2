package app.controller;

import app.helpers.TableBinding;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import app.model.implementation.Project;
import app.model.interfaces.Analysis.I_Analysis;
import app.model.interfaces.Analysis.I_AnalysisEntry;

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

    private final I_Analysis data = Project.getInstance().getStateAnalysis();


    @Override
    public void initialize(URL location,
                           ResourceBundle resources) {


        TableBinding<I_AnalysisEntry> tableBinding = new TableBinding<>(this.stateAnalysisTable,
                this.data);
        tableBinding.bindAll(this.addEntryButton,
                this.editEntryButton,
                this.deleteEntryButton);

    }
}
