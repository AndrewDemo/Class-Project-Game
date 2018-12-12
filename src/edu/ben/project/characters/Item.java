package edu.ben.project.characters;

import java.util.Random;
import edu.ben.project.board.Tile;
import edu.ben.project.game.Constants;

/**
 * Item Class
 * 
 *
 */
public class Item {

	private Tile[][] tiles = Constants.tiles;
	private String[] powerUpTypes = { "LB", "CL", "K" };
	private String[] objectiveTypes = { "D", "M", "C", "B" };
	private Tile currentTile;
	private String type;

	// CONSTRUCTORS

	/**
	 * Item Constructor
	 * 
	 * @param posX
	 *            x-coordinate of Item
	 * @param posY
	 *            y-coordinate of Item
	 * @param type
	 *            Type of Item from the powerUpTypes array
	 */
	public Item(int posX, int posY, String type) {

		if (type.equals("powerUp")) {
			Random random = new Random();
			int typeIndex = random.nextInt(2);
			this.type = generatePowerUpType(typeIndex);
		}

		else if (type.equals("objective")) {
			Random random = new Random();
			int typeIndex = random.nextInt(4);
			this.type = generateObjectiveType(typeIndex);
		}

		else {
			throw new IllegalArgumentException();
		}

		currentTile = tiles[posX][posY];
	}

	/**
	 * Overloaded constructor for when you do not want random powerUp spawns and
	 * instead want to spawn all 3
	 * 
	 * @param posX
	 *            x-coordinate of Item
	 * @param posY
	 *            y-coordinate of Item
	 * @param type
	 *            Type of Item from the powerUpTypes array
	 * @param currentPowerUp
	 *            is the index of the desired item
	 */
	public Item(int posX, int posY, String type, int currentPowerUp) {

		if (type.equals("powerUp")) {
			this.type = generatePowerUpType(currentPowerUp);
		}

		else if (type.equals("objective")) {
			Random random = new Random();
			int typeIndex = random.nextInt(2);
			this.type = generateObjectiveType(typeIndex);
		}

		else {
			throw new IllegalArgumentException();
		}

		currentTile = tiles[posX][posY];
	}

	// GENERATORS

	/**
	 * 
	 * @param index
	 *            is the index of the powerUp we want
	 * @return the string associated with the correct powerUp
	 */
	public String generatePowerUpType(int index) {
		return powerUpTypes[index];
	}

	/**
	 * Randomly selects the Objective type of an Item
	 * 
	 * @return objectiveTypes[typeIndex] a random String type
	 */
	private String generateObjectiveType(int typeIndex) {
		return objectiveTypes[typeIndex];
	}

	// GETTERS

	/**
	 * Gets the current Tile the Item is on
	 * 
	 * @return currentTile the current Tile the item is on
	 */
	public Tile getCurrentTile() {
		return currentTile;
	}

	/**
	 * Gets the Item type
	 * 
	 * @return type The Item type
	 */
	public String getType() {
		return type;
	}

}
