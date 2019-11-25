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

	public static boolean accountCreated=false;
	public ButtonGroup showtimesButtons = new ButtonGroup();
	public JComboBox seatsComboBox;
	public Movie selectedMovie;
	public AbstractButton button;
	public boolean selected;
	
	
	private JFrame frame;
	private String seats [] = {"1A", "1B", "1C","1D", "2A", "2B", "2C", "2D", "3A",
								"3B", "3C",	"3D", "4A",	"4B", "4C", "4D", "5A", "5B", "5C", "5D", "6A",			//Possibly store in Movie class? making seats another attribute to a Movie
								"6B", "6C", "6D", "7A", "7B", "7C", "7D"};
	
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

	public MovieGUI(Movie movie) {
		selectedMovie=movie;
		initialize(movie);
	}

	private void initialize(Movie movie) {
		frame = new JFrame();
		frame.setTitle(movie.getTitle());
		frame.setBounds(100, 100, 1447, 774);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel posterPanel = new JPanel();
		GridBagConstraints gbc_posterPanel = new GridBagConstraints();
		gbc_posterPanel.insets = new Insets(20, 20, 20, 20);
		gbc_posterPanel.gridx = 0;
		gbc_posterPanel.gridy = 1;
		gbc_posterPanel.gridheight = 2;
		gbc_posterPanel.fill = GridBagConstraints.VERTICAL;
		frame.getContentPane().add(posterPanel, gbc_posterPanel);
		
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
		frame.getContentPane().add(infoPanel, gbc_infoPanel);
		GridBagLayout gbl_infoPanel = new GridBagLayout();
		gbl_infoPanel.columnWidths = new int[]{175, 66, 66, 66, 66, 92, 47, 47, 47, 0};
		gbl_infoPanel.rowHeights = new int[]{39, 23, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_infoPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_infoPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		infoPanel.setLayout(gbl_infoPanel);
		
		
		JLabel movieTitleLabel = new JLabel(movie.getTitle());
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
		
		JLabel movieGenreLabel = new JLabel("Genre: " + movie.getGenre());
		GridBagConstraints gbc_movieGenreLabel = new GridBagConstraints();
		gbc_movieGenreLabel.anchor = GridBagConstraints.WEST;
		gbc_movieGenreLabel.insets = new Insets(0, 0, 5, 5);
		gbc_movieGenreLabel.gridx = 0;
		gbc_movieGenreLabel.gridy = 4;
		infoPanel.add(movieGenreLabel, gbc_movieGenreLabel);
		movieGenreLabel.setBackground(Color.WHITE);
		movieGenreLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 18));
		movieGenreLabel.setForeground(Color.BLACK);
		
		JLabel movieMPAALabel = new JLabel("MPAA Rating: " + movie.getMpaaRating());
		GridBagConstraints gbc_movieMPAALabel = new GridBagConstraints();
		gbc_movieMPAALabel.anchor = GridBagConstraints.WEST;
		gbc_movieMPAALabel.insets = new Insets(0, 0, 5, 5);
		gbc_movieMPAALabel.gridx = 0;
		gbc_movieMPAALabel.gridy = 5;
		infoPanel.add(movieMPAALabel, gbc_movieMPAALabel);
		movieMPAALabel.setBackground(Color.WHITE);
		movieMPAALabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 18));
		movieMPAALabel.setForeground(Color.BLACK);
		
		JLabel showtimesLabel = new JLabel("Showtimes:");
		GridBagConstraints gbc_showtimesLabel = new GridBagConstraints();
		gbc_showtimesLabel.anchor = GridBagConstraints.WEST;
		gbc_showtimesLabel.insets = new Insets(0, 0, 5, 5);
		gbc_showtimesLabel.gridx = 0;
		gbc_showtimesLabel.gridy = 6;
		infoPanel.add(showtimesLabel, gbc_showtimesLabel);
		showtimesLabel.setBackground(Color.WHITE);
		showtimesLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 18));
		showtimesLabel.setForeground(Color.BLACK);
		
		JRadioButton showtimes1Button = new JRadioButton("6:00 PM");    //Showtime radio buttons would then need an action listener
		GridBagConstraints gbc_showtimes1Button = new GridBagConstraints();
		gbc_showtimes1Button.anchor = GridBagConstraints.WEST;
		gbc_showtimes1Button.insets = new Insets(0, 0, 5, 5);
		gbc_showtimes1Button.gridx = 1;
		gbc_showtimes1Button.gridy = 6;
		infoPanel.add(showtimes1Button, gbc_showtimes1Button);
		showtimes1Button.setForeground(Color.BLACK);
		showtimesButtons.add(showtimes1Button);
		
		JRadioButton showtimes2Button = new JRadioButton("6:30 PM");
		GridBagConstraints gbc_showtimes2Button = new GridBagConstraints();
		gbc_showtimes2Button.anchor = GridBagConstraints.WEST;
		gbc_showtimes2Button.insets = new Insets(0, 0, 5, 5);
		gbc_showtimes2Button.gridx = 2;
		gbc_showtimes2Button.gridy = 6;
		infoPanel.add(showtimes2Button, gbc_showtimes2Button);
		showtimes2Button.setForeground(Color.BLACK);
		showtimesButtons.add(showtimes2Button);
		
		JRadioButton showtimes3Button = new JRadioButton("7:00 PM");
		GridBagConstraints gbc_showtimes3Button = new GridBagConstraints();
		gbc_showtimes3Button.anchor = GridBagConstraints.WEST;
		gbc_showtimes3Button.insets = new Insets(0, 0, 5, 5);
		gbc_showtimes3Button.gridx = 3;
		gbc_showtimes3Button.gridy = 6;
		infoPanel.add(showtimes3Button, gbc_showtimes3Button);
		showtimes3Button.setForeground(Color.BLACK);
		showtimesButtons.add(showtimes3Button);
		
		JRadioButton showtimes4Button = new JRadioButton("7:30 PM");
		GridBagConstraints gbc_showtimes4Button = new GridBagConstraints();
		gbc_showtimes4Button.anchor = GridBagConstraints.NORTHWEST;
		gbc_showtimes4Button.insets = new Insets(0, 0, 5, 5);
		gbc_showtimes4Button.gridx = 4;
		gbc_showtimes4Button.gridy = 6;
		infoPanel.add(showtimes4Button, gbc_showtimes4Button);
		showtimes4Button.setForeground(Color.BLACK);
		showtimesButtons.add(showtimes4Button);
		
		JLabel seatsLabel = new JLabel("Seats:");
		GridBagConstraints gbc_seatsLabel = new GridBagConstraints();
		gbc_seatsLabel.anchor = GridBagConstraints.WEST;
		gbc_seatsLabel.insets = new Insets(0, 0, 5, 5);
		gbc_seatsLabel.gridx = 0;
		gbc_seatsLabel.gridy = 7;
		infoPanel.add(seatsLabel, gbc_seatsLabel);
		seatsLabel.setBackground(Color.WHITE);
		seatsLabel.setFont(new Font("HelveticaNeue", Font.PLAIN, 18));
		seatsLabel.setForeground(Color.BLACK);
		
		seatsComboBox = new JComboBox(seats);
		GridBagConstraints gbc_seatsComboBox = new GridBagConstraints();
		gbc_seatsComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_seatsComboBox.insets = new Insets(0, 0, 0, 5);
		gbc_seatsComboBox.gridx = 0;
		gbc_seatsComboBox.gridy = 8;
		infoPanel.add(seatsComboBox, gbc_seatsComboBox);
		seatsComboBox.setBackground(Color.WHITE);
		seatsComboBox.setFont(new Font("Helvetica", Font.ITALIC + Font.BOLD, 15));
		seatsComboBox.setEditable(false);
		
		JButton homeButton = new JButton("Home");
		homeButton.setBackground(Color.WHITE);
		homeButton.setForeground(Color.BLACK);
		homeButton.setFont(new Font("HelveticaNeue", Font.BOLD, 15));
		homeButton.addActionListener(new HomeListener());
		GridBagConstraints gbc_homeButton = new GridBagConstraints();
		gbc_homeButton.anchor = GridBagConstraints.WEST;
		gbc_homeButton.insets = new Insets(0, 20, 20, 5);
		gbc_homeButton.gridx = 0;
		gbc_homeButton.gridy = 7;
		frame.getContentPane().add(homeButton, gbc_homeButton);
		
		JButton cartButton = new JButton("Add to Cart");
		cartButton.setBackground(Color.WHITE);
		cartButton.setForeground(Color.BLACK);
		cartButton.setFont(new Font("HelveticaNeue", Font.BOLD, 15));
		cartButton.addActionListener(new CartListener());
		GridBagConstraints gbc_cartButton = new GridBagConstraints();
		gbc_cartButton.insets = new Insets(0, 0, 20, 20);
		gbc_cartButton.gridx = 10;
		gbc_cartButton.gridy = 7;
		frame.getContentPane().add(cartButton, gbc_cartButton);
		
	}
	
	private class HomeListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			frame.dispose();
		}
	}
	 
	private class CartListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			Date movieTime=null;
			DateFormat dateformat;
			String selectedShowTime;
			String seat= (String)seatsComboBox.getSelectedItem();
			Double price= selectedMovie.getPrice();
			
	        for (Enumeration<AbstractButton> buttons = showtimesButtons.getElements(); buttons.hasMoreElements();) {
	        	button = buttons.nextElement();

	            if (button.isSelected()) {
	            	 
	            	selected=true;
	            	selectedShowTime = button.getText();
	            	dateformat = new SimpleDateFormat("hh:mm a");
	            	
	            	try {
						movieTime= dateformat.parse(selectedShowTime);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
	            	
	            }
	        }
	        
			if(accountCreated==false)
			{
				SignInGUI newSignUpWindow = new SignInGUI();
				newSignUpWindow.NewScreen();
			}
			else if(selected!=true) {
				JOptionPane.showMessageDialog(frame, "Choose a time and try again.");
			}
			else
			{
				TheaterAppGUI.customer.setBalance(TheaterAppGUI.customer.getBalance()-price);
				Ticket newTicket= new Ticket(seat,selectedMovie,price, movieTime);
				TheaterAppGUI.customer.getCustomerTickets().add(newTicket); //maybe will add an equals method to the customer class that checks if there is a similar ticket within their ticket collection
				JOptionPane.showMessageDialog(frame, "Ticket was successfully added to cart!");

			}
		}
	}

}
