/**
 * Definition for class to read the movies file and make movie objects
 * 
 * @authors Khalid Ahmed, Lana Berge, Ian Flickinger
 * Assignment: Final Project
 * Due Date: December 10, 2019
 * Class: CSCI 2082.01
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MovieBuilder extends JPanel {
	private static final long serialVersionUID = 1890L;
	private static final File dataFile = new File("movie-data/movies");
	private static final String emptyIconFilename = "movie-data/emptyIcon.png";
	private static final ImageIcon addDataIcon = new ImageIcon((new ImageIcon(emptyIconFilename)).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	private static final String TITLE = "title";
	private static final String PRICE = "price";
	private static final String MPAA_RATING = "mpaa_rating";
	private static final String GENRE = "genre";
	private static final String SHOWTIME = "showtime";
	private static final String POSTER = "poster";
	private static final String SEAT = "seat";
	private static final String COLUMNS = "Columns";
	private static final String ROWS = "Rows";
	private static final String ADD_MOVIE = "add_movie";
	private JPanel infoPanel;
	private ImageIcon poster;
	private JButton addMovieButton;
	
	public MovieBuilder() {	
		super();
		this.setLayout(new GridBagLayout());
		ImageIcon noPosterIcon = new ImageIcon(emptyIconFilename);
		noPosterIcon.setImage(noPosterIcon.getImage().getScaledInstance(382, 382, Image.SCALE_SMOOTH));
		
		JButton posterButton = new JButton(noPosterIcon);
		posterButton.setName(POSTER);
		posterButton.setBackground(this.getBackground());
		posterButton.setContentAreaFilled(false);
		posterButton.setBorder(null);
		posterButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser("movie-data");
				int returnVal = chooser.showOpenDialog(new JFrame("Choose File"));
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					poster = new ImageIcon(chooser.getSelectedFile().getAbsolutePath());
					posterButton.setIcon(new ImageIcon(poster.getImage().getScaledInstance(382, 576, Image.SCALE_SMOOTH)));
				}
				chooser.setVisible(true);
			}
		});
		GridBagConstraints gbc_posterButton = new GridBagConstraints();
		gbc_posterButton.insets = new Insets(20, 20, 20, 20);
		gbc_posterButton.gridx = 0;
		gbc_posterButton.gridy = 1;
		gbc_posterButton.gridheight = 2;
		gbc_posterButton.fill = GridBagConstraints.VERTICAL;
		this.add(posterButton, gbc_posterButton);
		
		infoPanel = new JPanel();
		GridBagConstraints gbc_infoPanel = new GridBagConstraints();
		gbc_infoPanel.insets = new Insets(0, 0, 5, 5);
		gbc_infoPanel.fill = GridBagConstraints.BOTH;
		gbc_infoPanel.gridx = 2;
		gbc_infoPanel.gridy = 1;
		this.add(infoPanel, gbc_infoPanel);
		
		GridBagLayout gbl_infoPanel = new GridBagLayout();
		gbl_infoPanel.columnWidths = new int[]{175, 150, 150, 150, 150, 150, 150, 150, 150, 150, 0};
		gbl_infoPanel.rowHeights = new int[]{39, 23, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_infoPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_infoPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		infoPanel.setLayout(gbl_infoPanel);
		
		JLabel movieTitleLabel = new JLabel("Title:");
		GridBagConstraints gbc_movieTitleLabel = new GridBagConstraints();
		gbc_movieTitleLabel.anchor = GridBagConstraints.WEST;
		gbc_movieTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_movieTitleLabel.gridx = 0;
		gbc_movieTitleLabel.gridy = 1;
		gbc_movieTitleLabel.fill = GridBagConstraints.HORIZONTAL;
		infoPanel.add(movieTitleLabel, gbc_movieTitleLabel);
		movieTitleLabel.setBackground(Color.WHITE);
		movieTitleLabel.setFont(new Font("HelveticaNeue", Font.BOLD, 45));
		movieTitleLabel.setForeground(Color.BLACK);
		
		JTextField movieTitleText = new JTextField(30);
		movieTitleText.setName(TITLE);
		GridBagConstraints gbc_movieTitleText = new GridBagConstraints();
		gbc_movieTitleText.anchor = GridBagConstraints.WEST;
		gbc_movieTitleText.insets = new Insets(0, 0, 5, 5);
		gbc_movieTitleText.gridx = 1;
		gbc_movieTitleText.gridy = 1;
		gbc_movieTitleText.gridwidth = 6;
		gbc_movieTitleText.fill = GridBagConstraints.HORIZONTAL;
		infoPanel.add(movieTitleText, gbc_movieTitleText);
		movieTitleText.setBackground(Color.WHITE);
		movieTitleText.setFont(new Font("HelveticaNeue", Font.BOLD, 45));
		movieTitleText.setForeground(Color.BLACK);
		
		JLabel priceLabel = new JLabel("Price ($):");
		GridBagConstraints gbc_priceLabel = new GridBagConstraints();
		gbc_priceLabel.anchor = GridBagConstraints.WEST;
		gbc_priceLabel.gridx = 0;
		gbc_priceLabel.gridy = 2;
		infoPanel.add(priceLabel, gbc_priceLabel);
		priceLabel.setBackground(Color.WHITE);
		priceLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 18));
		priceLabel.setForeground(Color.BLACK);
		
		JTextField priceText = new JTextField("0.00", 10);
		priceText.setName(PRICE);
		GridBagConstraints gbc_priceText = new GridBagConstraints();
		gbc_priceText.anchor = GridBagConstraints.WEST;
		gbc_priceText.gridx = 1;
		gbc_priceText.gridy = 2;
		infoPanel.add(priceText, gbc_priceText);
		priceText.setBackground(Color.WHITE);
		priceText.setFont(new Font("HelveticaNeue", Font.PLAIN, 18));
		priceText.setForeground(Color.BLACK);
		
		JLabel movieMPAALabel = new JLabel("MPAA Rating: ");
		GridBagConstraints gbc_movieMPAALabel = new GridBagConstraints();
		gbc_movieMPAALabel.anchor = GridBagConstraints.WEST;
		gbc_movieMPAALabel.insets = new Insets(0, 0, 5, 5);
		gbc_movieMPAALabel.gridx = 0;
		gbc_movieMPAALabel.gridy = 3;
		infoPanel.add(movieMPAALabel, gbc_movieMPAALabel);
		movieMPAALabel.setBackground(Color.WHITE);
		movieMPAALabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 18));
		movieMPAALabel.setForeground(Color.BLACK);
		
		JTextField mpaaText = new JTextField(10);
		mpaaText.setName(MPAA_RATING);
		GridBagConstraints gbc_mpaaText = new GridBagConstraints();
		gbc_mpaaText.anchor = GridBagConstraints.WEST;
		gbc_mpaaText.gridx = 1;
		gbc_mpaaText.gridy = 3;
		infoPanel.add(mpaaText, gbc_mpaaText);
		mpaaText.setBackground(Color.WHITE);
		mpaaText.setFont(new Font("HelveticaNeue", Font.PLAIN, 18));
		mpaaText.setForeground(Color.BLACK);
		
		JLabel movieGenreLabel = new JLabel("Genres: ");
		GridBagConstraints gbc_movieGenreLabel = new GridBagConstraints();
		gbc_movieGenreLabel.anchor = GridBagConstraints.WEST;
		gbc_movieGenreLabel.insets = new Insets(0, 0, 5, 5);
		gbc_movieGenreLabel.gridx = 0;
		gbc_movieGenreLabel.gridy = 4;
		infoPanel.add(movieGenreLabel, gbc_movieGenreLabel);
		movieGenreLabel.setBackground(Color.WHITE);
		movieGenreLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 18));
		movieGenreLabel.setForeground(Color.BLACK);
		
		JTextField genreText = new JTextField(10);
		genreText.setName(GENRE);
		GridBagConstraints gbc_genreText = new GridBagConstraints();
		gbc_genreText.anchor = GridBagConstraints.WEST;
		gbc_genreText.gridx = 1;
		gbc_genreText.gridy = 4;
		infoPanel.add(genreText, gbc_genreText);
		genreText.setBackground(Color.WHITE);
		genreText.setFont(new Font("HelveticaNeue", Font.PLAIN, 18));
		genreText.setForeground(Color.BLACK);
		
		JButton addGenreButton = new JButton(addDataIcon);
		addGenreButton.setToolTipText("Add Another Genre");
		GridBagConstraints gbc_addGenreButton = new GridBagConstraints();
		gbc_addGenreButton.gridx = 2;
		gbc_addGenreButton.gridy = 4;
		addGenreButton.setBackground(this.getBackground());
		addGenreButton.setContentAreaFilled(false);
		addGenreButton.setBorder(null);
		infoPanel.add(addGenreButton, gbc_addGenreButton);
		addGenreButton.addActionListener(new AddTextFieldListener(GENRE));
		
		JLabel showtimesLabel = new JLabel("Showtimes:");
		GridBagConstraints gbc_showtimesLabel = new GridBagConstraints();
		gbc_showtimesLabel.anchor = GridBagConstraints.WEST;
		gbc_showtimesLabel.insets = new Insets(0, 0, 5, 5);
		gbc_showtimesLabel.gridx = 0;
		gbc_showtimesLabel.gridy = 5;
		infoPanel.add(showtimesLabel, gbc_showtimesLabel);
		showtimesLabel.setBackground(Color.WHITE);
		showtimesLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 18));
		showtimesLabel.setForeground(Color.BLACK);
		
		JTextField showtimeText = new JTextField(10);
		showtimeText.setName(SHOWTIME);
		GridBagConstraints gbc_showtimeText = new GridBagConstraints();
		gbc_showtimeText.anchor = GridBagConstraints.WEST;
		gbc_showtimeText.gridx = 1;
		gbc_showtimeText.gridy = 5;
		infoPanel.add(showtimeText, gbc_showtimeText);
		showtimeText.setBackground(Color.WHITE);
		showtimeText.setFont(new Font("HelveticaNeue", Font.PLAIN, 18));
		showtimeText.setForeground(Color.BLACK);
		
		JButton addShowtimeButton = new JButton(addDataIcon);
		addShowtimeButton.setToolTipText("Add Another Genre");
		GridBagConstraints gbc_addShowtimeButton = new GridBagConstraints();
		gbc_addShowtimeButton.gridx = 2;
		gbc_addShowtimeButton.gridy = 5;
		addShowtimeButton.setBackground(this.getBackground());
		addShowtimeButton.setContentAreaFilled(false);
		addShowtimeButton.setBorder(null);
		infoPanel.add(addShowtimeButton, gbc_addShowtimeButton);
		addShowtimeButton.addActionListener(new AddTextFieldListener(SHOWTIME));
		
		JLabel seatsLabel = new JLabel("Seats:");
		GridBagConstraints gbc_seatsLabel = new GridBagConstraints();
		gbc_seatsLabel.anchor = GridBagConstraints.WEST;
		gbc_seatsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_seatsLabel.gridx = 0;
		gbc_seatsLabel.gridy = 6;
		infoPanel.add(seatsLabel, gbc_seatsLabel);
		seatsLabel.setBackground(Color.WHITE);
		seatsLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 18));
		seatsLabel.setForeground(Color.BLACK);
		
		JTextField seatRowsText = new JTextField(5);
		seatRowsText.setToolTipText(ROWS);
		seatRowsText.setName(SEAT + ROWS);
		GridBagConstraints gbc_seatRowsText = new GridBagConstraints();
		gbc_seatRowsText.gridx = 1;
		gbc_seatRowsText.gridy = 6;
		infoPanel.add(seatRowsText, gbc_seatRowsText);
		seatRowsText.setBackground(Color.WHITE);
		seatRowsText.setFont(new Font("HelveticaNeue", Font.PLAIN, 18));
		seatRowsText.setForeground(Color.BLACK);
		
		JTextField seatColsText = new JTextField(5);
		seatColsText.setToolTipText(COLUMNS);
		seatColsText.setName(SEAT + COLUMNS);
		GridBagConstraints gbc_seatColsText = new GridBagConstraints();
		gbc_seatColsText.gridx = 2;
		gbc_seatColsText.gridy = 6;
		infoPanel.add(seatColsText, gbc_seatColsText);
		seatColsText.setBackground(Color.WHITE);
		seatColsText.setFont(new Font("HelveticaNeue", Font.PLAIN, 18));
		seatColsText.setForeground(Color.BLACK);
		
		addMovieButton = new JButton("Add Movie");
		addMovieButton.setName(ADD_MOVIE);
		addMovieButton.setBackground(Color.WHITE);
		addMovieButton.setForeground(Color.BLACK);
		addMovieButton.setFont(new Font("HelveticaNeue", Font.BOLD, 15));
		GridBagConstraints gbc_addMovieButton = new GridBagConstraints();
		gbc_addMovieButton.anchor = GridBagConstraints.LAST_LINE_END;
		gbc_addMovieButton.insets = new Insets(250, 20, 20, 5);
		gbc_addMovieButton.gridx = 1;
		gbc_addMovieButton.gridy = 15;
		infoPanel.add(addMovieButton, gbc_addMovieButton);
	}
	
	public void addActionListener(ActionListener l) {
		addMovieButton.addActionListener(l);
	}
	
	public Movie getMovie() {
		Movie movie = null;
		try {
			Component[] components = infoPanel.getComponents();
			
			String title = null;
			LinkedList<String> genreList = new LinkedList<String>();
			String mpaaRating = null;
			LinkedList<String> timesList = new LinkedList<String>();
			double price = 0.0;
			int seatRows = 0;
			int seatCols = 0;
			
			for(Component comp : components) {
				if (comp.getClass() == JTextField.class) {
					JTextField field = (JTextField) comp;
					String text = field.getText();
					if (field.getName().contentEquals(TITLE))
						title = text;
					if (field.getName().contentEquals(PRICE))
						price = Double.parseDouble(text);
					if (field.getName().contentEquals(MPAA_RATING))
						mpaaRating = text;
					if (field.getName().contains(GENRE))
						genreList.add(text);
					if (field.getName().contains(SHOWTIME))
						timesList.add(text);
					if (field.getName().contains(SEAT)) {
						if (field.getToolTipText().contentEquals(ROWS))
							seatRows = Integer.parseInt(field.getText());
						if (field.getToolTipText().contentEquals(COLUMNS))
							seatCols = Integer.parseInt(field.getText());
					}
				}
			}

			String[] times = new String[timesList.toArray().length];
			timesList.toArray(times);
			
			String[] genres = new String[genreList.toArray().length];
			genreList.toArray(genres);
			
			movie = new Movie(title, genres, mpaaRating, times, poster, price, seatRows, seatCols);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movie;
	}
	
	private class AddTextFieldListener implements ActionListener {
		private String type;
		public AddTextFieldListener(String type) {
			super();
			this.type = type;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton caller = (JButton) e.getSource();
			GridBagConstraints gbc_caller = ((GridBagLayout) infoPanel.getLayout()).getConstraints(caller);
			infoPanel.remove(caller);
			
			JTextField dataField = new JTextField(10);
			GridBagConstraints gbc_dataField = (GridBagConstraints) gbc_caller.clone();
			infoPanel.add(dataField, gbc_dataField);
			dataField.setBackground(Color.WHITE);
			dataField.setFont(new Font("HelveticaNeue", Font.PLAIN, 18));
			dataField.setForeground(Color.BLACK);
			
			dataField.setName(type + gbc_dataField.gridx);
			
			gbc_caller.gridx++;
			infoPanel.add(caller, gbc_caller);
			
			infoPanel.revalidate();
			infoPanel.repaint();
		}
	}

	/**
	 * @description: reads the movies file and makes objects of movies and adds them to a movie collection
	 * @postcondition: makes movie objects and adds them to the movie collection
	 */
	public static Collection<Movie> readMovies() {
		Collection<Movie> movies = new LinkedList<Movie>();
		Scanner reader;
		try {
			reader = new Scanner(dataFile);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		final int TITLE = 0;
		final int GENRES = 1;
		final int MPAA_RATING = 2;
		final int SHOWTIMES = 3;
		final int POSTER_FILENAME = 4;
		final int PRICE = 5;
		final int SEATS = 6;
		final int MOVIE_TXT_LENGTH = 7;
		
		while (reader.hasNextLine()) {
			String[] input = new String[MOVIE_TXT_LENGTH];
			for (int line = 0; line < MOVIE_TXT_LENGTH; line++)
				input[line] = reader.nextLine();
			
			String title = input[TITLE];
			
			LinkedList<String> genreList = new LinkedList<String>();
			int first = 0;
			for (int last = 0; last < input[GENRES].length(); last++) {
				if (input[GENRES].charAt(last) == '|') {
					genreList.add(input[GENRES].substring(first, last));
					first = ++last;
				}
			}
			genreList.add(input[GENRES].substring(first));
			String[] genres = new String[0];
			genres = genreList.toArray(genres);
			
			String mpaaRating = input[MPAA_RATING];
			
			LinkedList<String> showtimeList = new LinkedList<String>();
			first = 0;
			for (int last = 0; last < input[SHOWTIMES].length(); last++) {
				if (input[SHOWTIMES].charAt(last) == '|') {
					showtimeList.add(input[SHOWTIMES].substring(first, last));
					first = ++last;
				}
			}
			showtimeList.add(input[SHOWTIMES].substring(first));
			String[] showTimes = new String[0];
			showTimes = showtimeList.toArray(showTimes);
			
			String posterFilename = input[POSTER_FILENAME];
			
			double price = Double.parseDouble(input[PRICE]);
			
			int delim = 0;
			for (int ch = 0; ch < input[SEATS].length(); ch++)
				if (input[SEATS].charAt(ch) == '|')
					delim = ch;
			int rows = Integer.parseInt(input[SEATS].substring(0, delim++));
			int cols = Integer.parseInt(input[SEATS].substring(delim));
			
			movies.add(new Movie(title, genres, mpaaRating, showTimes, posterFilename, price, rows, cols));
			
			if (reader.hasNextLine())
				reader.nextLine();
		}
		reader.close();
		return movies;
	}
	/**
	 * @description: method for display purposes (Not sure)
	 * @precondition: movies must be of type Collection<Movie>
	 */
	public static void writeMovies(Collection<Movie> movies) {
		PrintWriter out;
		try {
			out = new PrintWriter(new FileOutputStream(dataFile));
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		for (Movie movie : movies) {
			out.println(movie.getTitle());
	
			String genres = "";
			for (String genre : movie.getGenres()) {
				genres += genre + '|';
			}
			genres = genres.substring(0, genres.length() - 1);
			out.println(genres);
	
			out.println(movie.getMpaaRating());
			
			String showTimes = "";
			for (String showTime : movie.getShowTimes()) {
				showTimes += showTime + '|';
			}
			showTimes = showTimes.substring(0, showTimes.length() - 1);
			out.println(showTimes);
			
			String filename = "movie-data/" + movie.getTitle().replace(':', '-') + "_poster.jpg";
			out.println(filename);
	
			out.println(Double.toString(movie.getPrice()));
	
			String seats = "";
			seats += movie.getSeats().length + "|";
			seats += movie.getSeats()[0].length;
			out.println(seats);

			out.println();
			
			Image img = movie.getPoster().getImage();
			BufferedImage bi = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_BGR);

			Graphics2D g2 = bi.createGraphics();
			g2.drawImage(img, 0, 0, null);
			g2.dispose();
			File output;
			try {
				output = new File(filename);
				ImageIO.write(bi, "jpg", output);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		out.close();
	}

}
