package edu.ben.project.characters.test;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.Test;
import edu.ben.project.board.Tile;
import edu.ben.project.characters.PatrolGuard;

/**
 * This is the test class for the patrol guard object
 * 
 *
 */
public class PatrolGuardTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Tests the move method when the patrol guard is on the left wall
	 */
	@Test
	public void testMoveOnLeftWall() {
		// Creates Tiles
		Tile[][] tiles = new Tile[18][18];
		for (int i = 0; i < 18; i++) {
			for (int j = 0; j < 18; j++) {
				tiles[i][j] = new Tile(i, j, "-");
			}
		}
		PatrolGuard g = new PatrolGuard(1, 8, tiles);
		g.move(tiles);

		String actual = tiles[1][7].getName();
		String expected = "G";
		assertEquals(expected, actual);
	}

	/**
	 * Tests the move method when the patrol guard is on the top wall
	 */
	@Test
	public void testMoveOnBottomWall() {
		// Creates Tiles
		Tile[][] tiles = new Tile[18][18];
		for (int i = 0; i < 18; i++) {
			for (int j = 0; j < 18; j++) {
				tiles[i][j] = new Tile(i, j, "-");
			}
		}
		PatrolGuard g = new PatrolGuard(8, 1, tiles);
		g.move(tiles);

		String actual = tiles[9][1].getName();
		String expected = "G";
		assertEquals(expected, actual);
	}

	/**
	 * Tests the move method when the patrol guard is on the right wall
	 */
	@Test
	public void testMoveOnRightWall() {
		// Creates Tiles
		Tile[][] tiles = new Tile[18][18];
		for (int i = 0; i < 18; i++) {
			for (int j = 0; j < 18; j++) {
				tiles[i][j] = new Tile(i, j, "-");
			}
		}
		PatrolGuard g = new PatrolGuard(16, 8, tiles);
		g.move(tiles);

		String actual = tiles[16][9].getName();
		String expected = "G";
		assertEquals(expected, actual);
	}

	/**
	 * Tests the move method when the patrol guard is on the bottom wall
	 */
	@Test
	public void testMoveOnTopWall() {
		// Creates Tiles
		Tile[][] tiles = new Tile[18][18];
		for (int i = 0; i < 18; i++) {
			for (int j = 0; j < 18; j++) {
				tiles[i][j] = new Tile(i, j, "-");
			}
		}
		PatrolGuard g = new PatrolGuard(8, 16, tiles);
		g.move(tiles);

		String actual = tiles[7][16].getName();
		String expected = "G";
		assertEquals(expected, actual);
	}

}
