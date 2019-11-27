import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import java.util.Iterator;


public class CheckoutGUI {

	private JFrame frame;
	public static final double TAX_RATE = .08;
	public JTextArea totalTextArea;
	public JTextArea taxTextArea;
	public JTextArea subtotalTextArea;
	public JTextArea ticketTextArea;
	public static String ticketString=""; //Will be used for the ticket textArea //Look at TheaterAppGUI's checkout listener for more
	private JTextField removeTextField;

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
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 61, 61, 61, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		ticketTextArea = new JTextArea();
		GridBagConstraints gbc_ticketTextArea = new GridBagConstraints();
		gbc_ticketTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_ticketTextArea.fill = GridBagConstraints.BOTH;
		gbc_ticketTextArea.gridx = 0;
		gbc_ticketTextArea.gridy = 1;
		gbc_ticketTextArea.gridwidth = 11;
		gbc_ticketTextArea.fill = GridBagConstraints.HORIZONTAL;
		ticketTextArea.setEditable(false);
		frame.getContentPane().add(ticketTextArea, gbc_ticketTextArea);
		
//		JLabel ticketLabel = new JLabel("");							//Not sure what this widget is so I commented it out for now
//		GridBagConstraints gbc_ticketLabel = new GridBagConstraints();
//		gbc_ticketLabel.anchor = GridBagConstraints.EAST;
//		gbc_ticketLabel.insets = new Insets(0, 0, 5, 5);
//		gbc_ticketLabel.gridx = 0;
//		gbc_ticketLabel.gridy = 2;
//		frame.getContentPane().add(ticketLabel, gbc_ticketLabel);
		
//		JPanel ticketPanel = new JPanel();
//		GridBagConstraints gbc_ticketPanel = new GridBagConstraints();		
//		gbc_ticketPanel.insets = new Insets(0, 0, 5, 5);
//		gbc_ticketPanel.fill = GridBagConstraints.BOTH;
//		gbc_ticketPanel.gridx = 1;
//		gbc_ticketPanel.gridy = 2;
//		frame.getContentPane().add(ticketPanel, gbc_ticketPanel);
		
		removeTextField = new JTextField();
		GridBagConstraints gbc_removeTextField = new GridBagConstraints();
		gbc_removeTextField.anchor = GridBagConstraints.EAST;
		gbc_removeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_removeTextField.gridx = 2;
		gbc_removeTextField.gridy = 6;
		frame.getContentPane().add(removeTextField, gbc_removeTextField);
		removeTextField.setColumns(20);

		JButton removeButton = new JButton("Remove ticket");
		removeButton.setBackground(Color.WHITE);
		removeButton.setFont(new Font("HelveticaNeue", Font.BOLD, 18));
		removeButton.setForeground(Color.BLACK);
		GridBagConstraints gbc_removeButton = new GridBagConstraints();
		gbc_removeButton.anchor = GridBagConstraints.WEST;
		gbc_removeButton.insets = new Insets(0, 0, 5, 5);
		gbc_removeButton.gridx = 3;
		gbc_removeButton.gridy = 6;
		removeButton.addActionListener(new RemoveListener()); 	//RemoveListener() not get implemented
		frame.getContentPane().add(removeButton, gbc_removeButton);
		
		JLabel subtotalLabel = new JLabel("Subtotal: ");
		subtotalLabel.setBackground(Color.WHITE);
		subtotalLabel.setForeground(Color.BLACK);
		subtotalLabel.setFont(new Font("HelveticaNeue", Font.BOLD, 15));
		GridBagConstraints gbc_subtotalLabel = new GridBagConstraints();
		gbc_subtotalLabel.insets = new Insets(0, 0, 5, 5);
		gbc_subtotalLabel.gridx = 0;
		gbc_subtotalLabel.gridy = 6;
		frame.getContentPane().add(subtotalLabel, gbc_subtotalLabel);
		
		subtotalTextArea = new JTextArea();
		GridBagConstraints gbc_subtotalTextArea = new GridBagConstraints();
		gbc_subtotalTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_subtotalTextArea.fill = GridBagConstraints.BOTH;
		gbc_subtotalTextArea.gridx = 1;
		gbc_subtotalTextArea.gridy = 6;
		frame.getContentPane().add(subtotalTextArea, gbc_subtotalTextArea);
		
