package edu.ben.project.board;

import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import edu.ben.graphicsPackage.TileAssets;
import edu.ben.project.game.Constants;

/**
 * Using 'tiles' and 'btns' from the 'Constants' class generates obstacles on
 * the board and changes board images to display obstacles.
 * 
 *
 */
public class ObstacleGenerator {

	// Grabs from Constants class
	public static int size = Constants.SIZE;

	/**
	 * This method uses the JButton array and Tile array from the constants class to
	 * generate obstacles.
	 */
	public static void generateObstacles() {
		// Sets total number of obstacles
		int numOfObstacles = 40;
		generateObstacles(Constants.btns, Constants.tiles, numOfObstacles);
	}

	/**
	 * Overloaded generateObstacles method takes in JButton array, Tile array, and
	 * desired number of obstacles. Randomly generates obstacles of different shapes
	 * for board.
	 * 
	 * Sets obstacle images and places on board if the shape is valid.
	 * 
	 * @param btns
	 *            is the array of JButtons on the board
	 * @param tiles
	 *            is the array of tiles representing the board
	 * @param numOfObstacles
	 *            is the number of obstacles being created on the board
	 */
	public static void generateObstacles(JButton[][] btns, Tile[][] tiles, int numOfObstacles) {

		int tileSelection, posX, posY;
		Random rand = new Random();

		// Creates as many obstacle tiles as designated by numOfObstacles
		for (int i = 0; i < numOfObstacles; i++) {
			tileSelection = rand.nextInt(3); // Generates random number 0, 1, or 2
			posX = rand.nextInt(14) + 1; // Generates random number between 1 and 14
			posY = rand.nextInt(14) + 1;

			// Builds a different shape depending on random number
			if (tileSelection == 0) {
				if (squareObstacle(posX, posY, btns, tiles)) {
					i += 3; // If the obstacle placement is successful i acknowledges the additional
							// obstacles created
					setObstacleImage(tiles[posX][posY], btns); // Changes images of tiles to be obstacle images.
					setObstacleImage(tiles[posX + 1][posY], btns);
					setObstacleImage(tiles[posX][posY - 1], btns);
					setObstacleImage(tiles[posX + 1][posY - 1], btns);
				} else {
					i--; // If placement is unsuccessful i decrements as an obstacle was not created in
							// this iteration
				}
			} else if (tileSelection == 1) {
				if (verticalObstacle(posX, posY, btns, tiles)) {
					i++;
					setObstacleImage(tiles[posX][posY], btns); // Changes images of tiles to be obstacle images.
					setObstacleImage(tiles[posX][posY - 1], btns);
				} else {
					i--;
				}
			}

			else {
				if (horizontalObstacle(posX, posY, btns, tiles)) {
					i++;
					setObstacleImage(tiles[posX][posY], btns); // Changes images of tiles to be obstacle images.
					setObstacleImage(tiles[posX + 1][posY], btns);
				} else {
					i--;
				}
			}
		}
	}

	/**
	 * Sets the image of the specified tile to be an obstacle image.
	 * 
	 * @param t
	 *            is the tile that is being changed to an obstacle image
	 */
	public static void setObstacleImage(Tile t, JButton[][] btns) {
		if (t != null) {
			btns[t.getX()][t.getY()].setIcon(new ImageIcon(TileAssets.obstacle));
		}
	}

	/**
	 * Creates a square obstacle on the board using the bottom left tile as the
	 * starting point for the square.
	 * 
	 * @param posX
	 *            is the x coordinate of the starting point
	 * @param posY
	 *            is the y coordinate of the starting point
	 * @param btns
	 *            is the array of JButtons on the board
	 * @param tiles
	 *            is the array of tiles representing the board
	 * @return true if the obstacle was successfully placed
	 */
	public static boolean squareObstacle(int posX, int posY, JButton[][] btns, Tile[][] tiles) {

		if (validObstacleLoc(posX, posY, tiles) && validObstacleLoc(posX + 1, posY, tiles)
				&& validObstacleLoc(posX, posY - 1, tiles) && validObstacleLoc(posX + 1, posY - 1, tiles)) {

			tiles[posX][posY].setName("O");// Changes tiles to obstacle tiles.
			tiles[posX + 1][posY].setName("O");
			tiles[posX][posY - 1].setName("O");
			tiles[posX + 1][posY - 1].setName("O");

			return true;
		}
		return false;
	}

