package GUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import Database.CreateTables;
import Model.Room;
import Model.User;

import java.awt.event.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Availability extends JFrame implements ActionListener {

	private String[] availableDates = new String[15];
	private int[] roomNumberList = new int[15];
	private ArrayList<Integer> roomChoice = new ArrayList<Integer>();
	private JTextField roomNumber;
	private JList availableList;
	private JLabel lblArrivalDate, lblNoOfNights, lblnumRoomsLabel;
	private JButton back, continueb;
	private int numNights, numberOfRooms, numberOfGuests;
	private Calendar calDate;
	private String arrivalDate, departureDate;
	private JTextField totalCostField;
	private double total, price;
	private String user;
	private ArrayList<User> users;

	public Availability(Calendar dc, int numnights, int numGuests) {
		calDate = dc;
		numNights = numnights;
		numberOfGuests = numGuests;
		createAvailabilityScreen();

	}

	public Availability(String userID, ArrayList<User> users, Calendar dc,
			int numnights, int numGuests) {
		calDate = dc;
		numNights = numnights;
		numberOfGuests = numGuests;
		user = userID;
		this.users = users;
		createAvailabilityScreen();
	}

	public void createAvailabilityScreen() {
		setTitle("Availability of rooms selected");
		getContentPane().setLayout(new BorderLayout(0, 0));
		setSize(575, 355);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel dates_selected = new JPanel();
		getContentPane().add(dates_selected, BorderLayout.NORTH);
		dates_selected.setBorder(new TitledBorder("Dates Selected"));

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		arrivalDate = dateFormat.format(calDate.getTime());

		calDate.add(Calendar.DATE, numNights);
		departureDate = (String) (dateFormat.format(calDate.getTime()));

		lblArrivalDate = new JLabel("Arrival Date: " + arrivalDate + " - "
				+ departureDate);
		lblArrivalDate.setFont(new Font("SansSerif", Font.PLAIN, 15));
		dates_selected.add(lblArrivalDate);

		JLabel filler = new JLabel("              ");
		dates_selected.add(filler);

		lblNoOfNights = new JLabel("No. of Nights: " + numNights);
		lblNoOfNights.setFont(new Font("SansSerif", Font.PLAIN, 15));
		dates_selected.add(lblNoOfNights);

		JPanel rooms_available = new JPanel();
		getContentPane().add(rooms_available, BorderLayout.CENTER);
		rooms_available.setBorder(new TitledBorder("Available Rooms"));
		rooms_available.setLayout(null);

		lblnumRoomsLabel = new JLabel("Number of rooms:");
		lblnumRoomsLabel.setBounds(358, 37, 117, 14);
		rooms_available.add(lblnumRoomsLabel);
		roomNumber = new JTextField();
		roomNumber.setText("0");
		roomNumber.setBounds(477, 34, 36, 20);
		roomNumber.setEditable(false);
		rooms_available.add(roomNumber);
		roomNumber.setColumns(10);

		availableList = new JList(availableDates); // JList of available Rooms
		MouseListener mouseListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					// price = 0.0;
					int[] listofRooms = availableList.getSelectedIndices();
					if (listofRooms.length > 0) {
						roomNumber.setText("" + listofRooms.length);
					} else {
						roomNumber.setText("0");
					}
					if (roomChoice.size() > 0) {

						for (int j = roomChoice.size() - 1; j >= 0; j--) {
							roomChoice.remove(j);
						}
					}
					for (int i = 0; i < listofRooms.length; i++) {
						System.out.println(listofRooms[i]);

						if (roomChoice.contains(roomNumberList[listofRooms[i]])) {
							roomChoice.remove(i);

							// price = price - Double.parseDouble();

						} else {
							roomChoice.add(roomNumberList[listofRooms[i]]);
						}
					}
					System.out.println(roomChoice);
					try {

						if (((String) availableList.getSelectedValue())
								.contains("Single")) {
							price = price + (59.00 * numNights);
							totalCostField.setText(String.valueOf(price));
						} else if (((String) availableList.getSelectedValue())
								.contains("Double")) {
							price = price + (99.00 * numNights);
							totalCostField.setText(String.valueOf(price));
						} else if (((String) availableList.getSelectedValue())
								.contains("Twin")) {
							price = price + (199.00 * numNights);
							totalCostField.setText(String.valueOf(price));
						}
					} catch (NullPointerException npe) {
						totalCostField.setText("0.00");
					}

				}
			}
		};
		availableList.addMouseListener(mouseListener);
		availableList.setVisibleRowCount(5); // number of rows
		availableList
		.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // allows
		// multiple
		// rows
		// to
		// be
		// selected
		JScrollPane scrollPane = new JScrollPane(availableList); // adds
		// scrollbar
		// to JList
		scrollPane.setBounds(59, 34, 285, 119);
		rooms_available.add(scrollPane);

		JLabel lblTotalCost = new JLabel("Total Cost : ");
		lblTotalCost.setBounds(356, 64, 81, 16);
		rooms_available.add(lblTotalCost);

		totalCostField = new JTextField();
		totalCostField.setEditable(false);
		totalCostField.setBounds(429, 64, 84, 22);
		rooms_available.add(totalCostField);
		totalCostField.setColumns(10);

		JPanel buttons = new JPanel();
		getContentPane().add(buttons, BorderLayout.SOUTH);
		buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 5));

		back = new JButton("Back");
		back.addActionListener(this);
		buttons.add(back);

		continueb = new JButton("Continue");
		continueb.addActionListener(this);
		buttons.add(continueb);
	}

	public void listContent(ArrayList<Room> al) { // prepares an array of
		// strings for the JList
		for (int i = 0; i < al.size(); i++) {
			roomNumberList[i] = al.get(i).getRoomNumber();
			availableDates[i] = al.get(i).getRoomType() + " "
					+ al.get(i).getPrice();

		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) {

			if (StartScreen.isLoggedIn() == true) {

				UserScreen u = new UserScreen(user, users);
				this.setVisible(false);
				u.setVisible(true);
			}

			else {
				StartScreen s = new StartScreen();
				this.setVisible(false);
				s.setVisible(true);
			}

		} else {
			try {
				total = Double.parseDouble(totalCostField.getText());
				if (StartScreen.isLoggedIn() == true) {
					CreditCard c = new CreditCard(calDate, user, users, total,
							numberOfRooms, numNights, numberOfGuests,
							arrivalDate, departureDate, roomChoice);
					this.setVisible(false);
					c.setVisible(true);
				} else {
					Login l = new Login(calDate, total, numberOfRooms,
							numNights, numberOfGuests, arrivalDate,
							departureDate, roomChoice);
					this.setVisible(false);
					l.setVisible(true);
				}
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null,
						"You must select a room to proceed", "Booking Error",
						JOptionPane.WARNING_MESSAGE);
			}

		}

	}
}
