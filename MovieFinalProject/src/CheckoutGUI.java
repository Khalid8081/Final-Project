import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
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

	public JPanel initialize() {
		
		JPanel panel = new JPanel(new GridBagLayout());
		
		JLabel ticketsLabel = new JLabel("Your Tickets:");
		ticketsLabel.setBackground(Color.WHITE);
		ticketsLabel.setForeground(Color.BLACK);
		ticketsLabel.setFont(new Font("HelveticaNeue", Font.BOLD, 15));
		ImageIcon checkoutIcon = new ImageIcon("movie-data/Checkout_Icon.png");
		ticketsLabel.setIcon(checkoutIcon);
		//Icon made by [https://www.flaticon.com/authors/freepik] from www.flaticon.com
		GridBagConstraints gbc_ticketsLabel = new GridBagConstraints();
		gbc_ticketsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_ticketsLabel.gridx = 0;
		gbc_ticketsLabel.gridy = 0;
		panel.add(ticketsLabel, gbc_ticketsLabel);
		
		ticketTextArea = new JTextArea();
		GridBagConstraints gbc_ticketTextArea = new GridBagConstraints();
		gbc_ticketTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_ticketTextArea.fill = GridBagConstraints.BOTH;
		gbc_ticketTextArea.gridx = 0;
		gbc_ticketTextArea.gridy = 1;
		gbc_ticketTextArea.gridwidth = 11;
		gbc_ticketTextArea.fill = GridBagConstraints.HORIZONTAL;
		ticketTextArea.setEditable(false);
		panel.add(ticketTextArea, gbc_ticketTextArea);
		
		removeTextField = new JTextField();
		GridBagConstraints gbc_removeTextField = new GridBagConstraints();
		gbc_removeTextField.anchor = GridBagConstraints.EAST;
		gbc_removeTextField.insets = new Insets(0, 0, 5, 5);
		gbc_removeTextField.gridx = 2;
		gbc_removeTextField.gridy = 6;
		panel.add(removeTextField, gbc_removeTextField);
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
		panel.add(removeButton, gbc_removeButton);
		
		JLabel subtotalLabel = new JLabel("Subtotal: ");
		subtotalLabel.setBackground(Color.WHITE);
		subtotalLabel.setForeground(Color.BLACK);
		subtotalLabel.setFont(new Font("HelveticaNeue", Font.BOLD, 15));
		GridBagConstraints gbc_subtotalLabel = new GridBagConstraints();
		gbc_subtotalLabel.insets = new Insets(0, 0, 5, 5);
		gbc_subtotalLabel.gridx = 0;
		gbc_subtotalLabel.gridy = 6;
		panel.add(subtotalLabel, gbc_subtotalLabel);
		
		subtotalTextArea = new JTextArea();
		GridBagConstraints gbc_subtotalTextArea = new GridBagConstraints();
		gbc_subtotalTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_subtotalTextArea.fill = GridBagConstraints.BOTH;
		gbc_subtotalTextArea.gridx = 1;
		gbc_subtotalTextArea.gridy = 6;
		panel.add(subtotalTextArea, gbc_subtotalTextArea);
		subtotalTextArea.setColumns(20);
		
		JLabel taxLabel = new JLabel("Tax: ");
		taxLabel.setBackground(Color.WHITE);
		taxLabel.setForeground(Color.BLACK);
		taxLabel.setFont(new Font("HelveticaNeue", Font.BOLD, 15));
		GridBagConstraints gbc_taxLabel = new GridBagConstraints();
		gbc_taxLabel.insets = new Insets(0, 0, 5, 5);
		gbc_taxLabel.gridx = 0;
		gbc_taxLabel.gridy = 7;
		panel.add(taxLabel, gbc_taxLabel);
		
		taxTextArea = new JTextArea();
		GridBagConstraints gbc_taxTextArea = new GridBagConstraints();
		gbc_taxTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_taxTextArea.fill = GridBagConstraints.BOTH;
		gbc_taxTextArea.gridx = 1;
		gbc_taxTextArea.gridy = 7;
		panel.add(taxTextArea, gbc_taxTextArea);
		taxTextArea.setColumns(20);
		
		JLabel totalLabel = new JLabel("Total: ");
		totalLabel.setBackground(Color.WHITE);
		totalLabel.setForeground(Color.BLACK);
		totalLabel.setFont(new Font("HelveticaNeue", Font.BOLD, 15));
		GridBagConstraints gbc_totalLabel = new GridBagConstraints();
		gbc_totalLabel.insets = new Insets(0, 0, 5, 5);
		gbc_totalLabel.gridx = 0;
		gbc_totalLabel.gridy = 8;
		panel.add(totalLabel, gbc_totalLabel);
		
		totalTextArea = new JTextArea();
		GridBagConstraints gbc_totalTextArea = new GridBagConstraints();
		gbc_totalTextArea.insets = new Insets(0, 0, 5, 5);
		gbc_totalTextArea.fill = GridBagConstraints.BOTH;
		gbc_totalTextArea.gridx = 1;
		gbc_totalTextArea.gridy = 8;
		panel.add(totalTextArea, gbc_totalTextArea);
		totalTextArea.setColumns(20);
		
		JButton payButton = new JButton("Pay");
		payButton.setBackground(Color.WHITE);
		payButton.setForeground(Color.BLACK);
		payButton.setFont(new Font("HelveticaNeue", Font.BOLD, 15));
		ImageIcon payIcon = new ImageIcon("movie-data/Pay_Icon.png");
		payButton.setIcon(payIcon);
		//Icon made by [https://www.flaticon.com/authors/freepik] from www.flaticon.com
		payButton.addActionListener(new PayListener());
		GridBagConstraints gbc_payButton = new GridBagConstraints();
		gbc_payButton.insets = new Insets(0, 0, 20, 20);
		gbc_payButton.gridx = 10;
		gbc_payButton.gridy = 9;
		panel.add(payButton, gbc_payButton);
		ticketTextArea.setText(ticketString);
		return panel;
	}
	
	private class RemoveListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			//Needs to be implemented. Something we talked about in class was maybe indexing the user's tickets.
