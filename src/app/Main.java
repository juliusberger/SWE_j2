package app;

import app.InfoDialog.AlertType;
import app.components.importExport.I_ProjectExportImportManager;
import app.components.importExport.ProjectExportImportManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    private static Stage _primaryStage = null;

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getPrimaryStage() {
        return _primaryStage;
    }

    /**
     * Startet die JavaFX App und lädt die rootView.
     * Beim Beenden wird immer nachgefragt, ob das Projekt gespeichert werden soll. Dies gibt dem Anwender etwas mehr Sicherheit gegen aus Versehen passiertes Schliessen.
     *
     * @param primaryStage Wird vom JavaFX launch-Handler übergeben.
     * @throws IOException s. JavaFX launch-Handler
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        _primaryStage = primaryStage;

        AnchorPane root = FXMLLoader.load(getClass().getResource("view/rootView.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle(Constants.CONTEXT_TITLE_COMMON);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/assets/ANTool_Icon2.png")));
        primaryStage.setScene(scene);

        primaryStage.setOnCloseRequest(event -> {
            InfoDialog confirmationDialog = new InfoDialog(
                    Constants.CONTEXT_TITLE_COMMON,
                    "ANTool beenden",
                    "Vor dem Beenden speichern?",
                    AlertType.CONFIRMATION
            );

            if (confirmationDialog.wasYesClicked()) {
                I_ProjectExportImportManager projectExportImportManager = new ProjectExportImportManager();
                if (projectExportImportManager.saveProject()) {
                    Log.getLogger().info("AnTool wird beendet...");
                } else {
                    event.consume();
                }
            } else if (!confirmationDialog.wasNoClicked()) event.consume();
        });

        primaryStage.show();

        Log.getLogger().info("AnTool erfolgreich gestartet.");
    }
}
