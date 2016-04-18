package panels;

import javax.swing.JPanel;

import illusions.SteppingFeet;

/**
 * Panel of the feet
 * @author Irina Lavryonova
 *
 */
public class FootPanel extends JPanel{
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
	public FootPanel(){
		setDoubleBuffered(true);
		setLayout(SteppingFeet.FOOT_LAYOUT);
		setOpaque(true);
		setVisible(true);
	}//Constructor
}//class