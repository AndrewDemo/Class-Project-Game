package edu.ben.project.characters;

/**
 * Character Interface
 */
public interface Character {

	public void move(int posX, int posY);

	public boolean isValidMove(int posX, int posY);

}
