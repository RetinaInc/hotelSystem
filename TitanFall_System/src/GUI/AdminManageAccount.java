package GUI;

import java.awt.Color;
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

public class AdminManageAccount extends JPanel implements KeyListener, ActionListener {
	public AdminManageAccount(){

		JLabel welcome3 = new JLabel("TitanFall Towers Hotel");;
		welcome3.setBounds(309, 11, 264, 44);
		add(welcome3);

		JPanel options = new JPanel(null);
		options.setBounds(10,66,759,221);


		//contains all the elements neccessary to change your details
		JPanel updateDetailsOption = new JPanel(null);
		updateDetailsOption.setBounds(52, 19, 276, 183);

		JPanel updateDetails = new JPanel(new GridLayout(5,2));
		updateDetails.setBounds(10,0,256,128);
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
		updateButton.setBounds(40,128,199,55);
		updateDetailsOption.add(updateButton);
		JButton updateDetailsBtn = new JButton("Update Details");
		updateDetailsBtn.setBounds(32, 12, 140, 23);
		updateDetailsBtn.setToolTipText("Update your details");
		updateDetailsBtn.isFocusable();
		updateDetailsBtn.addKeyListener(this);
		updateDetailsBtn.addActionListener(this);
		updateButton.add(updateDetailsBtn);

		options.add(updateDetailsOption);
		add(options);

		//contains all the elements neccessary to change your password
		JPanel updatePassword = new JPanel(new GridLayout(2,0));
		updatePassword.setBounds(395, 11, 318, 191);
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
		changePasswordBtn.setBounds(88, 50, 140, 23);
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
		add(errorMessage);

		JLabel updatePasswordErrorMessage = new JLabel("");
		updatePasswordErrorMessage.setForeground(Color.RED);
		updatePasswordErrorMessage.setBounds(470, 290, 225, 23);
		updatePasswordErrorMessage.setVisible(false);
		add(updatePasswordErrorMessage);


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
