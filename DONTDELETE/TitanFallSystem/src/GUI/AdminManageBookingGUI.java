package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Database.Queries;
import Database.manageBookingOperations;

public class AdminManageBookingGUI extends JPanel implements ActionListener{
	private JPanel container;
	private JLabel currentList;
	private JButton deleteBooking;
	private Font fontBigger;
	private Color color = new Color(227,99,26);
	private DefaultTableModel model;
	private JTable table;
	private ArrayList<Object[]> bookingList;
	private Object[][] array2d;
	
	public AdminManageBookingGUI(){
		this.setLayout(null);
		container = new JPanel();
		container.setLayout(null);
		container.setVisible(true);
		container.setBounds(150,100,800,420);
		add(container);
		
		fontBigger = new Font("Veranda", Font.PLAIN, 18);
		
		//Panel used to welcome the user
		JPanel greeting = new JPanel();
		greeting.setBounds(161, 77, 391, 44);
		container.add(greeting);

		 currentList = new JLabel("Current List of Bookings on File:");
		currentList.setFont(fontBigger);
		greeting.add(currentList);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 132, 700, 130);
		container.add(scrollPane);
		Object[] columnNames = { "Booking ID", "First Name",
				"Last Name", "Number of Guests", "Number of Nights", "Arrival Date"};
		fillTable();
		model = new DefaultTableModel(array2d, columnNames){
			 @Override
			    public boolean isCellEditable(int row, int column) {
			       //all cells false
			       return false;
			    }
		};

		table = new JTable(model);
		table.getTableHeader().setBackground(color);
		table.setBorder(null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(table);

		 deleteBooking = new JButton("Delete");
		deleteBooking.addActionListener(this);
		deleteBooking.setFont(fontBigger);
		deleteBooking.setBackground(color);
		deleteBooking.setBounds(290, 290, 102, 23);
		container.add(deleteBooking);
	}
	private void fillTable() {
		// gets the bookings in the system where the departure date is not passed todays date
					manageBookingOperations m = new manageBookingOperations();
					bookingList = new ArrayList<Object[]>(m.getBookingsAdmin());
					array2d = bookingList.toArray(new Object[bookingList.size()][]);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == deleteBooking){
			try
			{
			//get the number of row the user selects 
			int row = table.getSelectedRow();
			//column is always set to zero because we are looking for the booking id
			int id = Integer.parseInt(table.getValueAt(row, 0).toString());
			
			manageBookingOperations m = new manageBookingOperations();
			m.removeBooking(id);
			JOptionPane.showMessageDialog(null, "Booking " + id + " was removed","Booking Removed",
					JOptionPane.INFORMATION_MESSAGE);
			AdminManageBookingGUI a = new AdminManageBookingGUI();
			container.setVisible(false);
			a.setBounds(0, 0, 850,420);
			a.setVisible(true);
			add(a);
			}
			catch(Exception me){
				JOptionPane.showMessageDialog(null, "Please select a booking you wish to remove","Remove Booking",
						JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
