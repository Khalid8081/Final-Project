import java.util.PriorityQueue;

public class Customer {
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private double balance;
	private boolean isAdmin;
	private TicketList customerTickets;
    
	public Customer(String firstName, String lastName, String phoneNumber, double balance) {
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setBalance(balance);
		customerTickets = new TicketList();
	}


	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		if(firstName!=null || firstName!="") {
			this.firstName = firstName;
		}
	}
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if(lastName!=null || lastName!="") {
			this.lastName = lastName;
		}
	}
 
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		if(phoneNumber!=null || phoneNumber!="") {
			this.phoneNumber = phoneNumber;
			if (phoneNumber.contentEquals("Admin"))
				setIsAdmin(true);
		}
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(boolean isAdmin ) {
		this.isAdmin = isAdmin;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		if(balance >= 0) {
			this.balance = balance;
		}
	}

	public TicketList getCustomerTickets() {
		return customerTickets;
	}

	public void setCustomerTickets(TicketList customerTickets) {
		this.customerTickets = customerTickets;
	}


}