	/**
	 * Creates a vertical obstacle on the board using the top tile as the starting
	 * point.
	 * 
	 * @param posX
	 *            is the x coordinate of the starting point
	 * @param posY
	 *            is the y coordinate of the starting point
	 * @param btns
	 *            is the array of JButtons on the board
	 * @param tiles
	 *            is the array of tiles representing the board
	 * @return true if the obstacle was successfully placed
	 */
	public static boolean verticalObstacle(int posX, int posY, JButton[][] btns, Tile[][] tiles) {

		if (validObstacleLoc(posX, posY, tiles) && validObstacleLoc(posX, posY - 1, tiles)) {

			tiles[posX][posY].setName("O"); // Changes tiles to obstacle tiles.
			tiles[posX][posY - 1].setName("O");

			return true;
		}
		return false;
	}

	/**
	 * Creates a horizontal obstacle on the board using the left tile as the
	 * starting point.
	 * 
	 * @param posX
	 *            is the x coordinate of the starting point
	 * @param posY
	 *            is the y coordinate of the starting point
	 * @param btns
	 *            is the array of JButtons on the board
	 * @param tiles
	 *            is the array of tiles representing the board
	 * @return true if the obstacle was successfully placed
	 */
	public static boolean horizontalObstacle(int posX, int posY, JButton[][] btns, Tile[][] tiles) {

		if (validObstacleLoc(posX, posY, tiles) && validObstacleLoc(posX + 1, posY, tiles)) {

			tiles[posX][posY].setName("O"); // Changes tiles to obstacle tiles.
			tiles[posX + 1][posY].setName("O");

			return true;
		}
		return false;
	}

	/**
	 * Determines the validity of an objects placement by checking if there are
	 * other objects adjacent or diagonal to the potential object. Also checks to
	 * ensure the tile is not being placed on an enemyTile;
	 * 
	 * @param posX
	 *            is the x coordinate of the potential obstacle tile
	 * @param posY
	 *            is the y coordinate of the potential obstacle tile
	 * @param tiles
	 *            is the array of tiles representing the board
	 * @return true if there are no conflicts in placing the tile in this location,
	 *         false otherwise
	 */
	public static boolean validObstacleLoc(int posX, int posY, Tile[][] tiles) {

		return (!tiles[posX + 1][posY].getIsObstacle() && !tiles[posX - 1][posY].getIsObstacle()
				&& !tiles[posX][posY + 1].getIsObstacle() && !tiles[posX][posY - 1].getIsObstacle()
				&& !tiles[posX + 1][posY + 1].getIsObstacle() && !tiles[posX + 1][posY - 1].getIsObstacle()
				&& !tiles[posX - 1][posY + 1].getIsObstacle() && !tiles[posX - 1][posY - 1].getIsObstacle());
	}

	/**
	 * This sets the outer brick tiles for our obstacle
	 * 
	 * @param posX
	 *            the x position of the tile
	 * @param posY
	 *            the y position of the tile.
	 * @param btns
	 *            is the array of JButtons on the board
	 * @param tiles
	 *            is the array of tiles representing the board
	 */
	public static void outerObstacles(int posX, int posY, JButton[][] btns, Tile[][] tiles) {

		// top row
		if (posX == 0 && posY > 0 && posY < size - 1) {
			btns[posX][posY].setIcon(new ImageIcon(TileAssets.redBrickLineBottom));
			tiles[posX][posY].setName("O");
		}

		// bottom row
		else if (posX == size - 1 && posY > 0 && posY < size - 1) {
			btns[posX][posY].setIcon(new ImageIcon(TileAssets.redBrickLineTop));
			tiles[posX][posY].setName("O");
		}

		// left row
		else if (posY == 0 && posX > 0 && posX < size - 1) {
			btns[posX][posY].setIcon(new ImageIcon(TileAssets.redBrickLineRight));
			tiles[posX][posY].setName("O");
		}

		// right row
		else if (posY == size - 1 && posX > 0 && posX < size - 1) {
			btns[posX][posY].setIcon(new ImageIcon(TileAssets.redBrickLineLeft));
			tiles[posX][posY].setName("O");
		}

		// any of the corners.
		else if ((posX == 0 || posX == size - 1) && (posY == 0 || posY == size - 1)) {
			btns[posX][posY].setIcon(new ImageIcon(TileAssets.redBrickFloor));
			tiles[posX][posY].setName("O");
		}
	}

}
