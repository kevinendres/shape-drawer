package shapes.drawbehaviors;

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

public class GroupSelectionDecorator implements IDrawSelectionDecorator {
  private final IDraw originalDrawBehavior;

  public GroupSelectionDecorator(IDraw drawBehavior) {
    this.originalDrawBehavior = drawBehavior;
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
    g2d.drawRect(upperLeft.x - 5, upperLeft.y - 5, width + 10, height + 10);
  }
}
