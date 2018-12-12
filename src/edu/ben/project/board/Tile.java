package edu.ben.project.board;

/**
 * This is the Tile class representing each tile on the board.
 * 
 */
public class Tile {

	private int posX;
	private int posY;
	private String name;

	/**
	 * Public constructor for Tile class
	 * 
	 * @param posX
	 *            is the tiles X coordinate on the board.
	 * @param posY
	 *            is the tiles Y coordinate on the board.
	 */
	public Tile(int posX, int posY, String name) {

		this.posX = posX;
		this.posY = posY;
		this.name = name;
	}

	/**
	 * we Override the to string method to be able to print out the tile as a
	 * string.
	 */
	@Override
	public String toString() {
		return name;
	}

	/**
	 * Override hashCode so we can compare tileObjects.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + posX;
		result = prime * result + posY;
		return result;
	}

	/**
	 * Override equals so we can compare tile objects.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tile other = (Tile) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (posX != other.posX)
			return false;
		if (posY != other.posY)
			return false;
		return true;
	}

	// SETTERS

	/**
	 * sets the x position of the tile
	 * 
	 * @param posX
	 *            the x position.
	 */
	public void setPosX(int posX) {
		this.posX = posX;
	}

	/**
	 * sets the y position of the tile
	 * 
	 * @param posY
	 *            the y position.
	 */
	public void setPosY(int posY) {
		this.posY = posY;
	}

	/**
	 * sets the name of the tile.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	// GETTERS

	/**
	 * Gets x coordinate of the tile
	 * 
	 * @return x coordinate of the tile
	 */
	public int getX() {
		return posX;
	}

	/**
	 * Gets y coordinate of the tile
	 * 
	 * @return the y coordinate of the tile
	 */
	public int getY() {
		return posY;
	}

	/**
	 * Gets the name of the tile
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	// properties of tile based on name.

	/**
	 * returns true if valid, false if not valid.
	 * 
	 * @return if a tile is valid or not.
	 */
	public boolean getIsValidMove() {

		return name.equals("#");
	}

	/**
	 * returns true if valid, false if not valid.
	 * 
	 * @return if a tile is valid or not.
	 */
	public boolean getIsExit() {

		return name.equals("E");
	}

	/**
	 * Returns whether or not the tile is an obstacle
	 * 
	 * @return true if the tile is an obstacle, false otherwise
	 */
	public boolean getIsObstacle() {
		return name.equals("O");
	}

	/**
	 * Returns whether or not the tile is an player
	 * 
	 * @return true if the tile is an player, false otherwise
	 */
	public boolean getIsPlayer() {
		return name.equals("P");
	}

	/**
	 * Returns whether or not the tile is an guard
	 * 
	 * @return true if the tile is a guard, false otherwise
	 */
	public boolean getIsGuard() {
		return name.equals("G");
	}

	/**
	 * check if the tile is one of our item tiles.
	 * 
	 * @return
	 */
	public boolean getIsItem() {

		return name.equals("M") || name.equals("D") || name.equals("C") || name.equals("B");

	}

	/**
	 * checks if the tile is a power up or not.
	 * 
	 * @return true if the tile is a power up, false if it is not.
	 */
	public boolean getIsPowerUp() {

		return name.equals("LB") || name.equals("CL") || name.equals("K");
	}

}
