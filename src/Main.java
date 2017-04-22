import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = FXMLLoader.load(getClass().getResource("components/root.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setResizable(false);
        primaryStage.setTitle("ANTool");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
