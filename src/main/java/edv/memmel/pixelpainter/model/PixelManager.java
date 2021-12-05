package edv.memmel.pixelpainter.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PixelManager {

  private final PropertyChangeSupport propertyChangeSupport;

  private final PixelGrid pixelGrid;
  private String currentColor = "black";

  public PixelManager(int gridSize) {
    propertyChangeSupport = new PropertyChangeSupport(this);
    pixelGrid = new PixelGrid(gridSize);
  }

  public void colorizePixel(Coordinate coordinate) {
    pixelGrid.getPixelAt(coordinate).setColor(currentColor);
    propertyChangeSupport.firePropertyChange("pixelColorChanged", null, coordinate);
  }

  public String getPixelColorAt(Coordinate coordinate) {
    return pixelGrid.getPixelAt(coordinate).getColor();
  }

  public void setPixelDisabled(boolean disabledStatus, Coordinate coordinate) {
    pixelGrid.getPixelAt(coordinate).setDisabled(disabledStatus);
    propertyChangeSupport.firePropertyChange(
        "pixelDisabledStatusChanged", null, coordinate);
  }

  public boolean isPixelDisabled(Coordinate coordinate) {
    return pixelGrid.getPixelAt(coordinate).isDisabled();
  }

  public String getCurrentPaintColor() {
    return currentColor;
  }

  public void setCurrentPaintColor(String color) {
    currentColor = color;
    propertyChangeSupport.firePropertyChange("currentPaintColorChanged", null, color);
  }

  public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
    propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
  }

  public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
    propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
  }
}
