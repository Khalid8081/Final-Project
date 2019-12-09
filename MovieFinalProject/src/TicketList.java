
public class TicketList {

	private TicketNode head;
	private TicketNode tail;
	private int count;
	
	public TicketList() {
		this.head = null;
		this.tail = null;
		this.count = 0;
	}
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
	public boolean remove(int targetId) {
		TicketNode cursor;
		TicketNode precursor;
		
		for(precursor = null, cursor = head; cursor != null;
				precursor = cursor, cursor = cursor.getNext()) {
			
			if (cursor.getTicket().getId()==targetId) {
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
	public TicketNode getHead() {
		return head; 
	}
	public void setHead(TicketNode head) {
		this.head = head;
	}
	public TicketNode getTail() {
		return tail;
	}
	public void setTail(TicketNode tail) {
		this.tail = tail;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
