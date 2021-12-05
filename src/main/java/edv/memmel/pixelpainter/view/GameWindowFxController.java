package edv.memmel.pixelpainter.view;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/** FX controller class for main window. */
public class GameWindowFxController {

  @FXML GridPane grid;

  @FXML
  void initialize() {
    for (int i = 0; i < 20; i++) {
      for (int j = 0; j < 20; j++) {
        Label label = new Label("");
        label.setStyle("-fx-background-color: \"lightgrey\"");
        label.setMinWidth(20.0);
        label.setMinHeight(20.0);
        label.setAlignment(Pos.CENTER);
        grid.add(label, i, j);
      }
    }
  }
}
