package shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D.Float;
import model.Point;
import model.ShapeColor;
import shapes.interfaces.IDraw;
import shapes.interfaces.IDrawSelectionDecorator;
import shapes.interfaces.IShadingTypeStrategy;
import view.interfaces.PaintCanvasBase;

public class EllipseSelectionDecorator implements IDrawSelectionDecorator {
  private final IDraw originalDrawBehavior;

  public EllipseSelectionDecorator(IDraw originalDrawBehavior) {
    this.originalDrawBehavior = originalDrawBehavior;
  }

  @Override
  public void draw(PaintCanvasBase paintCanvas, Point upperLeft, int width, int height,
      ShapeColor primaryColor, ShapeColor secondaryColor, IShadingTypeStrategy shadingStrategy) {
    this.originalDrawBehavior.draw(paintCanvas, upperLeft, width, height, primaryColor, secondaryColor,
        shadingStrategy);
    this.select(paintCanvas, upperLeft, width, height);
  }

  @Override
  public void select(PaintCanvasBase paintCanvas, Point upperLeft, int width, int height) {
    Graphics2D g2d = paintCanvas.getGraphics2D();
    Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
    g2d.setStroke(stroke);
    g2d.setColor(Color.BLACK);
    Shape ellipse = new Float(upperLeft.x - 5, upperLeft.y - 5, width + 10, height + 10);
    g2d.draw(ellipse);
  }

  @Override
  public IDraw getOriginalDrawBehavior() {
    return this.originalDrawBehavior;
  }
}
