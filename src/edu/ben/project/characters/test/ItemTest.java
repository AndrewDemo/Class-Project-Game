package edu.ben.project.characters.test;

import org.junit.Test;

import edu.ben.project.board.Tile;
import edu.ben.project.characters.Item;
import edu.ben.project.game.Constants;
import student.TestCase;

/**
 * 
 */
public class ItemTest extends TestCase {

	@Test
	public void testGeneratePowerUpType() {

		Item item = new Item(4, 4, "objective");

		item.generatePowerUpType(1);

		Tile actual = Constants.tiles[1][1];

	}

	@Test
	public void test2() {

	}

	@Test
	public void test3() {

	}

	@Test
	public void test4() {

	}

}
