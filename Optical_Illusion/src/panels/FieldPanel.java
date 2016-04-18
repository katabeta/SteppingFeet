package panels;

import javax.swing.JPanel;

import illusions.SteppingFeet;

/**
 * Panel containing all of the field stripes 
 * @author Irina Lavryonova
 *
 */
public class FieldPanel extends JPanel{
	/**
	 * Default serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 1) Paint the panel of screen and then copy it onto the screen when allowed
	 * 2) Set the layout
	 * 3) Set the panel to be opaque
	 * 4) Set the panel to be visible (draw the panel)
	 */
	public FieldPanel(){
		setDoubleBuffered(true);
		setLayout(SteppingFeet.FIELD_LAYOUT);
		setOpaque(true);
		setVisible(true);
	}//Constructor
}//class