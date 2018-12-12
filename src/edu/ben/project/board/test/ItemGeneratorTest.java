package edu.ben.project.board.test;

import static org.junit.Assert.*;
import java.awt.Image;
import org.junit.AfterClass;
import org.junit.Test;
import edu.ben.graphicsPackage.TileAssets;
import edu.ben.project.board.ItemGenerator;
import edu.ben.project.board.Tile;
import edu.ben.project.characters.Item;
import edu.ben.project.game.Constants;

/**
 * This is the test for the ItemGenerator class
 * 
 *
 */
public class ItemGeneratorTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Tests the placeOnBoard method to ensure it creates a powerUp type of item
	 * when powerUp is being specified.
	 */
	@Test
	public void testPlaceOnBoardPowerUp() {
		Tile[][] tiles = new Tile[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tiles[i][j] = new Tile(i, j, "-");
			}
		}

		Constants.levelCounter = 0;

		int posX = 2;
		int posY = 2;
		String type = "powerUp";

		Item item = ItemGenerator.placeOnBoard(tiles, posX, posY, type);
		String actual = item.getType();
		assertTrue(actual.equals("LB") || actual.equals("CL") || actual.equals("K"));
	}

	/**
	 * Tests the placeOnBoard method to ensure it creates a lightning bolt powerup
	 * if the level is 1 or 2 and the currentPowerUp variable is set to 0;
	 */
	@Test
	public void testPlaceOnBoardPowerUpCurrentPowerUp0() {
		Tile[][] tiles = new Tile[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tiles[i][j] = new Tile(i, j, "-");
			}
		}

		Constants.levelCounter = 1;
		ItemGenerator.setCurrentPowerUp(0);

		int posX = 2;
		int posY = 2;
		String type = "powerUp";

		Item item = ItemGenerator.placeOnBoard(tiles, posX, posY, type);
		String actual = item.getType();
		assertTrue(actual.equals("LB"));
	}

	/**
	 * Tests the placeOnBoard method to ensure it creates a clock powerup if the
	 * level is 1 or 2 and the currentPowerUp variable is set to 1;
	 */
	@Test
	public void testPlaceOnBoardPowerUpCurrentPowerUp1() {
		Tile[][] tiles = new Tile[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tiles[i][j] = new Tile(i, j, "-");
			}
		}

		Constants.levelCounter = 1;
		ItemGenerator.setCurrentPowerUp(1);

		int posX = 2;
		int posY = 2;
		String type = "powerUp";

		Item item = ItemGenerator.placeOnBoard(tiles, posX, posY, type);
		String actual = item.getType();
		assertTrue(actual.equals("CL"));
	}

	/**
	 * Tests the placeOnBoard method to ensure it creates a key powerup if the level
	 * is 1 or 2 and the currentPowerUp variable is set to 2;
	 */
	@Test
	public void testPlaceOnBoardPowerUpCurrentPowerUp2() {
		Tile[][] tiles = new Tile[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tiles[i][j] = new Tile(i, j, "-");
			}
		}

		Constants.levelCounter = 1;
		ItemGenerator.setCurrentPowerUp(2);

		int posX = 2;
		int posY = 2;
		String type = "powerUp";

		Item item = ItemGenerator.placeOnBoard(tiles, posX, posY, type);
		String actual = item.getType();
		assertTrue(actual.equals("K"));
	}

	/**
	 * Tests the placeOnBoard method to ensure it creates an objective type of item
	 * when objective is being specified.
	 */
	@Test
	public void testPlaceOnBoardObjective() {
		Tile[][] tiles = new Tile[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tiles[i][j] = new Tile(i, j, "-");
			}
		}

		int posX = 2;
		int posY = 2;
		String type = "objective";

		Item item = ItemGenerator.placeOnBoard(tiles, posX, posY, type);
		String actual = item.getType();
		assertTrue(actual.equals("D") || actual.equals("M") || actual.equals("C") || actual.equals("B"));
	}

	/**
	 * Checks getItemImage method to ensure it returns the correct image for the
	 * chest item.
	 */
	@Test
	public void testGetItemImageChest() {
		Item item = new Item(2, 2, "objective");
		while (item.getType().equals("B")) {
			item = new Item(2, 2, "objective");
		}
		Image actual = ItemGenerator.getItemImage(item);
		Image expected = TileAssets.chest;
		assertEquals(expected, actual);
	}

	/**
	 * Checks getItemImage method to ensure it returns the correct image for the
	 * coin item.
	 */
	@Test
	public void testGetItemImageCoin() {
		Item item = new Item(2, 2, "objective");
		while (item.getType().equals("C")) {
			item = new Item(2, 2, "objective");
		}
		Image actual = ItemGenerator.getItemImage(item);
		Image expected = TileAssets.coin;
		assertEquals(expected, actual);
	}

	/**
	 * Checks getItemImage method to ensure it returns the correct image for the
	 * money bag item.
	 */
	@Test
	public void testGetItemImageMoneyBag() {
		Item item = new Item(2, 2, "objective");
		while (item.getType().equals("M")) {
			item = new Item(2, 2, "objective");
		}
		Image actual = ItemGenerator.getItemImage(item);
		Image expected = TileAssets.moneyBag;
		assertEquals(expected, actual);
	}

	/**
	 * Checks getItemImage method to ensure it returns the correct image for the gem
	 * item.
	 */
	@Test
	public void testGetItemImageGem() {
		Item item = new Item(2, 2, "objective");
		while (item.getType().equals("LB")) {
			item = new Item(2, 2, "objective");
		}
		Image actual = ItemGenerator.getItemImage(item);
		Image expected = TileAssets.gem;
		assertEquals(expected, actual);
	}

	/**
	 * Checks getItemImage method to ensure it returns the correct image for the
	 * bolt item.
	 */
	@Test
	public void testGetItemImageBolt() {
		Item item = new Item(2, 2, "powerUp");
		while (item.getType().equals("LB")) {
			item = new Item(2, 2, "powerUp");
		}
		Image actual = ItemGenerator.getItemImage(item);
		Image expected = TileAssets.bolt;
		assertEquals(expected, actual);
	}

	/**
	 * Checks getItemImage method to ensure it returns the correct image for the
	 * clock item.
	 */
	@Test
	public void testGetItemImageClock() {
		Item item = new Item(2, 2, "powerUp");
		while (item.getType().equals("CL")) {
			item = new Item(2, 2, "powerUp");
		}
		Image actual = ItemGenerator.getItemImage(item);
		Image expected = TileAssets.clock;
		assertEquals(expected, actual);
	}

	/**
	 * Checks getItemImage method to ensure it returns the correct image for the key
	 * item.
	 */
	@Test
	public void testGetItemImageKey() {
		Item item = new Item(2, 2, "powerUp");
		while (item.getType().equals("K")) {
			item = new Item(2, 2, "powerUp");
		}
		Image actual = ItemGenerator.getItemImage(item);
		Image expected = TileAssets.key;
		assertEquals(expected, actual);
	}

	/**
	 * Tests the validItemLoc method when the location is valid
	 */
	@Test
	public void testValidItemLocLocValid() {
		Tile[][] tiles = new Tile[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tiles[i][j] = new Tile(i, j, "-");
			}
		}

		tiles[2][2].setName("-");
		assertTrue(ItemGenerator.validItemLoc(2, 2, tiles));

	}

	/**
	 * Tests the validItemLoc method when the location is invalid
	 */
	@Test
	public void testValidItemLocLocInvalid() {
		Tile[][] tiles = new Tile[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				tiles[i][j] = new Tile(i, j, "-");
			}
		}
		tiles[2][2].setName("Test");
		assertTrue(!ItemGenerator.validItemLoc(2, 2, tiles));
	}

}
