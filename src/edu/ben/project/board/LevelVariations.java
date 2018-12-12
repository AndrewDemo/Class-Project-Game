package edu.ben.project.board;

import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import edu.ben.graphicsPackage.TileAssets;
import edu.ben.project.game.Constants;

/**
 * This class is responsible for creating the variations between levels
 * 
 *
 */
public class LevelVariations {

	// Coordinates for teleporters
	// Holds the x coordinate of the 1st teleporter
	public static int teleporter1X;
	// Holds the y coordinate of the 1st teleporter
	public static int teleporter1Y = 1;
	// Holds the x coordinate of the 2nd teleporter
	public static int teleporter2X;
	// Holds the y coordinate of the 2nd teleporter
	public static int teleporter2Y = Constants.SIZE - 2;
	// Holds the bottom and top coordinates of the teleporter
	private static int topLoc;
	private static int botLoc;

	/**
	 * Overloaded no args method for generating teleporters. Uses btns and tiles
	 * from the Constants class for the JButton and Tile arrays. Calls
	 * 'setTeleporterImages' to change obstacle images after placing them on the
	 * board.
	 */
	public static void addTeleporters() {
		Random rand = new Random();
		addTeleporters(Constants.tiles, rand.nextInt(4));
		setTeleporterImages(Constants.btns);
	}

	/**
	 * Adds teleporters to the board
	 * 
	 * @param btns
	 *            is the array of JButtons whose images need to be changed
	 * @param tiles
	 *            is the array of tiles representing the board
	 * @param pairSelection
	 *            is an int of 0, 1, 2, or 3 that decides which pattern of
	 *            teleporter locations to use
	 */
	public static void addTeleporters(Tile[][] tiles, int pairSelection) {
		if (pairSelection < 0 || pairSelection > 3) {
			System.out.println("Invalid pairSelection in LevelVariations class - addTeleporters method");
			throw new IllegalArgumentException();
		}

		// Decides which pair of teleporter locations to use
		if (pairSelection == 0) {
			topLoc = 2;
			botLoc = 14;
		} else if (pairSelection == 1) {
			topLoc = 6;
			botLoc = 10;
		} else if (pairSelection == 2) {
			topLoc = 10;
			botLoc = 6;
		} else {
			topLoc = 14;
			botLoc = 2;
		}

		// Sets tile locations to "T" on the board
		tiles[1][topLoc].setName("T");
		tiles[Constants.SIZE - 2][botLoc].setName("T");

		// Updates x coordinate of teleporters
		teleporter1X = topLoc;
		teleporter2X = botLoc;

	}

	/**
	 * When called sets the images of the JButtons in the location found using the
	 * toploc and botloc class variables.
	 */
	private static void setTeleporterImages(JButton[][] btns) {
		btns[1][topLoc].setIcon(new ImageIcon(TileAssets.teleport));
		btns[Constants.SIZE - 2][botLoc].setIcon(new ImageIcon(TileAssets.teleport));
	}

}
