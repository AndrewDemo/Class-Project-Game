package edu.ben.project.board;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import edu.ben.graphicsPackage.TileAssets;
import edu.ben.project.characters.Guard;
import edu.ben.project.characters.Player;
import edu.ben.project.game.Constants;

/**
 * BoardImageManager class is responsible for changing the images of the
 * buttons.
 * 
 *
 */
public class BoardImageManager {

	private int size = Constants.SIZE;
	private JButton[][] btns = Constants.btns;
	private Tile[][] tiles = Constants.tiles;

	// Keeps track of the positions of the players last location
	private int lastPlayerX, lastPlayerY, lastPatrolGuardX, lastPatrolGuardY;
	// Lists containing last X coordinates of each guard
	ArrayList<Integer> lastGuardXList = new ArrayList<>();
	// Lists containing last Y coordinates of each guard
	ArrayList<Integer> lastGuardYList = new ArrayList<>();
	// Lists containing last Icons for of each guard
	ArrayList<Icon> guardLastIconList = new ArrayList<>();
	// Create new image variables here
	private Icon playerLastMoveIcon;
	private Icon patrolGuardLastIcon;

	/**
	 * Public constructor for BoardImageManager. Sets Images to Icon variables upon
	 * construction. Sprite sheet chosen is based on level counter in the constants
	 * class.
	 */
	public BoardImageManager() {
		// load images from assets here. We can then call any image here.
		if (Constants.levelCounter == 0)
			TileAssets.init("res/tileSpriteSheet.png");
		if (Constants.levelCounter == 1)
			TileAssets.init("res/tileSpriteSheetLevel2.png");
		if (Constants.levelCounter == 2)
			TileAssets.init("res/tileSpriteSheetLevel3.png");

	}

	/**
	 * Sets the buttons to the appropriate images based on their location.
	 * 
	 * @param posX
	 *            x-coordinate of button being set
	 * @param posY
	 *            y-coordinate of button being set
	 */
	public void setBaseLayout(int posX, int posY) {

		// Eliminates border around button
		btns[posX][posY].setBorder(BorderFactory.createEmptyBorder());
		btns[posX][posY].setContentAreaFilled(false);

		// generate outer obstacles
		if (posX == 0 || posY == 0 || posX == size - 1 || posY == size - 1) {
			ObstacleGenerator.outerObstacles(posX, posY, btns, tiles);
		}

		// All other tiles are set to floor images
		else {
			btns[posX][posY].setIcon(new ImageIcon(TileAssets.floorTileBlue));
		}
	}

	/**
	 * Sets the exit tiles image based on a randomly generated y axis
	 * 
	 * @param posY
	 *            is the randomly generated y axis
	 */
	public void setExitImage(Tile exitTile) {
		btns[exitTile.getX()][exitTile.getY()].setIcon(new ImageIcon(TileAssets.exitClosed));
	}

	/**
	 * Sets the tile images for the patrol guard
	 */
	public void setPatrolGuardImage(Tile patrolGuardTile) {

		// set the default last Icon
		patrolGuardLastIcon = btns[patrolGuardTile.getX()][patrolGuardTile.getY()].getIcon();

		// store the location of the guard Tile for future reference.
		lastPatrolGuardX = patrolGuardTile.getX();
		lastPatrolGuardY = patrolGuardTile.getY();

		// add the guard icon to the board.
		btns[patrolGuardTile.getX()][patrolGuardTile.getY()].setIcon(new ImageIcon(TileAssets.cop));
	}

	/**
	 * sets the default player image at the start of the game.
	 */
	public void setPlayerImage(Tile playerTile) {

		// store the icon on the board before we add the player icon.
		playerLastMoveIcon = btns[playerTile.getX()][playerTile.getY()].getIcon();

		// keep track of player position
		lastPlayerX = playerTile.getX();
		lastPlayerY = playerTile.getY();

		// draw the player image
		btns[playerTile.getX()][playerTile.getY()].setIcon(new ImageIcon(TileAssets.robber));
	}

	/**
	 * Updates button images when the player has moved. Setting the space the player
	 * was on back to an ordinary floor tile and the space the player is newly on to
	 * the player image
	 * 
	 * @param posX
	 *            x-coordinate of button player moved to
	 * @param posY
	 *            y-coordinate of button player moved to
	 */
	public void playerMoved(Player player) {

		Tile playerTile = player.getPlayerTile();

		// draw play last move icon
		btns[lastPlayerX][lastPlayerY].setIcon(playerLastMoveIcon);

		if (player.getPlayerLast().equals("E")) {
			playerLastMoveIcon = new ImageIcon(TileAssets.exitClosed);
		}

		else if (player.getPlayerLast().equals("T")) {
			playerLastMoveIcon = new ImageIcon(TileAssets.teleport);
		}

		else {
			// set our last move icon;
			playerLastMoveIcon = new ImageIcon(TileAssets.floorTileBlue);
		}

		// set new location to robber icon
		btns[playerTile.getX()][playerTile.getY()].setIcon(new ImageIcon(TileAssets.robber));

		// set the last moves of the player
		lastPlayerX = playerTile.getX();
		lastPlayerY = playerTile.getY();

	}

