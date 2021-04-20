package interact;

import static java.lang.Math.abs;
import static java.lang.Math.min;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import shapes.CreateShapeCommand;
import view.interfaces.PaintCanvasBase;
import model.persistence.ApplicationState;

public class MouseHandler implements MouseListener {
  private final CommandFactory commandFactory;
  private final ApplicationState appState;
  public Point pressPoint;
  public Point releasePoint;

  public MouseHandler(PaintCanvasBase paintCanvas, ApplicationState appState) {
    this.appState = appState;
    this.commandFactory = new CommandFactory(appState);
    this.pressPoint = new Point();
    this.releasePoint = new Point();
    paintCanvas.addMouseListener(this);
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    //do nothing
  }

  @Override
  public void mouseEntered(MouseEvent e) {
    //do nothing
  }

  @Override
  public void mouseExited(MouseEvent e) {
    //do nothing
  }

  @Override
  public void mousePressed(MouseEvent e) {
    this.pressPoint.x = e.getX();
    this.pressPoint.y = e.getY();
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    this.releasePoint.x = e.getX();
    this.releasePoint.y = e.getY();
    ICommand command = commandFactory.createCommand(pressPoint, releasePoint);
    command.run();
  }
}