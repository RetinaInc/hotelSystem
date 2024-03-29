package GUI;

import java.awt.*;
import java.awt.event.*;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import Database.CreateTables;
import Database.CreateUsers;
import Model.Hotel;
import Model.User;

public class AddAdminGUI extends JPanel implements ActionListener{
	private JTextField fname, lname, email, address, phone, username;
	private JPasswordField password;
	private JButton createAdmin;
	private JLabel lblFirstName, lblLastName, lblEmailAddress, lblHomeAddress,
			lblTelephone, lblUsername, lblPassword;
	private Color color = new Color(227,99,26);
	private Font fontBigger;
	private JPanel container;

	public AddAdminGUI(){
		this.setSize(600, 600);
		this.setLayout(null);
		container = new JPanel();
		container.setLayout(null);
		container.setBounds(200,100,495, 360);
		add(container);
		JPanel greeting = new JPanel();
		container.add(greeting);
		greeting.setBounds(40, 11, 390, 50);

		fontBigger = new Font("Veranda", Font.PLAIN, 18);
		JPanel account_details = new JPanel();
		account_details.setFont(fontBigger);
		container.add(account_details);
		account_details.setBounds(100, 74, 363, 191);
		account_details.setBorder(new TitledBorder("Enter account details"));
		account_details.setLayout(new GridLayout(7, 2));

		lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(fontBigger);
		account_details.add(lblFirstName);

		fname = new JTextField();
		fname.setToolTipText("Enter your first name");
		account_details.add(fname);
		fname.setColumns(10);

		lblLastName = new JLabel("Last Name");
		lblLastName.setFont(fontBigger);
		account_details.add(lblLastName);

		lname = new JTextField();
		lname.setToolTipText("Enter your last name");
		account_details.add(lname);
		lname.setColumns(10);

		lblHomeAddress = new JLabel("Home Address");
		lblHomeAddress.setFont(fontBigger);
		account_details.add(lblHomeAddress);

		address = new JTextField();
		address.setToolTipText("Enter your home address");
		account_details.add(address);
		address.setColumns(10);

		lblTelephone = new JLabel("Telephone");
		lblTelephone.setFont(fontBigger);
		account_details.add(lblTelephone);

		phone = new JTextField();
		phone.setToolTipText("Enter your phone number");
		account_details.add(phone);
		phone.setColumns(10);

		lblEmailAddress = new JLabel("Email Address");
		lblEmailAddress.setFont(fontBigger);
		account_details.add(lblEmailAddress);

		email = new JTextField();
		email.setToolTipText("Enter your email address");
		account_details.add(email);
		email.setColumns(10);

		lblUsername = new JLabel("Username");
		lblUsername.setFont(fontBigger);
		account_details.add(lblUsername);

		username = new JTextField();
		username.setToolTipText("Enter your chosen username");
		account_details.add(username);
		username.setColumns(10);

		lblPassword = new JLabel("Password");
		lblPassword.setFont(fontBigger);
		account_details.add(lblPassword);

		password = new JPasswordField();
		password.setToolTipText("Enter your password");
		account_details.add(password);

		createAdmin = new JButton("Create new Administrator");
		createAdmin.setFont(fontBigger);
		createAdmin.setBackground(color);
		createAdmin.setToolTipText("Create a new administrator");
		createAdmin.isFocusable();
		createAdmin.addActionListener(this);
		createAdmin.setBounds(180, 276, 240, 30);
		container.add(createAdmin);
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
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == createAdmin) {
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
				User u = new User(username.getText(),"A",fname.getText(),lname.getText(),address.getText(),phone.getText(),
						email.getText(),encryptedPassword);
				
				users.add(u);
				
				CreateUsers cu = new CreateUsers();
				if (cu.buildUser(u) == true) {
					JOptionPane.showMessageDialog(null,"Sorry, " + username.getText() +
							" is already taken, please try a different username",
									"Warning", JOptionPane.WARNING_MESSAGE);
					username.setText("");
				}
				else
					JOptionPane.showMessageDialog(null,username.getText() + " was added to the system",
							"Administrator added", JOptionPane.INFORMATION_MESSAGE);

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
}
