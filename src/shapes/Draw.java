package shapes;

import interact.Point;
import java.awt.Color;
import java.awt.Graphics2D;
import view.interfaces.PaintCanvasBase;

public class Draw implements IDraw{

  @Override
  public void draw(PaintCanvasBase paintCanvas, Point origin, int width, int height) {
    Graphics2D g2d = paintCanvas.getGraphics2D();
    g2d.setColor(Color.BLUE);
    g2d.fillRect(origin.x, origin.y, width, height);
  }
}
