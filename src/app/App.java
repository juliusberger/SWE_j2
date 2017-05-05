package app;

import app.models.implementation.Project;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by Julius on 05.05.17.
 */
public class App {
    private static App _instance;
    public static App getInstance() {
        if (App._instance == null)
            App._instance = new App();
        return App._instance;
    }

    private Stage _stage;


    void startApp() throws Exception {
        this._stage = new Stage();

        AnchorPane root = FXMLLoader.load(this.getClass().getResource("components/rootView.fxml"));
        Scene scene = new Scene(root);

        this._stage.setTitle("ANTool");
        this._stage.initStyle(StageStyle.UNIFIED);
        this._stage.getIcons().add(new Image(this.getClass().getResourceAsStream("assets/ANTool_Icon2.png")));
        this._stage.setScene(scene);
        this._stage.show();
    }

    public void restartApp() throws Exception {
        if (this._stage != null) {
            this._stage.close();
        }
        this.startApp();
    }
}
