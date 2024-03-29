package GUI;
//Gui Imports
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Database.Queries;
import Database.ReportQueries;
import Database.manageBookingOperations;

public class ManageBookingGUI extends JPanel implements ActionListener {
	//Gui Components 
	private JLabel currentBookings;
	private JButton editBooking, saveChanges,saveReceipt,addSpecial;
	private Object[][] array2d;
	private DefaultTableModel model;
	private JTable table;
	private String usersID;
	private JPanel bookingPanel;
	private ArrayList<Object[]> bookingList;
	private Color color = new Color(227,99,26);
	
	//Constructor for the tabbed pane class to utilze
	public ManageBookingGUI(String usersID){
		
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
		 currentBookings = new JLabel("Current Bookings:");
		currentBookings.setFont(font);
		currentBookings.setBounds(70, 170, 650, 100);
		bookingPanel.add(currentBookings);
	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 265, 750, 170);
		bookingPanel.add(scrollPane);
		Object[] columnNames = { "Booking ID", "Number of Guests",
				"Number of Rooms","Number of Nights", "Total Cost", "Arrival", "Departure"};
		testBookings(usersID);
		model = new DefaultTableModel(array2d, columnNames);

		table = new JTable(model);
		table.getTableHeader().setBackground(color);
		table.setBorder(null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);

		editBooking = new JButton("Edit booking");
		editBooking.setBackground(color);
		editBooking.addActionListener(this);
		editBooking.setBounds(810, 265, 150, 23);
		bookingPanel.add(editBooking);
		saveChanges = new JButton("Save Changes");
		saveChanges.setBackground(color);
		saveChanges.addActionListener(this);
		saveChanges.setBounds(810, 315, 150, 23);
		bookingPanel.add(saveChanges);
		
		saveReceipt = new JButton("Save Receipt");
		saveReceipt.addActionListener(this);
		saveReceipt.setToolTipText("Save selected booking to a file");
		saveReceipt.setBackground(color);
		saveReceipt.setBounds(810, 365, 150, 23);
		bookingPanel.add(saveReceipt);
		
		addSpecial = new JButton("Add Specials");
		addSpecial.addActionListener(this);
		addSpecial.setToolTipText("Add a special to a specific booking");
		addSpecial.setBackground(color);
		addSpecial.setBounds(810, 412, 150, 23);
		bookingPanel.add(addSpecial);

	//add the Booking container
	}
	// gets the users first name using the array of users passed in
		// by matching it against the user id of the user logged in
		public void testBookings(String userSearch) {
			manageBookingOperations m = new manageBookingOperations();
			bookingList = new ArrayList<Object[]>(m.getBookings(userSearch));
			array2d = bookingList.toArray(new Object[bookingList.size()][]);
//			for (int i = 0; i < array2d.length; i++) {
//				System.out.println(array2d[i][0] + " " + array2d[i][1] + " "
//						+ array2d[i][2] + " " + array2d[i][3] + " " + array2d[i][4]
//						+ " " + array2d[i][5] + " " +array2d[i][6]);
//			}
		}

	@Override
	public void actionPerformed(ActionEvent ae) {
		/** 
		 * Database Query code/Java Method goes here
		 * **/
		//code used to save the receipt of a selected booking
		if(ae.getSource() == saveReceipt){
			try
			{
			//get the number of row the user selects 
			int row = table.getSelectedRow();
			//column is always set to zero because we are looking for the booking id
			int id = Integer.parseInt(table.getValueAt(row, 0).toString());

			JFileChooser f = new JFileChooser();
			int returnVal = f.showSaveDialog(this);
			
			 if (returnVal == JFileChooser.APPROVE_OPTION) {
		            try {
		                BufferedWriter fw = new BufferedWriter(new FileWriter(f.getSelectedFile()+".txt"));
		                ReportQueries q = new ReportQueries();
		                fw.write(q.usersReceipt(id));
		                fw.close();
		            } catch (Exception ex) {
		                ex.printStackTrace();
		            }
			 }
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, "Please select a booking you wish to save a receipt on","Save receipt",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		else if(ae.getSource() == addSpecial){
			try
			{
			//get the number of row the user selects 
			int row = table.getSelectedRow();
			//column is always set to zero because we are looking for the booking id
			int bookingid = Integer.parseInt(table.getValueAt(row, 0).toString());
			
			SpecialsGUI s = new SpecialsGUI(usersID,bookingid);
			bookingPanel.setVisible(false);
			s.setVisible(true);
			s.setBounds(150, 300, 640, 300);
			add(s);
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, "Please select a booking you want to add a special to","Add special",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if(ae.getSource() == editBooking){
			try
			{
			//get the number of row the user selects 
			int row = table.getSelectedRow();
			//column is always set to zero because we are looking for the booking id
			int bookingid = Integer.parseInt(table.getValueAt(row, 0).toString());
			
			EditBookingGUI e = new EditBookingGUI(usersID, bookingid, (int) array2d[row][1],(int)array2d[row][2], (int) array2d[row][3] ,(double) array2d[row][4],(Date) array2d[row][5],(Date) array2d[row][6]);
			bookingPanel.setVisible(false);
			e.setVisible(true);
			e.setBounds(150, 300, 640, 300);
			add(e);
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Please select a booking you wish to edit","Edit Booking",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}