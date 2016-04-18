package handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Handles the press of the exit button
 * Clicking this button will close the application
 */
public class ExitButtonHandler implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e){
		System.exit(0);
	}//override
}//class