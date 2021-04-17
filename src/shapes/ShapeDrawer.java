package shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import view.interfaces.PaintCanvasBase;

public class ShapeDrawer {
  private static PaintCanvasBase paintCanvas;

  public ShapeDrawer(PaintCanvasBase paintCanvas) {
    this.paintCanvas = paintCanvas;
  }

  private static void clearCanvas() {
    Graphics2D g2d = paintCanvas.getGraphics2D();
    g2d.setColor(Color.WHITE);
    g2d.fillRect(0,0,1250,800);
  }

  public static void drawAllShapes() {
    clearCanvas();
    for (IShape shape : ShapeList.shapeList) {
     shape.draw(paintCanvas);
    }
  }
}
