/**
 * Definition for class to build linked list of movie tickets.
 * 
 * @authors Khalid Ahmed, Lana Berge, Ian Flickinger
 * Assignment: Final Project
 * Due Date: December 10, 2019
 * Class: CSCI 2082.01
 */

public class TicketList {
	private TicketNode head;
	private TicketNode tail;
	private int count;
	
	/**
	 * @description: Construct a TicketList with head and tail.
	 * @precondition: Instance variables for head, tail, and count exist.
	 * @postcondition: TicketList has been initialized with specified variables.
	 */
	public TicketList() {
		this.head = null;
		this.tail = null;
		this.count = 0;
	}
	/**
	 * @description: Add ticket to linked list of tickets.
	 * @param aTicket
	 * @precondition: aTicket exists and has been initialized.
	 * @postcondition: aTicket has been added to linked list of tickets.
	 */
	public void add(Ticket aTicket) {
		if (tail == null) {
			head = new TicketNode(aTicket, null);
			tail = head;
		} else {
			TicketNode newTicketNode = new TicketNode(aTicket, null);
			tail.setNext(newTicketNode);
			tail = newTicketNode;
		}
		count++;	
	}
	/**
	 * @description: Removes ticket from linked list of tickets.
	 * @param targetTicket ticket to be removed
	 * @precondition: targetTicket exists and has been initialized.
	 * @postcondition: If exists inside list, targetTicket has been removed from linked list.
	 */
	public boolean remove(int targetId) {
		TicketNode cursor;
		TicketNode precursor;
		
		for(precursor = null, cursor = head; cursor != null;
				precursor = cursor, cursor = cursor.getNext()) {
	
			if (cursor.getTicket().getId() == targetId) {
				if (precursor == null) {
					head = head.getNext();
				} else {
					precursor.setNext(cursor.getNext());
				}
				count--;
				return true;
			}
		}
		return false;
	}
	/**
	 * @description: Get the linked list's head for this TicketList.
	 * @precondition: Instance variable head exists and has been initialized.
	 * @postcondition: Linked list's head has been accessed.
	 * @returns head Linked list's head
	 */
	public TicketNode getHead() {
		return head; 
	}
	/**
	 * @description: Set the head of this TicketList.
	 * @param head Linked list's head
	 * @precondition: No precondition.
	 * @postcondition: Linked list's head has been mutated.
	 */
	public void setHead(TicketNode head) {
		this.head = head;
	}
	/**
	 * @description: Get the linked list's tail for this TicketList.
	 * @precondition: Instance variable tail exists and has been initialized.
	 * @postcondition: Linked list's tail has been accessed.
	 * @returns tail Linked list's tail
	 */
	public TicketNode getTail() {
		return tail;
	}
	/**
	 * @description: Set the tail of this TicketList.
	 * @param tail Linked list's tail
	 * @precondition: No precondition.
	 * @postcondition: Linked list's tail has been mutated.
	 */
	public void setTail(TicketNode tail) {
		this.tail = tail;
	}
	/**
	 * @description: Get the linked list's count for this TicketList.
	 * @precondition: Instance variable count exists and has been initialized.
	 * @postcondition: Linked list's count has been accessed.
	 * @returns count Linked list's count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @description: Set the count of this TicketList.
	 * @param count Linked list's count
	 * @precondition: No precondition.
	 * @postcondition: Linked list's count has been mutated.
	 */
	public void setCount(int count) {
		this.count = count;
	}
}