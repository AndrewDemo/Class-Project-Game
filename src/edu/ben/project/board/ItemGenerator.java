package edu.ben.project.board;

import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import edu.ben.graphicsPackage.TileAssets;
import edu.ben.project.characters.Item;
import edu.ben.project.game.Constants;

/**
 * Using the 'tiles' and 'btns' from the 'Constants' class generates items on
 * the board and changes board images to display items.
 * 
 *
 */
public class ItemGenerator {

	// Grabs from Constants class
	public static int size = Constants.SIZE;
	private static int currentPowerUp = 0;

	/**
	 * This method uses the JButton array and Tile array from the constants class to
	 * generate items. This is the default generateItems method, 3 powerups of each
	 * type are generated and their locations are randomly chosen using the
	 * generateItemLocation method.
	 */
	public static void generateItems() {
		currentPowerUp = 0;
		// Sets total number of power ups
		int numOfPowerUps = 3;
		// Sets total number of objectives
		int numOfObjectives = 3;

		// Generates power ups
		generateItemLocation(Constants.btns, Constants.tiles, numOfPowerUps, "powerUp");
		// Generates objective items
		generateItemLocation(Constants.btns, Constants.tiles, numOfObjectives, "objective");

	}

	/**
	 * Takes in JButton array, Tile array, desired number of items, and item type.
	 * Randomly generates items on the board in locations that are checked for
	 * validity.
	 * 
	 * @param btns
	 *            is the array of JButtons whose images are being changed
	 * @param tiles
	 *            is the array of Tile objects representing the board
	 * @param numOfItems
	 *            is the number of items being generated
	 * @param type
	 *            is the type of item being generated
	 */
	public static void generateItemLocation(JButton[][] btns, Tile[][] tiles, int numOfItems, String type) {
		Random rand = new Random();
		int posX, posY;
		for (int i = 0; i < numOfItems; i++) {
			// Generates a random x and y coordinate, checks if it is valid and calls
			// placeItem
			posX = rand.nextInt(14) + 2;
			posY = rand.nextInt(14) + 2;
			if (validItemLoc(posX, posY, tiles)) {
				placeItem(btns, tiles, posX, posY, type);
			} else {
				i--;
			}
		}
	}

	/**
	 * Calls placeOnBoard and setItemImage to generate the items, places the items
	 * on the board, and changes the images.
	 * 
	 * @param btns
	 *            is the array of JButtons whose images need to be changed
	 * 
	 * @param tiles
	 *            is the array of Tile objects representing the board
	 * @param posX
	 *            is the x coordinate where the item is being placed
	 * @param posY
	 *            is the y coordinate where the item is being placed
	 * @param type
	 *            is the type of item
	 */
	public static void placeItem(JButton[][] btns, Tile[][] tiles, int posX, int posY, String type) {
		Item item = placeOnBoard(tiles, posX, posY, type);
		setItemImage(posX, posY, btns, item);
	}

	/**
	 * Places the items on the board and changes the images.
	 * 
	 * @param tiles
	 *            is the array of Tile objects representing the board
	 * @param posX
	 *            is the x coordinate where the item is being placed
	 * @param posY
	 *            is the y coordinate where the item is being placed
	 * @param type
	 *            is the type of item
	 * @return the item that has just been generated and placed on the board
	 */
	public static Item placeOnBoard(Tile[][] tiles, int posX, int posY, String type) {
		Item item;
		if (Constants.levelCounter == 1 || Constants.levelCounter == 2) {
			item = new Item(posX, posY, type, currentPowerUp);
			currentPowerUp++;
		} else {
			item = new Item(posX, posY, type);
		}
		tiles[posX][posY].setName(item.getType());
		return item;
	}

	/**
	 * Sets the item image in the JButton
	 * 
	 * @param posX
	 *            is the x coordinate where the image is being changed
	 * @param posY
	 *            is the y coordinate where the image is being changed
	 * @param btns
	 *            is the JButton array of buttons whose image is being changed
	 * @param item
	 *            is the item whose image is being set to the button image
	 */
	public static void setItemImage(int posX, int posY, JButton[][] btns, Item item) {
		Image image = getItemImage(item);
		btns[posX][posY].setIcon(new ImageIcon(image));

	}

	/**
	 * Gets the appropriate image depending on the type of item that is being placed
	 * on the board
	 * 
	 * @param item
	 *            is the item whose image is being returned
	 * @return the image of the item that was passed in
	 */
	public static Image getItemImage(Item item) {
		if (item.getType().equals("LB")) {
			return TileAssets.bolt;
		} else if (item.getType().equals("CL")) {
			return TileAssets.clock;
		} else if (item.getType().equals("D")) {
			return TileAssets.gem;
		} else if (item.getType().equals("M")) {
			return TileAssets.moneyBag;
		} else if (item.getType().equals("C")) {
			return TileAssets.coin;
		} else if (item.getType().equals("B")) {
			return TileAssets.chest;
		} else if (item.getType().equals("K")) {
			return TileAssets.key;
		}
		return null;
	}

	/**
	 * Determines if the location is a valid location to put an item
	 * 
	 * @param posX
	 *            is the x coordinate on the board where the item is planning to go
	 * @param posY
	 *            is the y coordinate on the board where the item is planning to go
	 * @param tiles
	 *            is the array of Tile objects representing the board
	 * @return true if the location is valid, false otherwise.
	 */
	public static boolean validItemLoc(int posX, int posY, Tile[][] tiles) {
		return (tiles[posX][posY].getName().equals("-"));
	}

	/**
	 * Setter for the current powerUp variable
	 * 
	 * @param currentPowerUp
	 *            is the int that currentPowerUp is being set to.
	 */
	public static void setCurrentPowerUp(int currentPowerUp) {
		ItemGenerator.currentPowerUp = currentPowerUp;
	}

}
