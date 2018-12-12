package edu.ben.project.board.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import edu.ben.project.board.LevelVariations;
import edu.ben.project.board.Tile;
import edu.ben.project.game.Constants;

/**
 * This class is responsible for testing the LevelVariations class.
 * 
 *
 */
public class LevelVariationsTest {

	public int size = Constants.SIZE;
	Tile[][] tiles = new Tile[size][size];

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Tests to ensure the right top location is used for the teleporter when the
	 * pair selection is 0;
	 */
	@Test
	public void testAddTeleportersTopLocPairIs0() {
		// Creates Tiles
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				tiles[i][j] = new Tile(i, j, "-");
			}
		}
		LevelVariations.addTeleporters(tiles, 0);
		assertTrue(tiles[1][2].getName().equals("T"));
	}

	/**
	 * Tests to ensure the right top location is used for the teleporter when the
	 * pair selection is 0;
	 */
	@Test
	public void testAddTeleportersTopLocPairIs1() {
		// Creates Tiles
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				tiles[i][j] = new Tile(i, j, "-");
			}
		}
		LevelVariations.addTeleporters(tiles, 1);
		assertTrue(tiles[1][6].getName().equals("T"));
	}

	/**
	 * Tests to ensure the right top location is used for the teleporter when the
	 * pair selection is 0;
	 */
	@Test
	public void testAddTeleportersTopLocPairIs2() {
		// Creates Tiles
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				tiles[i][j] = new Tile(i, j, "-");
			}
		}
		LevelVariations.addTeleporters(tiles, 2);
		assertTrue(tiles[1][10].getName().equals("T"));
	}

	/**
	 * Tests to ensure the right top location is used for the teleporter when the
	 * pair selection is 0;
	 */
	@Test
	public void testAddTeleportersTopLocPairIs3() {
		// Creates Tiles
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				tiles[i][j] = new Tile(i, j, "-");
			}
		}
		LevelVariations.addTeleporters(tiles, 3);
		assertTrue(tiles[1][14].getName().equals("T"));
	}

	/**
	 * Tests to ensure the right bottom location is used for the teleporter when the
	 * pair selection is 0;
	 */
	@Test
	public void testAddTeleportersBotLocPairIs0() {
		// Creates Tiles
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				tiles[i][j] = new Tile(i, j, "-");
			}
		}
		LevelVariations.addTeleporters(tiles, 0);
		assertTrue(tiles[size - 2][14].getName().equals("T"));
	}

	/**
	 * Tests to ensure the right bottom location is used for the teleporter when the
	 * pair selection is 1;
	 */
	@Test
	public void testAddTeleportersBotLocPairIs1() {
		// Creates Tiles
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				tiles[i][j] = new Tile(i, j, "-");
			}
		}
		LevelVariations.addTeleporters(tiles, 1);
		assertTrue(tiles[size - 2][10].getName().equals("T"));
	}

	/**
	 * Tests to ensure the right bottom location is used for the teleporter when the
	 * pair selection is 2;
	 */
	@Test
	public void testAddTeleportersBotLocPairIs2() {
		// Creates Tiles
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				tiles[i][j] = new Tile(i, j, "-");
				tiles[i][j].setName("-");
			}
		}
		LevelVariations.addTeleporters(tiles, 2);
		assertTrue(tiles[size - 2][6].getName().equals("T"));
	}

	/**
	 * Tests to ensure the right bottom location is used for the teleporter when the
	 * pair selection is 3;
	 */
	@Test
	public void testAddTeleportersBotLocPairIs3() {
		// Creates Tiles
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				tiles[i][j] = new Tile(i, j, "-");
			}
		}
		LevelVariations.addTeleporters(tiles, 3);
		assertTrue(tiles[size - 2][2].getName().equals("T"));
	}

	/**
	 * Tests when an invalid pairSelection is entered
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAddTeleportersInvalidPairSelection() {
		// Creates Tiles
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				tiles[i][j] = new Tile(i, j, "-");
			}
		}
		LevelVariations.addTeleporters(tiles, 69);
	}

}
