package edu.ben.project.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import edu.ben.project.game.Constants;
import edu.ben.project.game.Game;

public class LoserPopUp extends JFrame {

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
	public LoserPopUp() throws MalformedURLException {
		super("Level Failed");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());
		f = new JPanel();
		f.setLayout(new BorderLayout());
		Icon image = null;
		URL url = null;
		// Icon icon = new ImageIcon(url);
		// JLabel label = new JLabel(icon);
		try {
			url = new URL("https://media.tenor.com/images/54cfb760a96b8139cd8b6134acc73050/tenor.gif");
			image = new ImageIcon(url);
		} catch (MalformedURLException ex) {
			System.out.println("Malformed URL");
		}
		JLabel label = new JLabel();
		label.setIcon(image);
		f.add(label, BorderLayout.CENTER);
		this.getContentPane().add(f, BorderLayout.CENTER);
		this.setVisible(true);
		this.setBounds(100, 100, 240, 400);

		this.setSize(235, 370);
		setLocationRelativeTo(null);

		setAlwaysOnTop(true);

		JButton btnRestartLevel = new JButton("Restart Level");
		btnRestartLevel.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRestartLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game.closeLoserPopUp();
				dispose();
				f.setVisible(false);
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
		btnRestartLevel.setBounds(3330, 220, 104, 40);
		btnExitGame.setBounds(10, 220, 116, 40);
		getContentPane().add(btnRestartLevel, BorderLayout.NORTH);
		getContentPane().add(btnExitGame, BorderLayout.SOUTH);
	}

}
