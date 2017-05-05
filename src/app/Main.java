package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import app.models.implementation.Project;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = FXMLLoader.load(this.getClass().getResource("components/rootView.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("ANTool");
        primaryStage.initStyle(StageStyle.UNIFIED);
        primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream("assets/ANTool_Icon2.png")));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}