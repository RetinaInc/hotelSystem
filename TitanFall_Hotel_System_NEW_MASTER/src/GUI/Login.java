package GUI;
import javax.swing.*;

import Database.CreateTables;
import Database.Queries;
import Model.Hotel;
import Model.User;
import oracle.jdbc.pool.OracleDataSource;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;


public class Login extends JFrame implements ActionListener,MouseListener,KeyListener{
	private JTextField username;
	private JPasswordField password;
	private JButton btnLogin;
	private JLabel lblCreateAccount;

	private Statement stmt;
	private ResultSet rset;
	Queries q = new Queries();
	private boolean creatingBooking = false;
	private double total;
	private int numRooms,numNights,numGuests;
	private String arrivalD,departureD;
	private Calendar calDate;
	
	public Login(){
		createLoginScreen();
	}
	
	public Login(Calendar dc,double total, int numberOfRooms, int numNights, int numberOfGuests, String arrivalDate, String departureDate){
		this.calDate = dc;
		creatingBooking = true;
		this.total = total;
		numRooms = numberOfRooms;
		this.numNights = numNights;
		numGuests = numberOfGuests;
		arrivalD = arrivalDate;
		departureD = departureDate;
		createLoginScreen();

	}
	
	public void createLoginScreen(){
		setTitle("Login Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(520,325);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		JPanel greeting = new JPanel();
		getContentPane().add(greeting);
		greeting.setBounds(54,11,390,50);
		
		JLabel lblTitanfallTowersHotel = new JLabel("Welcome to TitanFall Towers Hotel");
		lblTitanfallTowersHotel.setFont(new Font("Verdana", Font.ITALIC, 20));
		greeting.add(lblTitanfallTowersHotel);
		
		JPanel login_panel = new JPanel();
		getContentPane().add(login_panel);
		login_panel.setLayout(new GridLayout(2,2));
		login_panel.setBounds(127, 84, 238, 92);
		
		JPanel login_details = new JPanel();
		login_panel.add(login_details);
		login_details.setLayout(new GridLayout(2,2));
		
		JLabel lblUsername = new JLabel("Username");
		login_details.add(lblUsername);
		
		username = new JTextField();
		username.setToolTipText("Please enter your username");
		login_details.add(username);
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		login_details.add(lblPassword);
		
		password = new JPasswordField();
		password.setToolTipText("Please enter your password");
		login_details.add(password);
		
		JPanel login_button = new JPanel();
		login_panel.add(login_button);
		login_button.setLayout(new GridLayout(2,0));
		
		 btnLogin = new JButton("Login");
		 btnLogin.setToolTipText("Login to your account");
		 btnLogin.isFocusable();
		 btnLogin.addKeyListener(this);
		 btnLogin.setFocusable(true);
		btnLogin.addActionListener(this);
		login_button.add(btnLogin);
		
		JPanel create_accountOption = new JPanel();
		login_button.add(create_accountOption);
		create_accountOption.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		 lblCreateAccount = new JLabel("Create Account");
		 lblCreateAccount.setToolTipText("Create a new account");
		 lblCreateAccount.setFocusable(true);
		 lblCreateAccount.addKeyListener(this);
		 lblCreateAccount.setForeground(new Color(0,160,255));
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
		
		for(int i = 0; i < users.size(); i++){
			
			if(users.get(i).getUserID().equals(username.getText()) && users.get(i).getPassword().equals(password.getText())){
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
				try{
				if(type.equals("A")){
					Admin a = new Admin(user,users);
					this.setVisible(false);
					a.setVisible(true);
				}
				else if(loginSuccessful() == true && creatingBooking == true){
					CreditCard c = new CreditCard(calDate,user,users,total, numRooms,numNights,numGuests,arrivalD,departureD);
					this.setVisible(false);
					c.setVisible(true);
					
				}
				else
				{
					UserScreen ab = new UserScreen(user,users);
					this.setVisible(false);
					ab.setVisible(true);
				}
				}
				catch(Exception ae){}
				
			
			}
			else
				JOptionPane.showMessageDialog(null, "Invalid username or password","Login Error",JOptionPane.ERROR_MESSAGE);
			}
			catch(NumberFormatException ae){}
			}
			
		}


	public void mouseClicked(MouseEvent e) {    
        	CreateAccount c = new CreateAccount();
        	setVisible(false);
        	c.setVisible(true);
		
	}


	
	public void mouseEntered(MouseEvent e) {
        	lblCreateAccount.setForeground(new Color(100,255,100));
        }


	
	public void mouseExited(MouseEvent e) {
		lblCreateAccount.setForeground(new Color(0,160,255)); 
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
			try{
				
				if(loginSuccessful()){
					try{
					if(type.equals("A")){
						Admin a = new Admin(user,users);
						this.setVisible(false);
						a.setVisible(true);
					}
					else if(loginSuccessful() == true && creatingBooking == true){
						CreditCard c = new CreditCard(calDate,user,users,total, numRooms,numNights,numGuests,arrivalD,departureD);
						this.setVisible(false);
						c.setVisible(true);
						
					}
					else
					{
						UserScreen ab = new UserScreen(user,users);
						this.setVisible(false);
						ab.setVisible(true);
					}
					}
					catch(Exception ae){}
					
				
				}
				else
					JOptionPane.showMessageDialog(null, "Invalid username or password","Login Error",JOptionPane.ERROR_MESSAGE);
				}
				catch(NumberFormatException ae){}
				
		}
		
		else if(e.getSource() == lblCreateAccount && e.getKeyCode() == KeyEvent.VK_ENTER){
			CreateAccount c = new CreateAccount();
        	setVisible(false);
        	c.setVisible(true);
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