//			String ticketToBeRemoved = removeTextField.getText(); //Does not have to be String
			
			//user enters string
			
			//for loop 
			
			//if(string.equals(
			String targetId=removeTextField.getText();
			if(isNumeric(targetId)==true) {
				int targetIdint= Integer.parseInt(targetId);
				TheaterAppGUI.customer.getCustomerTickets().remove(targetIdint);
				ticketString="";
				TicketNode cursor=TheaterAppGUI.customer.getCustomerTickets().getHead();
				
				while (cursor != null) {
					CheckoutGUI.ticketString += cursor.getTicket().getMovie().getTitle()+" at "+cursor.getTicket().getShowtime().getHours()+":"+cursor.getTicket().getShowtime().getMinutes()+" PM "+" seat: "+cursor.getTicket().getSeat()+" Ticket ID: "+cursor.getTicket().getId()+ "\n";
					cursor = cursor.getNext();
				}
				
				ticketTextArea.setText(ticketString);
				
			}
			else {
				JOptionPane.showMessageDialog(frame, "Not a number! Try again.");
			}
			
			
			
		}
	}
	
	private class PayListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			totalTextArea.setText("");
			subtotalTextArea.setText("");
			double total = 0.0;
			double subtotal = 0.0;
			double taxes = 0.0;
			ImageIcon errorIcon = new ImageIcon("movie-data/Error_Icon.png");
			//Icon made by [https://www.flaticon.com/authors/roundicons] from www.flaticon.com
			ImageIcon alertIcon = new ImageIcon("movie-data/Alert_Icon.png");
			//Icon made by [https://www.flaticon.com/authors/freepik] from www.flaticon.com
			ImageIcon successIcon = new ImageIcon("movie-data/Success_Icon.png");
			//Icon made by [https://www.flaticon.com/authors/roundicons] from www.flaticon.com
		
			if(TheaterAppGUI.customer == null) {
				SignInGUI.NewScreen();
			}
			else if(TheaterAppGUI.customer.getCustomerTickets().getHead()==null) {
				JOptionPane.showMessageDialog(frame, "Your cart is empty!", "Empty Cart", JOptionPane.PLAIN_MESSAGE, errorIcon);
			}
			else { 
				TicketNode cursor = TheaterAppGUI.customer.getCustomerTickets().getHead();
				
				while (cursor != null) {
					subtotal=subtotal+cursor.getTicket().getMovie().getPrice();
					cursor = cursor.getNext();
				}
				
				taxes = subtotal * TAX_RATE;
				total =  subtotal + taxes;
				//The total,subtotal and tax will need to be formatted to look nicer on the gui.
				totalTextArea.setText(""+total);
				subtotalTextArea.setText(""+subtotal);
				taxTextArea.setText(""+taxes);
				
				if(TheaterAppGUI.customer.getBalance()<total) {
					JOptionPane.showMessageDialog(frame, "Your balance is low!"+ ticketString, "Low Balance", JOptionPane.PLAIN_MESSAGE, alertIcon);
				}
				else {
					TheaterAppGUI.customer.setBalance(TheaterAppGUI.customer.getBalance()-total);
					JOptionPane.showMessageDialog(frame, "Tickets were purchased successfully!", "Ticket Success", JOptionPane.PLAIN_MESSAGE, successIcon);
				}
			}
		}
	}
	public static boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
}
