package edu.ben.graphicsPackage;

import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * 
 */
public class SpriteSheet {

	private BufferedImage spriteSheet;

	/**
	 * this is our constructor
	 * 
	 * @param we
	 *            pass in the sheet the sheet image that we made.
	 */
	public SpriteSheet(BufferedImage spriteSheet) {
		this.spriteSheet = spriteSheet;
	}

	/**
	 * this returns an image from out sprite sheet by cropping out part of it.
	 * 
	 * @param x
	 *            the x coordinate
	 * @param y
	 *            the y coordinate
	 * @param width
	 *            width <----> (pixels)
	 * @param height
	 *            height ^ (pixels)
	 * @return
	 */
	public Image crop(int x, int y, int width, int height) {

		// hello

		return spriteSheet.getSubimage(x, y, width, height);
	}
}
