import java.util.Calendar;
import java.util.Date;

public class Movie {
	public String title;
	public String genre;
	public String mpaaRating;
	public Date showTime;
	 
	public Movie(String title, String genre, String mpaaRating, Date showTime) {
		this.title=title;
		this.genre=genre;
		this.mpaaRating=mpaaRating;
		this.showTime=showTime;
	}
	
}
  