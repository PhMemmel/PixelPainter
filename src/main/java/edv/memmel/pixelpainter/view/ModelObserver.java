package edv.memmel.pixelpainter.view;

import edv.memmel.pixelpainter.model.PixelManager;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.scene.control.Label;

class ModelObserver implements PropertyChangeListener {


  private Label[][] guiPixels;
  private Label currentColorLabel;
  private PixelManager pixelManager;

  ModelObserver(PixelManager pixelManager) {
    this.pixelManager = pixelManager;
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    switch (evt.getPropertyName()) {
      case "pixelColorChanged":

        break;
      case "pixelDisabledStatusChanged":

        break;
      case "currentPaintColorChanged":

        break;
    }
  }

  public void setCurrentColorLabel(Label currentColorLabel) {
    this.currentColorLabel = currentColorLabel;
  }

  public void setGuiPixels(Label[][] guiPixels) {
    this.guiPixels = guiPixels;
  }
}
