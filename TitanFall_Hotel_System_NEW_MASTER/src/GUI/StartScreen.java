package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import Database.CreateTables;
import Model.Booking;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Date;

public class StartScreen extends JFrame implements ActionListener, ItemListener,KeyListener {

	private String[] nights = { "1", "2", "3", "4", "5", "6", "7" };
	private String[] rooms = { "1", "2", "3", "4", "5", "6", "7", "8", "9",
			"10" };
	private String[] people = { "1", "2", "3", "4", "5", "6", "7", "8", "9",
			"10" };

	private static boolean loggedIn;
	private JDateChooser dateChooser;
	private JYearChooser day, year;
	private JMonthChooser month;
	private JLabel welcome;
	private JComboBox numNights, numPeople, numRooms;
	private JLabel lblnumNights, lblnumPeople, lblnumRooms, arrivalDate;
	private JButton login, btnSearch;
	private Font font;
	private Calendar chosenDate;
	private Calendar cal = Calendar.getInstance();

	public StartScreen() {
		super("TitanFall Towers");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(515, 315);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		setLoggedIn(false); // user is not logged in

		font = new Font("Veranda", font.ITALIC, 20);

		welcome = new JLabel("Welcome to TitanFall Towers Hotel");
		welcome.setFont(font);
		welcome.setBounds(78, 11, 374, 33);
		getContentPane().add(welcome);

		JPanel userInteraction = new JPanel();
		userInteraction.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		userInteraction.setLayout(new GridLayout(2, 0));
		userInteraction.setBounds(10, 65, 479, 167);
		getContentPane().add(userInteraction);

		JPanel search = new JPanel();
		search.setLayout(new FlowLayout());

		lblnumNights = new JLabel("No. of Nights");
		search.add(lblnumNights);

		numNights = new JComboBox(nights);
		search.add(numNights);

		arrivalDate = new JLabel("Arrival Date");
		search.add(arrivalDate);

		day = new JYearChooser();
		day.setYear((cal.get(Calendar.DAY_OF_MONTH)));
		day.setMaximum(31);
		day.setMinimum(1);
		search.add(day);

		month = new JMonthChooser();
		month.setMonth(cal.get(Calendar.MONTH));
		month.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent e) {
				if (month.getMonth() == 3 || month.getMonth() == 5
						|| month.getMonth() == 8 || month.getMonth() == 10) {
					day.setMaximum(30);
					if (day.getYear() == 31) {
						day.setYear(30);
					}
				}
				else if (month.getMonth() == 1 && year.getYear() != 2016) {
					day.setMaximum(28);
					if (day.getYear() == 29 || day.getYear() == 30
							|| day.getYear() == 31) {
						day.setYear(28);
					}
				} else if (year.getYear() == 2016 && month.getMonth() == 1) {
					day.setMaximum(29);
					if (day.getYear() == 30 || day.getYear() == 31) {
						day.setYear(29);
					}
				} else {
					day.setMaximum(31);
				}
			}
		});
		search.add(month);

		year = new JYearChooser();
		year.setYear(cal.get(Calendar.YEAR));
		year.setMaximum(2016);
		year.setMinimum(2014);

		search.add(year);

		// ////////////////////////////////////////////////////////////////////////////////////////////////////
		// JDateChooser //
		// Sets date of comboBoxes to selected date //
		// for-loop needed, otherwise it looks for position 2014,2015 etc //
		// //
		// //
		// ////////////////////////////////////////////////////////////////////////////////////////////////////

		dateChooser = new JDateChooser();
		dateChooser.setMinSelectableDate(cal.getTime());
		cal.add(Calendar.YEAR, 2);
		dateChooser.setMaxSelectableDate(cal.getTime());
		dateChooser.getDateEditor().addPropertyChangeListener(
				new PropertyChangeListener() {
					@Override
					public void propertyChange(PropertyChangeEvent e) {
						if ("date".equals(e.getPropertyName())) {
							chosenDate = Calendar.getInstance();
							chosenDate.setTime((Date) e.getNewValue());
							day.setYear(chosenDate.get(Calendar.DAY_OF_MONTH));
							month.setMonth(chosenDate.get(Calendar.MONTH));
							year.setYear(chosenDate.get(Calendar.YEAR));

						}

					}
				});
		search.add(dateChooser);

		lblnumPeople = new JLabel("No. of People");
		search.add(lblnumPeople);

		numPeople = new JComboBox(people);
		search.add(numPeople);

		lblnumRooms = new JLabel("No. of Rooms");
		search.add(lblnumRooms);

		numRooms = new JComboBox(rooms);
		search.add(numRooms);

		userInteraction.add(search);

		JPanel buttons = new JPanel();
		buttons.setLayout(null);
		userInteraction.add(buttons);

		userInteraction.add(buttons);

		login = new JButton("Login");
		login.setToolTipText("Login to your account or create a new account");
		login.isFocusable();
		login.addKeyListener(this);
		login.addActionListener(this);
		login.setBounds(10, 47, 89, 23);
		buttons.add(login);

		btnSearch = new JButton("Search");
		btnSearch.setToolTipText("Check availability of rooms");
		btnSearch.isFocusable();
		btnSearch.addKeyListener(this);
		btnSearch.addActionListener(this);
		btnSearch.setBounds(376, 47, 89, 23);
		buttons.add(btnSearch);
		System.out.println(day.getYear() + "     " + (month.getMonth() + 1)
				+ "        " + year.getYear());
	}

	public void actionPerformed(ActionEvent e) {
		Calendar calDate = Calendar.getInstance();
		calDate.set(year.getYear(), (month.getMonth()), day.getYear());
		if (e.getSource() == login) {
			Login l = new Login();
			this.setVisible(false);
			l.setVisible(true);
		} 
		else if(calDate.compareTo(Calendar.getInstance()) < 0){
			JOptionPane.showMessageDialog(null, "Date cannot be in the past","Date input error",JOptionPane.ERROR_MESSAGE);	
		}
		else{
			Booking b = new Booking(day.getYear(), month.getMonth(), year.getYear() ,(numNights.getSelectedIndex()) + 1);
			Availability a = new Availability(calDate,((numNights.getSelectedIndex()) + 1), numRooms.getSelectedIndex() + 1,
					numPeople.getSelectedIndex() + 1);
			a.listContent(b.availability());
			this.setVisible(false);
			a.setVisible(true);
		}
		
	}

	// getter and setter to set the loggedIn value to true or false throughout
	// the system
	public static boolean isLoggedIn() {
		return loggedIn;
	}

	public static void setLoggedIn(boolean loggedIna) {
		loggedIn = loggedIna;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == 3 || e.getStateChange() == 5
				|| e.getStateChange() == 8 || e.getStateChange() == 10) {
			day.setMaximum(30);
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		Calendar calDate = Calendar.getInstance();
		calDate.set(year.getYear(), (month.getMonth()), day.getYear());
		if(e.getSource() == login && e.getKeyCode() == KeyEvent.VK_ENTER){
			
			Login l = new Login();
			this.setVisible(false);
			l.setVisible(true);
		}
		else if(calDate.compareTo(Calendar.getInstance()) >= 0 && e.getKeyCode() == KeyEvent.VK_ENTER){
			Booking b = new Booking(day.getYear(), (month.getMonth()), year.getYear() ,(numNights.getSelectedIndex()) + 1);
			b.availability();
			Availability a = new Availability(calDate,((numNights.getSelectedIndex()) + 1), numRooms.getSelectedIndex() + 1,
					numPeople.getSelectedIndex() + 1);
			a.listContent(b.availability());
			this.setVisible(false);
			a.setVisible(true);
		}
		else{
			JOptionPane.showMessageDialog(null, "Date cannot be in the past","Date input error",JOptionPane.ERROR_MESSAGE);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
