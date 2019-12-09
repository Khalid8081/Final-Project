/**
 * Definition for class to create and store movies.
 * 
 * @authors Khalid Ahmed, Lana Berge, Ian Flickinger
 * Assignment: Final Project
 * Due Date: December 10, 2019
 * Class: CSCI 2082.01
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import javax.swing.ImageIcon;

public class Movie implements Serializable {
	public static final long serialVersionUID = -8547026694153616901L;
	public static final int posterWidth = 382;
	public static final int posterHeight = 576;
	private String title;
	private String[] genres;
	private String mpaaRating;
	private double price;
	private String[] showTimes;
	private ImageIcon poster;
	private Seat[][] seats;
	
	/**
	 * @description: Construct a Movie with title, genre, mpaaRating, times, posterFilename, price, seatRows, seatCols.
	 * @param title
	 * @param genres
	 * @param mpaaRating
	 * @param times
	 * @param posterFilename
	 * @param price
	 * @param seatRows
	 * @param seatCols
	 * @precondition: Instance variables for parameters exist.
	 * @postcondition: Movie has been initialized with specified variables.
	 */
	public Movie(String title, String[] genres, String mpaaRating, String[] times, String posterFilename, double price, int seatRows, int seatCols) {
		this(title, genres, mpaaRating, times, new ImageIcon(), price, seatRows, seatCols);
		poster = new ImageIcon(posterFilename);
	}
	
	public Movie(String title, String[] genres, String mpaaRating, String[] times, ImageIcon poster, double price, int seatRows, int seatCols) {
		super(); 
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
	/**
	 * @description: Get the movie's price for this Movie.
	 * @precondition: Instance variable price exists and has been initialized.
	 * @postcondition: Movie's price has been accessed.
	 * @returns price Movie's price 
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @description: Set the movie's price for this Movie.
	 * @param price Movie's price
	 * @postcondition: Movie's price has been mutated.
	 * @returns this price Movie's price
	 */
	public Movie setPrice(double price) {
		this.price = price;
		return this;
	}
	/**
	 * @description: Get the movie's title for this Movie.
	 * @precondition: Instance variable title exists and has been initialized.
	 * @postcondition: Movie's title has been accessed.
	 * @returns title Movie's title 
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @description: Set the movie's title for this Movie.
	 * @param title Movie's title
	 * @postcondition: Movie's title has been mutated.
	 * @returns this title Movie's title
	 */
	public Movie setTitle(String title) {
		this.title = title;
		return this;
	}
	/**
	 * @description: Get the movie's genres for this Movie.
	 * @precondition: Instance variable genres exists and has been initialized.
	 * @postcondition: Movie's genres has been accessed.
	 * @returns genres Movie's genres 
	 */
	public String[] getGenres() {
		return genres;
	}
	/**
	 * @description: Set the movie's genres for this Movie.
	 * @param genres Movie's genres
	 * @postcondition: Movie's genres has been mutated.
	 * @returns this genres Movie's genres
	 */
	public Movie setGenres(String[] genres) {
		this.genres = genres;
		return this;
	}
	/**
	 * @description: Get the movie's MPAA rating for this Movie.
	 * @precondition: Instance variable mpaaRating exists and has been initialized.
	 * @postcondition: Movie's MPAA rating has been accessed.
	 * @returns mpaaRating Movie's MPAA rating 
	 */
	public String getMpaaRating() {
		return mpaaRating;
	}
	/**
	 * @description: Set the movie's MPAA rating for this Movie.
	 * @param mpaaRating Movie's MPAA rating
	 * @postcondition: Movie's MPAA rating has been mutated.
	 * @returns this mpaaRating Movie's MPAA rating
	 */
	public Movie setMpaaRating(String mpaaRating) {
		this.mpaaRating = mpaaRating;
		return this;
	}
	/**
	 * @description: Get the movie's show times for this Movie.
	 * @precondition: Instance variable showTimes exists and has been initialized.
	 * @postcondition: Movie's show times has been accessed.
	 * @returns showTimes Movie's show times 
	 */
	public String[] getShowTimes() {
		return showTimes;
	}
	/**
	 * @description: Set the movie's show times for this Movie.
	 * @param showTimes Movie's show times
	 * @postcondition: Movie's show times has been mutated.
	 * @returns this showTimes Movie's show time
	 */
	public Movie setShowTimes(String[] showTimes) {
		this.showTimes = showTimes;
		return this;
	}
	/**
	 * @description: Get the movie's poster for this Movie.
	 * @precondition: Instance variable poster exists and has been initialized.
	 * @postcondition: Movie's poster has been accessed.
	 * @returns poster Movie's poster 
	 */
	public ImageIcon getPoster() {
		return poster;
	}
	/**
	 * @description: Set the movie's poster for this Movie.
	 * @param poster Movie's poster
	 * @postcondition: Movie's poster has been mutated.
	 * @returns this poster Movie's poster
	 */
	public Movie setPoster(ImageIcon poster) {
		this.poster = poster;
		return this;
	}
	/**
	 * @description: Get the movie's seats for this Movie.
	 * @precondition: Instance variable seats exists and has been initialized.
	 * @postcondition: Movie's seats has been accessed.
	 * @returns seats Movie's seats 
	 */
	public void setSeats(Seat[][] seats) {
		this.seats = seats;
	}
	/**
	 * @description:
	 * @precondition:
	 * @postcondition: 
	 * @returns seats
	 */
	public Seat[][] getSeats() {
		return seats;
	}
	/**
	 * @description:
	 * @precondition:
	 * @postcondition: 
	 * @returns 
	 */
	public class Seat implements Serializable {
		public static final long serialVersionUID = -8547026694153616902L;
		private String seatName;
		private boolean[] isTaken;
		
		public Seat(String seatName) {
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
		
		//TODO: Replace Collections.sort with personal sorting algorithm
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
					if (genre.contentEquals(acceptableGenre) && movies.contains(movie))
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
