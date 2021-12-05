package edv.memmel.pixelpainter.model;

public class PixelManager {

  private PixelGrid pixelGrid;
  private String currentColor = "black";

  public PixelManager(int gridSize) {
    pixelGrid = new PixelGrid(gridSize);
  }

  public void colorizePixel(int rowIndex, int colIndex) {
    pixelGrid.getPixelAt(rowIndex, colIndex).setColor(currentColor);
  }

  public String getPixelColorAt(int rowIndex, int colIndex) {
    return pixelGrid.getPixelAt(rowIndex, colIndex).getColor();
  }

  public void setPixelDisabled(boolean disabledStatus, int rowIndex, int colIndex) {
    pixelGrid.getPixelAt(rowIndex, colIndex).setDisabled(disabledStatus);
  }

  public boolean isPixelDisabled(int rowIndex, int colIndex) {
    return pixelGrid.getPixelAt(rowIndex, colIndex).isDisabled();
  }

  public String getCurrentPaintColor() {
    return currentColor;
  }

  public void setCurrentPaintColor(String color) {
    currentColor = color;
  }
}
