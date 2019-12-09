/**
 * Definition for class to create movie ticket node for movie tickets.
 * 
 * @authors Khalid Ahmed, Lana Berge, Ian Flickinger
 * Assignment: Final Project
 * Due Date: December 10, 2019
 * Class: CSCI 2082.01
 */
public class TicketNode {
		
	private Ticket theTicket;
	private TicketNode next;

	/**
	 * @description: Construct a TicketNode with data and link.
	 * @param theTicket
	 * @param next
	 * @precondition: Instance variables for theTicket (data) and next (link) exist.
	 * @postcondition: TicketNode has been initialized with specified variables.
	 */
	public TicketNode(Ticket theTicket, TicketNode next) {
		this.theTicket = theTicket;
		this.next = next;
	}
	/**
	 * @description: Get the node's data for this TicketNode.
	 * @precondition: Instance variable theTicket exists and has been initialized.
	 * @postcondition: Node's data has been accessed.
	 * @returns theTicket Node's data
	 */
	public Ticket getTicket() {
		return theTicket; 
	}
	/**
	 * @description: Set the node's data of this TicketNode.
	 * @param theTicket Node's data
	 * @precondition: No precondition.
	 * @postcondition: Node's data has been mutated.
	 * @returns this theTicket Node's data
	 */
	public TicketNode setTicket(Ticket theTicket) {
		this.theTicket = theTicket;
		return this;
	}
	/**
	 * @description: Get the node's link of this TicketNode.
	 * @precondition: Instance variable next exists and has been initialized.
	 * @postcondition: Node's link has been accessed.
	 * @returns next Node's link
	 */
	public TicketNode getNext() {
		return next;
	}
	/**
	 * @description: Set the node's link of this TicketNode.
	 * @param next Node's link
	 * @precondition: No precondition.
	 * @postcondition: Node's link has been mutated.
	 * @returns this next Node's link
	 */
	public TicketNode setNext(TicketNode next) {
		this.next = next;
		return this;
	}
	/**
	 * @description: Overriding method definition to generate a string representation of this TicketNode.
	 * @precondition: The instance variables called have been initialized.
	 * @postcondition: String containing information has been formed.
	 * @return a string representation of this TicketNode.
	 */
	public String toString() {
		return "TicketNode [Ticket = " + theTicket + ", Next Ticket = " + next + "]";
	}
}
