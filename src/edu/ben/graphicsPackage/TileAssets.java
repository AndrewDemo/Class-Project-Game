package edu.ben.graphicsPackage;

import java.awt.Image;

/**
 * 
 */
public class TileAssets {

	// size of all our images
	private static final int WIDTH = 64, HEIGHT = 64;

	// the name of all of the images on our sprite sheet
	public static Image exitClosed, floorTileBlue, teleport, cop, robber, obstacle, redBrickFloor, chest, gem, moneyBag,
			coin, validMove, redBrickLineBottom, redBrickLineRight, redBrickLineTop, redBrickLineLeft, clock, bolt, key,
			info, items, counterZero, counterOne, counterTwo, counterThree;

	/**
	 * this is going to load everything into our game.
	 */
	public static void init(String sheetName) {

		// create a new sprite sheet using our image loader.
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage(sheetName));
		// call the crop method from the sprite sheet to crop out a sprite from it.

		// first row
		redBrickLineTop = sheet.crop(0, 0, WIDTH, HEIGHT);
		redBrickLineLeft = sheet.crop(64, 0, WIDTH, HEIGHT);
		chest = sheet.crop(128, 0, WIDTH, HEIGHT);
		bolt = sheet.crop(192, 0, WIDTH, HEIGHT);
		exitClosed = sheet.crop(256, 0, WIDTH, HEIGHT);
		clock = sheet.crop(320, 0, WIDTH, HEIGHT);
		gem = sheet.crop(384, 0, WIDTH, HEIGHT);

		// second row
		validMove = sheet.crop(0, 64, WIDTH, HEIGHT);
		redBrickLineRight = sheet.crop(64, 64, WIDTH, HEIGHT);
		floorTileBlue = sheet.crop(128, 64, WIDTH, HEIGHT);
		teleport = sheet.crop(192, 64, WIDTH, HEIGHT);
		redBrickFloor = sheet.crop(256, 64, WIDTH, HEIGHT);
		obstacle = sheet.crop(320, 64, WIDTH, HEIGHT);
		moneyBag = sheet.crop(384, 64, WIDTH, HEIGHT);

		// row 3
		cop = sheet.crop(0, 128, WIDTH, HEIGHT);
		redBrickLineBottom = sheet.crop(64, 128, WIDTH, HEIGHT);
		robber = sheet.crop(128, 128, WIDTH, HEIGHT);
		coin = sheet.crop(192, 128, WIDTH, HEIGHT);
		key = sheet.crop(256, 128, WIDTH, HEIGHT);
		info = sheet.crop(320, 128, WIDTH, HEIGHT);
		items = sheet.crop(384, 128, WIDTH, HEIGHT);

		// row 4 boys WHOO!
		counterZero = sheet.crop(0, 192, WIDTH, HEIGHT);
		counterOne = sheet.crop(64, 192, WIDTH, HEIGHT);
		counterTwo = sheet.crop(128, 192, WIDTH, HEIGHT);
		counterThree = sheet.crop(192, 192, WIDTH, HEIGHT);
	}
}
