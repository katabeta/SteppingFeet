package handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

/**
 * Handles the gray out all lines button (what happens when the gray out all lines button is pressed)
 * When the button is pressed, all of the lines and the background are turned gray,
 * efeectivel graying out all of the field.
 * @author Irina Lavryonova
 *
 */
public class ToggleBackgroundHandler implements ActionListener{
	ColorHandler colorHandlerBG;
	ColorHandler colorHandlerP;
	JComboBox<String> bgcb;
	JComboBox<String> pcb;
	String[] choices;
	
	/**
	 * 
	 * @param bgcb the JComboBox which describes the color of the background
	 * @param pcb the JComboBox which describes the color of the panels
	 * @param choices the array which has all of the possible color choises
	 */
	public ToggleBackgroundHandler(JComboBox<String> bgcb, JComboBox<String> pcb, String[] choices) {
		colorHandlerBG = new ColorHandler(bgcb, Colorables.BG);
		colorHandlerP = new ColorHandler(pcb, Colorables.PANEL);
		this.bgcb = bgcb;
		this.pcb = pcb;
		this.choices = choices;
	}
	/**
	 * @Override
	 * Sets the value of the JComboBox which describes the color of the background as white.
	 * Sets the value of the JComboBox which describes the color of the panels as black.
	 * The ColorHandlers on the JComboBoxes then change the colors of the elements themeselves.
	 */
	public void actionPerformed(ActionEvent e){
		bgcb.setSelectedItem(choices[4]);
		pcb.setSelectedItem(choices[4]);
	}//override
}//class