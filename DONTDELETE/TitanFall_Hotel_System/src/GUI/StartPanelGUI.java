package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;

import Model.Booking;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import java.awt.BorderLayout;

public class StartPanelGUI extends JPanel implements ActionListener, ItemListener,KeyListener{
	private String[] nights = { "1", "2", "3", "4", "5", "6", "7" };
	private String[] rooms = { "1", "2", "3", "4", "5", "6", "7", "8", "9",
			"10" };
	private String[] people = { "1", "2", "3", "4", "5", "6", "7", "8", "9",
			"10" };
	private JDateChooser dateChooser;
	private JYearChooser day, year;
	private JMonthChooser month;

	private JComboBox numNights, numPeople;
	private JLabel lblnumNights, lblnumPeople, arrivalDate;
	private JButton login, btnSearch;
	private Font font;
	private JPanel userInteraction;
	private Calendar chosenDate;
	private Calendar cal = Calendar.getInstance();
	private Color color = new Color(227,99,26);
	
	public StartPanelGUI(){
		font = new Font("Veranda", font.ITALIC, 20);
		setLayout(null);
		setSize(1000, 600);
		

		userInteraction = new JPanel();
		userInteraction.setVisible(true);
		userInteraction.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		userInteraction.setLayout(new GridLayout(2, 0));
		userInteraction.setBounds(150, 0, 373, 230);
		add(userInteraction);
		JPanel search = new JPanel();
		search.setLayout(new FlowLayout());

		lblnumNights = new JLabel("No. of Nights");
		search.add(lblnumNights);

		numNights = new JComboBox(nights);
		search.add(numNights);

		arrivalDate = new JLabel("Arrival Date");
		search.add(arrivalDate);

		day = new JYearChooser();
		day.setPreferredSize(new Dimension(35,20));
		day.adjustWidthToMaximumValue();
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


		dateChooser = new JDateChooser();
		dateChooser.setMinSelectableDate(cal.getTime());
		dateChooser.setIcon(new ImageIcon("TitanfallImages/cal.jpg"));
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


		userInteraction.add(search);

		JPanel buttons = new JPanel();
		buttons.setLayout(null);
		userInteraction.add(buttons);


		login = new JButton("Login");
		login.setBackground(color);
		login.setToolTipText("Login to your account or create a new account");
		login.isFocusable();
		login.addKeyListener(this);
		login.addActionListener(this);
		login.setBounds(10, 47, 89, 23);
		buttons.add(login);

		btnSearch = new JButton("Search");
		btnSearch.setBackground(color);
		btnSearch.setToolTipText("Check availability of rooms");
		btnSearch.isFocusable();
		btnSearch.addKeyListener(this);
		btnSearch.addActionListener(this);
		btnSearch.setBounds(270, 47, 89, 23);
		buttons.add(btnSearch);
		System.out.println(day.getYear() + "     " + (month.getMonth() + 1)
				+ "        " + year.getYear());
	}

	public void actionPerformed(ActionEvent e) {
		Calendar calDate = Calendar.getInstance();
		calDate.set(year.getYear(), (month.getMonth()), day.getYear());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		if (e.getSource() == login) {
			LoginGUI l = new LoginGUI();
			userInteraction.setVisible(false);
			l.setVisible(true);
			this.add(l);
			
		} 
		else if(calDate.compareTo(cal) < 0){
			JOptionPane.showMessageDialog(null, "Date cannot be in the past","Date input error",JOptionPane.ERROR_MESSAGE);	
		}
		else{
			Booking b = new Booking(day.getYear(), month.getMonth(), year.getYear() ,(numNights.getSelectedIndex()) + 1);
			AvailabilityGUI a = new AvailabilityGUI(calDate,((numNights.getSelectedIndex()) + 1),
					numPeople.getSelectedIndex() + 1);
			a.listContent(b.availability());
			userInteraction.setVisible(false);
			a.setVisible(true);
			this.add(a);
		}
		
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
			
			LoginGUI l = new LoginGUI();
			this.setVisible(false);
			l.setVisible(true);
		}
		else if(calDate.compareTo(Calendar.getInstance()) >= 0 && e.getKeyCode() == KeyEvent.VK_ENTER){
			Booking b = new Booking(day.getYear(), (month.getMonth()), year.getYear() ,(numNights.getSelectedIndex()) + 1);
			b.availability();
			AvailabilityGUI a = new AvailabilityGUI(calDate,((numNights.getSelectedIndex()) + 1), numPeople.getSelectedIndex() + 1);
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

