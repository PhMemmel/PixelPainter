package edv.memmel.pixelpainter.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX Application starter class.
 */
public class FxGuiStarter extends Application {


  public static void main(String[] args) {
    launch();
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    FXMLLoader fxmlLoader =
        new FXMLLoader(getClass().getResource("/GameWindow.fxml"));
    Parent root = fxmlLoader.load();
    primaryStage.setTitle("PixelPainter");
    primaryStage.setScene(new Scene(root, 600, 700));
    primaryStage.show();
  }
}
