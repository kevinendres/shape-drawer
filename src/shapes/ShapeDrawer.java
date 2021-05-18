package shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import shapes.interfaces.IShape;
import view.interfaces.PaintCanvasBase;

public class ShapeDrawer {
  public static PaintCanvasBase paintCanvas;

  private static void clearCanvas() {
    Graphics2D g2d = paintCanvas.getGraphics2D();
    g2d.setColor(Color.WHITE);
    g2d.fillRect(0,0,1920,1080);
  }

  public static void drawAllShapes() {
    clearCanvas();
    for (IShape shape : ShapeList.shapeList) {
      shape.draw(paintCanvas);
    }
  }
}
