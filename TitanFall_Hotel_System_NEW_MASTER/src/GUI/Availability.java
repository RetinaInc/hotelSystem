package GUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import Database.CreateTables;
import Model.Room;
import Model.User;

import java.awt.event.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Availability extends JFrame implements ActionListener {

	private String[] availableDates = new String[15];
	private JTextField roomNumber;
	private JList availableList;
	private JLabel lblArrivalDate, lblNoOfNights, lblnumRoomsLabel;
	private JButton back, continueb;
	private int numNights,numberOfRooms,numberOfGuests;
	private Calendar calDate;
	private String arrivalDate, departureDate;
	private JTextField totalCostField;
	private double total;
	private String user;
	private ArrayList<User> users;

	public Availability(Calendar dc,int numnights, int numRooms,int numGuests){
		calDate = dc;
		numNights = numnights;
		numberOfRooms = numRooms;
		numberOfGuests = numGuests;
		createAvailabilityScreen();
		
	}
	
	public Availability(String userID,ArrayList<User> users,Calendar dc,int numnights, int numRooms,int numGuests){
		calDate = dc;
		numNights = numnights;
		numberOfRooms = numRooms;
		numberOfGuests = numGuests;
		user = userID;
		this.users = users;
		createAvailabilityScreen();
	}

	public void createAvailabilityScreen(){
		setTitle("Availability of rooms selected");
		getContentPane().setLayout(new BorderLayout(0, 0));
		setSize(575,355);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel dates_selected = new JPanel();
		getContentPane().add(dates_selected, BorderLayout.NORTH);
		dates_selected.setBorder(new TitledBorder("Dates Selected"));
		
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
		MouseListener mouseListener = new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        if (e.getClickCount() == 1) {
		           String selectedItem = (String) availableList.getSelectedValue();
		           System.out.println(selectedItem); 
		           if(((String) availableList.getSelectedValue()).contains("Single")){
		        	   Double price = (59.00 * numNights);
		        	   totalCostField.setText(price.toString());
		           }
		           else if(((String) availableList.getSelectedValue()).contains("Double")){
		        	   Double price = (99.00 * numNights);
		        	   totalCostField.setText(price.toString());
		           }
		           else
		           {
		        	   Double price = (199.00 * numNights);
		        	   totalCostField.setText(price.toString());
		           }
		         }
		    }
		};
		availableList.addMouseListener(mouseListener);
		availableList.setVisibleRowCount(5);											//number of rows 
		availableList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); //allows multiple rows to be selected
		JScrollPane scrollPane = new JScrollPane(availableList);						//adds scrollbar to JList
		scrollPane.setBounds(59, 34, 285, 119);
		rooms_available.add(scrollPane);

		 lblnumRoomsLabel = new JLabel("Number of rooms:");
		 lblnumRoomsLabel.setBounds(358, 37, 117, 14);
		rooms_available.add(lblnumRoomsLabel);
		
		roomNumber = new JTextField();
		roomNumber.setText("" + numberOfRooms);
		roomNumber.setBounds(477, 34, 36, 20);
		roomNumber.setEditable(false);
		rooms_available.add(roomNumber);
		roomNumber.setColumns(10);
		
		JLabel lblTotalCost = new JLabel("Total Cost : ");
		lblTotalCost.setBounds(356, 64, 81, 16);
		rooms_available.add(lblTotalCost);
		
		totalCostField= new JTextField();
		totalCostField.setEditable(false);
		totalCostField.setBounds(429, 64, 84, 22);
		rooms_available.add(totalCostField);
		totalCostField.setColumns(10);
		
		JPanel buttons = new JPanel();
		getContentPane().add(buttons, BorderLayout.SOUTH);
		buttons.setLayout(new FlowLayout(FlowLayout.CENTER,200,5));
		
		 back = new JButton("Back");
		 back.addActionListener(this);
		buttons.add(back);
		
		continueb = new JButton("Continue");
		continueb.addActionListener(this);
		buttons.add(continueb);
	}

	public void listContent(ArrayList<Room> al) {		//prepares an array of strings for the JList
		for (int i = 0; i < al.size(); i++) {
			
			availableDates[i] = al.get(i).getRoomNumber() + " " + al.get(i).getRoomType() + " " + al.get(i).getPrice();
			
		}
	}
	public void actionPerformed(ActionEvent e) {
		total = Double.parseDouble(totalCostField.getText());
		
		if (e.getSource() == back) {

			if (StartScreen.isLoggedIn() == true) {

				UserScreen u = new UserScreen(user, users);
				this.setVisible(false);
				u.setVisible(true);
			}

			else {
				StartScreen s = new StartScreen();
				this.setVisible(false);
				s.setVisible(true);
			}

		} 
		else {
			if (StartScreen.isLoggedIn() == true) {
				CreditCard c = new CreditCard(calDate,user,users,total, numberOfRooms,numNights,numberOfGuests,arrivalDate,departureDate);
				this.setVisible(false);
				c.setVisible(true);
			} 
			else {
				Login l = new Login(calDate,total,numberOfRooms,numNights,numberOfGuests,arrivalDate,departureDate);
				this.setVisible(false);
				l.setVisible(true);
			}
		}

	}
}
