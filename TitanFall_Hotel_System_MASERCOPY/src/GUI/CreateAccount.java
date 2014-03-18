package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import Model.User;
import Database.*;

import java.awt.event.*;
import java.awt.*;

public class CreateAccount extends JFrame implements ActionListener {
	private JTextField fname, lname, email, address, phone, username;
	private JPasswordField password;
	private JButton btnLogin, btnContinue;
	private JLabel lblFirstName, lblLastName, lblEmailAddress, lblHomeAddress,
			lblTelephone, lblUsername, lblPassword;

	public CreateAccount() {
		super("Create an account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setSize(493, 360);
		setLocationRelativeTo(null);

		JPanel greeting = new JPanel();
		getContentPane().add(greeting);
		greeting.setBounds(40, 11, 390, 50);

		JLabel lblTitanfallTowersHotel = new JLabel("TitanFall Towers Hotel");
		lblTitanfallTowersHotel.setFont(new Font("Verdana", Font.ITALIC, 20));
		greeting.add(lblTitanfallTowersHotel);

		JPanel account_details = new JPanel();
		getContentPane().add(account_details);
		account_details.setBounds(40, 74, 363, 191);
		account_details.setBorder(new TitledBorder("Enter account details"));
		account_details.setLayout(new GridLayout(7, 2));

		lblFirstName = new JLabel("First Name");
		account_details.add(lblFirstName);

		fname = new JTextField();
		account_details.add(fname);
		fname.setColumns(10);

		lblLastName = new JLabel("Last Name");
		account_details.add(lblLastName);

		lname = new JTextField();
		account_details.add(lname);
		lname.setColumns(10);

		lblHomeAddress = new JLabel("Home Address");
		account_details.add(lblHomeAddress);

		address = new JTextField();
		account_details.add(address);
		address.setColumns(10);

		lblTelephone = new JLabel("Telephone");
		account_details.add(lblTelephone);

		phone = new JTextField();
		account_details.add(phone);
		phone.setColumns(10);

		lblEmailAddress = new JLabel("Email Address");
		account_details.add(lblEmailAddress);

		email = new JTextField();
		account_details.add(email);
		email.setColumns(10);

		lblUsername = new JLabel("Username");
		account_details.add(lblUsername);

		username = new JTextField();
		account_details.add(username);
		username.setColumns(10);

		lblPassword = new JLabel("Password");
		account_details.add(lblPassword);

		password = new JPasswordField();
		account_details.add(password);

		btnLogin = new JButton("Login");
		btnLogin.addActionListener(this);
		btnLogin.setBounds(40, 276, 89, 23);
		getContentPane().add(btnLogin);

		btnContinue = new JButton("Continue");
		btnContinue.addActionListener(this);
		btnContinue.setBounds(314, 276, 89, 23);
		getContentPane().add(btnContinue);
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
			this.setVisible(false);
			l.setVisible(true);

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

				User u = new User(fname.getText(), lname.getText(),
						address.getText(), email.getText(), phone.getText(),
						username.getText(), password.getText());

				CreateUsers cu = new CreateUsers();
				if (cu.buildUser(u) == true) {
					JOptionPane
							.showMessageDialog(
									null,
									"Sorry, this username is already taken, please try a different username",
									"Warning", JOptionPane.WARNING_MESSAGE);
				} else {
					this.setVisible(false);
					UserScreen us = new UserScreen();
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
}