		JLabel taxLabel = new JLabel("Tax: ");
		taxLabel.setBackground(Color.WHITE);
		taxLabel.setForeground(Color.BLACK);
		taxLabel.setFont(new Font("HelveticaNeue", Font.BOLD, 15));
		GridBagConstraints gbc_taxLabel = new GridBagConstraints();
		gbc_taxLabel.insets = new Insets(0, 0, 5, 5);
		gbc_taxLabel.gridx = 0;
		gbc_taxLabel.gridy = 7;
		frame.getContentPane().add(taxLabel, gbc_taxLabel);
		
		taxTextArea = new JTextArea();
		GridBagConstraints gbc_taxTextArea = new GridBagConstraints();
		gbc_taxTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_taxTextArea.fill = GridBagConstraints.BOTH;
		gbc_taxTextArea.gridx = 1;
		gbc_taxTextArea.gridy = 7;
		frame.getContentPane().add(taxTextArea, gbc_taxTextArea);
		
		JLabel totalLabel = new JLabel("Total: ");
		totalLabel.setBackground(Color.WHITE);
		totalLabel.setForeground(Color.BLACK);
		totalLabel.setFont(new Font("HelveticaNeue", Font.BOLD, 15));
		GridBagConstraints gbc_totalLabel = new GridBagConstraints();
		gbc_totalLabel.insets = new Insets(0, 0, 5, 5);
		gbc_totalLabel.gridx = 0;
		gbc_totalLabel.gridy = 8;
		frame.getContentPane().add(totalLabel, gbc_totalLabel);
		
		totalTextArea = new JTextArea();
		GridBagConstraints gbc_totalTextArea = new GridBagConstraints();
		gbc_totalTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_totalTextArea.fill = GridBagConstraints.BOTH;
		gbc_totalTextArea.gridx = 1;
		gbc_totalTextArea.gridy = 8;
		frame.getContentPane().add(totalTextArea, gbc_totalTextArea);
		
		JButton payButton = new JButton("Pay");
		payButton.setBackground(Color.WHITE);
		payButton.setForeground(Color.BLACK);
		payButton.setFont(new Font("HelveticaNeue", Font.BOLD, 15));
		payButton.addActionListener(new PayListener());
		GridBagConstraints gbc_payButton = new GridBagConstraints();
		gbc_payButton.insets = new Insets(0, 0, 20, 20);
		gbc_payButton.gridx = 10;
		gbc_payButton.gridy = 9;
		frame.getContentPane().add(payButton, gbc_payButton);
		 
		ticketTextArea.setText(ticketString);
	}
	
	private class RemoveListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			//Needs to be implemented. Something we talked about in class was maybe indexing the user's tickets.
			String ticketToBeRemoved = removeTextField.getText(); //Does not have to be String
			
		}
	}
	
	private class PayListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			//To clear the text Areas
			totalTextArea.setText("");
			subtotalTextArea.setText("");
			double total=0.0;
			double subtotal=0.0;
			double taxes=0.0;
			
			//ticketTextArea
			if(MovieGUI.accountCreated==false) {
				SignInGUI newSignUpWindow = new SignInGUI();
				newSignUpWindow.NewScreen();
				MovieGUI.accountCreated=true;
			}
			else if(TheaterAppGUI.customer.getCustomerTickets().isEmpty()) {
				JOptionPane.showMessageDialog(frame, "Cart is empty!");
			}
			else {
				Iterator<Ticket> iterator= (Iterator)TheaterAppGUI.customer.getCustomerTickets().iterator();
				while(iterator.hasNext()){
					subtotal=subtotal+iterator.next().getPrice();
				}
				
				taxes = subtotal*TAX_RATE;
				total =  subtotal+taxes;
				//The total,subtotal and tax will need to be formatted to look nicer on the gui.
				totalTextArea.setText(""+total);
				subtotalTextArea.setText(""+subtotal);
				taxTextArea.setText(""+taxes);
				
				if(TheaterAppGUI.customer.getBalance()<total) {
					JOptionPane.showMessageDialog(frame, "Balance is low!"+ ticketString);
					
				}
				else {
					TheaterAppGUI.customer.setBalance(TheaterAppGUI.customer.getBalance()-total);
					JOptionPane.showMessageDialog(frame, "Purchased successful!");
				}
				
			}

		}
	}

}
