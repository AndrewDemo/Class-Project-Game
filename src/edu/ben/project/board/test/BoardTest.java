package edu.ben.project.board.test;

import org.junit.Test;

import edu.ben.project.board.Board;
import edu.ben.project.board.Tile;
import edu.ben.project.game.Constants;
import org.junit.Assert;
import student.TestCase;

/**
 * This is the test for the board class
 */
public class BoardTest extends TestCase {

	/**
	 * This tests the board setup to make sure that when the board is initialized it
	 * is all floor tiles at the start.
	 */
	@Test
	public void testBoardSetUp() {

		Tile[][] actual = Constants.tiles;

		Tile[][] expected = new Tile[Constants.SIZE][Constants.SIZE];

		for (int i = 0; i < expected.length; i++) {
			for (int j = 0; j < expected[i].length; j++) {
				expected[i][j] = new Tile(i, j, "-");
			}
		}

		Assert.assertArrayEquals(expected, actual);
	}

	// DYNAMIC MOVEMENT TESTS BELOW (missing enemies)

	/**
	 * This tests the player move valid method when the move is valid.
	 */
	@Test
	public void testPlayerMoveValid() {

		// create board, generate player tile, move player.
		Board board = new Board();
		board.generatePlayerTile(1, 1);
		board.playerMove(2, 2);

		// get the current board state
		Tile[][] actual = Constants.tiles;

		// create a new board for comparison
		Tile[][] expected = new Tile[Constants.SIZE][Constants.SIZE];

		// loop through the board state and add floor tiles.
		for (int i = 0; i < expected.length; i++) {
			for (int j = 0; j < expected[i].length; j++) {
				expected[i][j] = new Tile(i, j, "-");
			}
		}

		// add our player tile
		expected[2][2].setName("P");

		// add the valid moves that go along with the generation of a player.
		expected[0][2].setName("#");
		expected[1][1].setName("#");
		expected[1][2].setName("#");
		expected[1][3].setName("#");
		expected[2][0].setName("#");
		expected[2][1].setName("#");
		expected[2][3].setName("#");
		expected[2][4].setName("#");
		expected[3][1].setName("#");
		expected[3][2].setName("#");
		expected[3][3].setName("#");
		expected[4][2].setName("#");

		// compare if the board states are equal.
		Assert.assertArrayEquals(expected, actual);
	}

	/**
	 * this tests the player move method when the move inputed is illegal / out of
	 * range.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPlayerMoveInvalid() {

		// create board, generate player tile, move player.
		Board board = new Board();
		board.generatePlayerTile(1, 1);
		board.playerMove(1000, 1000);

	}

	/**
	 * this tests the player Move method when the player object has not been made.
	 */
	@Test(expected = NullPointerException.class)
	public void testPlayerMovePlayerNotMade() {

		// create board, move player.
		Board board = new Board();
		board.playerMove(1000, 1000);

	}

	/**
	 * This tests the generation of an exit tile that is not valid.
	 */
	@Test(expected = NullPointerException.class)
	public void testUpdateEnemiesNotMade() {

		// create board and generate player tile.
		Board board = new Board();

		board.updateEnemies(1, 1);

	}

	// GENERATOR TESTS BELOW (missing guards)

	/**
	 * This tests the generation of a player tile.
	 */
	@Test
	public void testGeneratePlayerTileValid() {

		// create board and generate player tile.
		Board board = new Board();
		board.generatePlayerTile(1, 1);

		// get the current board state
		Tile[][] actual = Constants.tiles;

		// create a new board for comparison
		Tile[][] expected = new Tile[Constants.SIZE][Constants.SIZE];

		// loop through the board state and add floor tiles.
		for (int i = 0; i < expected.length; i++) {
			for (int j = 0; j < expected[i].length; j++) {
				expected[i][j] = new Tile(i, j, "-");
			}
		}

		// add our player tile
		expected[1][1].setName("P");

		// add the valid moves that go along with the generation of a player.
		expected[0][0].setName("#");
		expected[0][1].setName("#");
		expected[0][2].setName("#");
		expected[1][0].setName("#");
		expected[1][2].setName("#");
		expected[1][3].setName("#");
		expected[2][0].setName("#");
		expected[2][1].setName("#");
		expected[2][2].setName("#");
		expected[3][1].setName("#");

		// compare if the board states are equal.
		Assert.assertArrayEquals(expected, actual);
	}

	/**
	 * This tests the generation of a player tile with an invalid input that is not
	 * in the range that a player can be positioned.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGeneratePlayerTileInvalid() {

		// create board and generate player tile.
		Board board = new Board();
		board.generatePlayerTile(100, 100);

	}

	/**
	 * This tests the generation of an exit tile.
	 */
	@Test
	public void testGenerateExitTileValid() {

		// create board and generate player tile.
		Board board = new Board();
		board.generateExitTile(1, Constants.SIZE - 2);

		// get the current board state
		Tile[][] actual = Constants.tiles;

		// create a new board for comparison
		Tile[][] expected = new Tile[Constants.SIZE][Constants.SIZE];

		// loop through the board state and add floor tiles.
		for (int i = 0; i < expected.length; i++) {
			for (int j = 0; j < expected[i].length; j++) {
				expected[i][j] = new Tile(i, j, "-");
			}
		}

		// add our player tile
		expected[1][Constants.SIZE - 2].setName("E");

		// compare if the board states are equal.
		Assert.assertArrayEquals(expected, actual);

	}

	/**
	 * This tests the generation of an exit tile that is not valid.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGenerateExitTileInvalid() {

		// create board and generate player tile.
		Board board = new Board();
		board.generateExitTile(1000, 1000);
	}

	/**
	 * This tests the generation of a patrol guard that is not valid.
	 */
	public void testGeneratePatrolGuardValid() {

		// create board and generate player tile.
		Board board = new Board();
		board.generateExitTile(Constants.SIZE - 2, Constants.SIZE - 2);
	}

	/**
	 * This tests the generation of a patrol guard that is not valid.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGeneratePatrolGuardInvalid() {

		// create board and generate player tile.
		Board board = new Board();
		board.generatePatrolGuard(Constants.SIZE - 2, 1000);
	}

	/**
	 * This tests the generation of an enemy tile that is valid.
	 */
	// @Test
	// public void testUpdateEnemiesValid() {
	//
	// // create board, generate player tile, move player.
	// Board board = new Board();
	//
	// board.generatePlayerTile(1, 1);
	//
	// board.generateGuard1();
	//
	// // WE CURRENTLY CAN'T TEST THIS SNCE OUR GENERATE GUARD METHOD IS UNTESTABLE.
	//
	// }
}
