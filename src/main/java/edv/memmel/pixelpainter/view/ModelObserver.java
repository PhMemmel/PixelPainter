package edv.memmel.pixelpainter.view;

import edv.memmel.pixelpainter.model.Coordinate;
import edv.memmel.pixelpainter.model.PixelManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

class ModelObserver implements PropertyChangeListener {

  private Label[][] guiPixels;
  private PixelManager pixelManager;
  private ColorPicker colorPicker;

  private final SimpleStringProperty currentColor;

  ModelObserver(PixelManager pixelManager) {
    this.pixelManager = pixelManager;
    pixelManager.addPropertyChangeListener(this);
    currentColor = new SimpleStringProperty("");
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    switch (evt.getPropertyName()) {
      case "pixelColorChanged":
        Coordinate coordinate = (Coordinate) evt.getNewValue();
        Color color = Color.valueOf(pixelManager.getPixelColorAt(coordinate));
        Platform.runLater(
            () ->
                guiPixels[coordinate.getX()][coordinate.getY()].setBackground(
                    new Background(new BackgroundFill(color, new CornerRadii(0), Insets.EMPTY))));
        break;
      case "pixelDisabledStatusChanged":
        // TODO
        break;
      case "currentPaintColorChanged":
        Platform.runLater(
            () -> {
              currentColor.setValue(pixelManager.getCurrentPaintColor());
              colorPicker.setValue(Color.valueOf(pixelManager.getCurrentPaintColor()));
            });
        break;
    }
  }

  void setCurrentColorLabel(Label currentColorLabel) {
    currentColorLabel.textProperty().bind(currentColor);
  }

  void setColorPicker(ColorPicker colorPicker) {
    this.colorPicker = colorPicker;
  }

  void setGuiPixels(Label[][] guiPixels) {
    this.guiPixels = guiPixels;
  }
}
