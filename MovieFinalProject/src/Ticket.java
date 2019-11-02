import java.util.Date;

public class Ticket implements Comparable<Ticket> {
	private	String seat;
	private Movie movie;
	private double price;
	
	private Date showtime;
	   
	Ticket(String seat, Movie movie, double price, Date showtime){
		setSeat(seat);
		setMovie(movie);
		setPrice(price);
		setShowtime(showtime);
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
