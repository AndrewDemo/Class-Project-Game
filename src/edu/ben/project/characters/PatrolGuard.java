package edu.ben.project.characters;

import edu.ben.project.board.Tile;
import edu.ben.project.game.Constants;

/**
 * This class represents the patrol guard
 * 
 *
 */
public class PatrolGuard {

	// Holds patrol guards x and y coordinates
	private int posX;
	private int posY;
	// Holds the name of the last tile the patrol guard was on
	private String patrolGuardLast;
	// The tile the patrol guard is currently on
	private Tile patrolGuard;

	/**
	 * Guard Constructor
	 * 
	 * @param posX
	 *            is the x-coordinate of the patrol guard
	 * @param posY
	 *            is the y-coordinate of the patrol guard
	 */
	public PatrolGuard(int posX, int posY, Tile[][] tiles) {

		// make sure that this is legal spot to put the player.
		if (posX > Constants.SIZE - 2 || posX < 1 || posY > Constants.SIZE - 2 || posY < 1) {
			throw new IllegalArgumentException();
		}

		// record the name of the tile before the guard goes there.
		// patrolGuardLast = Constants.tiles[posX][posY].getName();
		patrolGuardLast = "-";

		// set class variables
		this.posX = posX;
		this.posY = posY;

		// create our tile
		patrolGuard = new Tile(posX, posY, "G");

		// assign that spot
		tiles[posX][posY] = patrolGuard;
	}

	/**
	 * this moves the guard object.
	 * 
	 * @param playerX
	 *            is the player's new x-coordinate
	 * @param playerY
	 *            is the player's new y-coordinate
	 */
	public void move(Tile[][] tiles) {
		// store the previous location before the move.
		int previousX = posX;
		int previousY = posY;

		if (posX <= 16 && posX > 1 && posY == 16) {
			posX--;
		} else if (posY > 1 && posY <= 16 && posX == 1) {
			if (tiles[posX][posY - 1].getName().equals("T")) {
				posY -= 2;
			} else {
				posY--;
			}
		} else if (posX >= 1 && posX < 16 && posY == 1) {
			posX++;
		} else if (posX == 16 && posY >= 1 && posY < 16) {
			if (tiles[posX][posY + 1].getName().equals("T")) {
				posY += 2;
			} else {
				posY++;
			}
		}

		// Reset previous location name from our guard last
		if (patrolGuardLast.equals("P") || patrolGuardLast.equals("#")) {
			tiles[previousX][previousY].setName("-");
		} else {
			patrolGuard.setName(patrolGuardLast);
			tiles[previousX][previousY].setName(patrolGuardLast);
		}

		// Set the guard last to the new tile
		patrolGuardLast = tiles[posX][posY].getName();

		// set the guard tile to the new location
		tiles[posX][posY].setName("G");

		// set the guard tile
		patrolGuard = tiles[posX][posY];

	}

	/**
	 * This gets the guard tile object
	 * 
	 * @return the guard tile object
	 */
	public Tile getPatrolGuardTile() {
		return patrolGuard;
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
		return patrolGuardLast;
	}

	// SETTERS

	/**
	 * Setter for the name of the previous tile
	 * 
	 * @param guardLast
	 *            sets the name of the previous tile.
	 */
	public void setPatrolGuardLast(String patrolGuardLast) {
		this.patrolGuardLast = patrolGuardLast;
	}

	/**
	 * Sets the x-coordinate for the patrol guard
	 * 
	 * @param posX
	 *            is the x coordinate of the patrol guard
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * Sets the y-coordinate for the patrol guard
	 * 
	 * @param posY
	 *            is the y coordinate of the patrol guard
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

}
