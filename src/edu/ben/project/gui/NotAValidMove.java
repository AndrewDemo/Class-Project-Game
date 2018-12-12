package edu.ben.project.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Window.Type;
import java.awt.Font;

public class NotAValidMove extends JFrame {

	private JPanel contentPane;
	private JTextField txtNotAValid;

	/**
	 * Create the frame.
	 */
	public NotAValidMove() {
		setResizable(false);
		setType(Type.UTILITY);
		setUndecorated(true);

		setBackground(new Color(0, 255, 0, 0));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 675, 160, 30);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 0, 0));
		contentPane.setBackground(new Color(245, 245, 220));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		txtNotAValid = new JTextField();
		txtNotAValid.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtNotAValid.setBackground(new Color(0, 0, 0));
		txtNotAValid.setForeground(new Color(255, 0, 0));
		txtNotAValid.setEditable(false);
		txtNotAValid.setHorizontalAlignment(SwingConstants.CENTER);
		txtNotAValid.setText("Not A Valid Move");
		contentPane.add(txtNotAValid, BorderLayout.CENTER);
		txtNotAValid.setColumns(10);
		setLocationRelativeTo(null);
	}

}
