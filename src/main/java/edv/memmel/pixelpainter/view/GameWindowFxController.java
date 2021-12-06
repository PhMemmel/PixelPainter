package edv.memmel.pixelpainter.view;

import edv.memmel.pixelpainter.model.Coordinate;
import edv.memmel.pixelpainter.model.PixelManager;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/** FX controller class for main window. */
public class GameWindowFxController {

  private final int GRID_SIZE = 20;
  private final String labelCss = "-fx-border-color: \"black\"";

  @FXML GridPane grid;
  @FXML Label currentColorLabel;
  @FXML ColorPicker colorPicker;

  private PixelManager pixelManager;

  public GameWindowFxController() {
    pixelManager = new PixelManager(GRID_SIZE);
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
        int finalI = i;
        int finalJ = j;
        // Bind the background color to the model's color
        label
            .backgroundProperty()
            .bind(
                Bindings.createObjectBinding(
                    () ->
                        new Background(
                            new BackgroundFill(
                                Color.valueOf(
                                    pixelManager.getPixelColorAt(new Coordinate(finalI, finalJ))),
                                new CornerRadii(0),
                                Insets.EMPTY)),
                    pixelManager.pixelColorPropertyAt(new Coordinate(i, j))));
        grid.add(label, j, i); // care: first column, then row
      }
    }
    // bind color label to current color of the model
    currentColorLabel.textProperty().bind(pixelManager.currentColorProperty());
    // make color picker react to chosen color
    pixelManager.currentColorProperty().addListener((target, oldValue, newValue) -> {
      colorPicker.setValue(Color.valueOf(newValue));
    });
    resetPixels();
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
