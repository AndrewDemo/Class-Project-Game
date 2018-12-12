package edu.ben.project.characters;

import edu.ben.project.board.Tile;
import edu.ben.project.game.Constants;

public class Guard implements Character {

	private int posX;
	private int posY;
	private String guardLast;
	private Tile guard;

	/**
	 * Guard Constructor
	 */
	public Guard(int posX, int posY) {

		// make sure that this is legal spot to put the player.
		if (posX > Constants.SIZE - 2 || posX < 1 || posY > Constants.SIZE - 2 || posY < 1) {
			throw new IllegalArgumentException();
		}

		// record the name of the tile before the guard goes there.
		guardLast = Constants.tiles[posX][posY].getName();

		// set class variables
		this.posX = posX;
		this.posY = posY;

		// create our tile
		guard = new Tile(posX, posY, "G");

		// assign that spot
		Constants.tiles[posX][posY] = guard;
	}

	/**
	 * this moves the guard object.
	 */
	@Override
	public void move(int playerX, int playerY) {

		// if the guards are not frozen
		if (Constants.guardFrozenCounter == 0) {

			// store the previous location before the move.
			int previousX = posX;
			int previousY = posY;

			if (playerX > posX && posX + 1 < Constants.SIZE - 1 && isValidMove(posX + 1, posY)) {
				posX++;
			}

			else if (playerX < posX && posX - 1 > 0 && isValidMove(posX - 1, posY)) {
				posX--;
			}

			if (playerY > posY && posY + 1 < Constants.SIZE - 1 && isValidMove(posX, posY + 1)) {
				this.posY++;
			}

			else if (playerY < posY && posY - 1 > 0 && isValidMove(posX, posY - 1)) {
				posY--;
			}

			// reset previous location name from our guard last
			if (guardLast.equals("P") || guardLast.equals("#")) {
				Constants.tiles[previousX][previousY].setName("-");
			}

			else {
				Constants.tiles[previousX][previousY].setName(guardLast);
			}

			// set the guard last to the new tile
			guardLast = Constants.tiles[posX][posY].getName();

			// set the guard tile to the new location
			Constants.tiles[posX][posY].setName("G");

			// set guard tile.
			guard = Constants.tiles[posX][posY];
		}
	}

	/**
	 * Determines whether or not a guard move is valid
	 * 
	 * @param posX
	 *            is the x position being moved to
	 * @param posY
	 *            is the y position being moved to
	 * @param tiles
	 *            is the array of tile objects
	 * @return true if the move is valid, false otherwise
	 */
	@Override
	public boolean isValidMove(int posX, int posY) {
		return !Constants.tiles[posX][posY].getName().equals("O") && !Constants.tiles[posX][posY].getName().equals("G");
	}

	// GETTERS

	/**
	 * This gets the guard tile object
	 * 
	 * @return the guard tile object
	 */
	public Tile getGuardTile() {
		return guard;
	}

	/**
	 * Gets the x-coordinate of the Guard on the Board
	 * 
	 * @return posX The x-coordinate of the Guard on a Board
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * Gets the y-coordinate of the Guard on the Board
	 * 
	 * @return posY The y-coordinate of the Guard on a Board
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * Gets the name of the previous tile on the board.
	 * 
	 * @return the name of the previous tile
	 */
	public String getGuardLast() {
		return guardLast;
	}

	// SETTERS

	/**
	 * Setter for the name of the previous tile
	 * 
	 * @param guardLast
	 *            sets the name of the previous tile.
	 */
	public void setGuardLast(String guardLast) {
		this.guardLast = guardLast;
	}

}
