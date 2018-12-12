package edu.ben.project.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the input button listener for the info button on the board
 * 
 *
 */
public class InfoButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		Game.infoPanel();
	}

}
