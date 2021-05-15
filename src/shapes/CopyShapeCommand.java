package shapes;

import javax.sound.sampled.Clip;
import model.interact.ICommand;
import shapes.interfaces.IShape;
import shapes.SelectedShapesList;

public class CopyShapeCommand implements ICommand {

  @Override
  public void run() {
    Clipboard.clear();
    copySelectedShapes();
  }

  private void copySelectedShapes() {
    for (IShape shape : SelectedShapesList.shapeList) {
      Shape temp = new Shape((Shape)shape);
      temp.upperLeft.x += 7;
      temp.upperLeft.y += 7;
      Clipboard.add(temp);
    }
  }
}
