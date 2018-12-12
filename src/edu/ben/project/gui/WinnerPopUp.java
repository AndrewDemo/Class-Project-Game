package edu.ben.project.gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import edu.ben.project.game.Constants;
import edu.ben.project.game.Game;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class WinnerPopUp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel f;

	/**
	 * Create the frame.
	 * 
	 * @throws MalformedURLException
	 */
	public WinnerPopUp() throws MalformedURLException {
		super("Level Passed");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		f = new JPanel();
		f.setLayout(new BorderLayout());
		Icon image = null;
		URL url = null;
		// Icon icon = new ImageIcon(url);
		// JLabel label = new JLabel(icon);
		try {
			url = new URL("https://media.tenor.com/images/8fc1c2fba3274cd9aec5bcaa30d471e0/tenor.gif");
			image = new ImageIcon(url);
		} catch (MalformedURLException ex) {
			System.out.println("Malformed URL");
		}
		JLabel label = new JLabel();
		label.setIcon(image);
		f.add(label, BorderLayout.CENTER);
		this.getContentPane().add(f, BorderLayout.CENTER);
		this.setVisible(true);
		this.setBounds(100, 100, 245, 400);

		this.setSize(235, 400);
		setLocationRelativeTo(null);

		setAlwaysOnTop(true);
		JButton btnNextLevel = new JButton("Next Level");
		btnNextLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.closeWinnerPopUp();
				f.setVisible(false);
				Constants.levelCounter += 1;
				Game.levelLoader(); // Calls the levelLoader() when next level
									// is selected.

			}
		});
		JButton btnExitGame = new JButton("Exit Game");
		btnExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0); // Exits upon pressing the 'Exit Game' button
			}
		});
		btnNextLevel.setBounds(330, 220, 104, 40);
		btnExitGame.setBounds(10, 220, 116, 40);
		getContentPane().add(btnNextLevel, BorderLayout.NORTH);
		getContentPane().add(btnExitGame, BorderLayout.SOUTH);
	}
}
