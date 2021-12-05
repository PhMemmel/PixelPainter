package edv.memmel.pixelpainter.view;

import edv.memmel.pixelpainter.model.PixelManager;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/** FX controller class for main window. */
public class GameWindowFxController {

  private final int GRID_SIZE = 20;

  @FXML GridPane grid;
  @FXML Label currentColorLabel;

  private Label[][] labels;
  private ModelObserver modelObserver;

  public GameWindowFxController() {
    labels = new Label[GRID_SIZE][GRID_SIZE];
    modelObserver = new ModelObserver(new PixelManager(GRID_SIZE));
  }

  @FXML
  void initialize() {
    for (int i = 0; i < GRID_SIZE; i++) {
      for (int j = 0; j < GRID_SIZE; j++) {
        Label label = new Label("");
        label.setStyle("-fx-background-color: \"lightgrey\"; -fx-border-color: \"black\"");
        label.setMinWidth(20.0);
        label.setMinHeight(20.0);
        label.setAlignment(Pos.CENTER);
        grid.add(label, i, j);
        labels[i][j] = label;
      }
    }
    modelObserver.setGuiPixels(labels);
    modelObserver.setCurrentColorLabel(currentColorLabel);
  }
}
