package handlers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import illusions.SteppingFeet;
import panels.DarkPanel;

/**
 * Handles the color selection from the JComboBoxed / drop down menus
 */
public class ColorHandler implements ActionListener{
	JComboBox<String> combo;
	Colorables colorable;
	/**
	 * Creates a new color handler for the indicated JComboBox
	 * @param combo the JComboBox to which this ColorHandler should be applied
	 * @param colorable the colorable element the color of which variable combo describes
	 */
	public ColorHandler(JComboBox<String> combo, Colorables colorable){
		this.combo = combo;
		this.colorable = colorable;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		switch((String)combo.getSelectedItem()) {
		case "Black":
			setColor(colorable, Color.BLACK);
			break;
		case "Blue":
			setColor(colorable, Color.BLUE);
			break;
		case "Cyan":
			setColor(colorable, Color.CYAN);
			break;
		case "Dark gray":
			setColor(colorable, Color.DARK_GRAY);
			break;
		case "Gray":
			setColor(colorable, Color.GRAY);
			break;
		case "Green":
			setColor(colorable, Color.GREEN);
			break;
		case "Light gray":
			setColor(colorable, Color.LIGHT_GRAY);
			break;
		case "Magenta":
			setColor(colorable, Color.MAGENTA);
			break;
		case "Orange":
			setColor(colorable, Color.ORANGE);
			break;
		case "Pink":
			setColor(colorable, Color.PINK);
			break;
		case "Red":
			setColor(colorable, Color.RED);
			break;
		case "White":
			setColor(colorable, Color.WHITE);
			break;
		case "Yellow":
			setColor(colorable, Color.YELLOW);
			break;
		default:
			setColor(colorable, Color.WHITE);
			break;
		}
		
	}
	/**
	 * Set the color of a particular panel or content of the panel
	 * @param colorable the element the color of which you would like to change
	 * 		Options: DARK_FOOT, LIGHT_FOOT, BG (colors the background, so in between the stripes), PANEL (colors the stripes, not the panel itself)
	 * @param color the color to which you would like to change the color of the given element
	 */
	public void setColor(Colorables colorable, Color color){
		switch(colorable){
		case DARK_FOOT:
			SteppingFeet.footPanelDark.setBackground(color);
			break;
		case LIGHT_FOOT:
			SteppingFeet.footPanelLight.setBackground(color);
			break;
		case BG:
			SteppingFeet.fieldPanel.setBackground(color);
			break;
		case PANEL:
			for(DarkPanel d : SteppingFeet.darkPanels){
				d.setBackground(color);
			}
			break;
		default:
			break;
		}//switch
	}//function

}
