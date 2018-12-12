package edu.ben.project.game;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import edu.ben.graphicsPackage.TileAssets;
import edu.ben.project.board.Board;
import edu.ben.project.board.BoardImageManager;
import edu.ben.project.board.ItemGenerator;
import edu.ben.project.board.LevelVariations;
import edu.ben.project.board.ObstacleGenerator;
import edu.ben.project.characters.Guard;
import edu.ben.project.characters.Player;
import edu.ben.project.gui.BoardGUI;
import edu.ben.project.gui.InfoPopUp;
import edu.ben.project.gui.MainMenuGUI;
import edu.ben.project.gui.OptionsGUI;
import edu.ben.project.levelOneUseCase.LevelOneUseCase;

/**
 * Game class is the controller for the game
 * 
 *
 */
public class Game {

	private static Board board = new Board();
	private static BoardImageManager boardImageManager = new BoardImageManager();

	// Creates new class variables for the different frames
	private static MainMenuGUI menuFrame;
	private static OptionsGUI optionsFrame = new OptionsGUI();
	private static BoardGUI frame;

	/**
	 * Instantiates and launches the main menu GUI
	 */
	public static void main(String[] args) {
		Game game = new Game();
		game.launchMainMenu();
	}

	/**
	 * Public constructor for game class. Instantiates a new Board and
	 * BoardImageManager class.
	 */
	public Game() {
		board = new Board();
		boardImageManager = new BoardImageManager();
	}

	/**
	 * This launches the main menu therefore starting the entire game.
	 */
	public void launchMainMenu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuFrame = new MainMenuGUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * returns to main menu and closes options.
	 */
	public static void returnToMain() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					optionsFrame.setVisible(false);
					optionsFrame.setLocationRelativeTo(null);
					menuFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	/**
	 * Launched the option menu.
	 */
	public static void optionPanel() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuFrame.setVisible(false);
					optionsFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Closes the loser pop up
	 */
	public static void closeLoserPopUp() {
		Constants.loserFrame.setVisible(false);
	}

	/**
	 * Closes the winner pop up
	 */
	public static void closeWinnerPopUp() {
		Constants.winnerFrame.setVisible(false);
	}

	/**
	 * This is called when the player hits 'Play Again' from the last level winner
	 * pop up.
	 */
	public static void winnerPopUpLastPlayAgain() {
		Constants.levelCounter = 0;
		Constants.winnerFrameF.setVisible(false);
		Game.levelLoader();
	}

	/**
	 * Called when the player hits the 'Main Menu' button from the last winner pop
	 * up window
	 */
	public static void winnerPopUpLastMainMenu() {
		Constants.levelCounter = 0;
		Constants.winnerFrameF.setVisible(false);
		frame.setVisible(false);
		Game.main(null);
	}

	/**
	 * Decides which level to load, called from WinnerPopUp class upon next level
	 * push. This keeps the WinnerPopUp class from having to decide which level to
	 * load.
	 */
	public static void levelLoader() {
		if (Constants.levelCounter == 0) {
			level1();
		} else if (Constants.levelCounter == 1) {
			level2();
		} else if (Constants.levelCounter == 2) {
			level3();
		}

		return;
	}

