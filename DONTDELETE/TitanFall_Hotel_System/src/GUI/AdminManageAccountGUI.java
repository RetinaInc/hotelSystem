package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AdminManageAccountGUI extends JPanel implements KeyListener, ActionListener {
	private JPanel container;
	
	public AdminManageAccountGUI(){

		this.setLayout(null);
		container = new JPanel();
		container.setLayout(null);
		container.setVisible(true);
		container.setBounds(110,150,750,400);
		add(container);
		
		JPanel options = new JPanel(null);
		options.setBounds(10,43,759,244);


		// Contains all the elements necessary to change your personal details
		JPanel updateDetailsOption = new JPanel(null);
		updateDetailsOption.setBounds(52, 11, 276, 220);

		JPanel updateDetails = new JPanel(new GridLayout(5,2));
		updateDetails.setBounds(12,24,256,128);
		updateDetailsOption.setBorder(BorderFactory.createTitledBorder("Change Details"));
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


		JPanel updateButton = new JPanel(null);
		updateButton.setBounds(39,165,199,42);
		updateDetailsOption.add(updateButton);
		JButton updateDetailsBtn = new JButton("Update Details");
		updateDetailsBtn.setBounds(39, 13, 129, 20);
		updateButton.add(updateDetailsBtn);
		updateDetailsBtn.setToolTipText("Update your details");
		updateDetailsBtn.isFocusable();
		updateDetailsBtn.addKeyListener(this);
		updateDetailsBtn.addActionListener(this);

		options.add(updateDetailsOption);
		container.add(options);

		// Contains all the elements necessary to change your personal password
		JPanel updatePassword = new JPanel(new GridLayout(2,0));
		updatePassword.setBounds(395, 11, 318, 220);
		options.add(updatePassword);
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
		changePasswordBtn.setBounds(88, 61, 140, 23);
		changePasswordBtn.setToolTipText("Update your password");
		changePasswordBtn.isFocusable();
		changePasswordBtn.addKeyListener(this);
		changePasswordBtn.addActionListener(this);
		changePasswordPanel.add(changePasswordBtn);
		updatePassword.add(changePasswordPanel);

		JLabel errorMessage = new JLabel("");
		errorMessage.setForeground(Color.RED);
		errorMessage.setBounds(91, 290, 225, 23);
		errorMessage.setVisible(false);
		container.add(errorMessage);

		JLabel updatePasswordErrorMessage = new JLabel("");
		updatePasswordErrorMessage.setForeground(Color.RED);
		updatePasswordErrorMessage.setBounds(470, 290, 225, 23);
		updatePasswordErrorMessage.setVisible(false);
		container.add(updatePasswordErrorMessage);
	}
	public void actionPerformed(ActionEvent arg0) {
	}
	public void keyPressed(KeyEvent arg0) {
	}
	public void keyReleased(KeyEvent arg0) {
	}
	public void keyTyped(KeyEvent arg0) {
	}
}
