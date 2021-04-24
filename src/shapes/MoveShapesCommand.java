package shapes;

import java.util.ArrayList;
import java.util.List;
import model.Point;
import model.interact.ICommand;

public class MoveShapesCommand implements ICommand {
  private Point pressPoint;
  private Point releasePoint;
  private List<IShape> shapeList = new ArrayList<>();

  public MoveShapesCommand(Point pressPoint, Point releasePoint) {
    this.pressPoint = pressPoint;
    this.releasePoint = releasePoint;
  }
  @Override
  public void run() {

  }
}
