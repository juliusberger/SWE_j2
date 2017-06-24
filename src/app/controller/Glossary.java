package app.controller;

import app.helpers.TableBinding;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import app.model.implementation.Project;
import app.model.interfaces.Glossary.I_Glossary;
import app.model.interfaces.Glossary.I_GlossaryEntry;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class Glossary implements Initializable {
    public TableView<I_GlossaryEntry> _glossaryTable;

    public Button _glossaryAddButton;
    public Button _glossaryEditButton;
    public Button _glossaryDeleteButton;

    private final I_Glossary _data = Project.getInstance().getGlossary();

    @Override
    public void initialize(URL location,
                           ResourceBundle resources) {
        TableBinding<I_GlossaryEntry> glossaryEntryTableBinding = new TableBinding<>(_glossaryTable,
                _data);
        glossaryEntryTableBinding.bindAll(_glossaryAddButton,
                _glossaryEditButton,
                _glossaryDeleteButton);
    }
}
