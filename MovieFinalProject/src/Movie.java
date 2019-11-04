import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class Movie {
	private String title;
	private String genre;
	private String mpaaRating;
	private String[] showTimes;
	   
	public Movie(String title, String genre, String mpaaRating, String[] times) {
		this.title=title;
		this.genre=genre;
		this.mpaaRating=mpaaRating;
		this.showTimes=times;
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



	/*Create a collection of movies with only the given genres
	 * Parameters:
	 * 	Collection<Movie> movies	- the collection of movies to be searched
	 * 	String... genres			- variable arity of genres to include
	 * 
	 * Returns a collection of movies. This collection contains every movie from the 
	 * 	movies parameter with a given genre
	 * 
	 * NOTE: the genres can be chosen in the gui using check boxes
	 */
	public static Collection<Movie> getGenres(Collection<Movie> movies, String...genres) {
		Iterator<Movie> list = movies.iterator();
		Collection<Movie> selectedMovies = new LinkedList<Movie>();
		while (list.hasNext()) {
			Movie movie = list.next();
			for (String acceptableGenre : genres)
				if (movie.genre.equals(acceptableGenre))
					selectedMovies.add(movie);
		}
		return selectedMovies;
	}
	
	/*Create a collection of movies with only the given mpaa ratings
	 * Parameters:
	 * 	Collection<Movie> movies	- the collection of movies to be searched
	 * 	String... ratings			- variable arity of ratings to include
	 * 
	 * Returns a collection of movies. This collection contains every movie from the 
	 * 	movies parameter with a rating given in the ratings parameter
	 * 
	 * NOTE: the ratings can be chosen from the gui using check boxes
	 */
	public static Collection<Movie> getRatings(Collection<Movie> movies, String...ratings) {
		Iterator<Movie> list = movies.iterator();
		Collection<Movie> selectedMovies = new LinkedList<Movie>();
		while (list.hasNext()) {
			Movie movie = list.next();
			for (String acceptableRating : ratings)
				if (movie.mpaaRating.equals(acceptableRating))
					selectedMovies.add(movie);
		}
		return selectedMovies;	
	}
}
