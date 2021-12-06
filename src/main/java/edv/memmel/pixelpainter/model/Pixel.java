package edv.memmel.pixelpainter.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pixel {

  private StringProperty color;
  private boolean disabled;

  Pixel() {
    color = new SimpleStringProperty("lightgrey");
    disabled = false;
  }

  String getColor() {
    return color.getValue();
  }

  StringProperty colorProperty() {
    return color;
  };

  void setColor(String color) {
    this.color.setValue(color);
  }

  boolean isDisabled() {
    return disabled;
  }

  void setDisabled(boolean disabled) {
    this.disabled = disabled;
  }
}
