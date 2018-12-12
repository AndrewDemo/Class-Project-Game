package edu.ben.project.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.ben.project.game.Game;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

/**
 * 
 *
 */
public class OptionsGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField header;
	private JTextArea description;

	/**
	 * Create the frame.
	 */
	public OptionsGUI() {

		// info about the content pane
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 500, 330);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// info about the window as a whole.
		setVisible(false);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// info about the return to Menu Button
		JButton returnToMenuButton = new JButton("Return to Menu");
		returnToMenuButton.setBackground(SystemColor.controlHighlight);
		returnToMenuButton.setBounds(193, 230, 120, 30);
		contentPane.add(returnToMenuButton);

		// this is what happens when you click the return to menu button
		returnToMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Game.returnToMain();
			}
		});

		// info about the header
		header = new JTextField();
		header.setBackground(SystemColor.control);
		header.setForeground(Color.BLACK);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setEditable(false);
		header.setFont(new Font("Arial Black", Font.PLAIN, 13));
		header.setText("Welcome to Cops and Robbers!\r\n");
		header.setBounds(0, 0, 494, 62);
		header.setColumns(10);

		// add to content pane
		contentPane.add(header);

		// info about the description
		description = new JTextArea();
		description.setBackground(SystemColor.control);
		description.setFont(new Font("Arial Black", Font.PLAIN, 13));
		description.setText(
				"        \r\n       What is the goal of this game?\r\n\r\n      - Collect the 3 treasures in each level\r\n      - Reach the exit\r\n      - Avoid being caught by the guards!\r\n");
		description.setBounds(0, 62, 494, 170);

		// add to content pane
		contentPane.add(description);

	}
}
