/**
 * Definition for class to build movie information GUI.
 * 
 * @authors Khalid Ahmed, Lana Berge, Ian Flickinger
 * Assignment: Final Project
 * Due Date: December 10, 2019
 * Class: CSCI 2082.01
 */

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;


import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JPanel;

public class MovieGUI {
	public static final String MOVIE_TITLE = "movie title";
	public ButtonGroup showtimeButtons;
	public JComboBox<String> seatsComboBox;
	public Movie selectedMovie;
	public AbstractButton button;
	public boolean selected;
	private ActionListener actionListener;
	private JFrame frame;
	
	public static void NewScreen(Movie movie) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieGUI window = new MovieGUI(movie);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void addActionListener(ActionListener l) {
		actionListener = l;
	}

	public MovieGUI(Movie movie) {
		selectedMovie = movie;
	}

	public JPanel initialize(Movie movie) {
		JPanel panel = new JPanel(new GridBagLayout());
		JPanel posterPanel = new JPanel();
		GridBagConstraints gbc_posterPanel = new GridBagConstraints();
		gbc_posterPanel.insets = new Insets(20, 20, 20, 20);
		gbc_posterPanel.gridx = 0;
		gbc_posterPanel.gridy = 1;
		gbc_posterPanel.gridheight = 2;
		gbc_posterPanel.fill = GridBagConstraints.VERTICAL;
		panel.add(posterPanel, gbc_posterPanel);
		
		JLabel movieLabel = new JLabel();
		movieLabel.setBorder(BorderFactory.createEmptyBorder());
		ImageIcon movieIcon = movie.getPoster();
		ImageIcon formatIcon = new ImageIcon(movieIcon.getImage().getScaledInstance(382, 576, Image.SCALE_SMOOTH));
		movieLabel.setIcon(formatIcon);
		GridBagConstraints gbc_movieButton = new GridBagConstraints();
		gbc_movieButton.insets = new Insets(50, 50, 50, 50);
		posterPanel.add(movieLabel);
		
		JPanel infoPanel = new JPanel();
		GridBagConstraints gbc_infoPanel = new GridBagConstraints();
		gbc_infoPanel.insets = new Insets(0, 0, 5, 5);
		gbc_infoPanel.fill = GridBagConstraints.BOTH;
		gbc_infoPanel.gridx = 2;
		gbc_infoPanel.gridy = 1;
		panel.add(infoPanel, gbc_infoPanel);
		GridBagLayout gbl_infoPanel = new GridBagLayout();
		gbl_infoPanel.columnWidths = new int[]{175, 66, 66, 66, 66, 92, 47, 47, 47, 0};
		gbl_infoPanel.rowHeights = new int[]{39, 23, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_infoPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_infoPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		infoPanel.setLayout(gbl_infoPanel);
		
		JLabel movieTitleLabel = new JLabel(movie.getTitle());
		movieTitleLabel.setName(MOVIE_TITLE);
		ImageIcon movieTitleIcon = new ImageIcon("movie-data/MovieTitle_Icon.png");
		movieTitleLabel.setIcon(movieTitleIcon);
		//Icon made by [https://www.flaticon.com/authors/freepik] from www.flaticon.com
		GridBagConstraints gbc_movieTitleLabel = new GridBagConstraints();
		gbc_movieTitleLabel.anchor = GridBagConstraints.WEST;
		gbc_movieTitleLabel.insets = new Insets(0, 0, 5, 5);
		gbc_movieTitleLabel.gridx = 0;
		gbc_movieTitleLabel.gridy = 1;
		gbc_movieTitleLabel.gridwidth = 5;
		gbc_movieTitleLabel.fill = GridBagConstraints.HORIZONTAL;
		infoPanel.add(movieTitleLabel, gbc_movieTitleLabel);
		movieTitleLabel.setBackground(Color.WHITE);
		movieTitleLabel.setFont(new Font("HelveticaNeue", Font.BOLD, 45));
		movieTitleLabel.setForeground(Color.BLACK);
		
		JLabel priceLabel = new JLabel("Price: $" + String.format("%2.2f", movie.getPrice()));
		GridBagConstraints gbc_priceLabel = new GridBagConstraints();
		gbc_priceLabel.anchor = GridBagConstraints.WEST;
		gbc_priceLabel.gridx = 0;
		gbc_priceLabel.gridy = 2;
		infoPanel.add(priceLabel, gbc_priceLabel);
		priceLabel.setBackground(Color.WHITE);
		priceLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 18));
		priceLabel.setForeground(Color.BLACK);
		
