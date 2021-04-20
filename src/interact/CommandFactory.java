package interact;

import model.MouseMode;
import model.persistence.ApplicationState;
import shapes.CreateShapeCommand;

public class CommandFactory {
  private final ApplicationState appState;
  protected CommandFactory(ApplicationState appState) {
    this.appState = appState;
  }
  public ICommand createCommand(Point pressPoint, Point releasePoint) {
    if (appState.getActiveMouseMode() == MouseMode.DRAW) {
      return new CreateShapeCommand(pressPoint, releasePoint);
    }
    //placeholder
    else if (appState.getActiveMouseMode() == MouseMode.MOVE) {
      return new CreateShapeCommand(pressPoint, releasePoint);
    } else {
      return new CreateShapeCommand(pressPoint, releasePoint);
    }
  }

}
