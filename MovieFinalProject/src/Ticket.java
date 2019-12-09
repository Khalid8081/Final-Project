/**
 * Definition for class to create and store movies tickets.
 * 
 * @authors Khalid Ahmed, Lana Berge, Ian Flickinger
 * Assignment: Final Project
 * Due Date: December 10, 2019
 * Class: CSCI 2082.01
 */

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class Ticket implements Comparable<Ticket> {
	
	private	String seat;
	private Movie movie;
	private double price;
	public static int idStart=1000;
	public int id;
	private Date showTime;
	
	/**
	 * @description: Construct a Ticket with seat, movie, price, and showTime.
	 * @param seat
	 * @param movie
	 * @param price
	 * @param showTime
	 * @precondition: Instance variables for seat, movie, price, and showTime exist.
	 * @postcondition: Ticket has been initialized with specified variables.
	 */
	public Ticket(String seat, Movie movie, double price, Date showtime){
		setSeat(seat);
		setMovie(movie);
		setPrice(price);
		setShowtime(showtime);
		
		id=idStart;
		idStart+=2;
	}
	/**
	 * @description: Get the ticket's id of this Ticket.
	 * @precondition: Instance variable id exists and has been initialized.
	 * @postcondition: Ticket's id has been accessed.
	 * @returns id Ticket's id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @description: Get the ticket's seat of this Ticket.
	 * @precondition: Instance variable seat exists and has been initialized.
	 * @postcondition: Ticket's seat has been accessed.
	 * @returns seat Ticket's seat
	 */
	public String getSeat() {
		return seat;
	}
	/**
	 * @description: Set the ticket's seat of this Ticket
	 * @param seat Ticket's seat
	 * @postcondition: Ticket's seat has been mutated.
	 * @returns this seat Ticket's seat
	 */
	public Ticket setSeat(String seat) {
		this.seat = seat;
		return this;
	}
	/**
	 * @description: Get the ticket's movie of this Ticket.
	 * @precondition: Instance variable movie exists and has been initialized.
	 * @postcondition: Ticket's movie has been accessed.
	 * @returns movie Ticket's movie
	 */
	public Movie getMovie() {
		return movie;
	}
	/**
	 * @description: Set the ticket's movie of this Ticket
	 * @param movie Ticket's movie
	 * @postcondition: Ticket's movie has been mutated.
	 * @returns this movie Ticket's movie
	 */
	public Ticket setMovie(Movie movie) {
		this.movie = movie;
		return this;
	}
	/**
	 * @description: Get the ticket's price of this Ticket.
	 * @precondition: Instance variable price exists and has been initialized.
	 * @postcondition: Ticket's price has been accessed.
	 * @returns price Ticket's price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @description: Set the ticket's price of this Ticket
	 * @param price Ticket's price
	 * @postcondition: Ticket's price has been mutated.
	 * @returns this price Ticket's price
	 */
	public Ticket setPrice(double price) {
		this.price = price;
		return this;
	}
	/**
	 * @description: Get the ticket's show time of this Ticket.
	 * @precondition: Instance variable showTime exists and has been initialized.
	 * @postcondition: Ticket's show time has been accessed.
	 * @returns showTime Ticket's show time
	 */
	public Date getShowTime() {
		return showTime;
	}
	/**
	 * @description: Set the ticket's show time of this Ticket
	 * @param showTime Ticket's show time
	 * @postcondition: Ticket's show time has been mutated.
	 */
	public void setShowtime(Date showTime) {
		this.showTime = showTime;
	}
	/**
	 * @description: Compares tickets
	 * @param o Ticket
	 * @returns comparison of tickets
	 */
	@Override
	public int compareTo(Ticket o) {
		return showTime.compareTo(o.showTime);
	}
}