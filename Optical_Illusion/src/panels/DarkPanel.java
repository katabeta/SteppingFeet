package panels;

import javax.swing.JPanel;

import illusions.SteppingFeet;

/**
 * The visible field stripe
 * @author Irina Lavryonova
 *
 */
public class DarkPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 1) Paint the panel of screen and then copy it onto the screen when allowed
	 * 2) Set the panel to be opaque
	 * 3) Set the layout
	 * 4) Set the panel to be visible (draw the panel)
	 */
	public DarkPanel(){
		setDoubleBuffered(true);
		setOpaque(true);
		setLayout(SteppingFeet.BG_DARK_LAYOUT);
		setVisible(true);
	}//Constructor
}//class