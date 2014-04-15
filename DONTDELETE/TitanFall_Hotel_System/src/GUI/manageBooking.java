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

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Database.Queries;
import Database.ReportQueries;

public class manageBooking extends JPanel implements ActionListener {
	//Gui Components 
	private JLabel welcome,currentBookings;
	private JButton manageBooking, saveChanges,saveReceipt,addSpecial;
	private Object[][] array2d;
	private DefaultTableModel model;
	private JTable table;
	private String usersID;
	private JPanel bookingPanel;
	private ArrayList<Object[]> bookingList;
	private Color color = new Color(227,99,26);
	
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
		 currentBookings = new JLabel("Current Bookings:");
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
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);

		JButton editBooking = new JButton("Edit booking");
		editBooking.setBackground(color);
		editBooking.setBounds(751, 252, 150, 23);
		bookingPanel.add(editBooking);
		saveChanges = new JButton("Save Changes");
		saveChanges.setBackground(color);
		saveChanges.addActionListener(this);
		saveChanges.setBounds(751, 307, 150, 23);
		bookingPanel.add(saveChanges);
		
		saveReceipt = new JButton("Save Receipt");
		saveReceipt.addActionListener(this);
		saveReceipt.setToolTipText("Save selected booking to a file");
		saveReceipt.setBackground(color);
		saveReceipt.setBounds(751, 362, 150, 23);
		bookingPanel.add(saveReceipt);
		
		addSpecial = new JButton("Add Specials");
		addSpecial.addActionListener(this);
		addSpecial.setToolTipText("Add a special to a specific booking");
		addSpecial.setBackground(color);
		addSpecial.setBounds(751, 412, 150, 23);
		bookingPanel.add(addSpecial);

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
		/** 
		 * Database Query code/Java Method goes here
		 * **/
		//code used to save the receipt of a selected booking
		if(ae.getSource() == saveReceipt){
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
		
		else if(ae.getSource() == addSpecial){
			try
			{
			//get the number of row the user selects 
			int row = table.getSelectedRow();
			//column is always set to zero because we are looking for the booking id
			int bookingid = Integer.parseInt(table.getValueAt(row, 0).toString());
			
			specials s = new specials(usersID,bookingid);
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
	}
}