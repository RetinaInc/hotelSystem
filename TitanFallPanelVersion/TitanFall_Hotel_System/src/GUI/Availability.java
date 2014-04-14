package GUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import Model.Room;
import Model.User;

import java.awt.event.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Availability extends JPanel implements ActionListener {

	private String[] availableDates = new String[15];
	private int[] roomNumberList = new int[15];
	private double[] priceList = new double[15];
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
	private JPanel container;
	private JScrollPane scrollPane;
	private Color color = new Color(227,99,26);

	public Availability(Calendar dc, int numnights, int numGuests) {
		calDate = dc;
		numNights = numnights;
		numberOfGuests = numGuests;
		buildAvailabiltyScreen();
	}

	/**
	 * @wbp.parser.constructor
	 */
	public Availability(String userID, ArrayList<User> users, Calendar dc,
			int numnights, int numGuests) {
		calDate = dc;
		numNights = numnights;
		numberOfGuests = numGuests;
		user = userID;
		this.users = users;
		buildAvailabiltyScreen();
		

	}
	public void buildAvailabiltyScreen(){
		setSize(1000, 500);

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		arrivalDate = dateFormat.format(calDate.getTime());

		calDate.add(Calendar.DATE, numNights);
		departureDate = (String) (dateFormat.format(calDate.getTime()));
		MouseListener mouseListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					price = 0.0;
					int[] listofRooms = availableList.getSelectedIndices();
					if (listofRooms.length > 0) {
						roomNumber.setText("" + listofRooms.length);
						numberOfRooms = Integer.valueOf(roomNumber.getText());
					} else {
						roomNumber.setText("0");
						totalCostField.setText("0.0");
					}
					if (roomChoice.size() > 0) {
						for (int j = roomChoice.size() - 1; j >= 0; j--) {
							roomChoice.remove(j);
						}
					}
					for (int i = 0; i < listofRooms.length; i++) {
						System.out.println(listofRooms[i]);
						price = price + (priceList[listofRooms[i]] * numNights);
						totalCostField.setText(String.valueOf(price));
						if (roomChoice.contains(roomNumberList[listofRooms[i]])) {
							roomChoice.remove(i);
						} else {
							roomChoice.add(roomNumberList[listofRooms[i]]);
						}
					}

				}
			}
		};
		container = new JPanel();
		container.setLocation(0, 0);
		container.setSize(599, 300);
		add(container);
		
		setLayout(null);
		JPanel buttons = new JPanel();
		buttons.setBounds(10, 193, 548, 32);

		buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 5));

		back = new JButton("Back");
		back.setBackground(color);
		back.addActionListener(this);
		buttons.add(back);

		continueb = new JButton("Continue");
		continueb.setBackground(color);
		continueb.addActionListener(this);
		buttons.add(continueb);

		
		
		container.setLayout(new BorderLayout(0, 0));
		JPanel dates_selected = new JPanel();
		container.add(dates_selected, BorderLayout.NORTH);
		dates_selected.setBorder(new TitledBorder("Dates Selected"));

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
		container.add(rooms_available, BorderLayout.CENTER);
		rooms_available.setBorder(new TitledBorder("Available Rooms"));
		rooms_available.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(92, 22, 233, 160);
		rooms_available.add(scrollPane);

		availableList = new JList(availableDates);
		scrollPane.setViewportView(availableList);
		availableList.addMouseListener(mouseListener);
		availableList.setVisibleRowCount(5); // number of rows
		availableList
				.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // allows

		JPanel panel_1 = new JPanel();
		scrollPane.setColumnHeaderView(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JLabel lblType = new JLabel("Type     ");
		panel_1.add(lblType, BorderLayout.WEST);

		JLabel lblPrice = new JLabel("Price");
		panel_1.add(lblPrice, BorderLayout.CENTER);

		lblnumRoomsLabel = new JLabel("Number of rooms:");
		lblnumRoomsLabel.setBounds(350, 137, 108, 14);
		rooms_available.add(lblnumRoomsLabel);
		roomNumber = new JTextField();
		roomNumber.setBounds(485, 134, 86, 20);
		roomNumber.setText("0");
		roomNumber.setEditable(false);
		rooms_available.add(roomNumber);
		roomNumber.setColumns(10);

		JLabel lblTotalCost = new JLabel("Total Cost : ");
		lblTotalCost.setBounds(377, 168, 81, 14);
		rooms_available.add(lblTotalCost);

		totalCostField = new JTextField(10);
		totalCostField.setBounds(485, 162, 86, 20);
		totalCostField.setEditable(false);
		rooms_available.add(totalCostField);
		totalCostField.setText("0.0");
		rooms_available.add(buttons);
	}
	public Calendar getCalDate() {
		return calDate;
	}

	public void listContent(ArrayList<Room> al) { // prepares an array of
													// strings for the JList
		for (int i = 0; i < al.size(); i++) {
			roomNumberList[i] = al.get(i).getRoomNumber();
			priceList[i] = al.get(i).getPrice();
			availableDates[i] = al.get(i).getRoomType() + "    "
					+ al.get(i).getPrice();

		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == back) {

			if (StartScreen.isLoggedIn() == true) {

				UserTabbedScreen u = new UserTabbedScreen(user, users);
				getTopLevelAncestor().setVisible(false);
				u.setVisible(true);
			}

			else {
				startPanel s = new startPanel();
				s.setVisible(true);
				s.setSize(1000, 600);
				container.setVisible(false);
				add(s);
				
				
			}

		} else {
			try {
				total = Double.parseDouble(totalCostField.getText());
				if (StartScreen.isLoggedIn() == true) {
					CreditCard c = new CreditCard(calDate, user, users, total,
							numberOfRooms, numNights, numberOfGuests,
							arrivalDate, departureDate, roomChoice);
					container.setVisible(false);
					c.setVisible(true);
					add(c);
				} else {
					Login l = new Login(calDate, total, numberOfRooms,
							numNights, numberOfGuests, arrivalDate,
							departureDate, roomChoice);
					container.setVisible(false);
					l.setVisible(true);
					add(l);
				}
			} catch (NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null,
						"You must select a room to proceed", "Booking Error",
						JOptionPane.WARNING_MESSAGE);
			}

		}

	}
}
