package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import Model.Hotel;
import Model.User;
import Database.*;

import java.awt.event.*;
import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Calendar;

public class CreateAccount extends JPanel implements ActionListener,KeyListener {
	private JTextField fname, lname, email, address, phone, username;
	private JPasswordField password;
	private JButton btnLogin, btnContinue;
	private JLabel lblFirstName, lblLastName, lblEmailAddress, lblHomeAddress,
			lblTelephone, lblUsername, lblPassword;
	private boolean creatingBooking = false;
	private double total;
	private int numRooms,numNights,numGuests;
	private String arrivalD,departureD;
	private Calendar calDate;
	private ArrayList<Integer> roomChoice;
	private Color color = new Color(227,99,26);
	private JPanel container;
	
	public CreateAccount() {
		createCreateAccountScreen();
	}
	public CreateAccount(Calendar dc,double total, int numberOfRooms, int numNights, int numberOfGuests, String arrivalDate, String departureDate, ArrayList<Integer> roomChoice){
		this.roomChoice = roomChoice; //Possibly not working
		this.calDate = dc;
		creatingBooking = true;
		this.total = total;
		numRooms = numberOfRooms;
		this.numNights = numNights;
		numGuests = numberOfGuests;
		arrivalD = arrivalDate;
		departureD = departureDate;
		createCreateAccountScreen();

	}
	public void createCreateAccountScreen(){
		setSize(600,600);
		setLayout(null);
		container = new JPanel();
		container.setLayout(null);
		container.setBounds(120,-60,495, 360);
		add(container);
		JPanel greeting = new JPanel();
		container.add(greeting);
		greeting.setBounds(40, 11, 390, 50);


		JPanel account_details = new JPanel();
		container.add(account_details);
		account_details.setBounds(40, 74, 363, 191);
		account_details.setBorder(new TitledBorder("Enter account details"));
		account_details.setLayout(new GridLayout(7, 2));

		lblFirstName = new JLabel("First Name");
		account_details.add(lblFirstName);

		fname = new JTextField();
		fname.setToolTipText("Enter your first name");
		account_details.add(fname);
		fname.setColumns(10);

		lblLastName = new JLabel("Last Name");
		account_details.add(lblLastName);

		lname = new JTextField();
		lname.setToolTipText("Enter your last name");
		account_details.add(lname);
		lname.setColumns(10);

		lblHomeAddress = new JLabel("Home Address");
		account_details.add(lblHomeAddress);

		address = new JTextField();
		address.setToolTipText("Enter your home address");
		account_details.add(address);
		address.setColumns(10);

		lblTelephone = new JLabel("Telephone");
		account_details.add(lblTelephone);

		phone = new JTextField();
		phone.setToolTipText("Enter your phone number");
		account_details.add(phone);
		phone.setColumns(10);

		lblEmailAddress = new JLabel("Email Address");
		account_details.add(lblEmailAddress);

		email = new JTextField();
		email.setToolTipText("Enter your email address");
		account_details.add(email);
		email.setColumns(10);

		lblUsername = new JLabel("Username");
		account_details.add(lblUsername);

		username = new JTextField();
		username.setToolTipText("Enter your chosen username");
		account_details.add(username);
		username.setColumns(10);

		lblPassword = new JLabel("Password");
		account_details.add(lblPassword);

		password = new JPasswordField();
		password.setToolTipText("Enter your password");
		account_details.add(password);

		btnLogin = new JButton("Login");
		btnLogin.setBackground(color);
		btnLogin.setToolTipText("Login to your account");
		btnLogin.isFocusable();
		btnLogin.addKeyListener(this);
		btnLogin.addActionListener(this);
		btnLogin.setBounds(40, 276, 89, 23);
		container.add(btnLogin);

		btnContinue = new JButton("Continue");
		btnContinue.setBackground(color);
		btnContinue.setToolTipText("Create your account");
		btnContinue.isFocusable();
		btnContinue.addKeyListener(this);
		btnContinue.addActionListener(this);
		btnContinue.setBounds(314, 276, 89, 23);
		container.add(btnContinue);
	}
	public boolean emptyFields(String e) {
		boolean valid = false;
		if (e.isEmpty() == true) {
			valid = false;
		} else {
			valid = true;
		}
		return valid;
	}

	public boolean validateEmail(String e) {
		boolean valid = false;

		int index = e.indexOf('@');
		if (index != -1) {
			valid = true;
		}
		return valid;
	}

