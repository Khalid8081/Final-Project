import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.Collection;

import javax.swing.JPanel;

public class MovieBuilder {
	private static final File dataFile = new File("movie-data/MovieCollection");
	
	public static JPanel newMovieBuilder() {
		JPanel builder = new JPanel();
		
		return builder;
	}
	
	@SuppressWarnings("unchecked")
	public static Collection<Movie> readMovies() throws Exception {
		Collection<Movie> movies;
		
		FileInputStream file = new FileInputStream(dataFile);
		ObjectInputStream in = new ObjectInputStream(file);
		
		movies = (Collection<Movie>) in.readObject();

		in.close();
		file.close();
		
		return movies;
	}
	
	public static void writeMovies(Collection<Movie> movies) throws Exception {
		FileOutputStream file = new FileOutputStream(dataFile);
		ObjectOutputStream out = new ObjectOutputStream(file);
		
		out.writeObject(movies);

		out.close();
		file.close();
	}
}
