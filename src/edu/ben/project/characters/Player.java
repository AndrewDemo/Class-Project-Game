package edu.ben.project.characters;

import java.util.Stack;
import edu.ben.project.board.Tile;
import edu.ben.project.game.Constants;
import edu.ben.project.game.Game;

/**
 * Player Class
 * 
 */
public class Player implements Character {

	private int posX;
	private int posY;
	private Tile player;
	private String playerLast;
	private int range = 2;
	public static boolean justTeleported = false; // Tells whether or not the player has just used the teleporter
	// Keeps track of whether or not the player has the teleporter key
	private static boolean hasKey;

	/**
	 * Player Constructor
	 */
	public Player(int posX, int posY) {

		// make sure that this is legal spot to put the player.
		if (posX > Constants.SIZE - 2 || posX < 1 || posY > Constants.SIZE - 2 || posY < 1) {
			throw new IllegalArgumentException();
		}

		// grab the name of the tile before we put the player on top of it.
		playerLast = Constants.tiles[posX][posY].getName();

		// set our X and Y
		this.posX = posX;
		this.posY = posY;

		// generate our player tile.
		player = new Tile(posX, posY, "P");

		// set constants at that index to be equal to our player Tile
		Constants.tiles[posX][posY] = player;

		hasKey = false;
	}

	/**
	 * this method moves the user provided it is a valid move.
	 */
	@Override
	public void move(int posX, int posY) {

		// make sure that this is legal spot to put the player.
		if (posX > Constants.SIZE - 2 || posX < 1 || posY > Constants.SIZE - 2 || posY < 1) {
			throw new IllegalArgumentException();
		}

		// reset the valid moves
		resetValidMoves();

		// reset name to be '-' for floor
		Constants.tiles[this.posX][this.posY].setName(playerLast);

		if (Constants.tiles[posX][posY].getIsItem()) {
			// Updates the image counter on the board
			Constants.objectiveCounter++;
			Game.updateCounterButton();
			playerLast = "-";
			Constants.items.add(new Item(posX, posY, "objective"));
		}

		// if it is a power up
		else if (Constants.tiles[posX][posY].getIsPowerUp()) {

			// if it is a bolt
			if (Constants.tiles[posX][posY].getName().equals("LB")) {
				playerLast = "-";
				range++;
			}
			// if it is a clock
			else if (Constants.tiles[posX][posY].getName().equals("CL")) {
				playerLast = "-";
				Constants.guardFrozenCounter = 3;
			}
			// if it is a key
			else if (Constants.tiles[posX][posY].getName().equals("K")) {
				setHasKey(true);
			}
		}

		else {
			// track the last tile before we change it to player
			playerLast = Constants.tiles[posX][posY].getName();
		}

		// set the player tile to the new location
		player = Constants.tiles[posX][posY];
		player.setName("P");

		// set the new location
		this.posX = posX;
		this.posY = posY;
	}

	/**
	 * This method generates the valid moves for the player object. It also adds
	 * these valid moves to our constants tile class object.
	 * 
	 * @param board
	 * @return
	 * @return
	 */
	public void generateValidMoves() {

		for (int i = 0; i < Constants.tiles.length; i++) {
			for (int j = 0; j < Constants.tiles[i].length; j++) {

				// if the distance is 2 moves away at most, the tile is not an obstacle or an
				// enemy, and the tile is not the border, then it is a valid move.
				if ((Math.abs(Constants.tiles[i][j].getX() - posX)
						+ Math.abs(Constants.tiles[i][j].getY() - posY)) <= range
						&& (Math.abs(Constants.tiles[i][j].getX() - posX)
								+ Math.abs(Constants.tiles[i][j].getY() - posY)) > 0
						&& Constants.tiles[i][j].getName().equals("-")) {
					Constants.tiles[i][j].setName("#");
				}
			}
		}
	}

	/**
	 * after the player moves, we loop through the constants tiles and reset all the
	 * previous valid moves to be invalid, then the player moves to their new
	 * location and we generate the next set of valid moves.
	 */
	public void resetValidMoves() {

		for (int i = 0; i < Constants.tiles.length; i++) {
			for (int j = 0; j < Constants.tiles[i].length; j++) {
				if (Constants.tiles[i][j].getIsValidMove()) {
					// Constants.tiles[i][j].setIsValidMove(false);
					Constants.tiles[i][j].setName("-");
				}
			}
		}
	}

	/**
	 * This determines whether a tile is an option for the player to make.
	 * 
	 * @return true if the player can make the move, false if they cannot.
	 */
	public boolean isValidMove(int posX, int posY) {

		return !Constants.tiles[posX][posY].getIsObstacle()
				&& (Math.abs(Constants.tiles[posX][posY].getX() - this.posX)
						+ Math.abs(Constants.tiles[posX][posY].getY() - this.posY) <= range)
				&& (Math.abs(Constants.tiles[posX][posY].getX() - this.posX)
						+ Math.abs(Constants.tiles[posX][posY].getY() - this.posY) > 0);
	}

	// GETTERS

	/**
	 * 
	 * @return the player tile itself
	 */
	public Tile getPlayerTile() {
		return player;
	}

	/**
	 * Gets the x-coordinate of the Player on a Board
	 * 
	 * @return posX The x-coordinate of the Player on a Board
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * Gets the y-coordinate of the Player on a Board
	 * 
	 * @return
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * Gets the range for the player.
	 * 
	 * @return the range of the player.
	 */
	public int getRange() {
		return range;
	}

	/**
	 * 
	 * @return the name of the tile the player was previously at.
	 */
	public String getPlayerLast() {
		return playerLast;
	}

	/**
	 * 
	 * @return the items that the player collected.
	 */
	public Stack<Item> getItems() {
		return Constants.items;
	}

	/**
	 * Returns the variable hasKey
	 * 
	 * @return true if the player has a key, false otherwise
	 */
	public static boolean getHasKey() {
		return hasKey;
	}

	// SETTERS

	/**
	 * setter for the range
	 * 
	 * @param range
	 *            setter for the range.
	 */
	public void setRange(int range) {
		this.range = range;
	}

	/**
	 * Lets you set the name of the last tile the player was at
	 * 
	 * @param playerLast
	 *            the name of the tile the player was previously at.
	 */
	public void setPlayerLast(String playerLast) {

		this.playerLast = playerLast;
	}

	/**
	 * Lets you set the hasKey boolean
	 *
	 * @param hasKey
	 *            is whether or not the player has the key
	 */
	public static void setHasKey(boolean hasKey) {
		Player.hasKey = hasKey;
	}

}
