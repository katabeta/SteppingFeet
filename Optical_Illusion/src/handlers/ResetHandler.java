package handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

/**
 * Handles the reset button (what happens when the toggle background button is pressed)
 * When pressed, all of the lines become black and the background becomes white,
 * reseting the field to its original state
 */
public class ResetHandler implements ActionListener{
	
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
	public ResetHandler(JComboBox<String> bgcb, JComboBox<String> pcb, String[] choices){
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
		bgcb.setSelectedItem(choices[11]);
		pcb.setSelectedItem(choices[0]);
	}//override
}//class