	/**
	 * Sets guard Images
	 *
	 * @param guardList
	 *            is the list of guards
	 */
	public void setGuardImages(ArrayList<Guard> guardList) {

		guardLastIconList.clear();
		lastGuardXList.clear();
		lastGuardYList.clear();

		for (Guard g : guardList) {

			Tile guardTile = g.getGuardTile();
			// Sets the default last icon
			guardLastIconList.add(new ImageIcon(TileAssets.floorTileBlue));
			// Stores tiles x and y for future reference
			lastGuardXList.add(guardTile.getX());
			lastGuardYList.add(guardTile.getY());
			// Adds guard icon to the board
			btns[guardTile.getX()][guardTile.getY()].setIcon(new ImageIcon(TileAssets.cop));
		}

	}

	/**
	 * Updates images of guard to new position
	 * 
	 * @param guardList
	 *            is the list of guards
	 */
	public void guardsMoved(ArrayList<Guard> guardList, Player player) {

		for (int i = 0; i < guardList.size(); i++) {

			// Grabs the x and y of the guard
			int posX = guardList.get(i).getGuardTile().getX();
			int posY = guardList.get(i).getGuardTile().getY();

			// Draws the previous icon
			Constants.btns[lastGuardXList.get(i)][lastGuardYList.get(i)].setIcon(guardLastIconList.get(i));

			// get our last move icon
			if (Constants.tiles[posX][posY].getName().equals("#") && player.isValidMove(posX, posY)) {
				guardLastIconList.set(i, new ImageIcon(TileAssets.floorTileBlue));
			}

			else {
				guardLastIconList.set(i, Constants.btns[posX][posY].getIcon());
			}

			// Sets the new icon as guard
			Constants.btns[posX][posY].setIcon(new ImageIcon(TileAssets.cop));

			lastGuardXList.set(i, posX);
			lastGuardYList.set(i, posY);
		}

	}

	/**
	 * 
	 * @param x1
	 *            position of enemy
	 * @param y1
	 *            position of enemy
	 */
	public void patrolGuardMoved(int posX, int posY) {

		// draw the previous icon
		Constants.btns[lastPatrolGuardX][lastPatrolGuardY].setIcon(patrolGuardLastIcon);

		// get our last move icon
		if (Constants.tiles[posX][posY].getName().equals("P") || Constants.tiles[posX][posY].getName().equals("#")) {
			patrolGuardLastIcon = new ImageIcon(TileAssets.floorTileBlue);
		}

		else {
			patrolGuardLastIcon = Constants.btns[posX][posY].getIcon();
		}

		// set the new icon
		btns[posX][posY].setIcon(new ImageIcon(TileAssets.cop));

		lastPatrolGuardX = posX;
		lastPatrolGuardY = posY;

		// if they get on top of the player for some reason.
		if (lastPatrolGuardX == lastPlayerX && lastPatrolGuardY == lastPlayerY) {
			patrolGuardLastIcon = playerLastMoveIcon;
		}

	}

	/**
	 * this erases the moves once the player moves so we can redraw the valid moves
	 * later.
	 */
	public void eraseValidMoves() {

		for (int i = 0; i < Constants.tiles.length; i++) {
			for (int j = 0; j < Constants.tiles[i].length; j++) {
				if (!Constants.tiles[i][j].getIsObstacle() && Constants.tiles[i][j].getIsValidMove()) {
					btns[i][j].setIcon(new ImageIcon(TileAssets.floorTileBlue));
				}
			}
		}
	}

	/**
	 * This shows all of the valid move tiles that the player can click on. If they
	 * click on a tile that is not valid, the player cannot move.
	 * 
	 * @param validMoves
	 *            this is the tile array of moves that are valid.
	 */
	public void displayValidMoves() {

		for (int i = 0; i < Constants.tiles.length; i++) {
			for (int j = 0; j < Constants.tiles[i].length; j++) {
				if (!Constants.tiles[i][j].getIsObstacle() && Constants.tiles[i][j].getIsValidMove()) {
					btns[i][j].setIcon(new ImageIcon(TileAssets.validMove));
				}
			}
		}
	}

}
