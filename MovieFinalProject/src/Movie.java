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
	private String genre;
	private String mpaaRating;
	private Double price;
	private String[] showTimes;
	private ImageIcon poster;
	//seats
//	private String[] seats;
//	private boolean[] seatsFilled;
	
	public Movie(String title, String genre, String mpaaRating, String[] times, ImageIcon poster, double price) {
		setTitle(title);
		setGenre(genre);
		setMpaaRating(mpaaRating);
		setShowTimes(times);
		setPoster(poster);
		setPrice(price);
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

	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
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
				if (movie.genre.equals(acceptableGenre))
					selectedMovies.add(movie);
		
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