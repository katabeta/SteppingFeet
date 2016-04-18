package panels;

import javax.swing.JPanel;

import illusions.SteppingFeet;

/**
 * Panel containing all of the buttons 
 * @author Irina Lavryonova
 *
 */
public class UIBPanel extends JPanel{
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
	public UIBPanel(){
		setLayout(SteppingFeet.UIB_LAYOUT);
		setDoubleBuffered(true);
		setOpaque(false);
		setVisible(true);
	}//Constructor
}//class