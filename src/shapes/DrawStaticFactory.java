package shapes;

import model.ShapeShadingType;
import model.ShapeType;
import shapes.DrawEllipse;
import shapes.DrawRectangle;
import shapes.DrawTriangle;
import shapes.FilledShadingStrategy;
import shapes.OutlineAndFilledShadingStrategy;
import shapes.OutlineShadingStrategy;
import shapes.interfaces.IDraw;
import shapes.interfaces.IShadingTypeStrategy;

public class DrawStaticFactory {
  static IDraw createRectangle() {
    return new DrawRectangle();
  }

  static IDraw createTriangle() {
    return new DrawTriangle();
  }

  static IDraw createEllipse() {
    return new DrawEllipse();
  }

}
