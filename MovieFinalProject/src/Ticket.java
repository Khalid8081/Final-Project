import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class Ticket implements Comparable<Ticket> {
	
	private	String seat;
	private Movie movie;
	private double price;
	public static int idStart=1000;
	public int id;
	private Date showtime;
	   
	Ticket(String seat, Movie movie, double price, Date showtime){
		setSeat(seat);
		setMovie(movie);
		setPrice(price);
		setShowtime(showtime);
		
		id=idStart;
		idStart+=2;
		
		
	}

	public int getId() {
		return id;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public Date getShowtime() {
		return showtime;
	}
	
	public void setShowtime(Date showtime) {
		this.showtime = showtime;
	}

	@Override
	public int compareTo(Ticket o) {
		return showtime.compareTo(o.showtime);
	}

}
