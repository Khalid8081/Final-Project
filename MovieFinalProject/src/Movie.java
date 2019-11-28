import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class Movie implements Serializable {
	public static final long serialVersionUID = -8547026694153616901L;
	
	private String title;
	private String[] genres;
	private String mpaaRating;
	private Double price;
	private String[] showTimes;
	private ImageIcon poster;
	private Seat[][] seats;
	
	public Movie(String title, String[] genres, String mpaaRating, String[] times, ImageIcon poster, double price, int seatRows, int seatCols) {
		setTitle(title);
		setGenres(genres);
		setMpaaRating(mpaaRating);
		setShowTimes(times);
		setPoster(poster);
		setPrice(price);
		
		seats = new Seat[seatRows][seatCols];
		for (int row = 0; row < seatRows; row++) {
			char colID = 'A';
			for (int col = 0; col < seatCols; col++, colID++) {
				seats[row][col] = new Seat("" + (row+1) + colID);
			}
		}
	}
	
	public double getPrice() {
		return price;
	}
 
	public void setPrice(double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String[] getGenres() {
		return genres;
	}
	
	public void setGenres(String[] genres) {
		this.genres = genres;
	}

	public String getMpaaRating() {
		return mpaaRating;
	}
	
	public void setMpaaRating(String mpaaRating) {
		this.mpaaRating = mpaaRating;
	}

	public String[] getShowTimes() {
		return showTimes;
	}
	
	public void setShowTimes(String[] showTimes) {
		this.showTimes = showTimes;
	}
	
	public ImageIcon getPoster() {
		return poster;
	}
	
	public void setPoster(ImageIcon poster) {
		this.poster = poster;
	}
	
	public void setSeats(Seat[][] seats) {
		this.seats = seats;
	}
	public Seat[][] getSeats() {
		return seats;
	}
	
	public class Seat implements Serializable {
		public static final long serialVersionUID = -8547026694153616902L;
		
		private String seatName;
		private boolean[] isTaken;
		
		public Seat(String seatName) {
			System.out.println(seatName);
			this.seatName = seatName;
			isTaken = new boolean[showTimes.length];
		}
		
		public void setSeatName(String seatName) {
			this.seatName = seatName;
		}
		public String getSeatName() {
			return seatName;
		}
		
		public boolean[] isTaken() {
			return isTaken;
		}
		public void setIsTaken(boolean[] isTaken) {
			this.isTaken = isTaken;
		}
	}
	
	/*Sort collection of movies alphabetically
	 * Parameters:
	 * 	Collection<Movie> movies	- a collection of movies to be sorted
	 * 	
	 * Returns: a collection of the movies in alphabetical order
	 */
	public static Collection<Movie> sortByTitle(Collection<Movie> movies) {
		Collection<Movie> movieList = new ArrayList<Movie>(movies);
		
		//Use Collections.sort method to sort the list of movies by title
		//Instantiate a comparator to pass the method of comparison
		Collections.sort((ArrayList<Movie>) movieList, new Comparator<Movie>() {
			@Override
			public int compare(Movie o1, Movie o2) {
				return o1.getTitle().compareTo(o2.getTitle());
			}
		});
		
		return movieList;
	}
	
	/*Search through a collection of movies by title
	 * Parameters:
	 * 	Collection<Movie> movies
	 * 		- a collection of movies to be searched
	 * 	String target
	 * 		- the sequence to be found
	 * 
	 * Returns a collection of movies. Each movie contains an instance of the 
	 * 	target string
	 */
	public static Collection<Movie> searchTitles(Collection<Movie> movies, String target) {
		Collection<Movie> targets = new LinkedList<Movie>();

		for (Movie movie : movies) 
			if (movie.title.toLowerCase().contains(target.toLowerCase()))
				targets.add(movie);
		
		return targets;
	}
	
	/*Create a collection of movies with only the given genres
	 * Parameters:
	 * 	Collection<Movie> movies	- the collection of movies to be searched
	 * 	String... genres			- variable arity of genres to include
	 * 
	 * Returns a collection of movies. This collection contains every movie from the 
	 * 	movies parameter with a given genre. The movies are separated by genre.
	 * 
	 * NOTE: the genres can be chosen in the gui using check boxes
	 */
	public static Collection<Movie> filterGenres(Collection<Movie> movies, String...genres) {
		Collection<Movie> selectedMovies = new LinkedList<Movie>();
		
		for (String acceptableGenre : genres)
			for (Movie movie : movies) 
				for (String genre : movie.genres)
					if (genre.contentEquals(acceptableGenre) && !movies.contains(movie))
						movies.add(movie);
		
		return selectedMovies;
	}
	
	/*Create a collection of movies with only the given mpaa ratings
	 * Parameters:
	 * 	Collection<Movie> movies	- the collection of movies to be searched
	 * 	String... ratings			- variable arity of ratings to include
	 * 
	 * Returns a collection of movies. This collection contains every movie from the 
	 * 	movies parameter with a rating given in the ratings parameter. The movies are
	 * 	separated by rating
	 * 
	 * NOTE: the ratings can be chosen from the gui using check boxes
	 */
	public static Collection<Movie> filterRatings(Collection<Movie> movies, String...ratings) {
		Collection<Movie> selectedMovies = new LinkedList<Movie>();
		
		for (String acceptableRating : ratings)
			for (Movie movie : movies) 
				if (movie.mpaaRating.equals(acceptableRating))
					selectedMovies.add(movie);
		
		return selectedMovies;	
	}
}