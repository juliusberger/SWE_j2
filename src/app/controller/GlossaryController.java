package app.controller;

import app.components.tableBinding.I_TableBinding;
import app.components.tableBinding.TableBinding;
import app.model.implementation.ProjectRegistry;
import app.model.interfaces.Glossary.I_Glossary;
import app.model.interfaces.Glossary.I_GlossaryEntry;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controller für das Glossar (view/glossary.fxml)
 * Es wird das Model {@link I_Glossary} an die Tabelle gebunden, um die Einträge des Typs {@link I_GlossaryEntry} zu verwalten.
 */
public class GlossaryController implements Initializable {
    private final I_Glossary _dataModel = ProjectRegistry.getInstance().getGlossary();
    public TableView<I_GlossaryEntry> _glossaryTable;
    public Button _glossaryAddButton;
    public Button _glossaryEditButton;
    public Button _glossaryDeleteButton;

    /**
     * Bindet die Tabelle an die Repräsentationen der Einträge des Typs {@link I_GlossaryEntry} im Model.
     * Für mehr Informationen zur Bindung eines Models an eine Tabelle, siehe {@link TableBinding}.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        I_TableBinding<I_GlossaryEntry> glossaryEntryTableBinding = new TableBinding<>();
        glossaryEntryTableBinding.setTableView(_glossaryTable);
        glossaryEntryTableBinding.setDataModel(_dataModel);
        glossaryEntryTableBinding.bindTableToData();
        glossaryEntryTableBinding.bindButtonsToTableActions(_glossaryAddButton,
                                                            _glossaryEditButton,
                                                            _glossaryDeleteButton
        );
    }
}
