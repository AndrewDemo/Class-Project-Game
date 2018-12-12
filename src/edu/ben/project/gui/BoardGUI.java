package edu.ben.project.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.ben.project.game.Constants;
import edu.ben.project.game.Game;
import edu.ben.project.game.PlayerInputButtonListener;
import java.awt.event.ActionEvent;

/**
 * GUI class for Cops and Robbers board
 * 
 *
 */
public class BoardGUI extends JFrame {

	/**
	 * Adds default serial ID
	 */
	private static final long serialVersionUID = 1L;
	private int size = Constants.SIZE;
	private JPanel contentPane;

	/**
	 * Creates the frame.
	 */
	public BoardGUI() {

		// make a new game object
		Game game = new Game();

		// make a new content pane object
		contentPane = new JPanel();

		// characteristics of the GUI itself.
		setBounds(100, 100, 450, 300);
		setTitle("Cops and Robbers");
		setSize(1080, 1080);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		getContentPane().setLayout(null);

		// 3rd parameter creates space below the button grid
		contentPane.setBorder(new EmptyBorder(0, 0, 75, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(new GridLayout(size, size));

		final JButton[][] btns = Constants.btns; // Gets the btns from the
													// Constants class

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				btns[i][j] = new JButton("");
				btns[i][j].setPreferredSize(new Dimension(5, 5));
				// Creates a new Listener for each button in the game
				ActionListener actionListener = new PlayerInputButtonListener(game, i, j);
				btns[i][j].addActionListener(actionListener);
				getContentPane().add(btns[i][j]);
			}
		}

	}
}