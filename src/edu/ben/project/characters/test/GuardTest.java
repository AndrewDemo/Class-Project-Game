package edu.ben.project.characters.test;

import org.junit.Test;
import edu.ben.project.board.Board;
import edu.ben.project.board.ObstacleGenerator;
import edu.ben.project.characters.Guard;
import edu.ben.project.characters.Player;
import edu.ben.project.game.Constants;
import student.TestCase;

/**
 * 
 */
public class GuardTest extends TestCase {

	/**
	 * This tests the constructor to make sure that it sets everything up with a
	 * valid input.
	 */
	@Test
	public void testGuardValid() {

		// create our new board
		Board board = new Board();

		// create our guard
		Guard guard = new Guard(1, 1);

		String actual = Constants.tiles[1][1].getName();

		String expected = "G";

		assertEquals(expected, actual);
	}

	/**
	 * This tests the constructor with an invalid input.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGuardInvalid() {

		// create our new board
		Board board = new Board();

		// create our guard
		Guard guard = new Guard(-1, -1);

	}

	/**
	 * this tests a move from a guard if it is not valid
	 */
	@Test
	public void testIsValidMoveFalse() {

		// create our new board
		Board board = new Board();

		// create obstacle tile
		Constants.tiles[0][0].setName("O");

		// create our guard
		Guard guard = new Guard(1, 1);

		// try to move to obstacle
		boolean actual = guard.isValidMove(0, 0);

		assertFalse(actual);

	}

	/**
	 * this tests a move from a guard if it is valid.
	 */
	@Test
	public void testIsValidMoveTrue() {

		// create our new board
		Board board = new Board();

		// create our guard
		Guard guard = new Guard(1, 1);

		// try to move to empty floor tile
		boolean actual = guard.isValidMove(0, 0);

		assertTrue(actual);

	}

	/**
	 * this tests the movement of the guard to an open valid space.
	 */
	@Test
	public void testMoveOpenSpace() {

		// create our new board
		Board board = new Board();

		// create our guard
		Guard guard = new Guard(1, 1);

		// move the guard
		guard.move(7, 7);
		guard.move(7, 7);
		guard.move(7, 7);
		guard.move(7, 7);
		guard.move(7, 7);

		String actual = Constants.tiles[6][6].getName();

		String expected = "G";

		assertEquals(expected, actual);
	}

	/**
	 * this tests the movement of the guard to make sure that the previous floor
	 * tile is not empty.
	 */
	@Test
	public void testMovePreviousSpace() {

		// create our new board
		Board board = new Board();

		// create our guard
		Guard guard = new Guard(1, 1);

		// move the guard
		guard.move(7, 7);

		String actual = Constants.tiles[1][1].getName();

		String expected = "-";

		assertEquals(expected, actual);

	}

	/**
	 * attempt to move the guard with obstacles blocking it.
	 */
	@Test
	public void testMoveObstacle() {

		// create our new board
		Board board = new Board();

		// put obstacles in the way
		Constants.tiles[1][2].setName("O");
		Constants.tiles[2][1].setName("O");
		Constants.tiles[2][2].setName("O");

		// create our guard
		Guard guard = new Guard(1, 1);

		// try to move the guard
		guard.move(3, 3);

		String actual = Constants.tiles[1][1].getName();

		String expected = "G";

		assertEquals(expected, actual);
	}

	/**
	 * This tests to see that when a guard goes on top of a tile such as an exit
	 * tile, they do not erase it from the memory of the game.
	 */
	@Test
	public void testGuardLastExit() {

		// make our board
		Board board = new Board();

		// add our guard
		Guard guard = new Guard(2, Constants.SIZE - 3);

		// generate the exit tile
		board.generateExitTile(2, Constants.SIZE - 2);

		// move to the exit
		guard.move(2, Constants.SIZE - 2);

		// move away from the exit
		guard.move(2, Constants.SIZE - 3);
		guard.move(2, Constants.SIZE - 4);
		guard.move(2, Constants.SIZE - 5);

		// make sure that the tile is still an exit tile after the player leaves.
		assertTrue(Constants.tiles[2][Constants.SIZE - 2].getIsExit());
	}

}
