package pong;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This along with PongPanel implements the view of the simple Pong game.
 */
public class PongView extends JFrame {
    private PongModel model;
    private PongPanel pongPanel;
    private JLabel statusBar;
    private JMenu pongMenu;
    private JPopupMenu popupMenu;
    /* controls whether paddle appears on top of JPanel */
    private boolean flipVertical;

    /**
     * The constructor creates the components and places them in the window.
     * @param model the model for this Pong game
     */
    public PongView(PongModel model) {
        super("Simple Pong Game");
        this.model = model;
        flipVertical = false;

        // create the menu

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        pongMenu = new JMenu("Menu");
        pongMenu.setMnemonic('M');
        menuBar.add(pongMenu);

        JMenuItem flipVerticalItem = new JMenuItem("Flip Vertically");
        flipVerticalItem.setMnemonic('F');
        pongMenu.add(flipVerticalItem);

        JMenuItem pauseItem = new JMenuItem("Pause/Continue");
        pauseItem.setMnemonic('P');
        pongMenu.add(pauseItem);

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.setMnemonic('E');
        pongMenu.add(exitItem);

        // create the popup menu, need new JMenuItems

        popupMenu = new JPopupMenu();
        popupMenu.add(new JMenuItem("Flip Vertically"));
        popupMenu.add(new JMenuItem("Pause/Continue"));
        popupMenu.add(new JMenuItem("Exit"));

        /* CENTER:
         * The panel where Pong is played
         */
        pongPanel = new PongPanel(model, this);
        add(pongPanel, BorderLayout.CENTER);
        pongPanel.setBackground(Color.WHITE);
        Dimension size = pongPanel.getSize();
        model.setSize(size.width, size.height);

        /* SOUTH:
         * A status bar for telling us what happens.
         * Borrowed from Figure 14.15.
         */
        statusBar = new JLabel("The status bar is open.");
        statusBar.setBackground(Color.YELLOW);
        statusBar.setOpaque(true); // need this for setBackground to work
        add(statusBar, BorderLayout.SOUTH);

        // so the PongPanel can listen to the keyboard
        pongPanel.requestFocus();
    }

    /**
     * Register event handlers with the appropriate components.
     * @param controller1 a PongMouseController
     * @param controller2 a PongResizeController
     * @param controller3 a PongMenuController
     * @param controller4 a PongPopupController
     */
    public void registerListeners(PongMouseController controller1, 
            PongResizeController controller2,
            PongMenuController controller3,
            PongPopupController controller4) {
        pongPanel.addMouseListener(controller1);
        pongPanel.addMouseMotionListener(controller1);
        pongPanel.addComponentListener(controller2);
        pongPanel.addKeyListener(controller3);
        this.addMouseListener(controller4);

        Component[] components = pongMenu.getMenuComponents();
        for (Component component : components) {
            if (component instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) component;
                button.addActionListener(controller3);
            }
        }

        components = popupMenu.getComponents();
        for (Component component : components) {
            if (component instanceof AbstractButton) {
                AbstractButton button = (AbstractButton) component;
                button.addActionListener(controller3);
            }
        }
    }

    /**
     * Set the text in the status bar.
     * @param text
     */
    public void setStatus(String text) {
        statusBar.setText(text);
    }

    /**
     * @return The size of the PongPanel.
     */
    public Dimension getPongPanelSize() {
        return pongPanel.getSize();
    }

    /**
     * Translate from mouse x to model x depending on view mode.
     * @param x horizontal location of mouse
     */
    public int translateX(int x) {
        return x;
    }

    /**
     * Translate from mouse y to model y depending on view mode.
     * @param y vertical location of mouse or model
     */
    public int translateY(int y) {
        if (flipVertical) {
            Dimension size = getPongPanelSize();
            y = size.height - y;
        }
        return y;
    }

    /**
     * @return value of flipVertical
     */
    public boolean getFlipVertical() {
        return flipVertical;
    }

    /**
     * Set value of flipVertical
     * @param b new value for flipVertical
     */
    public void setFlipVertical(boolean b) {
        flipVertical = b;
    }

    /**
     * Show popup menu if indicated.
     * @param event
     */
    public void checkForTriggerEvent(MouseEvent event) {
        if (event.isPopupTrigger()) {
            popupMenu.show(event.getComponent(), event.getX(), event.getY()); 
        }
    }
}
