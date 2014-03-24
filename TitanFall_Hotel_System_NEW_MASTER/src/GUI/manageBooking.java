package GUI;
//Gui Imports
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class manageBooking extends JPanel implements ActionListener {
	//Gui Components 
	private JLabel welcome,currentBookings;
	private JList bookingList;
	private JButton manageBooking, saveChanges;
	
	//Constructor for the tabbed pane class to utilze
	public manageBooking(){
	//Font Set	
	Font font = new Font("Verdana", Font.ITALIC, 20);
	//bookingCont is a container for all the panels elements that will display on the booking tab
	JPanel bookingCont = new JPanel(new BorderLayout());
	
	//panel to hold the the Titanfall Towers Hotel Text
	/** 
	 * Logo to be placed in the panel below 
	 * When Designed
	 * **/
	JPanel title = new JPanel(new FlowLayout());
	
		welcome = new JLabel("TitanFall Towers Hotel");
		welcome.setFont(font);
		title.add(welcome);
		bookingCont.add(title,BorderLayout.NORTH);
	
	//This bookingPanel contains all of the booking details components such as the List	
	JPanel bookingPanel = new JPanel(new FlowLayout());
		
		currentBookings = new JLabel("Current Bookings: ");
		currentBookings.setFont(font);
		bookingPanel.add(currentBookings);
	
		//Jlist sample data to be replaced with database results
		String[] bookings ={"Booking id:        Date:         ",
				"Booking id:        Date:         ","Booking id:        Date:         ","Booking id:        Date:         ","Booking id:        Date:         ",
				"Booking id:        Date:         ","Booking id:        Date:         ","Booking id:        Date:         ","Booking id:        Date:         ",
				"Booking id:        Date:         ","Booking id:        Date:         ","Booking id:        Date:         ","Booking id:        Date:         ",
				"Booking id:        Date:         ","Booking id:        Date:         ","Booking id:        Date:         "};
		
		
		/**
		 * List code below controls the size,scrollability of the jlist box
		 * 
		 *  
		 * **/
		bookingList = new JList(bookings);
		bookingList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		bookingList.setLayoutOrientation(JList.VERTICAL);
		bookingList.setVisibleRowCount(-1);
		JScrollPane listScroller = new JScrollPane(bookingList);
		listScroller.setPreferredSize(new Dimension(250,100));
		bookingPanel.add(listScroller);
		
		bookingCont.add(bookingPanel,BorderLayout.CENTER);
	
	JPanel buttonPanel = new JPanel(new FlowLayout());
	
		manageBooking = new JButton("Manage Booking");
		manageBooking.addActionListener(this);
		buttonPanel.add(manageBooking);	
	
		saveChanges = new JButton("Save Changes");
		saveChanges.addActionListener(this);
		buttonPanel.add(saveChanges);	
	
		bookingCont.add(buttonPanel,BorderLayout.SOUTH);
	
	
	
	//add the Booking container
	add(bookingCont);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		/** 
		 * Database Query code/Java Method goes here
		 * **/
	}
}