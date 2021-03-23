package pong;

import java.awt.event.*;

/**
 * This reacts to selections from the menu, and also
 * implements the keyboard shortcuts.
 *
 */
public class PongMenuController extends KeyAdapter implements ActionListener {
	private PongModel model;
	private PongView view;
	
	/**
	 * @param model the model of this Pong game
	 * @param view the view of this Pong game
	 */
	public PongMenuController(PongModel model, PongView view) {
		this.model = model;
		this.view = view;
	}
	
	/**
	 * Handle the menu item that was selected.
	 */
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		if (command.equals("Exit")) {
			view.dispose();
			System.exit(0);
		} else if (command.equals("Pause/Continue")) {
			model.setPause(! model.getPause());
		} else if (command.equals("Flip Vertically")) {
			view.setFlipVertical(! view.getFlipVertical());
		}
	}
	
	/**
	 * Handle the keyboard shortcut.
	 */
	public void keyTyped(KeyEvent event) {
		char c = event.getKeyChar();
		if (c == 'e' || c == 'E') {
			view.dispose();
			System.exit(0);
		} else if (c == 'p' || c == 'P') {
			model.setPause(! model.getPause());
		} else if (c == 'f' || c == 'F') {
			view.setFlipVertical(! view.getFlipVertical());
		}
	}
}
