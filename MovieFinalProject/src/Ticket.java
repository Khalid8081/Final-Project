
public class Ticket {
	private	String seat;
	private Movie movie;
	private double price;
	  
	Ticket(String seat, Movie movie, double price){
		setSeat(seat);
		setMovie(movie);
		setPrice(price);
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

}
