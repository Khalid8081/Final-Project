
public class TicketNode {
		
	private Ticket theTicket;
	private TicketNode next;

	public TicketNode(Ticket theTicket, TicketNode next) {
		this.theTicket = theTicket;
		this.next = next;
	}

	public Ticket getTicket() {
		return theTicket; 
	}

	public void setTicket(Ticket theTicket) {
		this.theTicket = theTicket;
	}

	public TicketNode getNext() {
		return next;
	}

	public void setNext(TicketNode next) {
		this.next = next;
	}

	public String toString() {
		return "TicketNode [Ticket=" + theTicket + ", Next Ticket=" + next + "]";
	}
	
	

}
