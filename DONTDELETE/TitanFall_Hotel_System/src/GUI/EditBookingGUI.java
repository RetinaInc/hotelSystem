package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;

import com.toedter.calendar.JCalendar;

import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class EditBookingGUI extends JPanel implements ActionListener{
	private JPanel edit;
	private JComboBox numGuestsCombo, numRoomsCombo, numNightsCombo;
	private int bookingid;
	private double price;
	private int numGuests, numRooms, numNights;
	private Calendar arrival, departure, currentDate, maxDate;
	private JTextField day;
	private JTextField month;
	private JTextField year;
	private JTextField textField_3;
	private Color color = new Color(227,99,26);
	private String usersID;
	private JButton btnCancel, btnSaveChanges;
	public EditBookingGUI(String usersID, int bookingid, int numGuests, int numRooms, int numNights, double price, Date arrivalD, Date departureD){
		System.out.println(bookingid + " " + numGuests + " " +numRooms + " " + price + " " + arrivalD + " " + departureD);
		this.usersID = usersID;
		this.numNights = numNights;
		this.bookingid = bookingid;
		this.numGuests = numGuests;
		this.numRooms = numRooms;
		this.price = price;
		arrival = Calendar.getInstance();
		arrival.setTime(arrivalD);
		departure = Calendar.getInstance();
		departure.setTime(departureD);
		setLayout(null);	
		edit = new JPanel();
		edit.setBorder(new TitledBorder(null, "Change booking details - Booking ID: " + this.bookingid, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		edit.setBounds(125,210, 745, 294);
		add(edit);
		edit.setLayout(null);
		
		
		System.out.println(this.bookingid + " " + this.numGuests + " " +this.numRooms + " " + this.price + " " + arrival.getTime() + " " + departure.getTime());
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBounds(156, 50, 249, 185);
		edit.add(leftPanel);
		
		JLabel lblNumberOfGuests = new JLabel("Number of Guests:                           ");
		leftPanel.add(lblNumberOfGuests);
		
		numGuestsCombo = new JComboBox(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		numGuestsCombo.setSelectedIndex(numGuests -1);
		leftPanel.add(numGuestsCombo);
		
		JLabel lblNumberOfRooms = new JLabel("Number of Rooms:                           ");
		leftPanel.add(lblNumberOfRooms);
		
		numRoomsCombo = new JComboBox(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		numRoomsCombo.setSelectedIndex(numRooms -1);
		leftPanel.add(numRoomsCombo);
		
		this.bookingid = bookingid;
		
		JLabel lblNumberOfNights = new JLabel("Number of Nights:                             ");
		leftPanel.add(lblNumberOfNights);
		
		numNightsCombo = new JComboBox(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14"}));
		numNightsCombo.setSelectedIndex(numNights -1);
		leftPanel.add(numNightsCombo);
		
		JLabel lblArrivalDate = new JLabel("Arrival Date:                 ");
		leftPanel.add(lblArrivalDate);
		
		day = new JTextField();
		day.setEditable(false);
		leftPanel.add(day);
		day.setColumns(2);
		
		month = new JTextField("");
		month.setEditable(false);
		leftPanel.add(month);
		month.setColumns(3);
		
		year = new JTextField("2014");
		year.setEditable(false);
		leftPanel.add(year);
		year.setColumns(3);
		
		JLabel lblNewTotalCost = new JLabel("New Total Cost:                        ");
		leftPanel.add(lblNewTotalCost);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		leftPanel.add(textField_3);
		textField_3.setColumns(6);
		
		JPanel rigthPanel = new JPanel();
		rigthPanel.setBounds(415, 50, 225, 185);
		edit.add(rigthPanel);
		
		final JCalendar calendar = new JCalendar();
		currentDate = Calendar.getInstance();
		calendar.setMinSelectableDate(currentDate.getTime());
		currentDate.add(Calendar.DAY_OF_MONTH, -1);
		maxDate = Calendar.getInstance();
		maxDate.add(Calendar.YEAR, 2);
		calendar.setMaxSelectableDate(maxDate.getTime());
		
		rigthPanel.add(calendar);
		calendar.addPropertyChangeListener(new PropertyChangeListener(){

			@Override
			public void propertyChange(PropertyChangeEvent p) {
				if(calendar.getDate().after(currentDate.getTime()) && calendar.getDate().before(maxDate.getTime())){
					day.setText(Integer.toString(calendar.getDayChooser().getDay()));
					month.setText(dateConverter(calendar.getMonthChooser().getMonth()));
					year.setText(Integer.toString(calendar.getYearChooser().getYear()));
				}
				
				
			}
			
		});
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(230, 260, 100, 25);
		btnCancel.addActionListener(this);
		btnCancel.setBackground(color);
		edit.add(btnCancel);
		
		btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.setBackground(color);
		btnSaveChanges.addActionListener(this);
		btnSaveChanges.setBounds(470, 260, 150, 25);
		edit.add(btnSaveChanges);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnCancel)){
			ManageBookingGUI m = new ManageBookingGUI(usersID);
			edit.setVisible(false);
			m.setVisible(true);
			add(m);
		}
		
	}
	public String dateConverter(int month){
		String[] months = {"Jan","Feb","Mar","Apr", "May", "Jun", "Jul", "Aug","Sep","Oct","Nov","Dec" };
		
		return months[month];

	}
}