	public static boolean isNumber(String string) {
		try {
			Long.parseLong(string);
			// int a = Integer.parseInt(string);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogin) {
			Login l = new Login();
			container.setVisible(false);
			l.setVisible(true);
			add(l);

		} else {
			if (isNumber(fname.getText()) == false
					&& isNumber(lname.getText()) == false
					&& validateEmail(email.getText()) == true
					&& isNumber(phone.getText()) == true 
					&& emptyFields(fname.getText()) == true
					&& emptyFields(lname.getText()) == true
					&& emptyFields(address.getText()) == true
					&& emptyFields(phone.getText()) == true
					&& emptyFields(username.getText()) == true
					&& emptyFields(password.getText()) == true) {

				// Add information to the database
				CreateTables c = new CreateTables();
				Hotel h = c.getHotel();
				ArrayList<User> users = c.getUsers();
				String encryptedPassword = "";
				try {
					encryptedPassword = Encryption.encrypt(password.getText());
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (GeneralSecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				User u = new User(username.getText(),"G",fname.getText(),lname.getText(),address.getText(),phone.getText(),
						email.getText(),encryptedPassword);
				
				users.add(u);

				CreateUsers cu = new CreateUsers();
				if (cu.buildUser(u) == true) {
					JOptionPane.showMessageDialog(null,"Sorry, this username is already taken, please try a different username",
									"Warning", JOptionPane.WARNING_MESSAGE);
				} else {
					if(creatingBooking == true){
						CreditCard cc = new CreditCard(calDate,username.getText(),users,total, numRooms,numNights,numGuests,arrivalD,departureD, roomChoice);
						container.setVisible(false);
						cc.setVisible(true);
						cc.setSize(1000, 400);
						add(cc);
					}
					else
					{
						getTopLevelAncestor().setVisible(false);
						UserTabbedScreen us = new UserTabbedScreen(username.getText(),users);
						us.setVisible(true);
					}
				}

			} else {
				if (emptyFields(fname.getText()) == false
						|| emptyFields(lname.getText()) == false
						|| emptyFields(address.getText()) == false
						|| emptyFields(phone.getText()) == false
						|| emptyFields(username.getText()) == false
						|| emptyFields(password.getText()) == false) {
					JOptionPane.showMessageDialog(null,
							"You cannot leave a field blank", "Warning",
							JOptionPane.WARNING_MESSAGE);
				} else if (validateEmail(email.getText()) == false) {
					JOptionPane.showMessageDialog(null,
							"You must enter a valid email address", "Warning",
							JOptionPane.WARNING_MESSAGE);
				} else
					JOptionPane.showMessageDialog(null,
							"You must enter valid data for each field", "Warning",
							JOptionPane.WARNING_MESSAGE);
			}

		}

	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getSource() == btnLogin && e.getKeyCode() == KeyEvent.VK_ENTER){
			Login l = new Login();
			this.setVisible(false);
			l.setVisible(true);
		}
		
		else if(e.getSource() == btnContinue && e.getKeyCode() == KeyEvent.VK_ENTER){
			if (isNumber(fname.getText()) == false
					&& isNumber(lname.getText()) == false
					&& validateEmail(email.getText()) == true
					&& isNumber(phone.getText()) == true 
					&& emptyFields(fname.getText()) == true
					&& emptyFields(lname.getText()) == true
					&& emptyFields(address.getText()) == true
					&& emptyFields(phone.getText()) == true
					&& emptyFields(username.getText()) == true
					&& emptyFields(password.getText()) == true) {

				// Add information to the database
				CreateTables c = new CreateTables();
				Hotel h = c.getHotel();
				ArrayList<User> users = c.getUsers();
				
				User u = new User(username.getText(),"G",fname.getText(),lname.getText(),address.getText(),phone.getText(),
						email.getText(),password.getText());
				
				users.add(u);

				CreateUsers cu = new CreateUsers();
				if (cu.buildUser(u) == true) {
					JOptionPane
							.showMessageDialog(
									null,
									"Sorry, this username is already taken, please try a different username",
									"Warning", JOptionPane.WARNING_MESSAGE);
				} else {
					this.setVisible(false);
					UserScreen us = new UserScreen(username.getText(),users);
					us.setVisible(true);
				}

			} else {
				if (emptyFields(fname.getText()) == false
						|| emptyFields(lname.getText()) == false
						|| emptyFields(address.getText()) == false
						|| emptyFields(phone.getText()) == false
						|| emptyFields(username.getText()) == false
						|| emptyFields(password.getText()) == false) {
					JOptionPane.showMessageDialog(null,
							"You cannot leave a field blank", "Warning",
							JOptionPane.WARNING_MESSAGE);
				} else if (validateEmail(email.getText()) == false) {
					JOptionPane.showMessageDialog(null,
							"You must enter a valid email address", "Warning",
							JOptionPane.WARNING_MESSAGE);
				} else
					JOptionPane.showMessageDialog(null,
							"You must enter valid data for each field", "Warning",
							JOptionPane.WARNING_MESSAGE);
			}
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
