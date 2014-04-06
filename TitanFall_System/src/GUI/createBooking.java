
package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import Model.Booking;
import Model.User;

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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.border.BevelBorder;

public class createBooking extends JPanel implements ActionListener {
	private String[] nights = { "1", "2", "3", "4", "5", "6", "7", "8", "9",
			"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
	"21" };
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
	private JLabel lblnumNights, lblnumPeople, lblnumRooms, arrivalDate,
	calendar;
	private JButton login, btnSearch;
	private Font font;
	private Calendar chosenDate;
	private JPanel panel;


	public createBooking() {
		Calendar cal = Calendar.getInstance();
		font = new Font("Veranda", font.ITALIC, 20);
		setLoggedIn(false);
		cal.add(Calendar.YEAR, 2);
		setLayout(null);

		welcome = new JLabel("Welcome to TitanFall Towers Hotel");
		welcome.setBounds(194, 33, 589, 26);
		add(welcome);
		welcome.setFont(new Font("Verdana", Font.ITALIC, 32));

		JLabel welcomeUser = new JLabel("Welcome " + "Thomas");
		welcomeUser.setForeground(new Color(50, 205, 50));
		welcomeUser.setFont(new Font("Tahoma", Font.ITALIC, 14));
		welcomeUser.setBounds(841, 11, 127, 23);
		add(welcomeUser);

		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, Color.DARK_GRAY, Color.GRAY, Color.DARK_GRAY));
		panel.setBounds(172, 108, 633, 282);
		add(panel);
		panel.setLayout(null);

		lblnumNights = new JLabel("No. of Nights");
		lblnumNights.setBounds(42, 72, 126, 26);
		panel.add(lblnumNights);
		lblnumNights.setFont(new Font("Tahoma", Font.PLAIN, 20));

		numNights = new JComboBox(nights);
		numNights.setBounds(178, 74, 49, 20);
		panel.add(numNights);
		numNights.setFont(new Font("Tahoma", Font.PLAIN, 20));

		lblnumPeople = new JLabel("No. of People");
		lblnumPeople.setBounds(236, 71, 130, 24);
		panel.add(lblnumPeople);
		lblnumPeople.setFont(new Font("Tahoma", Font.PLAIN, 20));

		numPeople = new JComboBox(people);
		numPeople.setBounds(365, 72, 49, 25);
		panel.add(numPeople);
		numPeople.setFont(new Font("Tahoma", Font.PLAIN, 20));

		lblnumRooms = new JLabel("No. of Rooms");
		lblnumRooms.setBounds(424, 75, 126, 20);
		panel.add(lblnumRooms);
		lblnumRooms.setFont(new Font("Tahoma", Font.PLAIN, 20));

		arrivalDate = new JLabel("Arrival Date");
		arrivalDate.setBounds(52, 114, 126, 26);
		panel.add(arrivalDate);
		arrivalDate.setFont(new Font("Tahoma", Font.PLAIN, 20));

		day = new JYearChooser();
		day.setBounds(281, 120, 35, 20);
		panel.add(day);
		day.setYear((cal.get(Calendar.DAY_OF_MONTH)));
		day.setMaximum(31);
		day.setMinimum(1);

		month = new JMonthChooser();
		month.setBounds(321, 118, 98, 24);
		panel.add(month);
		month.setMonth(cal.get(Calendar.MONTH));

		year = new JYearChooser();
		year.setBounds(424, 120, 47, 20);
		panel.add(year);
		year.setYear(cal.get(Calendar.YEAR));
		year.setMaximum(2016);
		year.setMinimum(2014);

		numRooms = new JComboBox(rooms);
		numRooms.setBounds(552, 72, 49, 23);
		panel.add(numRooms);
		numRooms.setFont(new Font("Tahoma", Font.PLAIN, 20));

		// ////////////////////////////////////////////////////////////////////////////////////////////////////
		// JDateChooser //
		// Sets date of comboBoxes to selected date //
		// for-loop needed, otherwise it looks for position 2014,2015 etc //
		// //
		// //
		// ////////////////////////////////////////////////////////////////////////////////////////////////////

		dateChooser = new JDateChooser();
		dateChooser.setBounds(200, 122, 65, 20);
		panel.add(dateChooser);
		dateChooser.setMinSelectableDate(cal.getTime());
		dateChooser.setMaxSelectableDate(cal.getTime());

		btnSearch = new JButton("Search");
		btnSearch.setBackground(Color.GREEN);
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSearch.setBounds(254, 202, 126, 26);
		panel.add(btnSearch);
		btnSearch.addActionListener(this);
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

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnSearch) {
			Calendar calDate = Calendar.getInstance();
			calDate.set(year.getYear(), (month.getMonth()), day.getYear());

			if(calDate.compareTo(Calendar.getInstance()) >= 0){
				Booking b = new Booking(day.getYear(), month.getMonth(), year.getYear() ,(numNights.getSelectedIndex()) + 1);
				Availability a = new Availability(calDate,((numNights.getSelectedIndex()) + 1),
						numPeople.getSelectedIndex() + 1);
				a.listContent(b.availability());
				this.setVisible(false);
				a.setVisible(true);
			}
		} else {

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

	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == 3 || e.getStateChange() == 5
				|| e.getStateChange() == 8 || e.getStateChange() == 10) {
			day.setMaximum(30);
		}

	}
}
