package edv.memmel.pixelpainter.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PixelManager {

  private final PixelGrid pixelGrid;
  private StringProperty currentColor;

  public PixelManager(int gridSize) {
    pixelGrid = new PixelGrid(gridSize);
    currentColor = new SimpleStringProperty("black");
  }

  public void colorizePixel(Coordinate coordinate) {
    pixelGrid.getPixelAt(coordinate).setColor(currentColor.getValue());
  }

  public String getPixelColorAt(Coordinate coordinate) {
    return pixelGrid.getPixelAt(coordinate).getColor();
  }

  public StringProperty pixelColorPropertyAt(Coordinate coordinate) {
    return pixelGrid.getPixelAt(coordinate).colorProperty();
  }

  public void setPixelDisabled(boolean disabledStatus, Coordinate coordinate) {
    pixelGrid.getPixelAt(coordinate).setDisabled(disabledStatus);
  }

  public boolean isPixelDisabled(Coordinate coordinate) {
    return pixelGrid.getPixelAt(coordinate).isDisabled();
  }

  public String getCurrentPaintColor() {
    return currentColor.getValue();
  }

  public StringProperty currentColorProperty() {
    return currentColor;
  }

  public void setCurrentPaintColor(String color) {
    currentColor.setValue(color);
  }
}
