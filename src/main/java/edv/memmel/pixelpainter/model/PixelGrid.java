package edv.memmel.pixelpainter.model;

public class PixelGrid {

  Pixel[][] pixelGrid;

  PixelGrid(int size) {
    pixelGrid = new Pixel[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        pixelGrid[i][j] = new Pixel();
      }
    }
  }

  Pixel getPixelAt(Coordinate coordinate) {
    return pixelGrid[coordinate.getX()][coordinate.getY()];
  }

}
