package GUI;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import Model.User;

public class UserTabbedScreen extends JFrame {
	private JTabbedPane tabbedPane;

	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel panel6;
	
	private Font font;

	
	public UserTabbedScreen() {
		
		
		super("Home");
		font = new Font("Veranda", font.ITALIC, 20);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,500);
		setLocationRelativeTo(null);
	
		//if the users log in was successful then they are brought to this page and LoggedIn is set to true
		this.setTitle("Titanfall Towers-User Home Screen");
		this.setResizable(false);
		this.setBackground(Color.gray);
		
		

		// Create the tab pages
		panel1 = new createBooking();
		panel2 = new manageBooking();
		panel3 = new calendar();
		panel4 = new specials();
		panel5 = new help();
		panel6 = new manageAccount();

		// Create a tabbed pane
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Create Booking", panel1);
		tabbedPane.addTab("Manage Booking", panel2);
		tabbedPane.addTab("Calendar", panel3);
		tabbedPane.addTab("Add Specials", panel4);
		tabbedPane.addTab("Help", panel5);
		tabbedPane.addTab("Manage Account", panel6);
		this.add(tabbedPane);
	}
	

	// Main method to get things started
	public static void main(String args[]) {
		// Create an instance of the test application
		UserTabbedScreen mainFrame = new UserTabbedScreen();
		mainFrame.setVisible(true);
	}
}
