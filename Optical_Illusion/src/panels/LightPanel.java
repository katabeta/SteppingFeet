package panels;

import javax.swing.JPanel;

import illusions.SteppingFeet;

/**
 * The invisible field stripe 
 * @author Irina Lavryonova
 *
 */
public class LightPanel extends JPanel{
	/**
	 * Default serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 1) Set the layout
	 * 2) Paint the panel of screen and then copy it onto the screen when allowed
	 * 3) Set the panel to be transparent
	 * 4) Set the panel to be visible (draw the panel)
	 */
	public LightPanel(){
		setDoubleBuffered(true);
		setLayout(SteppingFeet.BG_LIGHT_LAYOUT);
		setOpaque(false);
		setVisible(true);
	}//Constructor
}//class
