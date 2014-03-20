package GUI;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class UserTabbedScreen extends JFrame {
	private JTabbedPane tabbedPane;

	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5;
	
	public UserTabbedScreen() {
		super("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,400);
		setLocationRelativeTo(null);
	
		getContentPane().setLayout(new BorderLayout(0, 0));
		//if the users log in was successful then they are brought to this page and LoggedIn is set to true
		this.setTitle("Titanfall Towers-User Home Screen");
		this.setSize(600, 300);
		this.setResizable(false);
		this.setBackground(Color.gray);

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BorderLayout());
		this.add(topPanel);

		// Create the tab pages
		panel1 = new createBooking();
		panel2 = new manageBooking();
		panel3 = new calendar();
		panel4 = new help();
		panel5 = new manageAccount();

		// Create a tabbed pane
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Create Booking", panel1);
		tabbedPane.addTab("Manage Booking", panel2);
		tabbedPane.addTab("Calendar", panel3);
		tabbedPane.addTab("Help", panel4);
		tabbedPane.addTab("Manage Account", panel5);
		this.add(tabbedPane, BorderLayout.CENTER);
	}

	// Main method to get things started
	public static void main(String args[]) {
		// Create an instance of the test application
		UserTabbedScreen mainFrame = new UserTabbedScreen();
		mainFrame.setVisible(true);
	}
}
