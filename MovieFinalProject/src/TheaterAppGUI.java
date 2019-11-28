import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
 
 
public class TheaterAppGUI {
	public JFrame frame;
	public String sortOption;
	public String chooseOption;
	public JComboBox<String> sortComboBox;
	public JComboBox<String> movieComboBox;
	public CheckoutGUI newCheckoutWindow;
	public JPanel moviePanel;
	
	public static Customer customer;
	
	private static final int WIDTH = 1600;
	private static final int HEIGHT = 1050;
	private static final String CARD1 = "A-Z";
	private static final String CARD2 = "Drama";
	private static final String CARD3 = "Thriller";
	private static final String CARD4 = "Adventure";
	private static final String CARD5 = "Fantasy";
	private static final String CARD6 = "R";
	private static final String CARD7 = "PG";
	private static final String CARD8 = "PG-13";
	
	private JTextField searchTextField;
	
	public Collection<Movie> movies; 
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TheaterAppGUI window = new TheaterAppGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public TheaterAppGUI()  {
		try {
			movies = MovieBuilder.readMovies();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		initialize(); 
	}
		
	public void initialize()  {
		frame = new JFrame();
		frame.setTitle("Movie Theater");
		frame.setSize(WIDTH, HEIGHT);
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 148, 0, 0, 52, 0, 123, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel movieTheaterLabel = new JLabel("MOVIE THEATER");
		movieTheaterLabel.setBackground(Color.WHITE);
		movieTheaterLabel.setFont(new Font("HelveticaNeue", Font.BOLD, 18));
		movieTheaterLabel.setForeground(Color.BLACK);
		GridBagConstraints gbc_movieTheaterLabel = new GridBagConstraints();
		gbc_movieTheaterLabel.anchor = GridBagConstraints.WEST;
		gbc_movieTheaterLabel.insets = new Insets(20, 20, 25, 25);
		gbc_movieTheaterLabel.gridx = 1;
		gbc_movieTheaterLabel.gridy = 1;
		frame.getContentPane().add(movieTheaterLabel, gbc_movieTheaterLabel);
		
		JLabel searchLabel = new JLabel("Search:");
		searchLabel.setBackground(Color.WHITE);
		searchLabel.setFont(new Font("HelveticaNeue", Font.BOLD, 18));
		searchLabel.setForeground(Color.BLACK);
		GridBagConstraints gbc_searchLabel = new GridBagConstraints();
		gbc_searchLabel.insets = new Insets(0, 0, 5, 5);
		gbc_searchLabel.anchor = GridBagConstraints.CENTER;
		gbc_searchLabel.gridx = 1;
		gbc_searchLabel.gridy = 2;
		frame.getContentPane().add(searchLabel, gbc_searchLabel);
		
		searchTextField = new JTextField();
		GridBagConstraints gbc_searchTextField = new GridBagConstraints();
		gbc_searchTextField.fill = GridBagConstraints.BOTH;
		gbc_searchTextField.insets = new Insets(5, 5, 5, 5);
		gbc_searchTextField.gridx = 2;
		gbc_searchTextField.gridy = 2;
		frame.getContentPane().add(searchTextField, gbc_searchTextField);
		searchTextField.setColumns(10);
		searchTextField.addActionListener(new SearchListener());
		
		JButton enterButton = new JButton("Enter");
		enterButton.setBackground(Color.WHITE);
		enterButton.setForeground(Color.BLACK);
		enterButton.setFont(new Font("HelveticaNeue", Font.BOLD, 15));
		GridBagConstraints gbc_enterButton = new GridBagConstraints();
		gbc_enterButton.anchor = GridBagConstraints.WEST;
		gbc_enterButton.insets = new Insets(10, 10, 10, 10);
		gbc_enterButton.gridx = 3;
		gbc_enterButton.gridy = 2;
		enterButton.addActionListener(new SearchListener()); 	
		frame.getContentPane().add(enterButton, gbc_enterButton);
		
		JLabel nowShowingLabel = new JLabel("Sort by:");
		nowShowingLabel.setBackground(Color.WHITE);
		nowShowingLabel.setFont(new Font("HelveticaNeue", Font.BOLD, 18));
		nowShowingLabel.setForeground(Color.BLACK);
		GridBagConstraints gbc_nowShowingLabel = new GridBagConstraints();
		gbc_nowShowingLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nowShowingLabel.anchor = GridBagConstraints.CENTER;
		gbc_nowShowingLabel.gridx = 1;
		gbc_nowShowingLabel.gridy = 3;
		frame.getContentPane().add(nowShowingLabel, gbc_nowShowingLabel); 
		
		String sortComboBoxStrings[] = {CARD1, CARD2, CARD3, CARD4, CARD5,CARD6,CARD7,CARD8};
		sortComboBox = new JComboBox<String>(sortComboBoxStrings);
		sortComboBox.setBackground(Color.WHITE);
		sortComboBox.setFont(new Font("Helvetica", Font.ITALIC + Font.BOLD, 15));
		sortComboBox.setEditable(false);
		GridBagConstraints gbc_sortComboBox = new GridBagConstraints();
		gbc_sortComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_sortComboBox.fill = GridBagConstraints.BOTH;
		gbc_sortComboBox.gridx = 2;
		gbc_sortComboBox.gridy = 3;
		frame.getContentPane().add(sortComboBox, gbc_sortComboBox);
		
		JButton sortButton = new JButton("Sort");
		sortButton.setBackground(Color.WHITE);
		sortButton.setForeground(Color.BLACK);
		sortButton.setFont(new Font("HelveticaNeue", Font.BOLD, 15));
		GridBagConstraints gbc_sortButton = new GridBagConstraints();
		gbc_sortButton.anchor = GridBagConstraints.WEST;
		gbc_sortButton.insets = new Insets(0, 0, 5, 5);
		gbc_sortButton.gridx = 3;
		gbc_sortButton.gridy = 3;
		sortButton.addActionListener(new SortListener());
		frame.getContentPane().add(sortButton, gbc_sortButton);
		
		JLabel moviesLabel = new JLabel("Movies:");
		moviesLabel.setBackground(Color.WHITE);
		moviesLabel.setFont(new Font("HelveticaNeue", Font.BOLD, 18));
		moviesLabel.setForeground(Color.BLACK);
		GridBagConstraints gbc_moviesLabel = new GridBagConstraints();
		gbc_moviesLabel.insets = new Insets(0, 0, 5, 5);
		gbc_moviesLabel.anchor = GridBagConstraints.CENTER;
		gbc_moviesLabel.gridx = 1;
		gbc_moviesLabel.gridy = 6;
		frame.getContentPane().add(moviesLabel, gbc_moviesLabel);
		
		movieComboBox = new JComboBox<String>();
		movieComboBox.setBackground(Color.WHITE);
		movieComboBox.setFont(new Font("Helvetica", Font.ITALIC + Font.BOLD, 15));
		movieComboBox.setEditable(false);
		GridBagConstraints gbc_movieComboBox = new GridBagConstraints();
		movieComboBox.setBackground(Color.WHITE);
		gbc_movieComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_movieComboBox.fill = GridBagConstraints.BOTH;
		gbc_movieComboBox.gridx = 2;
		gbc_movieComboBox.gridy = 6;
		frame.getContentPane().add(movieComboBox, gbc_movieComboBox);
		
		JButton chooseButton = new JButton("Choose");
		chooseButton.setBackground(Color.WHITE);
		chooseButton.setForeground(Color.BLACK);
		chooseButton.setFont(new Font("HelveticaNeue", Font.BOLD, 15));
		GridBagConstraints gbc_chooseButton = new GridBagConstraints();
		gbc_chooseButton.anchor = GridBagConstraints.WEST;
		gbc_chooseButton.insets = new Insets(0, 0, 5, 5);
		gbc_chooseButton.gridx = 3;
		gbc_chooseButton.gridy = 6;
		chooseButton.addActionListener(new ChooseListener());
		frame.getContentPane().add(chooseButton, gbc_chooseButton);
		
		moviePanel = new JPanel();
		moviePanel.setLayout(new GridBagLayout());
		setMovieDisplayHome();
		
		JScrollPane movieScrollPane = new JScrollPane(moviePanel);
		movieScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		GridBagConstraints gbc_movieScrollPane = new GridBagConstraints();
		gbc_movieScrollPane.gridwidth = 7;
		gbc_movieScrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_movieScrollPane.fill = GridBagConstraints.BOTH;
		gbc_movieScrollPane.gridx = 1;
		gbc_movieScrollPane.gridy = 7;
		frame.getContentPane().add(movieScrollPane, gbc_movieScrollPane);
				
		JButton homeButton = new JButton("Home");
		homeButton.setBackground(Color.WHITE);
		homeButton.setForeground(Color.BLACK);
		homeButton.setFont(new Font("HelveticaNeue", Font.BOLD, 15));
		homeButton.addActionListener(new HomeListener());
		GridBagConstraints gbc_homeButton = new GridBagConstraints();
		gbc_homeButton.anchor = GridBagConstraints.WEST;
		gbc_homeButton.insets = new Insets(5, 20, 10, 5);
		gbc_homeButton.gridx = 1;
		gbc_homeButton.gridy = 8;
		frame.getContentPane().add(homeButton, gbc_homeButton);
		
		JButton checkoutButton = new JButton("Checkout");
		checkoutButton.setBackground(Color.WHITE);
		checkoutButton.setForeground(Color.BLACK);
		checkoutButton.setFont(new Font("HelveticaNeue", Font.BOLD, 15));
		checkoutButton.addActionListener(new CheckoutListener());
		GridBagConstraints gbc_checkoutButton = new GridBagConstraints();
		gbc_checkoutButton.insets = new Insets(5, 20, 10, 5);
		gbc_checkoutButton.gridx = 6;
		gbc_checkoutButton.gridy = 8;
		frame.getContentPane().add(checkoutButton, gbc_checkoutButton);
		
		JButton newMovieButton = new JButton("New Movie");
		newMovieButton.setBackground(Color.WHITE);
		newMovieButton.setForeground(Color.BLACK);
		newMovieButton.setFont(new Font("HelveticaNeue", Font.BOLD, 15));
		newMovieButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setMovieDisplayAddNew();
			}
		});
		GridBagConstraints gbc_newMovieButton = new GridBagConstraints();
		gbc_newMovieButton.insets = new Insets(5, 20, 10, 5);
		gbc_newMovieButton.gridx = 6;
		gbc_newMovieButton.gridy = 1;
		
		JButton signInButton = new JButton("Sign In");
		signInButton.setBackground(Color.WHITE);
		signInButton.setForeground(Color.BLACK);
		signInButton.setFont(new Font("HelveticaNeue", Font.BOLD, 15));
		signInButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (customer == null) {
					SignInGUI.NewScreen();
					return;
				}
				
				
				
				frame.getContentPane().remove(signInButton);
				
				if (customer.isAdmin())
					frame.getContentPane().add(newMovieButton, gbc_newMovieButton);
				frame.revalidate();
				frame.repaint();
			}
		});
		GridBagConstraints gbc_signInButton = new GridBagConstraints();
		gbc_signInButton.insets = new Insets(5, 20, 10, 5);
		gbc_signInButton.gridx = 6;
		gbc_signInButton.gridy = 1;
		frame.getContentPane().add(signInButton, gbc_signInButton);
	}
	
	public void setMovieDisplayAddNew() {
		moviePanel.removeAll();
		movieComboBox.removeAllItems();
		
		MovieBuilder builder = new MovieBuilder();
		builder.addActionListener(new NewMovieListener());
		
		moviePanel.add(builder);
		
		movieComboBox.revalidate();
		moviePanel.revalidate();
		moviePanel.repaint();
	}
	
	public void setMovieDisplayHome() { //Home movie display with all movie posters
		moviePanel.removeAll();
		movieComboBox.removeAllItems();
		for (Movie movie : movies) {
			JLabel moviePosterLabel = new JLabel();
			moviePosterLabel.setIcon(new ImageIcon(movie.getPoster().getImage().getScaledInstance(264, 396, Image.SCALE_SMOOTH)));
			moviePanel.add(moviePosterLabel);
			movieComboBox.addItem(movie.getTitle());
		}
		movieComboBox.revalidate();
		moviePanel.revalidate();
	}
	
	private void setMovieDisplay(Collection <Movie> displayedMovies) { //Movie display of selected movie
		moviePanel.removeAll();
		movieComboBox.removeAllItems();
		for (Movie movie : displayedMovies) {
			MovieGUI newDisplay = new MovieGUI(movie); 
			newDisplay.addActionListener(new MovieGUIListener());
			JPanel panel = newDisplay.initialize(movie);
			moviePanel.add(panel);
			movieComboBox.addItem(movie.getTitle());
		}
		movieComboBox.revalidate();
		moviePanel.revalidate();
		moviePanel.repaint();
	}

	private void setMovieDisplayCheckout() {
		moviePanel.removeAll();
		movieComboBox.removeAllItems();
		
		CheckoutGUI newDisplay = new CheckoutGUI(); 
		JPanel checkoutPanel = newDisplay.initialize();
		moviePanel.add(checkoutPanel);
		
		movieComboBox.revalidate();
		moviePanel.revalidate();
		moviePanel.repaint();
	}
	
	private class SearchListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			String movieTitleSearch = searchTextField.getText();
			
			LinkedList<Movie> matches = 
					new LinkedList<Movie>(Movie.searchTitles(movies, searchTextField.getText()));
			
			if(matches.isEmpty()) {
				JOptionPane.showMessageDialog(frame, "No results for "+ movieTitleSearch +". Please try again");
			} else {
				setMovieDisplay(matches);
			}
		}
	}
	
	private class SortListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			sortOption = (String) sortComboBox.getSelectedItem();
			Collection<Movie> sortedCollection = movies;
			
			movieComboBox.removeAllItems(); 
			if(sortOption.equals(CARD1)) {
				sortedCollection = Movie.sortByTitle(movies);
			}
			else if(sortOption.equals(CARD2)){
				sortedCollection = Movie.filterGenres(movies, sortOption);
			}
			else if(sortOption.equals(CARD3)){
				sortedCollection = Movie.filterGenres(movies, sortOption);
			}
			else if(sortOption.equals(CARD4)){
				sortedCollection = Movie.filterGenres(movies, sortOption);
			}
			else if(sortOption.equals(CARD5)){
				sortedCollection = Movie.filterGenres(movies, sortOption);
			}
			else if(sortOption.equals(CARD6)){
				sortedCollection = Movie.filterRatings(movies, sortOption);
			}
			else if(sortOption.equals(CARD7)){
				sortedCollection = Movie.filterRatings(movies, sortOption);
			}
			else if(sortOption.equals(CARD8)){
				sortedCollection = Movie.filterRatings(movies, sortOption);
			}
			
			setMovieDisplay(sortedCollection);
		}
	}
	
	private class ChooseListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			chooseOption = (String) movieComboBox.getSelectedItem();
			Collection<Movie> chosenCollection = movies;
			
			chosenCollection = Movie.searchTitles(chosenCollection, chooseOption);
			
			setMovieDisplay(chosenCollection);
		}
	}
	
	private class HomeListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			setMovieDisplayHome();
		}
	}
	
	private class CheckoutListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			CheckoutGUI.ticketString= ""; //resets the string if the user clicks the checkoutbutton again so it doesn't show a movie ticket more than once.
			try {
			Iterator<Ticket> iterator= TheaterAppGUI.customer.getCustomerTickets().iterator();
			while(iterator.hasNext()){
				CheckoutGUI.ticketString += iterator.next().getMovie().getTitle()+"\n";
			}
			setMovieDisplayCheckout();
			}
			catch(NullPointerException e1) {
				JOptionPane.showMessageDialog(frame, "Cannot checkout with an empty cart! Please add tickets.");
			}
		}
	}
	
	public class NewMovieListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();
			JPanel infoPanel = (JPanel) source.getParent();
			MovieBuilder builder = (MovieBuilder) infoPanel.getParent();
			Movie newMovie = builder.getMovie();
			
			if (newMovie != null) {
				movies.add(newMovie);
				try {
					MovieBuilder.writeMovies(movies);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			
				setMovieDisplayHome();
			} else {
				//TODO: Display error somewhere
			}
		}
	}
	
	public class MovieGUIListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel panel = ((JPanel) ((JButton) e.getSource()).getParent());
			String movieTitle = null;
			for (Component comp : panel.getComponents()) {
				if (comp.getName() != null && comp.getName().contentEquals(MovieGUI.MOVIE_TITLE))
					movieTitle = ((JLabel) comp).getText();
			}
			if (movieTitle != null) {
				Movie target = null;
				for (Movie movie : movies) {
					if (movie.getTitle().contentEquals(movieTitle))
						target = movie;
				}
				movies.remove(target);
				MovieBuilder.writeMovies(movies);
				setMovieDisplay(movies);
			}
		}
	}
}
