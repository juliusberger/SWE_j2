package components.stateAnalysis;

import helpers.Dialog;
import helpers.TableBinding;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import models.FutureAnalysis;
import models.partials.Analysis.AnalysisEntry;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class StateAnalysis implements Initializable {

    public TableView<AnalysisEntry> stateAnalysisTable;

    public Button addEntryButton;
    public Button editEntryButton;
    public Button deleteEntryButton;

    private FutureAnalysis data = new FutureAnalysis();


    @Override
    public void initialize(URL location,
                           ResourceBundle resources) {


// TODO: Optimize and Refactor Functions for edit and add

        TableBinding.bindTableToData(stateAnalysisTable,
                data.getEntries(),
                "entryName",
                "description");
        TableBinding.observeDisabledButtonState(stateAnalysisTable,
                editEntryButton,
                deleteEntryButton);

        TableBinding.bindTableDeleteButton(stateAnalysisTable,
                deleteEntryButton);

        addEntryButton.setOnAction(event -> {
            Dialog dialog = new Dialog("Eintrag",
                    "Beschreibung");
            dialog.addObserver((o, arg) -> {
                if (dialog.isSaveClicked()) {
                    this.data.getEntries().add(new AnalysisEntry(
                            dialog.getData(0),
                            dialog.getData(1)
                    ));
                }
                dialog.deleteObservers();
            });
            dialog.show();
        });

        editEntryButton.setOnAction(event -> {
            final AnalysisEntry selectedEntry = this.stateAnalysisTable.getSelectionModel().getSelectedItem();
            Dialog dialog = new Dialog("Eintrag",
                    "Beschreibung");
            dialog.addObserver((o, arg) -> {
                if (dialog.isSaveClicked()) {
                    selectedEntry.setEntryName(
                            dialog.getData(0)
                    );
                    selectedEntry.setDescription(
                            dialog.getData(1)
                    );
                }
                dialog.deleteObservers();
            });
            dialog.setData(
                    selectedEntry.getEntryName(),
                    selectedEntry.getDescription());
            dialog.show();
        });

        stateAnalysisTable.setRowFactory(tv -> {
            TableRow<AnalysisEntry> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && !row.isEmpty()) {
                    editEntryButton.getOnAction().handle(null);
                }
            });
            return row;
        });


    }
}
