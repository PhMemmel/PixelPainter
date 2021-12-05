package edv.memmel.pixelpainter.view;

import edv.memmel.pixelpainter.model.Coordinate;
import edv.memmel.pixelpainter.model.PixelManager;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/** FX controller class for main window. */
public class GameWindowFxController {

  private final int GRID_SIZE = 20;
  private final String labelCss = "-fx-border-color: \"black\"";

  @FXML GridPane grid;
  @FXML Label currentColorLabel;
  @FXML ColorPicker colorPicker;

  private Label[][] labels;
  private PixelManager pixelManager;
  private ModelObserver modelObserver;

  public GameWindowFxController() {
    pixelManager = new PixelManager(GRID_SIZE);
    labels = new Label[GRID_SIZE][GRID_SIZE];
    modelObserver = new ModelObserver(pixelManager);
  }

  @FXML
  void initialize() {
    for (int i = 0; i < GRID_SIZE; i++) {
      for (int j = 0; j < GRID_SIZE; j++) {
        Label label = new Label("");
        label.setStyle(labelCss);
        label.setMinWidth(20.0);
        label.setMinHeight(20.0);
        label.setAlignment(Pos.CENTER);
        label.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> setColor(event));
        grid.add(label, j, i); // care: first column, then row
        labels[i][j] = label;
      }
    }
    // initialize labels in the model
    resetPixels();
    // Set neccessary references:
    modelObserver.setGuiPixels(labels);
    modelObserver.setCurrentColorLabel(currentColorLabel);
    modelObserver.setColorPicker(colorPicker);
  }

  private void setColor(MouseEvent event) {
    Coordinate coordinate =
        new Coordinate(
            GridPane.getRowIndex((Node) event.getTarget()),
            GridPane.getColumnIndex((Node) event.getTarget()));
    pixelManager.colorizePixel(coordinate);
  }

  @FXML
  void changeColor() {
    pixelManager.setCurrentPaintColor(colorPicker.getValue().toString());
  }

  @FXML
  void resetPixels() {
    pixelManager.setCurrentPaintColor("lightgrey");
    for (int i = 0; i < GRID_SIZE; i++) {
      for (int j = 0; j < GRID_SIZE; j++) {
        pixelManager.colorizePixel(new Coordinate(i, j));
      }
    }
  }
}
