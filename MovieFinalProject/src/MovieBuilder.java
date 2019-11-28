import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MovieBuilder extends JPanel {
	private static final long serialVersionUID = 1890L;
	private static final File dataFile = new File("movie-data/MovieCollection");
	private static final File backupDataFile = new File("movie-data/MovieCollection_Backup");
	private static final String emptyIconFile = "movie-data/emptyIcon.png";
	private static final ImageIcon addDataIcon = new ImageIcon((new ImageIcon(emptyIconFile)).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
	
	private static final String TITLE = "title";
	private static final String PRICE = "price";
	private static final String MPAA_RATING = "mpaa_rating";
	private static final String GENRE = "genre";
	private static final String SHOWTIME = "showtime";
	private static final String POSTER = "poster";
	private static final String SEAT = "seat";
	private static final String COLUMNS = "Columns";
	private static final String ROWS = "Rows";

	private JPanel infoPanel;
	private JButton addMovieButton;
	private ImageIcon poster;
	private int seatRows, seatCols;
	
	public MovieBuilder() {
		
		this.setLayout(new GridBagLayout());
		
		ImageIcon noPosterIcon = new ImageIcon(emptyIconFile);
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
			
			for (Component comp : components) {
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
			
			ImageIcon moviePoster = new ImageIcon(poster.getImage());
			movie = new Movie(title, genres, mpaaRating, times, moviePoster, price, seatRows, seatCols);
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
	
	@SuppressWarnings("unchecked")
	public static Collection<Movie> readMovies() {
		Collection<Movie> movies = null;
		
		try {
			FileInputStream file = new FileInputStream(backupDataFile);
			ObjectInputStream in = new ObjectInputStream(file);
		
			movies = (Collection<Movie>) in.readObject();

			in.close();
			file.close();
			
			String[] showtimes = {"6:00 pm", "6:30 pm", "7:00 pm", "7:30 pm"};
			for (Movie movie : movies) {
				movie.setShowTimes(showtimes);
			}
		} catch (Exception e) {
			System.out.println("Can't Read Movies");
		}
		
		return movies;
	}
	
	public static void writeMovies(Collection<Movie> movies) {
		try {
			FileOutputStream file = new FileOutputStream(dataFile);
			ObjectOutputStream out = new ObjectOutputStream(file);
		
			out.writeObject(movies);

			out.close();
			file.close();
			
			//If the stream was written properly, back it up
			FileInputStream filein = new FileInputStream(dataFile);
			FileOutputStream fileout = new FileOutputStream(backupDataFile);
			
			fileout.write(filein.readAllBytes());
			
			filein.close();
			fileout.close();
		} catch (Exception e) {
			System.out.println("Can't Write Movies");
			e.printStackTrace();
		} 
	}
}
