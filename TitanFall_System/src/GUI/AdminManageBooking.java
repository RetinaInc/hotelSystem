package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class AdminManageBooking extends JPanel implements KeyListener, MouseListener {
	private String[] columnNames = {"Booking ID", "Room Number", "User ID"};
	public AdminManageBooking(){
		this.setLayout(null);

		//Panel used to welcome the user
		JPanel greeting = new JPanel();
		greeting.setBounds(320, 69, 391, 44);
		add(greeting);

		JLabel lblCurrentListOf = new JLabel("Current List of Bookings on File:");
		lblCurrentListOf.setFont(new Font("Tahoma", Font.BOLD, 16));
		greeting.add(lblCurrentListOf);

		Object[][] data = {
				{1,127,"Robert"},
				{2,28,"Robert"},
				{3,200,"Mark"},
				{4,12,"Dell"},
				{5,15,"Thomas"}
		};

		JTable bookings = new JTable(data,columnNames);
		bookings.setFont(new Font("Tahoma", Font.PLAIN, 16));

		bookings.setPreferredScrollableViewportSize(new Dimension(200,200));
		bookings.setFillsViewportHeight(true);
		bookings.setEnabled(false);
		bookings.getTableHeader().setReorderingAllowed(false);

		JScrollPane scrollPane = new JScrollPane(bookings);
		scrollPane.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setBounds(316, 124, 395, 132);
		add(scrollPane);

		JButton deleteBookingButton = new JButton("Delete");
		deleteBookingButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		deleteBookingButton.setForeground(Color.RED);
		deleteBookingButton.setBounds(584, 261, 102, 23);
		add(deleteBookingButton);

		JLabel bookingId = new JLabel("Booking ID");
		bookingId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bookingId.setBounds(320, 261, 127, 23);
		add(bookingId);

		JTextField deleteBooking = new JTextField();
		deleteBooking.setBounds(434, 261, 140, 21);
		add(deleteBooking);
		deleteBooking.setColumns(10);

		JLabel welcomeUser = new JLabel("Welcome ");
		welcomeUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		welcomeUser.setBounds(759, 50, 127, 23);
		add(welcomeUser);

		JLabel signOut = new JLabel("Sign Out");
		signOut.setFont(new Font("Tahoma", Font.PLAIN, 16));
		signOut.setFocusable(true);
		signOut.addKeyListener(this);
		signOut.addMouseListener(this);
		signOut.setForeground(new Color(0,160,255));
		signOut.setBounds(901, 50, 68, 23);
		add(signOut);

		JLabel lblPleaseEnterThe = new JLabel("Please Enter the booking Id of the  Booking you would like to Remove in the box above");
		lblPleaseEnterThe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPleaseEnterThe.setBounds(180, 326, 640, 14);
		add(lblPleaseEnterThe);

		JLabel lblTitanfallTowersHotel = new JLabel("TitanFall Towers Hotel");
		lblTitanfallTowersHotel.setBounds(329, 11, 357, 40);
		add(lblTitanfallTowersHotel);
		lblTitanfallTowersHotel.setFont(new Font("Verdana", Font.ITALIC, 32));

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
}
