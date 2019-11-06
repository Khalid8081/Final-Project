import java.util.PriorityQueue;

public class Customer {
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private PriorityQueue<Ticket> customerTickets;
   
	public Customer(String firstName, String lastName, String phoneNumber) {
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		customerTickets = new PriorityQueue<Ticket>();
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
		}
	}

	public PriorityQueue<Ticket> getCustomerTickets() {
		return customerTickets;
	}

	public void setCustomerTickets(PriorityQueue<Ticket> customerTickets) {
		this.customerTickets = customerTickets;
	}


}
