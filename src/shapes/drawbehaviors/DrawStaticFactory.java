package shapes.drawbehaviors;

import shapes.interfaces.IDraw;

public class DrawStaticFactory {
  public static IDraw createRectangle() {
    return new DrawRectangle();
  }

  public static IDraw createTriangle() {
    return new DrawTriangle();
  }

  public static IDraw createEllipse() {
    return new DrawEllipse();
  }

}
