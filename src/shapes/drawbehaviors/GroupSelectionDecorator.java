package shapes.drawbehaviors;

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
  public void select(PaintCanvasBase paintCanvas, Point upperLeft, int width, int height) {

  }

  @Override
  public void draw(PaintCanvasBase paintCanvas, Point origin, int width, int height,
      ShapeColor primaryColor, ShapeColor secondaryColor, IShadingTypeStrategy shadingStrategy) {

  }
}
