package edv.memmel.pixelpainter.model;

public class Pixel {

  private String color;
  private boolean disabled;

  Pixel() {
    color = null;
    disabled = false;
  }

  String getColor() {
    return color;
  }

  void setColor(String color) {
    this.color = color;
  }

  boolean isDisabled() {
    return disabled;
  }

  void setDisabled(boolean disabled) {
    this.disabled = disabled;
  }
}
