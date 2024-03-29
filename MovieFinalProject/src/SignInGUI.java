/**
 * Definition for class to build sign in/sign up GUI window.
 * 
 * @authors Khalid Ahmed, Lana Berge, Ian Flickinger
 * Assignment: Final Project
 * Due Date: December 10, 2019
 * Class: CSCI 2082.01
 */

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class SignInGUI {
	private JFrame frame;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField phoneNumberTextField;
	private static final Color NEW_TEAL = new Color(51,135,181);

	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignInGUI window = new SignInGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SignInGUI() {
		initialize();
	} 

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Sign In / Sign Up");
		frame.setBounds(100, 100, 400, 274);
		frame.setBackground(NEW_TEAL);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel signInLabel = new JLabel("Sign In / Sign Up");
		signInLabel.setBackground(Color.WHITE);
		signInLabel.setFont(new Font("HelveticaNeue", Font.BOLD, 18));
		signInLabel.setForeground(Color.BLACK);
		ImageIcon signInIcon = new ImageIcon("movie-data/SignIn_Icon.png");
		signInLabel.setIcon(signInIcon);
		//Icon made by [https://www.flaticon.com/authors/freepik] from www.flaticon.com
		GridBagConstraints gbc_signInLabel = new GridBagConstraints();
		gbc_signInLabel.insets = new Insets(20, 0, 15, 0);
		gbc_signInLabel.gridx = 1;
		gbc_signInLabel.gridy = 0;
		frame.getContentPane().add(signInLabel, gbc_signInLabel);
		
		JLabel firstNameLabel = new JLabel("First Name:");
		firstNameLabel.setBackground(Color.WHITE);
		firstNameLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		firstNameLabel.setForeground(Color.BLACK);
		GridBagConstraints gbc_firstNameLabel = new GridBagConstraints();
		gbc_firstNameLabel.anchor = GridBagConstraints.EAST;
		gbc_firstNameLabel.insets = new Insets(0, 10, 5, 5);
		gbc_firstNameLabel.gridx = 0;
		gbc_firstNameLabel.gridy = 1;
		frame.getContentPane().add(firstNameLabel, gbc_firstNameLabel);
		
		firstNameTextField = new JTextField();
		GridBagConstraints gbc_firstNameTextField = new GridBagConstraints();
		gbc_firstNameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_firstNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstNameTextField.gridx = 1;
		gbc_firstNameTextField.gridy = 1;
		frame.getContentPane().add(firstNameTextField, gbc_firstNameTextField);
		firstNameTextField.setColumns(10);
		
		JLabel lastNameLabel = new JLabel("Last Name:");
		lastNameLabel.setBackground(Color.WHITE);
		lastNameLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		lastNameLabel.setForeground(Color.BLACK);
		GridBagConstraints gbc_lastNameLabel = new GridBagConstraints();
		gbc_lastNameLabel.anchor = GridBagConstraints.EAST;
		gbc_lastNameLabel.insets = new Insets(0, 10, 5, 5);
		gbc_lastNameLabel.gridx = 0;
		gbc_lastNameLabel.gridy = 2;
		frame.getContentPane().add(lastNameLabel, gbc_lastNameLabel);
		
		lastNameTextField = new JTextField();
		GridBagConstraints gbc_lastNameTextField = new GridBagConstraints();
		gbc_lastNameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_lastNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_lastNameTextField.gridx = 1;
		gbc_lastNameTextField.gridy = 2;
		frame.getContentPane().add(lastNameTextField, gbc_lastNameTextField);
		lastNameTextField.setColumns(10);
		 
		JLabel phoneNumberLabel = new JLabel("Phone Number:");
		phoneNumberLabel.setBackground(Color.WHITE);
		phoneNumberLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 15));
		phoneNumberLabel.setForeground(Color.BLACK);
		GridBagConstraints gbc_phoneNumberLabel = new GridBagConstraints();
		gbc_phoneNumberLabel.anchor = GridBagConstraints.EAST;
		gbc_phoneNumberLabel.insets = new Insets(0, 10, 5, 5);
		gbc_phoneNumberLabel.gridx = 0;
		gbc_phoneNumberLabel.gridy = 3;
		frame.getContentPane().add(phoneNumberLabel, gbc_phoneNumberLabel);
		
		phoneNumberTextField = new JTextField();
		GridBagConstraints gbc_phoneNumberTextField = new GridBagConstraints();
		gbc_phoneNumberTextField.insets = new Insets(0, 0, 5, 5);
		gbc_phoneNumberTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_phoneNumberTextField.gridx = 1;
		gbc_phoneNumberTextField.gridy = 3;
		frame.getContentPane().add(phoneNumberTextField, gbc_phoneNumberTextField);
		phoneNumberTextField.setColumns(10);
		
		JButton enterButton = new JButton("Enter");
		enterButton.setBackground(Color.WHITE);
		enterButton.setFont(new Font("HelveticaNeue", Font.BOLD, 18));
		enterButton.setForeground(Color.BLACK);
		GridBagConstraints gbc_enterButton = new GridBagConstraints();
		gbc_enterButton.insets = new Insets(0, 0, 5, 5);
		gbc_enterButton.gridx = 1;
		gbc_enterButton.gridy = 5;
		enterButton.addActionListener(new SignInListener());
		frame.getContentPane().add(enterButton, gbc_enterButton);
	}
	
	private class SignInListener implements ActionListener
	{
		ImageIcon errorIcon = new ImageIcon("movie-data/Error_Icon.png");
		//Icon made by [https://www.flaticon.com/authors/roundicons] from www.flaticon.com
		ImageIcon successIcon = new ImageIcon("movie-data/Success_Icon.png");
		//Icon made by [https://www.flaticon.com/authors/roundicons] from www.flaticon.com
		public void actionPerformed(ActionEvent e) {
			String firstName = firstNameTextField.getText();
			String lastName = lastNameTextField.getText();
			String phoneNumber = phoneNumberTextField.getText();
			if(firstName.isEmpty() == true || lastName.isEmpty() == true || phoneNumber.isEmpty() == true) {
				JOptionPane.showMessageDialog(frame, "Please enter your information.", "Sign In / Sign Up", JOptionPane.PLAIN_MESSAGE, errorIcon);
			} else {
				TheaterAppGUI.customer = new Customer(firstName, lastName, phoneNumber, 1000); 
				frame.dispose();
				JOptionPane.showMessageDialog(frame, "You are now signed in!", "Sign In / Sign Up", JOptionPane.PLAIN_MESSAGE, successIcon);
			}
		}
	}
}
