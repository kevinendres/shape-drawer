package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.interact.MouseHandler;
import model.persistence.ApplicationState;
import shapes.ShapeDrawer;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;

public class Main {
    public static void main(String[] args){
        PaintCanvasBase paintCanvas = new PaintCanvas();
        ShapeDrawer.paintCanvas = paintCanvas;
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
        MouseHandler mouseHandler = new MouseHandler(paintCanvas, appState);
        controller.setup();
    }
}
