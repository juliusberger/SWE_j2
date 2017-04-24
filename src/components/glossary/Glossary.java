package components.glossary;

import helpers.TableBinding;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import models.Glossary.GlossaryEntry;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Erstellt von Julius am 23/04/2017.
 */
public class Glossary implements Initializable {
    public TableView<GlossaryEntry> glossaryTable;

    public Button glossaryAddButton;
    public Button glossaryEditButton;
    public Button glossaryDeleteButton;

    private models.Glossary.Glossary data = new models.Glossary.Glossary();

    @Override
    public void initialize(URL location,
                           ResourceBundle resources) {
        TableBinding<GlossaryEntry> glossaryEntryTableBinding = new TableBinding<>(this.glossaryTable,
                this.data,
                "item",
                "definition");
        glossaryEntryTableBinding.bindAll(this.glossaryAddButton,
                this.glossaryEditButton,
                this.glossaryDeleteButton);
    }
}
