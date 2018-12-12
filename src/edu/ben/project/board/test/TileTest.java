package edu.ben.project.board.test;

import org.junit.Test;
import student.TestCase;
import edu.ben.project.board.Tile;

/**
 * 
 */
public class TileTest extends TestCase {

	/**
	 * tests the toString of the tile.
	 */
	@Test
	public void testToString() {

		Tile tile = new Tile(1, 1, "My new Tile");

		String expected = "My new Tile\n";

		System.out.println(tile);

		String actual = systemOut().getHistory();

		assertEquals(expected, actual);
	}

	/**
	 * tests the override equals method in the tile class.
	 */
	@Test
	public void testEquals() {

		Tile tile = new Tile(1, 1, "My new Tile");

		Tile tile2 = new Tile(1, 1, "My new Tile");

		boolean actual = tile.equals(tile2);

		assertTrue(actual);
	}

	/**
	 * tests the override hash in the tile class.
	 */
	@Test
	public void testHashCode() {

		Tile tile1 = new Tile(1, 1, "My new Tile");

		Tile tile2 = new Tile(1, 1, "My new Tile");

		int tile1Code = tile1.hashCode();

		int tile2Code = tile2.hashCode();

		assertEquals(tile1Code, tile2Code);
	}

	/**
	 * tests if the tile is a valid move when true
	 */
	@Test
	public void testIsValidMoveTrue() {

		Tile tile = new Tile(1, 1, "#");

		assertTrue(tile.getIsValidMove());
	}

	/**
	 * tests if the tile is a valid move when false.
	 */
	@Test
	public void testisValidMoveFalse() {

		Tile tile = new Tile(1, 1, "Not a valid move");

		assertFalse(tile.getIsValidMove());

	}

	/**
	 * tests if the tile is a player tile when true.
	 */
	@Test
	public void testIsPlayerTrue() {

		Tile tile = new Tile(1, 1, "P");

		assertTrue(tile.getIsPlayer());
	}

	/**
	 * tests if the tile is a player tile when false.
	 */
	@Test
	public void testIsPlayerFalse() {

		Tile tile = new Tile(1, 1, "Not your player tile");

		assertFalse(tile.getIsPlayer());
	}

	/**
	 * tests if the tile is a exit tile when true.
	 */
	@Test
	public void testIsExitTrue() {

		Tile tile = new Tile(1, 1, "E");

		assertTrue(tile.getIsExit());
	}

	/**
	 * tests if the tile is a exit tile when false.
	 */
	@Test
	public void testIsExitFalse() {

		Tile tile = new Tile(1, 1, "Not your exit tile");

		assertFalse(tile.getIsExit());
	}

	/**
	 * tests if the tile is an obstacle tile when true.
	 */
	@Test
	public void testIsObstacleTrue() {

		Tile tile = new Tile(1, 1, "O");

		assertTrue(tile.getIsObstacle());
	}

	/**
	 * tests if the tile is an obstacle tile when false.
	 */
	@Test
	public void testIsObstacleFalse() {

		Tile tile = new Tile(1, 1, "Not your obstacle tile");

		assertFalse(tile.getIsObstacle());
	}

	/**
	 * tests if the tile is a guard tile when true.
	 */
	@Test
	public void testIsGuardTrue() {

		Tile tile = new Tile(1, 1, "G");

		assertTrue(tile.getIsGuard());
	}

	/**
	 * tests if the tile is a guard tile when false.
	 */
	@Test
	public void testIsGuardFalse() {

		Tile tile = new Tile(1, 1, "Not your guard tile");

		assertFalse(tile.getIsGuard());
	}

	/**
	 * tests if the tile is a guard tile when true.
	 */
	@Test
	public void testIsItemTrueDiamond() {

		Tile tile = new Tile(1, 1, "D");

		assertTrue(tile.getIsItem());
	}

	/**
	 * tests if the tile is a guard tile when true.
	 */
	@Test
	public void testIsItemTrueMoneyBag() {

		Tile tile = new Tile(1, 1, "M");

		assertTrue(tile.getIsItem());
	}

	/**
	 * tests if the tile is a guard tile when true.
	 */
	@Test
	public void testIsItemTrueCoin() {

		Tile tile = new Tile(1, 1, "C");

		assertTrue(tile.getIsItem());
	}

	/**
	 * tests if the tile is a guard tile when true.
	 */
	@Test
	public void testIsItemTrueTreasureBox() {

		Tile tile = new Tile(1, 1, "B");

		assertTrue(tile.getIsItem());
	}

	/**
	 * tests if the tile is a guard tile when false.
	 */
	@Test
	public void testIsItemFalse() {

		Tile tile = new Tile(1, 1, "Not your item tile");

		assertFalse(tile.getIsItem());
	}

	/**
	 * tests if the tile is a "speed boost" or lightning bolt
	 */
	@Test
	public void testIsPowerUpTrueLightningBolt() {

		Tile tile = new Tile(1, 1, "LB");

		assertTrue(tile.getIsPowerUp());
	}

	/**
	 * tests if this is a 'slow guard" or a clock.
	 */
	@Test
	public void testIsPowerUpTrueClock() {

		Tile tile = new Tile(1, 1, "CL");

		assertTrue(tile.getIsPowerUp());
	}

	/**
	 * tests if this is a key power up
	 */
	@Test
	public void testIsPowerUpTrueKey() {
		Tile tile = new Tile(1, 1, "K");

		assertTrue(tile.getIsPowerUp());
	}

	/**
	 * tests power up when false
	 */
	@Test
	public void testIsPowerUpFalse() {

		Tile tile = new Tile(1, 1, "Not a power up");

		tile.setName("Not a power up.");

		assertFalse(tile.getIsPowerUp());
	}

}
