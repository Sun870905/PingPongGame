package pong;

import java.awt.event.*;

/**
 * This class is an event handler for the Timer.
 * This is set up in the main method in the Pong class.
 
 */
public class PongRepaintController implements ActionListener {
	private PongModel model;
	private PongView view;
	
	/**
	 * @param model the model of this Pong game
	 * @param view the view of this Pong game
	 */
	public PongRepaintController(PongModel model, PongView view) {
		this.model = model;
		this.view = view;
	}
	
	/**
	 * Perform the needed actions when the timer goes off.
	 * When the timer goes off, move the ball to its next position,
	 * determine if the number of hits or misses changed,
	 * and repaint the window.
	 */
	public void actionPerformed(ActionEvent event) {
		int hits = model.getHits();
		int misses = model.getMisses();
		model.moveBall();
		if (hits != model.getHits() || misses != model.getMisses()) {
			view.setStatus(model.getHits() + " hits, " + 
					model.getMisses() + " misses");
		}
		view.repaint();
	}

}
