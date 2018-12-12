package edu.ben.project.levelOneUseCase;

import java.awt.EventQueue;
import java.util.ArrayList;

import edu.ben.project.board.Board;
import edu.ben.project.board.LevelVariations;
import edu.ben.project.board.Tile;
import edu.ben.project.characters.Guard;
import edu.ben.project.characters.Player;
import edu.ben.project.game.Constants;
import edu.ben.project.game.Game;
import edu.ben.project.gui.BoardGUI;
import edu.ben.project.gui.LoserPopUp;
import edu.ben.project.gui.WinnerPopUp;
import edu.ben.project.gui.WinnerPopUpLastLevel;

public class LevelOneUseCase {

	public void playerWin(Board board, BoardGUI frame) {
		Tile playerLoc = board.getPlayer().getPlayerTile();
		Tile exitTileLoc = board.getExit();
		if (playerLoc.equals(exitTileLoc) && Constants.items.size() == 3 && board.getPlayer().getItems().size() > 0) {
			frame.setEnabled(false);
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						if (Constants.levelCounter < 2) {
							Constants.winnerFrame = new WinnerPopUp();
							Constants.winnerFrame.setVisible(true);
						} else {
							Constants.winnerFrameF = new WinnerPopUpLastLevel();
							Constants.winnerFrameF.setVisible(true);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

	// Checks if the player is in the same location as the guard.
	public void playerLose(Board board, BoardGUI frame) {
		boolean caught = false;
		ArrayList<Guard> guardList = board.getGuardList();
		Tile playerLoc = board.getPlayer().getPlayerTile();
		Tile exitTileLoc = board.getExit();
		for (Guard g : guardList) {
			Tile guardLoc = g.getGuardTile();
			if (playerLoc.equals(guardLoc)) {
				caught = true;
				frame.setEnabled(false);
			}
			if (playerLoc.equals(exitTileLoc) && playerLoc.equals(guardLoc) && Constants.items.size() == 3) {
				caught = false;
			}
		}

		Tile patrolGuardLoc = board.getPatrolGuard().getPatrolGuardTile();
		if (playerLoc.equals(patrolGuardLoc)) {
			caught = true;
		}

		if (playerLoc.equals(exitTileLoc) && playerLoc.equals(patrolGuardLoc) && Constants.items.size() == 3) {
			caught = false;
		}
		if (caught) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Constants.loserFrame = new LoserPopUp();
						Constants.loserFrame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

	/**
	 * Checks if the player is on a teleporter, if they are teleport them to the
	 * other teleporter and sets the Player class variable 'justTeleported' to true.
	 * 
	 * @param posX
	 *            is the x coordinate the player just moved to
	 * @param posY
	 *            is the y coordinate the player just moved to
	 */
	public void onTeleporter(int posX, int posY) {

		if (posX == LevelVariations.teleporter1Y && posY == LevelVariations.teleporter1X && Player.getHasKey()) {
			Player.justTeleported = true;
			Game.movePlayer(LevelVariations.teleporter2Y, LevelVariations.teleporter2X);
		} else if (posX == LevelVariations.teleporter2Y && posY == LevelVariations.teleporter2X && Player.getHasKey()) {
			Player.justTeleported = true;
			Game.movePlayer(LevelVariations.teleporter1Y, LevelVariations.teleporter1X);
		}
		return;

	}
}