	/**
	 * Sets Menu to not visible and launches the first level board
	 */
	public static void loadGameFromMenu() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menuFrame.setVisible(false);
					frame = new BoardGUI();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Sets first level board to not visible and launches the first level board
	 */
	public static void level1() {
		// Resets player hasKey variable so they cannot use previous keys
		Player.setHasKey(false);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(false);
					frame = new BoardGUI();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Sets first level board to not visible and launches the second level board
	 */
	public static void level2() {
		// Resets player hasKey variable so they cannot use previous keys
		Player.setHasKey(false);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(false);
					frame = new BoardGUI();
					// Adds teleporters to the board
					LevelVariations.addTeleporters();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Sets third level board to not be visible and launches the third level board
	 */
	public static void level3() {
		// Resets player hasKey variable so they cannot use previous keys
		Player.setHasKey(false);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(false);
					frame = new BoardGUI();
					// Adds teleporters to the board
					LevelVariations.addTeleporters();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 
	 * @param posX
	 *            the X position of our tile
	 * @param posY
	 *            the Y position of our tile
	 */
	public static void loadLevel(int posX, int posY) {
		Constants.objectiveCounter = 0;

		Constants.items.clear();

		// set the base layout for the level (floor + outer obstacles)
		boardImageManager.setBaseLayout(posX, posY);

		// After setting the last tile image, sets exit and obstacle tiles (AKA
		// once we
		// reach the last tile in the array).
		if (posX == Constants.SIZE - 1 && posY == Constants.SIZE - 1) {

			// generate the exit
			board.generateExitTile((int) (15 * Math.random() + 1), Constants.SIZE - 2);
			boardImageManager.setExitImage(board.getExit());

			// set the obstacles inside the board.
			ObstacleGenerator.generateObstacles();

			// generate the player
			board.generatePlayerTile(Constants.SIZE / 2, 1);
			boardImageManager.setPlayerImage(board.getPlayer().getPlayerTile());

			// display the valid moves of the player
			boardImageManager.displayValidMoves();

			// set the guards
			// Number of guards currently set to the level number + 2
			int numOfGuards = Constants.levelCounter + 2;
			board.generateGuards(numOfGuards);
			boardImageManager.setGuardImages(board.getGuardList());

			// Sets the patrol guard
			board.generatePatrolGuard(Constants.SIZE - 2, Constants.SIZE - 2);
			boardImageManager.setPatrolGuardImage(board.getPatrolGuard().getPatrolGuardTile());

			// Generates Items
			ItemGenerator.generateItems();

			// Generates the info buttons on the screen
			generateInfoButton();
			generateCounterButtons();
		}
	}

	/**
	 * Updates board images and player location in board class when the player moves
	 * 
	 * @param posX
	 *            x coordinate the player moved to
	 * @param posY
	 *            y coordinate the player moved to
	 */
	public static void movePlayer(int posX, int posY) {

		// erase the valid moves from the screen.
		boardImageManager.eraseValidMoves();

		// update the player
		board.playerMove(posX, posY);
		boardImageManager.playerMoved(board.getPlayer());

		// check if player won
		LevelOneUseCase check = new LevelOneUseCase();
		check.playerWin(board, frame);

		// Check if player should teleport
		if (!Player.justTeleported) {
			check.onTeleporter(posX, posY);
		}

		// Resets justTeleported boolean in player class
		Player.justTeleported = false;

		// if the guards are not frozen they move.
		if (Constants.guardFrozenCounter == 0) {
			// update the guards
			ArrayList<Guard> guardList = board.getGuardList();
			board.updateEnemies(board.getPlayer().getPlayerTile().getX(), board.getPlayer().getPlayerTile().getY());
			boardImageManager.guardsMoved(guardList, board.getPlayer());
			boardImageManager.patrolGuardMoved(board.getPatrolGuard().getPatrolGuardTile().getX(),
					board.getPatrolGuard().getPatrolGuardTile().getY());
		}

		// Otherwise they don't move and we tick the counter down.
		else {
			Constants.guardFrozenCounter--;
		}

		// update player valid moves
		boardImageManager.displayValidMoves();

		check.playerLose(board, frame);

	}

	/**
	 * Returns the player tile
	 * 
	 * @return the player tile.
	 */
	public static Player getPlayer() {
		return board.getPlayer();
	}

	/**
	 * Generates the info button at the bottom right of the game board
	 */
	public static void generateInfoButton() {
		// Constants.tiles[Constants.SIZE - 1][Constants.SIZE - 1].setName("Info");
		Constants.btns[Constants.SIZE - 1][Constants.SIZE - 1].setIcon(new ImageIcon(TileAssets.info));
		ActionListener actionListener = new InfoButtonListener();
		Constants.btns[Constants.SIZE - 1][Constants.SIZE - 1].addActionListener(actionListener);
	}

	/**
	 * Launch the info panel on the board
	 */
	public static void infoPanel() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Constants.infoPopUp = new InfoPopUp();
					Constants.infoPopUp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * This method closes the info pop up window
	 */
	public static void closeInfoButton() {
		Constants.infoPopUp.setVisible(false);
	}

	/**
	 * Generates the counter buttons at the bottom right of the board
	 */
	public static void generateCounterButtons() {
		Constants.btns[Constants.SIZE - 1][0].setIcon(new ImageIcon(TileAssets.items));
		Constants.btns[Constants.SIZE - 1][1].setIcon(new ImageIcon(TileAssets.counterZero));
	}

	/**
	 * Updates the counter button at the bottom left of the board
	 */
	public static void updateCounterButton() {
		if (Constants.objectiveCounter == 0) {
			Constants.btns[Constants.SIZE - 1][1].setIcon(new ImageIcon(TileAssets.counterZero));
		} else if (Constants.objectiveCounter == 1) {
			Constants.btns[Constants.SIZE - 1][1].setIcon(new ImageIcon(TileAssets.counterOne));
		} else if (Constants.objectiveCounter == 2) {
			Constants.btns[Constants.SIZE - 1][1].setIcon(new ImageIcon(TileAssets.counterTwo));
		} else if (Constants.objectiveCounter == 3) {
			Constants.btns[Constants.SIZE - 1][1].setIcon(new ImageIcon(TileAssets.counterThree));
		}
	}

}