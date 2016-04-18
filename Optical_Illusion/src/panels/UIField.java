package panels;

import java.awt.Color;

import javax.swing.JLayeredPane;

/**
 * Panel onto which the field elements are layered 
 * @author Irina Lavryonova
 *
 */
public class UIField extends JLayeredPane{
	/**
	 * Default serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 1) Paint the panel of screen and then copy it onto the screen when allowed
	 * 2) Set the panel to be opaque
	 * 3) Set the panel to be visible (draw the panel)
	 * 4) Set the background colour of the pane
	 */
	public UIField(){
		setDoubleBuffered(true);
		setOpaque(true);
		setVisible(true);
		setBackground(Color.LIGHT_GRAY);
	}//Constructor
}//class