/**
 * Definition for class to create and store customers.
 * 
 * @authors Khalid Ahmed, Lana Berge, Ian Flickinger
 * Assignment: Final Project
 * Due Date: December 10, 2019
 * Class: CSCI 2082.01
 */

public class Customer {
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private double balance;
	private boolean isAdmin;
	private TicketList customerTickets;
	
	/**
	 * @description: Construct a Customer with first name, last name, phone number, and balance.
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 * @param balance
	 * @precondition: Instance variables for firstName, lastName, phoneNumber, and balance exist.
	 * @postcondition: Customer has been initialized with specified variables.
	 */
	public Customer(String firstName, String lastName, String phoneNumber, double balance) {
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setBalance(balance);
		customerTickets = new TicketList();
	}
	/**
	 * @description: Get the customer's first name for this Customer.
	 * @precondition: Instance variable firstName exists and has been initialized.
	 * @postcondition: Customer's first name has been accessed.
	 * @returns firstName Customer's first name
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @description: Set the customer's first name for this Customer.
	 * @param firstName Customer's first name
	 * @precondition: No precondition.
	 * @postcondition: Customer's first name has been mutated.
	 * @returns this firstName Customer's first name
	 */
	public Customer setFirstName(String firstName) {
		if(firstName!= null || firstName!= "") {
			this.firstName = firstName;
		}
		return this;
	}
	/**
	 * @description: Get the customer's last name for this Customer.
	 * @precondition: Instance variable lastName exists and has been initialized.
	 * @postcondition: Customer's last name has been accessed.
	 * @returns lastName Customer's last name
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @description: Set the customer's last name for this Customer.	
	 * @param lastName Customer's last name
	 * @precondition: No precondition.
	 * @postcondition: Customer's last name has been mutated.
	 * @returns this lastName Customer's last name
	 */
	public Customer setLastName(String lastName) {
		if(lastName!= null || lastName!= "") {
			this.lastName = lastName;
		}
		return this;
	}
	/**
	 * @description: Get the customer's phone number for this Customer.
	 * @precondition: Instance variable phoneNumber exists and has been initialized.
	 * @postcondition: Customer's phone number has been accessed.
	 * @returns phoneNumber Customer's phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @description: Set the customer's phone number for this Customer.
	 * @param phoneNumber Customer's phoneNumber
	 * @precondition: No precondition.
	 * @postcondition: Customer's phone number has been mutated.
	 * @returns this phoneNumber Customer's phone number
	 */
	public Customer setPhoneNumber(String phoneNumber) {
		if(phoneNumber!= null || phoneNumber!= "") {
			this.phoneNumber = phoneNumber;
			if(phoneNumber.contentEquals("Admin")) {
				setIsAdmin(true);
			}
		}
		return this;
	}
	/**
	 * @description: 
	 * @precondition: Instance variable isAdmin exists and has been initialized.		
	 * @postcondition: 
	 * @returns isAdmin
	 */
	public boolean isAdmin() {
		return isAdmin;
	}
	/**
	 * @description: Set the admin.
	 * @param isAdmin boolean whether it is admin.
	 * @precondition: No precondition.
	 * @postcondition: Admin has been mutated.
	 * @returns this isAdmin 
	 */
	public Customer setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
		return this;
	}
	/**
	 * @description: Get the customer's balance for this Customer.
	 * @precondition: Instance variable balance exists and has been initialized.
	 * @postcondition: Customer's balance has been accessed.
	 * @returns balance Customer's balance
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * @description: Set the customer's balance for this Customer.
	 * @param balance Customer's balance
	 * @precondition: No precondition.
	 * @postcondition: Customer's balance has been mutated.
	 * @returns this balance Customer's balance
	 */
	public Customer setBalance(double balance) {
		if(balance >= 0) {
			this.balance = balance;
		}
		return this;
	}
	/**
	 * @description: Get the customer's tickets for this Customer.
	 * @precondition: Instance variable customerTickets exists and has been initialized.
	 * @postcondition: Customer's tickets has been accessed.
	 * @returns customerTickets Customer's tickets
	 */
	public TicketList getCustomerTickets() {
		return customerTickets;
	}
	/**
	 * @description: Set the customer's tickets for this Customer.
	 * @param customerTickets Customer's tickets
	 * @precondition: No precondition.
	 * @postcondition: Customer's tickets has been mutated.
	 * @returns this customerTickets Customer's tickets
	 */
	public Customer setCustomerTickets(TicketList customerTickets) {
		this.customerTickets = customerTickets;
		return this;
	}
}