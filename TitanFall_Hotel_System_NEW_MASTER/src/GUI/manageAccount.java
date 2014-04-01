package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class manageAccount extends JPanel implements KeyListener, ActionListener {
	public manageAccount(){
	JPanel manage_account = new JPanel();
	manage_account.setLayout(null);
	
	
	this.setLayout(null);
	JLabel welcome = new JLabel("Welcome to TitanFall Towers Hotel");
	welcome.setBounds(194, 33, 589, 26);
	add(welcome);
	welcome.setFont(new Font("Verdana", Font.ITALIC, 32));
	
	JLabel welcomeUser = new JLabel("Welcome " + "Thomas");
	welcomeUser.setForeground(new Color(50, 205, 50));
	welcomeUser.setFont(new Font("Tahoma", Font.ITALIC, 14));
	welcomeUser.setBounds(841, 11, 127, 23);
	add(welcomeUser);
	
	JLabel errorMessage = new JLabel("");
	errorMessage.setForeground(Color.RED);
	errorMessage.setBounds(91, 290, 225, 23);
	errorMessage.setVisible(false);
	manage_account.add(errorMessage);
	
	
	JLabel updatePasswordErrorMessage = new JLabel("");
	updatePasswordErrorMessage.setForeground(Color.RED);
	updatePasswordErrorMessage.setBounds(470, 290, 225, 23);
	updatePasswordErrorMessage.setVisible(false);
	manage_account.add(updatePasswordErrorMessage);
	
	//contains all the elements neccessary to change your details
	JPanel updateDetailsOption = new JPanel(null);
	updateDetailsOption.setBorder(new TitledBorder(null, "Update Personal Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	updateDetailsOption.setBounds(140, 131, 358, 259);
	add(updateDetailsOption);
	
	JPanel updateDetails = new JPanel(new GridLayout(5,2));
	updateDetails.setBounds(10,21,338,163);
	updateDetailsOption.add(updateDetails);
	
	JLabel fname = new JLabel("First Name:");
	JTextField tfname = new JTextField();
	tfname.setToolTipText("Enter your first name");
	JLabel lname = new JLabel("Last Name:");
	JTextField tlname = new JTextField();
	tlname.setToolTipText("Enter your last name");
	JLabel lHomeAddress = new JLabel("Home Address");
	JTextField address = new JTextField();
	address.setToolTipText("Enter your home address");
	JLabel email = new JLabel("Email Address:       ");
	JTextField temail = new JTextField();
	temail.setToolTipText("Enter your email address");
	JLabel phone = new JLabel("Telephone:");
	JTextField tphone = new JTextField();
	tphone.setToolTipText("Enter your phone number");
	
	updateDetails.add(fname);
	updateDetails.add(tfname);
	updateDetails.add(lname);
	updateDetails.add(tlname);
	updateDetails.add(lHomeAddress);
	updateDetails.add(address);
	updateDetails.add(email);
	updateDetails.add(temail);
	updateDetails.add(phone);
	updateDetails.add(tphone);
	
	JButton changeDetailsBtn = new JButton("Update Details");
	changeDetailsBtn.setBounds(119, 200, 144, 35);
	updateDetailsOption.add(changeDetailsBtn);
	//contains all the elements neccessary to change your password
	JPanel updatePassword = new JPanel(new GridLayout(2,0));
	updatePassword.setBounds(508, 131, 358, 259);
	add(updatePassword);
	updatePassword.setBorder(BorderFactory.createTitledBorder("Change Password"));
	
	JPanel changePassword = new JPanel(new GridLayout(3,2));
	updatePassword.add(changePassword);
	
	JLabel oldPass = new JLabel("Old Password:");
	JPasswordField toldPass = new JPasswordField();
	toldPass.setToolTipText("Enter your current password");
	JLabel newPass = new JLabel("New Password:");
	JPasswordField tnewPass = new JPasswordField();
	tnewPass.setToolTipText("Enter your new password");
	JLabel confirmNewPass = new JLabel("Confirm New Password:  ");
	JPasswordField tconfirmNewPass = new JPasswordField();
	tconfirmNewPass.setToolTipText("Confirm your new password");
	
	
	changePassword.add(oldPass);
	changePassword.add(toldPass);
	changePassword.add(newPass);
	changePassword.add(tnewPass);
	changePassword.add(confirmNewPass);
	changePassword.add(tconfirmNewPass);
	
	JPanel changePasswordPanel = new JPanel(null);
	JButton changePasswordBtn = new JButton("Update Password");
	changePasswordBtn.setBounds(114, 71, 151, 36);
	changePasswordBtn.setToolTipText("Update your password");
	changePasswordBtn.isFocusable();
	changePasswordBtn.addKeyListener(this);
	changePasswordBtn.addActionListener(this);
	changePasswordPanel.add(changePasswordBtn);
	updatePassword.add(changePasswordPanel);
	
	JLabel lblUpdateYourAccount = new JLabel("Update Your account details here ....");
	lblUpdateYourAccount.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblUpdateYourAccount.setBounds(297, 70, 345, 36);
	add(lblUpdateYourAccount);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
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
