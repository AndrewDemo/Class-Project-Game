package edu.ben.project.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.ben.project.game.Constants;
import edu.ben.project.game.Game;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

/**
 * This is the popup window after completing the final level
 */
public class WinnerPopUpLastLevel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtYouWin;

	/**
	 * Create the frame.
	 */
	public WinnerPopUpLastLevel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtYouWin = new JTextField();
		txtYouWin.setHorizontalAlignment(SwingConstants.CENTER);
		txtYouWin.setBounds(10, 72, 424, 52);
		txtYouWin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtYouWin.setText("Congratulations!\r\nYou completed Cops and Robbers!");
		contentPane.add(txtYouWin);
		txtYouWin.setColumns(10);
		txtYouWin.setEditable(false);

		JButton btnNextLevel = new JButton("Play Again?");
		btnNextLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.winnerPopUpLastPlayAgain();
			}
		});
		btnNextLevel.setBounds(319, 220, 115, 40);
		contentPane.add(btnNextLevel);

		JButton btnExitGame = new JButton("Exit Game");
		btnExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0); // Exits upon pressing the 'Exit Game' button
			}
		});
		btnExitGame.setBounds(10, 220, 115, 40);
		contentPane.add(btnExitGame);

		JButton buttonMainMenu = new JButton("Main Menu");
		buttonMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.winnerPopUpLastMainMenu();
			}
		});
		buttonMainMenu.setBounds(164, 220, 115, 40);
		contentPane.add(buttonMainMenu);

		JLabel backgroundLabel = new JLabel("");
		backgroundLabel.setBounds(-39, 0, 498, 271);
		contentPane.add(backgroundLabel);
		backgroundLabel.setIcon(new ImageIcon("res/green.png"));
	}
}