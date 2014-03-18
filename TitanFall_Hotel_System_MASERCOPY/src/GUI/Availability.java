package GUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

import java.awt.event.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Availability extends JFrame implements ActionListener{

	private JTable bookings;
	
	private String[] columnNames = {"Room Type", "Cost of room","Room number"};
	private String[] nums = {"1","2","3","4"};
	private JTable table;
	private JTextField roomNumber;
	private JLabel lblArrivalDate,lblNoOfNights,lblPleaseEnterThe;
	private JButton back,continueb;
	private int day,month,year, numNights;
	private JDateChooser date;
	private JComboBox numberOfNights;
	private String arrivalDate,departureDate;
	
	public Availability(JDateChooser dc,JComboBox numnights){
		super("Availability of rooms selected");

		getContentPane().setLayout(new BorderLayout(0, 0));
		setSize(575,355);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel dates_selected = new JPanel();
		getContentPane().add(dates_selected, BorderLayout.NORTH);
		dates_selected.setBorder(new TitledBorder("Dates Selected"));
		
		date = dc;
		numberOfNights = numnights;
		
		int numofnights = Integer.parseInt(numberOfNights.getSelectedItem().toString());
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		arrivalDate = dateFormat.format(date.getDate());
		
		Calendar c = Calendar.getInstance();
		c.setTime(date.getDate());
		c.add(Calendar.DATE, numofnights);
		departureDate = (String)(dateFormat.format(c.getTime()));
		
		
		 lblArrivalDate = new JLabel("Arrival Date: " + arrivalDate + " - " + departureDate);
		lblArrivalDate.setFont(new Font("SansSerif", Font.PLAIN, 15));
		dates_selected.add(lblArrivalDate);
		
		JLabel filler = new JLabel("              ");
		dates_selected.add(filler);
		
		 lblNoOfNights = new JLabel("No. of Nights: " + numofnights);
		lblNoOfNights.setFont(new Font("SansSerif", Font.PLAIN, 15));
		dates_selected.add(lblNoOfNights);
		
		JPanel rooms_available = new JPanel();
		getContentPane().add(rooms_available, BorderLayout.CENTER);
		rooms_available.setBorder(new TitledBorder("Available Rooms"));
		rooms_available.setLayout(null);
		
		Object[][] data = {
				{"Single",69.99,"24"},
				{"Single",69.99,"27"},
				{"Double",80.00,"45"},
				{"Double",80.00,"53"},
				{"Suite",99.99,"63"},
				{"Suite",99.99,"64"}
		};
		
		table = new JTable(data,columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(50,50));
		table.setFillsViewportHeight(true);
		table.setEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(59, 34, 285, 119);
		rooms_available.add(scrollPane);
		
		 lblPleaseEnterThe = new JLabel("Please enter the room number of the room you wish to book");
		lblPleaseEnterThe.setBounds(28, 178, 361, 14);
		rooms_available.add(lblPleaseEnterThe);
		
		roomNumber = new JTextField();
		roomNumber.setBounds(410, 175, 86, 20);
		rooms_available.add(roomNumber);
		roomNumber.setColumns(10);
		
		
		
		JPanel buttons = new JPanel();
		getContentPane().add(buttons, BorderLayout.SOUTH);
		buttons.setLayout(new FlowLayout(FlowLayout.CENTER,200,5));
		
		 back = new JButton("Back");
		 back.addActionListener(this);
		buttons.add(back);
		
		JButton continueb = new JButton("Continue");
		continueb.addActionListener(this);
		buttons.add(continueb);
		
	}

	public Availability() {
		// TODO Auto-generated constructor stub
	}

	public boolean loggedIn(){
		return true;
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back){
			
			if(loggedIn() == true){
				
				UserScreen u = new UserScreen();
				this.setVisible(false);
				u.setVisible(true);
			}
			
			else
			{
				StartScreen s = new StartScreen();
				this.setVisible(false);
				s.setVisible(true);
			}
			
		}
		else{
			if(StartScreen.isLoggedIn() == true){
				CC c = new CC();
				this.setVisible(false);
				c.setVisible(true);
			}
			else
			{
				Login l = new Login();
				this.setVisible(false);
				l.setVisible(true);
			}
		}
		
	}
}