		String movieGenres = "";
		for (String genre : movie.getGenres()) {
			movieGenres += genre + ", ";
		}
		JLabel movieGenreLabel = new JLabel("Genres: " + movieGenres.substring(0, movieGenres.length() - 2));
		GridBagConstraints gbc_movieGenreLabel = new GridBagConstraints();
		gbc_movieGenreLabel.anchor = GridBagConstraints.WEST;
		gbc_movieGenreLabel.insets = new Insets(0, 0, 5, 5);
		gbc_movieGenreLabel.gridx = 0;
		gbc_movieGenreLabel.gridy = 3;
		infoPanel.add(movieGenreLabel, gbc_movieGenreLabel);
		movieGenreLabel.setBackground(Color.WHITE);
		movieGenreLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 18));
		movieGenreLabel.setForeground(Color.BLACK);
		
		JLabel movieMPAALabel = new JLabel("MPAA Rating: " + movie.getMpaaRating());
		GridBagConstraints gbc_movieMPAALabel = new GridBagConstraints();
		gbc_movieMPAALabel.anchor = GridBagConstraints.WEST;
		gbc_movieMPAALabel.insets = new Insets(0, 0, 5, 5);
		gbc_movieMPAALabel.gridx = 0;
		gbc_movieMPAALabel.gridy = 4;
		infoPanel.add(movieMPAALabel, gbc_movieMPAALabel);
		movieMPAALabel.setBackground(Color.WHITE);
		movieMPAALabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 18));
		movieMPAALabel.setForeground(Color.BLACK);
		
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
		
		showtimeButtons = new ButtonGroup();
		for (int i = 0; i < movie.getShowTimes().length; i++) {
			JRadioButton showtimesButton = new JRadioButton(movie.getShowTimes()[i]);    
			GridBagConstraints gbc_showtimesButton = new GridBagConstraints();
			gbc_showtimesButton.anchor = GridBagConstraints.WEST;
			gbc_showtimesButton.insets = new Insets(0, 0, 5, 5);
			gbc_showtimesButton.gridx = i + 1;
			gbc_showtimesButton.gridy = 5;
			infoPanel.add(showtimesButton, gbc_showtimesButton);
			showtimesButton.setForeground(Color.BLACK);
			showtimeButtons.add(showtimesButton);
		}
	
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
		
		Movie.Seat[][] seats = movie.getSeats();
		String[] seatNames = new String[seats.length * seats[0].length];
		for (int row = 0; row < seats.length; row++) {
			for (int col = 0; col < seats[0].length; col++) {
				if (!seats[row][col].isTaken()[0])
					seatNames[row * seats[0].length + col] = seats[row][col].getSeatName();
			}
		}
		seatsComboBox = new JComboBox<String>(seatNames);
		GridBagConstraints gbc_seatsComboBox = new GridBagConstraints();
		gbc_seatsComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_seatsComboBox.anchor = GridBagConstraints.WEST;
		gbc_seatsComboBox.gridx = 1;
		gbc_seatsComboBox.gridy = 6;
		infoPanel.add(seatsComboBox, gbc_seatsComboBox);
		seatsComboBox.setBackground(Color.WHITE);
		seatsComboBox.setFont(new Font("Helvetica", Font.ITALIC + Font.BOLD, 15));
		seatsComboBox.setEditable(false);
		
		JButton cartButton = new JButton("Add to Cart");
		cartButton.setBackground(Color.WHITE);
		cartButton.setForeground(Color.BLACK);
		cartButton.setFont(new Font("HelveticaNeue", Font.BOLD, 15));
		ImageIcon ticketsIcon = new ImageIcon("movie-data/Tickets_Icon.png");
		cartButton.setIcon(ticketsIcon);
		//Icon made by [https://www.flaticon.com/authors/dimi-kazak] from www.flaticon.com
		cartButton.addActionListener(new CartListener());
		GridBagConstraints gbc_cartButton = new GridBagConstraints();
		gbc_cartButton.insets = new Insets(250, 20, 20, 5);
		gbc_cartButton.gridx = 6;
		gbc_cartButton.gridy = 15;
		infoPanel.add(cartButton, gbc_cartButton);
		
		JButton removeButton = new JButton("Remove Movie");
		removeButton.setBackground(Color.WHITE);
		removeButton.setForeground(Color.BLACK);
		removeButton.setFont(new Font("HelveticaNeue", Font.BOLD, 15));
		removeButton.addActionListener(actionListener);
		GridBagConstraints gbc_removeButton = new GridBagConstraints();
		gbc_removeButton.insets = new Insets(250, 20, 20, 5);
		gbc_removeButton.gridx = 0;
		gbc_removeButton.gridy = 15;
		gbc_removeButton.gridwidth = 2;
		if (TheaterAppGUI.customer != null && TheaterAppGUI.customer.isAdmin())
			infoPanel.add(removeButton, gbc_removeButton);
		
		return panel;
	}
	 
	private class CartListener implements ActionListener
	{
		ImageIcon errorIcon = new ImageIcon("movie-data/Error_Icon.png");
		//Icon made by [https://www.flaticon.com/authors/roundicons] from www.flaticon.com
		ImageIcon successIcon = new ImageIcon("movie-data/Success_Icon.png");
		//Icon made by [https://www.flaticon.com/authors/roundicons] from www.flaticon.com
		public void actionPerformed(ActionEvent e) {
			if(TheaterAppGUI.customer == null) {
				SignInGUI.NewScreen();
			}
			else {
			Date movieTime = null;
			DateFormat dateformat=new SimpleDateFormat("H:mm a");
			String selectedShowTime;
			String seat = (String) seatsComboBox.getSelectedItem();
	        if(seat==null || seat.equals("")) {
	        	JOptionPane.showMessageDialog(frame, "Invalid seat");
	        }
	        else {
				double price= selectedMovie.getPrice();
				
		        for (Enumeration<AbstractButton> buttons = showtimeButtons.getElements(); buttons.hasMoreElements();) {
		        	button = buttons.nextElement();
		
		            if (button.isSelected()) {
		            	
		            	selected = true;
		            	selectedShowTime = button.getText();
		            	
		            	try {
							movieTime = dateformat.parse(selectedShowTime);
							for (Movie.Seat[] movieSeats : selectedMovie.getSeats()) {
								for (Movie.Seat movieSeat : movieSeats) {
									if (movieSeat.getSeatName().contentEquals(seat))
										movieSeat.isTaken()[0] = true;
								}
							}
					      
									
						} catch (ParseException e1) 
		            	{
							e1.printStackTrace();
						}
		            }
		        }
				if(selected != true) {
					JOptionPane.showMessageDialog(frame, "Choose a showtime and try again.", "Add Showtime", JOptionPane.PLAIN_MESSAGE, errorIcon);
				} else { 
					TheaterAppGUI.customer.setBalance(TheaterAppGUI.customer.getBalance()-price);
					Ticket newTicket= new Ticket(seat,selectedMovie,price, movieTime);
					//adding is here
					TheaterAppGUI.customer.getCustomerTickets().add(newTicket); //maybe will add an equals method to the customer class that checks if there is a similar ticket within their ticket collection
					JOptionPane.showMessageDialog(frame, "Ticket was successfully added to cart!", "Ticket Success", JOptionPane.PLAIN_MESSAGE, successIcon);
				}
			}
			}
		}
	}

}