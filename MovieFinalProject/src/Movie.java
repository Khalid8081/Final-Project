import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class Movie {
	private String title;
	private String genre;
	private String mpaaRating;
	private String[] showTimes;
	private ImageIcon poster;
	//seats
	   
	public Movie(String title, String genre, String mpaaRating, String[] times, ImageIcon poster) {
		this.title = title;
		this.genre = genre;
		this.mpaaRating = mpaaRating;
		this.showTimes = times;
		this.poster = poster;
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
		Iterator<Movie> list;
		Collection<Movie> selectedMovies = new LinkedList<Movie>();
		
		for (String acceptableGenre : genres) {
			list = movies.iterator();
			while (list.hasNext()) {
				Movie movie = list.next();
				if (movie.genre.equals(acceptableGenre))
					selectedMovies.add(movie);
			}
		}
		
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
		Iterator<Movie> list;
		Collection<Movie> selectedMovies = new LinkedList<Movie>();
		
		for (String acceptableRating : ratings) {
			list = movies.iterator();
			while (list.hasNext()) {
				Movie movie = list.next();
				if (movie.mpaaRating.equals(acceptableRating))
					selectedMovies.add(movie);
			}
		}
		
		return selectedMovies;	
	}
}