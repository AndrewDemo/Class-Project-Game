package edu.ben.project.game;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.ben.project.gui.NotAValidMove;

/**
 * Responsible for calling appropriate method when button is pressed
 * 
 *
 */
public class PlayerInputButtonListener implements ActionListener {

	private int posX;
	private int posY;

	/**
	 * Public constructor. Upon creation calls setTileImage method to set the
	 * buttons images.
	 * 
	 * @param game
	 *            is the current game object being used
	 * @param posX
	 *            is the x coordinate of the button
	 * @param posY
	 *            is the y coordinate of the button
	 */
	public PlayerInputButtonListener(Game game, int posX, int posY) {

		this.posX = posX;
		this.posY = posY;

		Game.loadLevel(posX, posY);
	}

	/**
	 * Calls playerMoved() from game class when player presses a button. Passes in X
	 * and Y coordinate the player has decided to move to.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {

		// if it is valid move we make the move
		if (Game.getPlayer().isValidMove(posX, posY)) {
			Game.movePlayer(posX, posY);
			if (Constants.notValid.isVisible()) {
				Constants.notValid.setVisible(false);
			}
		}

		// otherwise we tell the player that they can't make that move
		else if (posX != Constants.SIZE - 1 && posY != Constants.SIZE - 1) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Constants.notValid = new NotAValidMove();
						Constants.notValid.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

}
