package edu.ben.project.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.ben.graphicsPackage.TileAssets;
import edu.ben.project.game.Game;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JLabel;

/**
 * This is the info popUp that is sitting at the bottom right of the game board
 * 
 *
 */
public class InfoPopUp extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField header;
	private JTextArea description;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;

	/**
	 * Create the frame.
	 */
	public InfoPopUp() {

		// info about the content pane
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 500, 330);
		setContentPane(contentPane);

		// info about the window as a whole.
		setVisible(false);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setLayout(null);

		// info about the return to Menu Button
		JButton closePopUpButton = new JButton("Return to game");
		closePopUpButton.setBounds(354, 1, 140, 30);
		closePopUpButton.setBackground(SystemColor.controlHighlight);
		contentPane.add(closePopUpButton);

		// this is what happens when you click the return to menu button
		closePopUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Game.closeInfoButton();
			}
		});

		// info about the header
		header = new JTextField();
		header.setBounds(0, 0, 89, 30);
		header.setBackground(SystemColor.control);
		header.setForeground(Color.BLACK);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setEditable(false);
		header.setFont(new Font("Arial Black", Font.PLAIN, 13));
		header.setText("Info Key");
		header.setColumns(10);

		// add to content pane
		contentPane.add(header);

		// info about the description
		description = new JTextArea();
		description.setText("<- Collect 3 treasure\r\nobjects in each level!");
		description.setBounds(285, 42, 209, 62);
		description.setBackground(SystemColor.control);
		description.setFont(new Font("Arial Black", Font.PLAIN, 13));

		// add to content pane
		contentPane.add(description);

		JLabel chestI = new JLabel("");
		chestI.setBounds(10, 41, 71, 63);
		contentPane.add(chestI);
		chestI.setIcon(new ImageIcon(TileAssets.chest));
		chestI.setPreferredSize(new Dimension(5, 5));

		JLabel coinI = new JLabel("");
		coinI.setPreferredSize(new Dimension(5, 5));
		coinI.setBounds(72, 41, 71, 63);
		contentPane.add(coinI);
		coinI.setIcon(new ImageIcon(TileAssets.coin));
		coinI.setPreferredSize(new Dimension(5, 5));

		JLabel gemI = new JLabel("");
		gemI.setPreferredSize(new Dimension(5, 5));
		gemI.setBounds(133, 41, 71, 63);
		contentPane.add(gemI);
		gemI.setIcon(new ImageIcon(TileAssets.gem));
		gemI.setPreferredSize(new Dimension(5, 5));

		JLabel bagI = new JLabel("");
		bagI.setPreferredSize(new Dimension(5, 5));
		bagI.setBounds(193, 41, 71, 63);
		contentPane.add(bagI);
		bagI.setIcon(new ImageIcon(TileAssets.moneyBag));
		bagI.setPreferredSize(new Dimension(5, 5));

		JLabel boltI = new JLabel("");
		boltI.setPreferredSize(new Dimension(5, 5));
		boltI.setBounds(10, 115, 71, 63);
		contentPane.add(boltI);
		boltI.setIcon(new ImageIcon(TileAssets.bolt));
		boltI.setPreferredSize(new Dimension(5, 5));

		JLabel clockI = new JLabel("");
		clockI.setPreferredSize(new Dimension(5, 5));
		clockI.setBounds(10, 178, 71, 63);
		contentPane.add(clockI);
		clockI.setIcon(new ImageIcon(TileAssets.clock));
		clockI.setPreferredSize(new Dimension(5, 5));

		JLabel keyI = new JLabel("");
		keyI.setPreferredSize(new Dimension(5, 5));
		keyI.setBounds(10, 238, 71, 63);
		contentPane.add(keyI);
		keyI.setIcon(new ImageIcon(TileAssets.key));
		keyI.setPreferredSize(new Dimension(5, 5));

		JTextArea textArea = new JTextArea();
		textArea.setText("<- The Speed Boost increases\r\nthe distance the player can move");
		textArea.setFont(new Font("Arial Black", Font.PLAIN, 13));
		textArea.setBackground(SystemColor.menu);
		textArea.setBounds(133, 116, 351, 62);
		contentPane.add(textArea);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setText("<- The Clock powerup stops the\r\nguards from moving for 3 turns");
		textArea_1.setFont(new Font("Arial Black", Font.PLAIN, 13));
		textArea_1.setBackground(SystemColor.menu);
		textArea_1.setBounds(133, 179, 351, 62);
		contentPane.add(textArea_1);

		JTextArea textArea_2 = new JTextArea();
		textArea_2.setText("<- The Key allows you to use the teleporters\r\nat the top and bottom of the level");
		textArea_2.setFont(new Font("Arial Black", Font.PLAIN, 13));
		textArea_2.setBackground(SystemColor.menu);
		textArea_2.setBounds(133, 239, 351, 62);
		contentPane.add(textArea_2);

	}
}
