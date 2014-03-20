package GUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import Model.Room;

import java.awt.event.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Availability extends JFrame implements ActionListener {

	private static String[] columnNames = { "Room Type", "Cost of room",
			"Room number" };
	private String[] nums = { "1", "2", "3", "4" };
	private String[] availableDates = new String[15];
	private JTextField roomNumber;
	private JList availableList;
	private JLabel lblArrivalDate, lblNoOfNights, lblPleaseEnterThe;
	private JButton back, continueb;
	private int numNights;
	private Calendar calDate;
	private String arrivalDate, departureDate;

	public Availability(Calendar dc,int numnights){
		super("Availability of rooms selected");
		getContentPane().setLayout(new BorderLayout(0, 0));
		setSize(575,355);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel dates_selected = new JPanel();
		getContentPane().add(dates_selected, BorderLayout.NORTH);
		dates_selected.setBorder(new TitledBorder("Dates Selected"));
		
		calDate = dc;
		
		numNights = numnights;
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		arrivalDate = dateFormat.format(calDate.getTime());
		
		
		calDate.add(Calendar.DATE, numNights);
		departureDate = (String)(dateFormat.format(calDate.getTime()));
		
		
		 lblArrivalDate = new JLabel("Arrival Date: " + arrivalDate + " - " + departureDate);
		lblArrivalDate.setFont(new Font("SansSerif", Font.PLAIN, 15));
		dates_selected.add(lblArrivalDate);
		
		JLabel filler = new JLabel("              ");
		dates_selected.add(filler);
		
		 lblNoOfNights = new JLabel("No. of Nights: " + numNights);
		lblNoOfNights.setFont(new Font("SansSerif", Font.PLAIN, 15));
		dates_selected.add(lblNoOfNights);
		
		JPanel rooms_available = new JPanel();
		getContentPane().add(rooms_available, BorderLayout.CENTER);
		rooms_available.setBorder(new TitledBorder("Available Rooms"));
		rooms_available.setLayout(null);
		
		availableList = new JList(availableDates);  									//JList of available Rooms
		availableList.setVisibleRowCount(5);											//number of rows 
		availableList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); //allows multiple rows to be selected
		JScrollPane scrollPane = new JScrollPane(availableList);		//adds scrollbar to JList
		scrollPane.setBounds(59, 34, 285, 119);
		rooms_available.add(scrollPane);

		 lblPleaseEnterThe = new JLabel("Please enter the room number of the room you wish to book");
		lblPleaseEnterThe.setBounds(28, 178, 361, 14);
		rooms_available.add(lblPleaseEnterThe);
		
		roomNumber = new JTextField();
		roomNumber.setBounds(410, 175, 86, 20);
		rooms_available.add(roomNumber);
		roomNumber.setColumns(10);
		
		
		
		
		
		JPanel buttons = new JPanel();
		getContentPane().add(buttons, BorderLayout.SOUTH);
		buttons.setLayout(new FlowLayout(FlowLayout.CENTER,200,5));
		
		 back = new JButton("Back");
		 back.addActionListener(this);
		buttons.add(back);
		
		JButton continueb = new JButton("Continue");
		continueb.addActionListener(this);
		buttons.add(continueb);
		
		
	}

	public Availability() {
		// TODO Auto-generated constructor stub
	}

	public boolean loggedIn() {
		return false;
	}

	public void listContent(ArrayList<Room> al) {		//prepares an array of strings for the JList
		for (int i = 0; i < al.size(); i++) {

			availableDates[i] = al.get(i).getRoomNumber() + " "
					+ al.get(i).getRoomType() + " " + al.get(i).getPrice();

		}

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) {

			if (loggedIn() == true) {

				UserScreen u = new UserScreen();
				this.setVisible(false);
				u.setVisible(true);
			}

			else {
				StartScreen s = new StartScreen();
				this.setVisible(false);
				s.setVisible(true);
			}

		} else {
			if (StartScreen.isLoggedIn() == true) {
				CreditCard c = new CreditCard();
				this.setVisible(false);
				c.setVisible(true);
			} else {
				Login l = new Login();
				this.setVisible(false);
				l.setVisible(true);
			}
		}

	}
}
