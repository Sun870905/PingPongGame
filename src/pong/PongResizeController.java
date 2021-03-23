package pong;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class is an event handler for when the Pong's panel
 * is resized.

 */
public class PongResizeController extends ComponentAdapter {
	private PongModel model;
	private PongView view;
	
	/**
	 * @param model the model of this Pong game
	 * @param view the view of this Pong game
	 */
	public PongResizeController(PongModel model, PongView view) {
		this.model = model;
		this.view = view;
	}

	/**
	 * Ensure that the model gets the correct size of the PongPanel.
	 */
    public void componentResized(ComponentEvent event) {
    	Dimension size = view.getPongPanelSize();
    	if (size.width != model.getWidth() || size.height != model.getHeight()) {
    		model.setSize(size.width, size.height);
    		view.setStatus("Size is " + size.width + " x " + size.height);
    	}
    }
}


