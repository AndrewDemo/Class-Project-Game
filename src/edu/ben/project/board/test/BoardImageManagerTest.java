package edu.ben.project.board.test;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import org.junit.Test;
import edu.ben.graphicsPackage.TileAssets;
import edu.ben.project.board.BoardImageManager;
import edu.ben.project.game.Constants;
import student.TestCase;

/**
 * 
 */
public class BoardImageManagerTest extends TestCase {

	@Test
	public void testSetBoardImagesObstacle() {

		// create our image manager
		BoardImageManager boardImageManager = new BoardImageManager();

		// loop through the image manager and set up the base layout.
		for (int i = 0; i < Constants.SIZE; i++) {
			for (int j = 0; j < Constants.SIZE; j++) {
				Constants.btns[i][j] = new JButton();
				boardImageManager.setBaseLayout(i, j);
			}
		}

		Icon actual = Constants.btns[0][0].getIcon();

		Icon expected = new ImageIcon(TileAssets.redBrickFloor);

		assertEquals(expected, actual);

	}

}
