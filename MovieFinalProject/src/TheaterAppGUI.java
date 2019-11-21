import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class TheaterAppGUI {

	private JFrame frame;
	private static final int WIDTH = 1600;
	private static final int HEIGHT = 1050;
	private static final String CARD1 = "A-Z";
	private static final String CARD2 = "Genre";
	private static final String CARD3 = "MPAA";
	
	private JTextField searchTextField;
	
	private String[] showtimes = {"6:00", "6:30", "7:00", "7:30"};					 //Can adjust showtimes, just have it like this for now
	Movie movie1 = new Movie("JOKER", "Drama", "R", showtimes, new ImageIcon(getClass().getResource("Movie1_Joker.jpg")));
	Movie movie2 = new Movie("Midsommar", "Thriller", "R", showtimes, new ImageIcon(getClass().getResource("Movie2_Midsommar.jpg")));
	Movie movie3 = new Movie("Once Upon a Time in Hollywood", "Drama", "R", showtimes, new ImageIcon(getClass().getResource("Movie3_OnceUpon.jpg")));
	Movie movie4 = new Movie("Lion King", "Adventure", "PG", showtimes, new ImageIcon(getClass().getResource("Movie4_LionKing.jpg")));
	Movie movie5 = new Movie("Avengers: Endgame", "Fantasy", "PG-13", showtimes, new ImageIcon(getClass().getResource("Movie5_Avengers.jpg")));
	
	Movie[] movies = {movie1, movie2, movie3, movie4, movie5};
	
	public Collection<Movie> movieCollection = new LinkedList<Movie>();// We want to use a Collection so we can use the sorting methods
	
	
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
		//adding movies to the collection
		movieCollection.add(movie1);
		movieCollection.add(movie2);
		movieCollection.add(movie3);
		movieCollection.add(movie4);
		movieCollection.add(movie4);
		
		initialize(); 
	}
		
	private void initialize()  {
		frame = new JFrame();
		frame.setTitle("Movie Theater");
		frame.setSize(WIDTH, HEIGHT);
		frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel movieTheaterLabel = new JLabel("MOVIE THEATER");
		movieTheaterLabel.setBackground(Color.WHITE);
		movieTheaterLabel.setFont(new Font("HelveticaNeue", Font.BOLD, 18));
		movieTheaterLabel.setForeground(Color.BLACK);
		GridBagConstraints gbc_movieTheaterLabel = new GridBagConstraints();
		gbc_movieTheaterLabel.insets = new Insets(20, 20, 25, 25);
		gbc_movieTheaterLabel.gridx = 1;
		gbc_movieTheaterLabel.gridy = 1;
		frame.getContentPane().add(movieTheaterLabel, gbc_movieTheaterLabel);
		
		JLabel searchLabel = new JLabel("Search: "); //L
		searchLabel.setBackground(Color.WHITE);
		searchLabel.setFont(new Font("HelveticaNeue", Font.BOLD, 18));
		searchLabel.setForeground(Color.BLACK);
		GridBagConstraints gbc_searchLabel = new GridBagConstraints();
		gbc_searchLabel.anchor = GridBagConstraints.CENTER;
		gbc_searchLabel.insets = new Insets(5, 20, 10, 5);
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
		
		JButton enterButton = new JButton("Enter");//B
		enterButton.setBackground(Color.WHITE);
		enterButton.setForeground(Color.BLACK);
		enterButton.setFont(new Font("HelveticaNeue", Font.BOLD, 15));
		GridBagConstraints gbc_enterButton = new GridBagConstraints();
		gbc_enterButton.anchor = GridBagConstraints.WEST;
		gbc_enterButton.insets = new Insets(10, 10, 10, 10);
		gbc_enterButton.gridx = 3;
		gbc_enterButton.gridy = 2;
		enterButton.addActionListener(new SearchListener()); 	//SearchListener() not implemented
		frame.getContentPane().add(enterButton, gbc_enterButton);
		
		
		JLabel nowShowingLabel = new JLabel("Now Showing:");
		nowShowingLabel.setBackground(Color.WHITE);
		nowShowingLabel.setFont(new Font("HelveticaNeue", Font.BOLD, 18));
		nowShowingLabel.setForeground(Color.BLACK);
		GridBagConstraints gbc_nowShowingLabel = new GridBagConstraints();
		gbc_nowShowingLabel.anchor = GridBagConstraints.CENTER;
		gbc_nowShowingLabel.insets = new Insets(5, 20, 10, 5);
		gbc_nowShowingLabel.gridx = 1;
		gbc_nowShowingLabel.gridy = 3;
		frame.getContentPane().add(nowShowingLabel, gbc_nowShowingLabel); 
		
		JButton movie1Button = new JButton("1");
		movie1Button.setBackground(Color.WHITE);
		movie1Button.setForeground(Color.WHITE);
		ImageIcon movie1Icon = new ImageIcon(new ImageIcon(getClass().getResource("Movie1_Joker.jpg")).getImage().getScaledInstance(264, 396, Image.SCALE_SMOOTH));
		movie1Button.setIcon(movie1Icon);
		movie1Button.setBorder(BorderFactory.createEmptyBorder());
		movie1Button.addActionListener(new MovieListener());
		
		String comboBoxStrings[] = {CARD1, CARD2, CARD3};		//This is combo box for sorting methods, not functional right now
		JComboBox comboBox = new JComboBox(comboBoxStrings);
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Helvetica", Font.ITALIC + Font.BOLD, 15));
		comboBox.setEditable(false);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 3;
		frame.getContentPane().add(comboBox, gbc_comboBox);
		GridBagConstraints gbc_movie1Button = new GridBagConstraints();
		gbc_movie1Button.insets = new Insets(20, 120, 20, 20);
		gbc_movie1Button.gridx = 1;
		gbc_movie1Button.gridy = 6;
		frame.getContentPane().add(movie1Button, gbc_movie1Button);
		
		JButton movie2Button = new JButton("2");
		movie2Button.setBackground(Color.WHITE);
		movie2Button.setForeground(Color.WHITE);
		ImageIcon movie2Icon = new ImageIcon(new ImageIcon(getClass().getResource("Movie2_Midsommar.jpg")).getImage().getScaledInstance(264, 396, Image.SCALE_SMOOTH));
		movie2Button.setIcon(movie2Icon);
		movie2Button.setBorder(BorderFactory.createEmptyBorder());
		movie2Button.addActionListener(new MovieListener());
		GridBagConstraints gbc_movie2Button = new GridBagConstraints();
		gbc_movie2Button.insets = new Insets(20, 20, 20, 20);
		gbc_movie2Button.gridx = 2;
		gbc_movie2Button.gridy = 6;
		frame.getContentPane().add(movie2Button, gbc_movie2Button);
		
		JButton movie3Button = new JButton("3");
		movie3Button.setBackground(Color.WHITE);
		movie3Button.setForeground(Color.WHITE);
		ImageIcon movie3Icon = new ImageIcon(new ImageIcon(getClass().getResource("Movie3_OnceUpon.jpg")).getImage().getScaledInstance(264, 396, Image.SCALE_SMOOTH));
		movie3Button.setIcon(movie3Icon);
		movie3Button.setBorder(BorderFactory.createEmptyBorder());
		movie3Button.addActionListener(new MovieListener());
		GridBagConstraints gbc_movie3Button = new GridBagConstraints();
		gbc_movie3Button.insets = new Insets(20, 20, 20, 20);
		gbc_movie3Button.gridx = 3;
		gbc_movie3Button.gridy = 6;
		frame.getContentPane().add(movie3Button, gbc_movie3Button);
		
		JButton movie4Button = new JButton("4");
		movie4Button.setBackground(Color.WHITE);
		movie4Button.setForeground(Color.WHITE);
		ImageIcon movie4Icon = new ImageIcon(new ImageIcon(getClass().getResource("Movie4_LionKing.jpg")).getImage().getScaledInstance(264, 396, Image.SCALE_SMOOTH));
		movie4Button.setIcon(movie4Icon);
		movie4Button.setBorder(BorderFactory.createEmptyBorder());
		movie4Button.addActionListener(new MovieListener());
		GridBagConstraints gbc_movie4Button = new GridBagConstraints();
		gbc_movie4Button.insets = new Insets(20, 20, 20, 20);
		gbc_movie4Button.gridx = 4;
		gbc_movie4Button.gridy = 6;
		frame.getContentPane().add(movie4Button, gbc_movie4Button);
		
		JButton movie5Button = new JButton("5");
		movie5Button.setBackground(Color.WHITE);
		movie5Button.setForeground(Color.WHITE);
		ImageIcon movie5Icon = new ImageIcon(new ImageIcon(getClass().getResource("Movie5_Avengers.jpg")).getImage().getScaledInstance(264, 396, Image.SCALE_SMOOTH));
		movie5Button.setIcon(movie5Icon);
		movie5Button.setBorder(BorderFactory.createEmptyBorder());
		movie5Button.addActionListener(new MovieListener());
		GridBagConstraints gbc_movie5Button = new GridBagConstraints();
		gbc_movie5Button.insets = new Insets(0, 0, 0, 120);
		gbc_movie5Button.gridx = 5;
		gbc_movie5Button.gridy = 6;
		frame.getContentPane().add(movie5Button, gbc_movie5Button);
		
		JButton checkoutButton = new JButton("Checkout");
		checkoutButton.setBackground(Color.WHITE);
		checkoutButton.setForeground(Color.BLACK);
		checkoutButton.setFont(new Font("HelveticaNeue", Font.BOLD, 15));
		checkoutButton.addActionListener(new CheckoutListener());
		GridBagConstraints gbc_checkoutButton = new GridBagConstraints();
		gbc_checkoutButton.insets = new Insets(5, 20, 10, 5);
		gbc_checkoutButton.gridx = 5;
		gbc_checkoutButton.gridy = 8;
		frame.getContentPane().add(checkoutButton, gbc_checkoutButton);

	}
	
	private class SearchListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			String movieTitleSearch = searchTextField.getText();
			//Search movies based of user input
		}
	}
	
	private class MovieListener implements ActionListener //Send object of Movie as parameter so we can build the correct movie window
	{
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getActionCommand() == "1") {
				MovieGUI newMovieWindow = new MovieGUI(movies[0]);
				newMovieWindow.NewScreen(movies[0]);
			}
			else if(e.getActionCommand() == "2") {
				MovieGUI newMovieWindow = new MovieGUI(movies[1]);
				newMovieWindow.NewScreen(movies[1]);
			}
			else if(e.getActionCommand() == "3") {
				MovieGUI newMovieWindow = new MovieGUI(movies[2]);
				newMovieWindow.NewScreen(movies[2]);
			}
			else if(e.getActionCommand() == "4") {
				MovieGUI newMovieWindow = new MovieGUI(movies[3]);
				newMovieWindow.NewScreen(movies[3]);
			}
			else if(e.getActionCommand() == "5") {
				MovieGUI newMovieWindow = new MovieGUI(movies[4]);
				newMovieWindow.NewScreen(movies[4]);
			}
		}
	}
	
	private class CheckoutListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			CheckoutGUI newCheckoutWindow = new CheckoutGUI();
			newCheckoutWindow.NewScreen();
		}
	}
}
