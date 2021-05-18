package shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import model.Point;
import model.ShapeColor;
import shapes.interfaces.IDraw;
import shapes.interfaces.IDrawSelectionDecorator;
import shapes.interfaces.IShadingTypeStrategy;
import view.interfaces.PaintCanvasBase;

public class TriangleSelectionDecorator implements IDrawSelectionDecorator {
  private final IDraw originalDrawBehavior;

  public TriangleSelectionDecorator(IDraw originalDrawBehavior) {
    this.originalDrawBehavior = originalDrawBehavior;
  }

  @Override
  public void draw(PaintCanvasBase paintCanvas, Point upperLeft, int width, int height,
      ShapeColor primaryColor, ShapeColor secondaryColor, IShadingTypeStrategy shadingStrategy) {
    this.originalDrawBehavior.draw(paintCanvas, upperLeft, width, height, primaryColor, secondaryColor,
        shadingStrategy);
    this.select(paintCanvas, upperLeft, width, height);
  }

  public void select(PaintCanvasBase paintCanvas, Point upperLeft, int width, int height) {
    Graphics2D g2d = paintCanvas.getGraphics2D();
    Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
    g2d.setStroke(stroke);
    g2d.setColor(Color.BLACK);
    g2d.drawPolygon(new int[] {upperLeft.x - 3, upperLeft.x - 3, upperLeft.x + width + 9}, new int[] {upperLeft.y - 6,
        upperLeft.y + height + 3, upperLeft.y + height + 3}, 3);
  }

  public IDraw getOriginalDrawBehavior() {
    return this.originalDrawBehavior;
  }
}
