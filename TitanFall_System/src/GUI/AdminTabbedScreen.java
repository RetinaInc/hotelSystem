package GUI;


import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import Model.User;

public class AdminTabbedScreen extends JFrame {
	private JTabbedPane tabbedPane;

	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	private JPanel panel6;
	
	private Font font;

	
	public AdminTabbedScreen() {
		
		
		super("Home");
		font = new Font("Veranda", font.ITALIC, 20);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000,500);
		setLocationRelativeTo(null);
	
		//if the users log in was successful then they are brought to this page and LoggedIn is set to true
		this.setTitle("Titanfall Towers-Admin Home Screen");
		this.setResizable(false);
		this.setBackground(Color.gray);
		
		

		// Create the tab pages
		panel1 = new AdminManageBooking();
		panel2 = new AdminManageRooms();
		panel3 = new AdminAddSpecials();
		panel4 = new AdminPrintReports();
		panel5 = new AdminHelp();
		panel6 = new AdminManageAccount();

		// Create a tabbed pane
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Manage Bookings", panel1);
		tabbedPane.addTab("Manage Rooms", panel2);
		tabbedPane.addTab("Add Specials", panel3);
		tabbedPane.addTab("Print Reports", panel4);
		tabbedPane.addTab("Help", panel5);
		tabbedPane.addTab("Manage Account", panel6);
		this.add(tabbedPane);
	}
	

	// Main method to get things started
	public static void main(String args[]) {
		// Create an instance of the test application
		AdminTabbedScreen mainFrame = new AdminTabbedScreen();
		mainFrame.setVisible(true);
	}
}
