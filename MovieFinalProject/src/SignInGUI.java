import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;


import javax.swing.JButton;

public class SignInGUI {

	private JFrame frame;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField phoneNumberTextField;

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
		frame.setTitle("Sign In/Sign Up");
		frame.setBounds(100, 100, 400, 300);
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
		GridBagConstraints gbc_signInLabel = new GridBagConstraints();
		gbc_signInLabel.insets = new Insets(0, 0, 35, 5);
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
		gbc_firstNameLabel.gridy = 3;
		frame.getContentPane().add(firstNameLabel, gbc_firstNameLabel);
		
		firstNameTextField = new JTextField();
		GridBagConstraints gbc_firstNameTextField = new GridBagConstraints();
		gbc_firstNameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_firstNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_firstNameTextField.gridx = 1;
		gbc_firstNameTextField.gridy = 3;
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
		gbc_lastNameLabel.gridy = 4;
		frame.getContentPane().add(lastNameLabel, gbc_lastNameLabel);
		
		lastNameTextField = new JTextField();
		GridBagConstraints gbc_lastNameTextField = new GridBagConstraints();
		gbc_lastNameTextField.insets = new Insets(0, 0, 5, 5);
		gbc_lastNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_lastNameTextField.gridx = 1;
		gbc_lastNameTextField.gridy = 4;
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
		gbc_phoneNumberLabel.gridy = 5;
		frame.getContentPane().add(phoneNumberLabel, gbc_phoneNumberLabel);
		
		phoneNumberTextField = new JTextField();
		GridBagConstraints gbc_phoneNumberTextField = new GridBagConstraints();
		gbc_phoneNumberTextField.insets = new Insets(0, 0, 5, 5);
		gbc_phoneNumberTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_phoneNumberTextField.gridx = 1;
		gbc_phoneNumberTextField.gridy = 5;
		frame.getContentPane().add(phoneNumberTextField, gbc_phoneNumberTextField);
		phoneNumberTextField.setColumns(10);
		
		JButton enterButton = new JButton("Enter");
		enterButton.setBackground(Color.WHITE);
		enterButton.setFont(new Font("HelveticaNeue", Font.BOLD, 18));
		enterButton.setForeground(Color.BLACK);
		GridBagConstraints gbc_enterButton = new GridBagConstraints();
		gbc_enterButton.gridx = 2;
		gbc_enterButton.gridy = 6;
		enterButton.addActionListener(new SignInListener());
		frame.getContentPane().add(enterButton, gbc_enterButton);
		
	}
	
	private class SignInListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			String firstName = firstNameTextField.getText();
			String lastName = lastNameTextField.getText();
			String phoneNumber = phoneNumberTextField.getText();
			//Here would we first search to see if Customer already exists in system? and if they don't, we create new Customer object?
			Customer customer = new Customer(firstName, lastName, phoneNumber, 0); //I just put 0 for balance for now
			
		}
	}


}
