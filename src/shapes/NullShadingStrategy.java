package shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import shapes.interfaces.IDraw;
import shapes.interfaces.IShadingTypeStrategy;

public class NullShadingStrategy implements IShadingTypeStrategy {

  private static NullShadingStrategy instance;
  private NullShadingStrategy() {}

  public static IShadingTypeStrategy getInstance() {
    if (instance == null) {
      instance = new NullShadingStrategy();
    }
    else {
      //do nothing
    }
    return instance;
  }
  @Override
  public void shade(Graphics2D g2d, Shape shape, Color primary, Color secondary) {
    //do nothing
  }
}
