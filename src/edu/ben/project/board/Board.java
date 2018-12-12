package edu.ben.project.board;

import java.util.ArrayList;
import java.util.Random;
import edu.ben.project.characters.Guard;
import edu.ben.project.characters.PatrolGuard;
import edu.ben.project.characters.Player;
import edu.ben.project.game.Constants;

/**
 * Board class is responsible for managing the 2d array of Tile objects as well
 * as knowing where the player and exit is.
 * 
 *
 */
public class Board {

	private int size = Constants.SIZE;
	private Tile exitTile;
	private Player player;
	private ArrayList<Guard> guardList = new ArrayList<Guard>();
	private PatrolGuard patrolGuard;

	/**
	 * Public constructor. Upon construction creates a 2d array of Tile objects
	 * based on the size set in the Game class.
	 */
	public Board() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				// set the names to "-" by default
				Constants.tiles[i][j] = new Tile(i, j, "-");
			}
		}
	}

	/**
	 * updates the enemy tiles. Checks to ensure the guard move is valid before
	 * moving them
	 */
	public void updateEnemies(int posX, int posY) {

		for (Guard g : guardList) {
			if (g == null) {
				throw new NullPointerException();
			}
			g.move(posX, posY);
		}
		patrolGuard.move(Constants.tiles);

	}

	/**
	 * This moves the player to a new location
	 * 
	 * @param posX
	 *            the x position
	 * @param posY
	 *            the y position
	 */
	public void playerMove(int posX, int posY) {

		// make sure that we made the player class.
		if (player == null) {
			throw new NullPointerException();
		}

		// move the player
		player.move(posX, posY);

		// generate the valid moves
		player.generateValidMoves();
	}

	// GENERATORS BELOW

	/**
	 * Sets the tile images for the enemies.
	 */
	public void generateGuards(int numOfGuards) {

		// Empties the previous guardList before making new guards.
		guardList.clear();

		for (int i = 0; i < numOfGuards; i++) {
			// this is the x-range in which they will appear.
			int low = 10;
			int high = 13;

			// import random
			Random rand = new Random();

			// positions for enemy
			int posX = 0;
			int posY = 0;

			// we assume it is not a valid tile
			boolean valid = false;

			// until it is a valid spot
			while (!valid) {

				// generate random place
				posY = rand.nextInt(high - low) + low + 2;
				posX = rand.nextInt(14) + 2;

				// check if it is valid
				if (!Constants.tiles[posX][posY].getIsObstacle() && !Constants.tiles[posX][posY].getIsGuard()) {
					valid = true;
				}
			}

			Guard guard = new Guard(posX, posY);
			// Adds a guard to the composite
			guardList.add(guard);
		}
	}

	/**
	 * Sets the tile images for the enemies.
	 */
	public void generatePatrolGuard(int posX, int posY) {

		// make sure that the location is valid, otherwise we throw it.
		if (posX != Constants.SIZE - 2 || posY != Constants.SIZE - 2) {
			throw new IllegalArgumentException();
		}

		// create patrol guard.
		patrolGuard = new PatrolGuard(posX, posY, Constants.tiles);
	}

	/**
	 * Sets exit tile based on randomly generated y axis
	 * 
	 * @param posY
	 *            is the randomly generated y axis
	 */
	public void generateExitTile(int posX, int posY) {

		// make sure that this is legal spot to put the exit.
		if (posX > Constants.SIZE - 2 || posX < 1 || posY != Constants.SIZE - 2) {
			throw new IllegalArgumentException();
		}

		exitTile = new Tile(posX, posY, "E");

		// set tile at board equal to exit
		Constants.tiles[posX][posY] = exitTile;
	}

	/**
	 * Sets player tile based on passed in player coordinates
	 * 
	 * @param posX
	 *            is the players x coordinate on the board
	 * @param posY
	 *            is the players y coordinate on the board
	 */
	public void generatePlayerTile(int posX, int posY) {

		// instantiate our player class
		player = new Player(posX, posY);

		// generate the moves of the player.
		player.generateValidMoves();
	}

	// GETTERS BELOW

	/**
	 * Returns the tile the exit is on
	 * 
	 * @return exitTile
	 */
	public Tile getExit() {
		return exitTile;
	}

	/**
	 * Gets tile the player is on
	 * 
	 * @return playerTile
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Returns the list of guards
	 * 
	 * @return array list of guard tiles
	 */
	public ArrayList<Guard> getGuardList() {
		return guardList;
	}

	/**
	 * returns the patrolGuard
	 * 
	 * @return patrolGuard
	 */
	public PatrolGuard getPatrolGuard() {
		return patrolGuard;
	}

	/**
	 * Sets the exit tile
	 * 
	 * @param t
	 *            is the tile the exit tile is being set to
	 */
	public void setExitTile(Tile t) {
		exitTile = t;
	}
}
