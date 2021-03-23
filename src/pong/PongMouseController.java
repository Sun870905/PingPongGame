package pong;

import java.awt.event.*;

/**
 * This is the mouse event handler for the PongPanel.
 
 *
 */
public class PongMouseController implements MouseListener, MouseMotionListener {
	private PongModel model;
	private PongView view;
	
	/**
	 * @param model the model of this Pong game
	 * @param view the view of this Pong game
	 */
	public PongMouseController(PongModel model, PongView view) {
		this.model = model;
		this.view = view;
	}
	
	/*
	 * MouseListener event handlers
	 */ 

	/**
	 * Go back to view for possible popup menu.
	 */
	public void mouseClicked(MouseEvent event) {
		view.checkForTriggerEvent(event);
	} // end method mouseClicked

	/**
	 * Go back to view for possible popup menu.
	 */
	public void mousePressed(MouseEvent event) {
		view.checkForTriggerEvent(event);
	} // end method mousePressed

	/**
	 * nothing to do for mouse release
	 */
	public void mouseReleased(MouseEvent event) {

	} // end method mouseReleased

	/**
	 * clear status bar
	 */
	public void mouseEntered(MouseEvent event) {
		model.setPaddle(event.getX(), event.getY());
		view.setStatus("");
	} // end method mouseEntered

	/**
	 * notify user that mouse is outside the panel
	 */
	public void mouseExited(MouseEvent event) {
		view.setStatus("Mouse outside playing field");
	} // end method mouseExited


	/*
	 *  MouseMotionListener event handlers
	 */

	/*
	 * position of mouse controls paddle
	 */
	public void mouseDragged(MouseEvent event) {
		model.setPaddle(view.translateX(event.getX()), 
				view.translateY(event.getY()));
	} // end method mouseDragged

	/*
	 * position of mouse controls paddle
	 */
	public void mouseMoved(MouseEvent event) {
		model.setPaddle(view.translateX(event.getX()), 
				view.translateY(event.getY()));
	} // end method mouseMoved
	
}
