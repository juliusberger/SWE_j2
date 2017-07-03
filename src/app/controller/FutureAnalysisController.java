package app.controller;

import app.components.tableBinding.I_TableBinding;
import app.components.tableBinding.TableBinding;
import app.model.implementation.ProjectRegistry;
import app.model.interfaces.Analysis.I_Analysis;
import app.model.interfaces.Analysis.I_AnalysisEntry;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller für die Soll-Analyse (view/futureAnalysis.fxml)
 * Es wird das Model {@link I_Analysis} an die Tabelle gebunden, um die Einträge des Typs {@link I_AnalysisEntry} zu verwalten.
 */
public class FutureAnalysisController implements Initializable {

    private final I_Analysis _dataModel = ProjectRegistry.getInstance().getFutureAnalysis();
    public TableView<I_AnalysisEntry> _futureAnalysisTable;
    public Button _addEntryButton;
    public Button _editEntryButton;
    public Button _deleteEntryButton;

    /**
     * Bindet die Tabelle an die Repräsentationen der Einträge des Typs {@link I_AnalysisEntry} im Model.
     * Für mehr Informationen zur Bindung eines Models an eine Tabelle, siehe {@link TableBinding}.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        I_TableBinding<I_AnalysisEntry> analysisTableBinding = new TableBinding<>();
        analysisTableBinding.setTableView(_futureAnalysisTable);
        analysisTableBinding.setDataModel(_dataModel);
        analysisTableBinding.bindTableToData();
        analysisTableBinding.bindButtonsToTableActions(_addEntryButton, _editEntryButton, _deleteEntryButton);
    }
}
