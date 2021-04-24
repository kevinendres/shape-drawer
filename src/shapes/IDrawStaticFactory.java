package shapes;

import model.ShapeShadingType;
import model.ShapeType;

public interface IDrawStaticFactory {
  static IDraw createDrawBehavior(ShapeType shapeType) {
    switch(shapeType) {
      case RECTANGLE:
        return new DrawRectangle();
      case TRIANGLE:
        return new DrawTriangle();
      case ELLIPSE:
        return new DrawEllipse();
      default:
        return null;
    }
  }

  static IShadingTypeStrategy createShadingStrategy(ShapeShadingType shapeShadingType) {
    switch (shapeShadingType) {
      case OUTLINE:
        return new OutlineShadingStrategy();
      case FILLED_IN:
        return new FilledShadingStrategy();
      case OUTLINE_AND_FILLED_IN:
        return new OutlineAndFilledShadingStrategy();
      default:
        return null;
    }
  }
}
