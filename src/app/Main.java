package app;

import app.helpers.importExport.ProjectExportImportManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    private static Stage _primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getPrimaryStage() {
        return _primaryStage;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        _primaryStage = primaryStage;

        AnchorPane root = FXMLLoader.load(getClass().getResource("view/rootView.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle(Constants.CONTEXT_TITLE_COMMON);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("assets/ANTool_Icon2.png")));
        primaryStage.setScene(scene);

        primaryStage.setOnCloseRequest(event -> {
            if (InfoDialog.confirm(Constants.CONTEXT_TITLE_COMMON, "ANTool beenden", "Vor dem Beenden speichern?")) {
                if (ProjectExportImportManager.saveProject()) {
                    Log.getLogger().info("AnTool wird beendet...");
                } else {
                    event.consume();
                }
            }
        });

        primaryStage.show();

        Log.getLogger().info("AnTool erfolgreich gestartet.");
    }
}
