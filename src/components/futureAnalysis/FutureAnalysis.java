package components.futureAnalysis;

import helpers.TableBinding;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import models.Analysis.I_AnalysisEntry;
import models.Project;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class FutureAnalysis implements Initializable {

    public TableView<I_AnalysisEntry> futureAnalysisTable;

    public Button addEntryButton;
    public Button editEntryButton;
    public Button deleteEntryButton;

    private models.Analysis.I_Analysis data = Project.getInstance().getFutureAnalysis();


    @Override
    public void initialize(URL location,
                           ResourceBundle resources) {

        TableBinding<I_AnalysisEntry> tableBinding = new TableBinding<>(this.futureAnalysisTable,
                this.data,
                "entryName",
                "description");
        tableBinding.bindAll(this.addEntryButton,
                this.editEntryButton,
                this.deleteEntryButton);

    }
}
