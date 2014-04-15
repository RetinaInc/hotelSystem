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
	private JPanel container;
	public AdminManageBooking(){
		this.setLayout(null);
		container = new JPanel();
		container.setLayout(null);
		container.setVisible(true);
		container.setBounds(150,100,675,420);
		add(container);
		//Panel used to welcome the user
		JPanel greeting = new JPanel();
		greeting.setBounds(161, 77, 391, 44);
		container.add(greeting);

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
		scrollPane.setBounds(157, 132, 395, 132);
		container.add(scrollPane);

		JButton deleteBookingButton = new JButton("Delete");
		deleteBookingButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		deleteBookingButton.setForeground(Color.RED);
		deleteBookingButton.setBounds(425, 269, 102, 23);
		container.add(deleteBookingButton);

		JLabel bookingId = new JLabel("Booking ID");
		bookingId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bookingId.setBounds(161, 269, 127, 23);
		container.add(bookingId);

		JTextField deleteBooking = new JTextField();
		deleteBooking.setBounds(275, 269, 140, 21);
		container.add(deleteBooking);
		deleteBooking.setColumns(10);


		JLabel lblPleaseEnterThe = new JLabel("Please Enter the booking Id of the  Booking you would like to Remove in the box above");
		lblPleaseEnterThe.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPleaseEnterThe.setBounds(21, 334, 640, 23);
		container.add(lblPleaseEnterThe);

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
