package edu.ben.project.game;

import java.util.Stack;

import javax.swing.JButton;
import edu.ben.project.board.Tile;
import edu.ben.project.characters.Item;
import edu.ben.project.gui.BoardGUI;
import edu.ben.project.gui.InfoPopUp;
import edu.ben.project.gui.LoserPopUp;
import edu.ben.project.gui.NotAValidMove;
import edu.ben.project.gui.WinnerPopUp;
import edu.ben.project.gui.WinnerPopUpLastLevel;

/**
 * This class is responsible for holding all constant variables.
 * 
 *
 */
public class Constants {

	// SIZE does not account for the games walls, so SIZE really creates a playable
	// game board of SIZE - 2 x SIZE - 2
	final public static int SIZE = 18;

	// btns is the array of JButtons making up the GUI board
	public static JButton[][] btns = new JButton[SIZE][SIZE];

	// Array of tile objects making up the board
	public static Tile[][] tiles = new Tile[SIZE][SIZE];

	public static Game game;

	// Controls what level the player is on
	public static int levelCounter = 0;

	// Controls the number of treasures the player has gotten
	public static int objectiveCounter = 0;

	public static WinnerPopUp winnerFrame; // 'You Won' popup frame

	public static WinnerPopUpLastLevel winnerFrameF;

	public static LoserPopUp loserFrame; // You've been caught popup frame

	// PopUp frame for the information button
	public static InfoPopUp infoPopUp;

	public static BoardGUI boradGui;

	public static int numOfGuards = 3;

	public static Stack<Item> items = new Stack<Item>();

	public static int guardFrozenCounter = 0;

	public static NotAValidMove notValid = new NotAValidMove();

}
