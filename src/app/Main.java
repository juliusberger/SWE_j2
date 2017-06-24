package app;

import app.helpers.Log;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    public static void main(String[] args) {
        /*XmlImporter_new i = new XmlImporter_new("C:\\Users\\Julius\\Desktop\\test2.xml");
        i.importXml();*/
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = FXMLLoader.load(getClass().getResource("view/rootView.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("ANTool");
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("assets/ANTool_Icon2.png")));
        primaryStage.setScene(scene);

        // TODO: Irgendwelche Checks vorm Beenden?
        primaryStage.setOnCloseRequest(event -> Log.getLogger().info("AnTool wird beendet..."));

        primaryStage.show();

        Log.getLogger().info("AnTool erfolgreich gestartet.");


    }

}
