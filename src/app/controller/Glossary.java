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
    public TableView<I_GlossaryEntry> glossaryTable;

    public Button glossaryAddButton;
    public Button glossaryEditButton;
    public Button glossaryDeleteButton;

    private final I_Glossary data = Project.getInstance().getGlossary();

    @Override
    public void initialize(URL location,
                           ResourceBundle resources) {
        TableBinding<I_GlossaryEntry> glossaryEntryTableBinding = new TableBinding<>(this.glossaryTable,
                this.data,
                "item",
                "definition");
        glossaryEntryTableBinding.bindAll(this.glossaryAddButton,
                this.glossaryEditButton,
                this.glossaryDeleteButton);
    }
}
