package GUI;
import javax.swing.*;

import Database.CreateTables;
import Database.Queries;
import Model.Booking;
import Model.Hotel;
import Model.User;
import oracle.jdbc.pool.OracleDataSource;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class LoginGUI extends JPanel implements ActionListener,MouseListener,KeyListener{
	private JTextField username;
	private JPasswordField password;
	private JButton btnLogin, btnBack;
	private JLabel lblCreateAccount;
	private JPanel container;
	Queries q = new Queries();
	private boolean creatingBooking = false;
	private double total;
	private int numRooms,numNights,numGuests;
	private String arrivalD,departureD;
	private Calendar calDate = Calendar.getInstance();
	private ArrayList<Integer> roomChoice;
	private Color color = new Color(227,99,26);
	private Font fontBigger;
	public LoginGUI(){
		createLoginScreen();
	}
	
	public LoginGUI(Calendar dc,double total, int numberOfRooms, int numNights, String arrivalDate, String departureDate, ArrayList<Integer> roomChoice){
		this.roomChoice = roomChoice; //Possibly not working
		Date dcDate = dc.getTime();
		calDate.setTime(dcDate);
		creatingBooking = true;
		this.total = total;
		numRooms = numberOfRooms;
		this.numNights = numNights;
		arrivalD = arrivalDate;
		departureD = departureDate;
		createLoginScreen();

	}
	
	public void createLoginScreen(){
		setSize(1000, 600);
		setLayout(null);
		container = new JPanel();
		container.setLocation(135, 11);
		container.setSize(400, 280);
		add(container);

		fontBigger = new Font("Veranda", Font.PLAIN, 16);
		JPanel login_panel = new JPanel();
		container.add(login_panel);
		login_panel.setLayout(new GridLayout(2,2));
		login_panel.setBounds(127, 84, 238, 92);
		
		JPanel login_details = new JPanel();
		login_panel.add(login_details);
		GridBagLayout gbl_login_details = new GridBagLayout();
		gbl_login_details.columnWidths = new int[]{86, 86, 0};
		gbl_login_details.rowHeights = new int[]{33, 33, 0};
		gbl_login_details.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_login_details.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		login_details.setLayout(gbl_login_details);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(fontBigger);
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.ABOVE_BASELINE;
		gbc_lblUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 0;
		gbc_lblUsername.gridy = 0;
		login_details.add(lblUsername, gbc_lblUsername);
		
		username = new JTextField();
		username.setToolTipText("Please enter your username");
		GridBagConstraints gbc_username = new GridBagConstraints();
		gbc_username.anchor = GridBagConstraints.WEST;
		gbc_username.insets = new Insets(0, 0, 5, 0);
		gbc_username.gridx = 1;
		gbc_username.gridy = 0;
		login_details.add(username, gbc_username);
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(fontBigger);
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.BELOW_BASELINE;
		gbc_lblPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPassword.insets = new Insets(0, 0, 0, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 1;
		login_details.add(lblPassword, gbc_lblPassword);
		
		password = new JPasswordField();
		password.isFocusable();
		password.addKeyListener(this);
		password.setToolTipText("Please enter your password");
		GridBagConstraints gbc_password = new GridBagConstraints();
		gbc_password.fill = GridBagConstraints.HORIZONTAL;
		gbc_password.gridx = 1;
		gbc_password.gridy = 1;
		login_details.add(password, gbc_password);
		
		JPanel button_panel= new JPanel();
		login_panel.add(button_panel);
		JPanel buttons = new JPanel(new FlowLayout());
		button_panel.add(buttons);
		button_panel.setLayout(new GridLayout(2,0));
		
		 btnLogin = new JButton("Login");
		 btnLogin.setFont(fontBigger);
		 btnLogin.setBackground(color);
		 btnLogin.setToolTipText("Login to your account");
		 btnLogin.isFocusable();
		 btnLogin.addKeyListener(this);
		 btnLogin.setFocusable(true);
		btnLogin.addActionListener(this);
		buttons.add(btnLogin);
		btnBack = new JButton("Back");
		btnBack.setFont(fontBigger);
		btnBack.setBackground(color);
		btnBack.setToolTipText("Go Back");
		btnBack.isFocusable();
		btnBack.addKeyListener(this);
		btnBack.setFocusable(true);
		btnBack.addActionListener(this);
		buttons.add(btnBack);
		
		JPanel create_accountOption = new JPanel();
		button_panel.add(create_accountOption);
		create_accountOption.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		 lblCreateAccount = new JLabel("Create Account");
		 lblCreateAccount.setFont(fontBigger);
		 lblCreateAccount.setToolTipText("Create a new account");
		 lblCreateAccount.setFocusable(true);
		 lblCreateAccount.addKeyListener(this);
		 lblCreateAccount.addMouseListener(this);
		 create_accountOption.add(lblCreateAccount);
	}
	
	String type = "";
	String user = "";
	
	CreateTables c = new CreateTables();
	Hotel h = c.getHotel();
	ArrayList<User> users = c.getUsers();
	
	
	public boolean loginSuccessful(){
		boolean login = false;
		String passDe = "";
		for(int i = 0; i < users.size(); i++){
			try {
				passDe = Encryption.encrypt(password.getText());
			} catch (GeneralSecurityException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(users.get(i).getUserID().equals(username.getText()) && users.get(i).getPassword().equals(passDe)){
				login = true;
				type = users.get(i).getUserType();
				user = users.get(i).getUserID();
			}	
		}
		return login;
	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnLogin){
			try{	
			if(loginSuccessful()){
				loginMethod();
			}
			else
				JOptionPane.showMessageDialog(null, "Invalid username or password","Login Error",JOptionPane.ERROR_MESSAGE);
			}
			catch(NumberFormatException ae){}
			}
		else if(e.getSource().equals(btnBack) && creatingBooking ==  false){
			StartPanelGUI s = new StartPanelGUI();
			s.setVisible(true);
			container.setVisible(false);
			add(s);
		}
		else if(e.getSource().equals(btnBack) && creatingBooking ==  true){
			//calDate.add(Calendar.DATE,  - numNights);
			Booking b = new Booking(calDate ,numNights);			
			AvailabilityGUI a = new AvailabilityGUI(calDate,numNights);
			a.listContent(b.availability());
			container.setVisible(false);
			a.setVisible(true);
			add(a);
		}
		}
	


	public void mouseClicked(MouseEvent e) {    
		if(creatingBooking == true){
			CreateAccountGUI c = new CreateAccountGUI(calDate,total, numRooms,numNights,numGuests,arrivalD,departureD, roomChoice);
        	container.setVisible(false);
        	c.setVisible(true);
        	add(c);
		}
		else
		{
			CreateAccountGUI c = new CreateAccountGUI();
        	container.setVisible(false);
        	c.setVisible(true);
        	add(c);
		}
	}

	public void mouseEntered(MouseEvent e) {
    	lblCreateAccount.setForeground(color);
    }



public void mouseExited(MouseEvent e) {
	lblCreateAccount.setForeground(color.BLACK); 
}



public void mousePressed(MouseEvent e) {
    	lblCreateAccount.setForeground(Color.BLUE);
}

public void mouseReleased(MouseEvent e) {

    	lblCreateAccount.setForeground(Color.BLUE);
}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getSource() == btnLogin && e.getKeyCode() == KeyEvent.VK_ENTER){
			loginMethod();			
		}
		
		else if(e.getSource() == password && e.getKeyCode() == KeyEvent.VK_ENTER){
			loginMethod();
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
	public void loginMethod(){
		try{
			
			if(loginSuccessful()){
				try{
				if(type.equals("A")){
					System.out.println(user);
					System.out.println(users.get(0).getfName());
					AdminTabbedScreenGUI a = new AdminTabbedScreenGUI(user,users);
					getTopLevelAncestor().setVisible(false);
					a.setVisible(true);
				}
				else if(loginSuccessful() == true && creatingBooking == true){
					CreditCardGUI c = new CreditCardGUI(calDate,user,users,total, numRooms,numNights,arrivalD,departureD, roomChoice);
					container.setVisible(false);
					c.setVisible(true);
					c.setSize(1000, 400);
					add(c);
					
				}
				else
				{
					UserTabbedScreenGUI ab = new UserTabbedScreenGUI(user,users);
					getTopLevelAncestor().setVisible(false);
					this.setVisible(false);
					ab.setVisible(true);
				}
				}
				catch(Exception ae){
					System.out.println(ae);
					ae.printStackTrace();
				}
				
			
			}
			else
				JOptionPane.showMessageDialog(null, "Invalid username or password","Login Error",JOptionPane.ERROR_MESSAGE);
			}
			catch(NumberFormatException ae){}
	}

}



