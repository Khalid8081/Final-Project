import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JPanel;


public class CheckoutGUI {

	private JFrame frame;

	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckoutGUI window = new CheckoutGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CheckoutGUI() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Checkout");
		frame.setBounds(100, 100, 1447, 774);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{173, 79, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 61, 61, 61, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel ticketsLabel = new JLabel("Your Tickets:");
		ticketsLabel.setBackground(Color.WHITE);
		ticketsLabel.setForeground(Color.BLACK);
		ticketsLabel.setFont(new Font("HelveticaNeue", Font.BOLD, 15));
		GridBagConstraints gbc_ticketsLabel = new GridBagConstraints();
		gbc_ticketsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ticketsLabel.gridx = 0;
		gbc_ticketsLabel.gridy = 0;
		frame.getContentPane().add(ticketsLabel, gbc_ticketsLabel);
		
		JLabel ticketLabel = new JLabel("THIS AREA WOULD DISPLAY CUSTOMER'S TICKET INFORMATION");
		GridBagConstraints gbc_ticketLabel = new GridBagConstraints();
		gbc_ticketLabel.anchor = GridBagConstraints.EAST;
		gbc_ticketLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ticketLabel.gridx = 0;
		gbc_ticketLabel.gridy = 1;
		frame.getContentPane().add(ticketLabel, gbc_ticketLabel);
		
		JPanel ticketPanel = new JPanel();
		GridBagConstraints gbc_ticketPanel = new GridBagConstraints();
		gbc_ticketPanel.insets = new Insets(0, 0, 5, 5);
		gbc_ticketPanel.fill = GridBagConstraints.BOTH;
		gbc_ticketPanel.gridx = 1;
		gbc_ticketPanel.gridy = 1;
		frame.getContentPane().add(ticketPanel, gbc_ticketPanel);
		
		JLabel subtotalLabel = new JLabel("Subtotal: ");
		subtotalLabel.setBackground(Color.WHITE);
		subtotalLabel.setForeground(Color.BLACK);
		subtotalLabel.setFont(new Font("HelveticaNeue", Font.BOLD, 15));
		GridBagConstraints gbc_subtotalLabel = new GridBagConstraints();
		gbc_subtotalLabel.insets = new Insets(0, 0, 5, 5);
		gbc_subtotalLabel.gridx = 0;
		gbc_subtotalLabel.gridy = 5;
		frame.getContentPane().add(subtotalLabel, gbc_subtotalLabel);
		
		JTextArea subtotalTextArea = new JTextArea();
		GridBagConstraints gbc_subtotalTextArea = new GridBagConstraints();
		gbc_subtotalTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_subtotalTextArea.fill = GridBagConstraints.BOTH;
		gbc_subtotalTextArea.gridx = 1;
		gbc_subtotalTextArea.gridy = 5;
		frame.getContentPane().add(subtotalTextArea, gbc_subtotalTextArea);
		
		JLabel taxLabel = new JLabel("Tax: ");
		taxLabel.setBackground(Color.WHITE);
		taxLabel.setForeground(Color.BLACK);
		taxLabel.setFont(new Font("HelveticaNeue", Font.BOLD, 15));
		GridBagConstraints gbc_taxLabel = new GridBagConstraints();
		gbc_taxLabel.insets = new Insets(0, 0, 5, 5);
		gbc_taxLabel.gridx = 0;
		gbc_taxLabel.gridy = 6;
		frame.getContentPane().add(taxLabel, gbc_taxLabel);
		
		JTextArea taxTextArea = new JTextArea();
		GridBagConstraints gbc_taxTextArea = new GridBagConstraints();
		gbc_taxTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_taxTextArea.fill = GridBagConstraints.BOTH;
		gbc_taxTextArea.gridx = 1;
		gbc_taxTextArea.gridy = 6;
		frame.getContentPane().add(taxTextArea, gbc_taxTextArea);
		
		JLabel totalLabel = new JLabel("Total: ");
		totalLabel.setBackground(Color.WHITE);
		totalLabel.setForeground(Color.BLACK);
		totalLabel.setFont(new Font("HelveticaNeue", Font.BOLD, 15));
		GridBagConstraints gbc_totalLabel = new GridBagConstraints();
		gbc_totalLabel.insets = new Insets(0, 0, 5, 5);
		gbc_totalLabel.gridx = 0;
		gbc_totalLabel.gridy = 7;
		frame.getContentPane().add(totalLabel, gbc_totalLabel);
		
		JTextArea totalTextArea = new JTextArea();
		GridBagConstraints gbc_totalTextArea = new GridBagConstraints();
		gbc_totalTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_totalTextArea.fill = GridBagConstraints.BOTH;
		gbc_totalTextArea.gridx = 1;
		gbc_totalTextArea.gridy = 7;
		frame.getContentPane().add(totalTextArea, gbc_totalTextArea);
		
		JButton payButton = new JButton("Pay");
		payButton.setBackground(Color.WHITE);
		payButton.setForeground(Color.BLACK);
		payButton.setFont(new Font("HelveticaNeue", Font.BOLD, 15));
		payButton.addActionListener(new PayListener());
		GridBagConstraints gbc_payButton = new GridBagConstraints();
		gbc_payButton.insets = new Insets(0, 0, 20, 20);
		gbc_payButton.gridx = 10;
		gbc_payButton.gridy = 8;
		frame.getContentPane().add(payButton, gbc_payButton);
	}
	
	private class PayListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			SignInGUI newSignInWindow = new SignInGUI(); 	//When Pay button is clicked, pop up that has user sign in/sign up, create object of Customer class
			newSignInWindow.NewScreen();
			//Payment method
			//Need dialog if there is an error (not enough funds in balance)
			//Dialog saying payment successful
		}
	}

}
