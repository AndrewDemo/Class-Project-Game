package edu.ben.project.board.test;

import javax.swing.JButton;
import org.junit.Test;
import edu.ben.project.board.ObstacleGenerator;
import edu.ben.project.board.Tile;
import edu.ben.project.game.Constants;
import student.TestCase;

/**
 * This is the test class for ObstacleGenerator
 * 
 *
 */
public class ObstacleGeneratorTest extends TestCase {

	int size = Constants.SIZE;
	JButton[][] btns = new JButton[10][10];
	Tile[][] tiles = new Tile[10][10];

	/**
	 * Tests squareObstacle method to ensure the top left block is being set to an
	 * obstacle.
	 */
	@Test
	public void testSquareObstacleTopLeftBlock() {
		// Creates Tiles
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				tiles[i][j] = new Tile(i, j, "-");
			}
		}

		ObstacleGenerator.squareObstacle(2, 2, btns, tiles);
		String actual = tiles[2][2].getName();
		String expected = "O";
		assertEquals(expected, actual);
	}

	/**
	 * Tests squareObstacle method to ensure the top right block is being set to an
	 * obstacle.
	 */
	@Test
	public void testSquareObstacleTopRightBlock() {
		// Creates Tiles
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				tiles[i][j] = new Tile(i, j, "-");
			}
		}

		ObstacleGenerator.squareObstacle(2, 2, btns, tiles);
		String actual = tiles[3][2].getName();
		String expected = "O";
		assertEquals(expected, actual);
	}

	/**
	 * Tests squareObstacle method to ensure the top bottom block is being set to an
	 * obstacle.
	 */
	@Test
	public void testSquareObstacleBottomLeftBlock() {
		// Creates Tiles
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				tiles[i][j] = new Tile(i, j, "-");
			}
		}

		ObstacleGenerator.squareObstacle(2, 2, btns, tiles);
		String actual = tiles[2][1].getName();
		String expected = "O";
		assertEquals(expected, actual);
	}

	/**
	 * Tests squareObstacle method to ensure the bottom right block is being set to
	 * an obstacle.
	 */
	@Test
	public void testSquareObstacleBottomRightBlock() {
		// Creates Tiles
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				tiles[i][j] = new Tile(i, j, "-");
			}
		}

		ObstacleGenerator.squareObstacle(2, 2, btns, tiles);
		String actual = tiles[3][1].getName();
		String expected = "O";
		assertEquals(expected, actual);
	}

	/**
	 * Tests verticalObstacle method to ensure top block is being set to an obstacle
	 */
	@Test
	public void testVerticalObstacleTopBlock() {
		// Creates Tiles
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				tiles[i][j] = new Tile(i, j, "-");
			}
		}

		ObstacleGenerator.verticalObstacle(2, 2, btns, tiles);
		String actual = tiles[2][2].getName();
		String expected = "O";
		assertEquals(expected, actual);
	}

	/**
	 * Tests verticalObstacle method to ensure bottom block is being set to an
	 * obstacle
	 */
	@Test
	public void testVerticalObstacleBottomBlock() {
		// Creates Tiles
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				tiles[i][j] = new Tile(i, j, "-");
			}
		}

		ObstacleGenerator.verticalObstacle(2, 2, btns, tiles);
		String actual = tiles[2][1].getName();
		String expected = "O";
		assertEquals(expected, actual);
	}

	/**
	 * Tests horizontalObstacle method to ensure left block is being set to an
	 * obstacle
	 */
	@Test
	public void testHorizontalLeftBlock() {
		// Creates Tiles
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				tiles[i][j] = new Tile(i, j, "-");
			}
		}

		ObstacleGenerator.horizontalObstacle(2, 2, btns, tiles);
		String actual = tiles[2][2].getName();
		String expected = "O";
		assertEquals(expected, actual);
	}

	/**
	 * Tests horizontalObstacle method to ensure right block is being set to an
	 * obstacle
	 */
	@Test
	public void testHorizontalRightBlock() {
		// Creates Tiles
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				tiles[i][j] = new Tile(i, j, "-");
			}
		}

		ObstacleGenerator.horizontalObstacle(2, 2, btns, tiles);
		String actual = tiles[3][2].getName();
		String expected = "O";
		assertEquals(expected, actual);
	}

	/**
	 * Tests validObstacleLoc when the location passed in is valid
	 */
	@Test
	public void testValidObstacleLocLocIsValid() {
		// Creates Tiles
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				tiles[i][j] = new Tile(i, j, "-");
			}
		}

		ObstacleGenerator.horizontalObstacle(2, 2, btns, tiles);
		assertTrue(ObstacleGenerator.validObstacleLoc(5, 5, tiles));
	}

	/**
	 * Tests validObstacleLoc when the location passed in is not valid
	 */
	@Test
	public void testValidObstacleLocLocIsNotValid() {
		// Creates Tiles
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				tiles[i][j] = new Tile(i, j, "-");
			}
		}

		ObstacleGenerator.horizontalObstacle(2, 2, btns, tiles);
		assertTrue(!ObstacleGenerator.validObstacleLoc(2, 2, tiles));
	}

}
