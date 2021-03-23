package pong;

import javax.swing.*;

/**
 * This implements a simple Pong game to illustrate a more complex
 * GUI with multiple classes for the controller and view parts of 
 * the MVC pattern.
 * 
 *
 */
public class Pong {
	/**
	 * Create the objects for the model, view and controller,
	 * and launch the application.
	 */
	public static void main(String[] args) {
		/* create new model, view and controller */
		PongModel model = new PongModel();
		PongView view = new PongView(model);
		PongMouseController mouseController = 
				new PongMouseController(model, view);
		PongResizeController resizeController = 
				new PongResizeController(model, view);
		PongMenuController menuController = 
				new PongMenuController(model, view);
		PongPopupController popupController = 
				new PongPopupController(model, view);
		PongRepaintController repaintController = 
				new PongRepaintController(model, view);
		
		// repaint timer so that the window will update every 25 ms
	    new Timer(25, repaintController).start();
		
		/* register other controllers as listeners */
		view.registerListeners(mouseController, resizeController,
				menuController, popupController);
		
		/* start it up */
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(400, 300);
		view.setVisible(true);
	}
}
