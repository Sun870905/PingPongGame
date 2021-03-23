package pong;

import java.awt.event.*;

/**
 * This class passes the decision to show the popup menu to the PongView.
 * Adapted from Fig. 22.7.
 
 */
public class PongPopupController extends MouseAdapter {
	
	private PongModel model;
	private PongView view;
	
	/**
	 * @param model the model of this Pong game
	 * @param view the view of this Pong game
	 */
	public PongPopupController(PongModel model, PongView view) {
		this.model = model;
		this.view = view;
	}
	
	/**
	 * Go back to the view object to do the pop up menu.
	 */
    public void mousePressed(MouseEvent event) { 
       view.checkForTriggerEvent(event); // check for trigger
    } // end method mousePressed

    /**
     * Go back to the view object to do the pop up menu.
     */
    public void mouseReleased(MouseEvent event) { 
       view.checkForTriggerEvent(event); // check for trigger
    } // end method mouseReleased
}
