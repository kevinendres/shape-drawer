package shapes;

import java.util.ArrayList;
import java.util.List;
import shapes.interfaces.IShape;

public class Clipboard {
  public static final List<IShape> clipboard = new ArrayList<>();

  public static void add(IShape shape) {
    clipboard.add(shape);
  }

  public static void clear() { clipboard.clear();
  }

}
