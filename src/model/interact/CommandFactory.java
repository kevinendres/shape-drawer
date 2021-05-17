package model.interact;

import model.Point;
import model.persistence.ApplicationState;
import shapes.CreateShapeCommand;
import shapes.MoveShapesCommand;
import shapes.SelectShapesCommand;

public class CommandFactory {
  private final ApplicationState appState;
  protected CommandFactory(ApplicationState appState) {
    this.appState = appState;
  }
  public ICommand createCommand(Point pressPoint, Point releasePoint) {
    switch (appState.getActiveMouseMode()) {
      case DRAW:
        return new CreateShapeCommand(pressPoint, releasePoint, appState.getActivePrimaryColor(),
            appState.getActiveSecondaryColor(), appState.getActiveShapeShadingType(),
            appState.getActiveShapeType());
      case SELECT:
        return new SelectShapesCommand(pressPoint, releasePoint);
      case MOVE:
        return new MoveShapesCommand(pressPoint, releasePoint);
      default:
        return null;
    }
  }
}
