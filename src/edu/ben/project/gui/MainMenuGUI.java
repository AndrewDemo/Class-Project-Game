package edu.ben.project.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.ben.project.game.Game;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;

/**
 * Main Menu GUI
 * 
 */
public class MainMenuGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCopsAndRobbers;

	/**
	 * Create the frame.
	 */
	public MainMenuGUI() {

		// Info about the contentPane
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 500, 330);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Info about the GUI itself
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// info about the start button
		JButton startGameButton = new JButton("Start Game");
		startGameButton.setForeground(new Color(0, 0, 0));
		startGameButton.setBackground(SystemColor.controlHighlight);
		startGameButton.setBounds(190, 120, 120, 30);
		contentPane.add(startGameButton);

		// when we press start we go to level 1
		startGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Game.loadGameFromMenu();
			}
		});

		// info about the options button
		JButton infoButton = new JButton("Info");
		infoButton.setBackground(SystemColor.controlHighlight);
		infoButton.setBounds(190, 160, 120, 30);
		contentPane.add(infoButton);

		// when we press the option button something will happen ( we need to figure
		// this out)
		infoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Game.optionPanel();
			}
		});

		// info about the exit button
		JButton exitGameButton = new JButton("Exit Game");
		exitGameButton.setBackground(SystemColor.controlHighlight);
		exitGameButton.setBounds(190, 200, 120, 30);
		contentPane.add(exitGameButton);

		// when we press the exit button, we leave the game.
		exitGameButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				System.exit(0);
			}
		});

		// title menu "Cops and Robbers"
		txtCopsAndRobbers = new JTextField();
		txtCopsAndRobbers.setBackground(SystemColor.controlHighlight);
		txtCopsAndRobbers.setFont(new Font("Arial Black", Font.BOLD, 20));
		txtCopsAndRobbers.setBounds(130, 30, 240, 50);
		txtCopsAndRobbers.setHorizontalAlignment(SwingConstants.CENTER);
		txtCopsAndRobbers.setText("Cops and Robbers");
		txtCopsAndRobbers.setEditable(false);
		txtCopsAndRobbers.setColumns(11);
		contentPane.add(txtCopsAndRobbers);

		// background image info
		JLabel menuBackground = new JLabel("");
		// MenuBackground.setIcon(new ImageIcon(
		menuBackground.setIcon(new ImageIcon("res/cops and robbers.jpg"));
		menuBackground.setBackground(SystemColor.text);
		menuBackground.setBounds(0, 0, 500, 330);
		contentPane.add(menuBackground);
	}
}