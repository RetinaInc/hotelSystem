package GUI;
//Gui Imports
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Database.Queries;

public class manageBooking extends JPanel implements ActionListener {
	//Gui Components 
	private JLabel welcome,currentBookings;
	private JButton manageBooking, saveChanges;
	private Object[][] array2d;
	private DefaultTableModel model;
	private JTable table;
	private String usersID;
	private JPanel bookingPanel;
	private ArrayList<Object[]> bookingList;
	
	//Constructor for the tabbed pane class to utilze
	public manageBooking(String usersID){
		
	//Font Set	
		this.usersID = usersID;
	Font font = new Font("Verdana", Font.ITALIC, 20);
	//bookingCont is a container for all the panels elements that will display on the booking tab
	this.setLayout(new BorderLayout());
		this.setSize(1000, 600);

	
	//This bookingPanel contains all of the booking details components such as the List	
		bookingPanel = new JPanel(null);
		bookingPanel.setBounds(150, 300, 640, 300);
		add(bookingPanel);
		JLabel currentBookings = new JLabel("Current Bookings:");
		currentBookings.setFont(font);
		currentBookings.setBounds(70, 170, 650, 100);
		bookingPanel.add(currentBookings);
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 265, 650, 170);
		bookingPanel.add(scrollPane);
		Object[] columnNames = { "Booking ID", "Number of Guests",
				"Number of Rooms", "Total Cost", "Arrival", "Departure"};
		testBookings(usersID);
		model = new DefaultTableModel(array2d, columnNames);

		table = new JTable(model);
		table.setBorder(null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);

		JButton btnEditBooking = new JButton("Edit booking");
		btnEditBooking.setBounds(751, 262, 150, 23);
		bookingPanel.add(btnEditBooking);
		saveChanges = new JButton("Save Changes");
		saveChanges.addActionListener(this);
		saveChanges.setBounds(751, 317, 150, 23);
		bookingPanel.add(saveChanges);

	//add the Booking container
	}
	// gets the users first name using the array of users passed in
		// by matching it against the user id of the user logged in
		public void testBookings(String userSearch) {
			Queries q = new Queries();
			bookingList = new ArrayList<Object[]>(q.getBookings(userSearch));
			array2d = bookingList.toArray(new Object[bookingList.size()][]);
			for (int i = 0; i < array2d.length; i++) {
				System.out.println(array2d[i][0] + " " + array2d[i][1] + " "
						+ array2d[i][2] + " " + array2d[i][3] + " " + array2d[i][4]
						+ " " + array2d[i][5]);
			}

		}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		/** 
		 * Database Query code/Java Method goes here
		 * **/
	}
}