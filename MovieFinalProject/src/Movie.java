import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.LinkedList;

public class Movie {
	private String title;
	private String genre;
	private String mpaaRating;
	private int runtime;
	
	private GregorianCalendar premiere;
	private GregorianCalendar finale;
	private String[] showTimes;
	   
	public Movie(String title, String genre, String mpaaRating, int runtime, 
			GregorianCalendar premiere, GregorianCalendar finale, String[] times) {
		this.title = title;
		this.genre = genre;
		this.mpaaRating = mpaaRating;
		this.runtime = runtime;
		
		this.premiere = premiere;
		this.finale = finale;
		this.showTimes = times;
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
	
	public int getRuntime() {
		return runtime;
	}
	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	
	public GregorianCalendar getPremiere() {
		return premiere;
	}
	public void setPremiere(GregorianCalendar premiere) {
		this.premiere = premiere;
	}
	
	public GregorianCalendar getFinale() {
		return finale;
	}
	public void setFinale(GregorianCalendar finale) {
		this.finale = finale;
	}

	public String[] getShowTimes() {
		return showTimes;
	}
	public void setShowTimes(String[] showTimes) {
		this.showTimes = showTimes;
	}
	
	
	/*
	 * 
	 */
	public static Collection<Movie> onScreen(Collection<Movie> movies) {
		Collection<Movie> onScreen = new LinkedList<Movie>();
		
		GregorianCalendar now = new GregorianCalendar();
		for (Movie movie : movies)
			if (movie.premiere.compareTo(now) <= 0 && movie.finale.compareTo(now) > 0)
				onScreen.add(movie);
		
		return onScreen;
	}
	
	/*
	 * 
	 */
	public static Collection<Movie> comingSoon(Collection<Movie> movies) {
		Collection<Movie> comingSoon = new LinkedList<Movie>();
		
		GregorianCalendar now = new GregorianCalendar();
		for (Movie movie : movies)
			if (movie.premiere.compareTo(now) > 0)
				comingSoon.add(movie);
		
		return comingSoon;
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
			if (movie.title.contains(target))
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