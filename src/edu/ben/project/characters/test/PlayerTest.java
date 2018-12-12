package edu.ben.project.characters.test;

import org.junit.Assert;
import org.junit.Test;

import edu.ben.project.board.Board;
import edu.ben.project.board.Tile;
import edu.ben.project.characters.Player;
import edu.ben.project.game.Constants;
import student.TestCase;

/**
 * 
 */
public class PlayerTest extends TestCase {

	/**
	 * tests the player class constructor with a valid input.
	 */
	@Test
	public void testPlayerValid() {

		// make our board
		Board board = new Board();

		// add our player
		Player player = new Player(1, 1);

		String actual = Constants.tiles[1][1].getName();

		String expected = "P";

		assertEquals(expected, actual);
	}

	/**
	 * This makes sure that the player class records the tile that was located
	 * before the player moved to that tile.
	 */
	@Test
	public void testPlayerValidPreviousNameFloor() {

		// make our board
		Board board = new Board();

		// add our player
		Player player = new Player(1, 1);

		String actual = player.getPlayerLast();

		String expected = "-";

		assertEquals(expected, actual);
	}

	/**
	 * This makes sure that the player class records the tile that was located
	 * before the player moved to that tile.
	 */
	@Test
	public void testPlayerValidPreviousExit() {

		// make our board
		Board board = new Board();

		// make the exit
		board.generateExitTile(1, Constants.SIZE - 2);

		// add our player
		Player player = new Player(1, Constants.SIZE - 3);

		// move over the exit
		player.move(1, Constants.SIZE - 2);

		// see if it records the E
		String actual = player.getPlayerLast();

		String expected = "E";

		assertEquals(expected, actual);
	}

	/**
	 * This tests to see that when a player goes on top of a tile such as the exit
	 * tile when they are not able to exit the level, the player doesn't erase that
	 * tile when the leave, but instead, it is still named the exit tile.
	 */
	@Test
	public void testPlayerLastExit() {

		// make our board
		Board board = new Board();

		// add our player
		Player player = new Player(2, Constants.SIZE - 3);

		// generate the exit tile
		board.generateExitTile(2, Constants.SIZE - 2);

		// move to the exit
		player.move(2, Constants.SIZE - 2);

		// move past the exit
		player.move(3, Constants.SIZE - 2);

		// make sure that the tile is still an exit tile after the player leaves.
		assertTrue(Constants.tiles[2][Constants.SIZE - 2].getIsExit());
	}

}
