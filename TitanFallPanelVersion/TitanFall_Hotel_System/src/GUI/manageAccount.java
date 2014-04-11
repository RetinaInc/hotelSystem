package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import Database.CreateTables;
import Model.Hotel;
import Model.User;
import javax.swing.SwingConstants;

public class manageAccount extends JPanel implements KeyListener,
		ActionListener {
	private JPanel container;
	private JTextField tfname,tlname, address, temail, tphone;
	private JLabel errorMessage, updatePasswordErrorMessage;
	private String usersID;
	private ArrayList<User> users;
	private JPasswordField toldPass,tnewPass,  tconfirmNewPass;
	private JButton changeDetailsBtn,changePasswordBtn;
	public manageAccount(String userID, ArrayList<User> users) {
		usersID = userID;
		this.users = users;
		container = new JPanel();
		container.setLayout(null);
		container.setBounds(0, 79,1000, 450);
		JPanel manage_account = new JPanel();
		manage_account.setLayout(null);
		add(container);
		this.setLayout(null);
		container.add(manage_account);
		// contains all the elements neccessary to change your details
		JPanel updateDetailsOption = new JPanel(null);
		updateDetailsOption.setBorder(new TitledBorder(null,
				"Update Personal Details", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		updateDetailsOption.setBounds(140, 131, 358, 259);
		container.add(updateDetailsOption);

		JPanel updateDetails = new JPanel(new GridLayout(5, 2));
		updateDetails.setBounds(10, 21, 338, 163);
		updateDetailsOption.add(updateDetails);

		JLabel fname = new JLabel("First Name:");
		tfname = new JTextField();
		tfname.setToolTipText("Enter your first name");
		JLabel lname = new JLabel("Last Name:");
		tlname = new JTextField();
		tlname.setToolTipText("Enter your last name");
		JLabel lHomeAddress = new JLabel("Home Address");
		address = new JTextField();
		address.setToolTipText("Enter your home address");
		JLabel email = new JLabel("Email Address:       ");
		temail = new JTextField();
		temail.setToolTipText("Enter your email address");
		JLabel phone = new JLabel("Telephone:");
		tphone = new JTextField();
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

		changeDetailsBtn = new JButton("Update Details");
		changeDetailsBtn.setBounds(119, 200, 144, 35);
		changeDetailsBtn.setToolTipText("Update your password");
		changeDetailsBtn.isFocusable();
		changeDetailsBtn.addKeyListener(this);
		changeDetailsBtn.addActionListener(this);
		updateDetailsOption.add(changeDetailsBtn);
		// contains all the elements neccessary to change your password
		JPanel updatePassword = new JPanel(new GridLayout(2, 0));
		updatePassword.setBounds(508, 131, 358, 259);
		container.add(updatePassword);
		updatePassword.setBorder(BorderFactory
				.createTitledBorder("Change Password"));

		JPanel changePassword = new JPanel(new GridLayout(3, 2));
		updatePassword.add(changePassword);

		JLabel oldPass = new JLabel("Old Password:");
		toldPass = new JPasswordField();
		toldPass.setToolTipText("Enter your current password");
		JLabel newPass = new JLabel("New Password:");
		tnewPass = new JPasswordField();
		tnewPass.setToolTipText("Enter your new password");
		JLabel confirmNewPass = new JLabel("Confirm New Password:  ");
		tconfirmNewPass = new JPasswordField();
		tconfirmNewPass.setToolTipText("Confirm your new password");

		changePassword.add(oldPass);
		changePassword.add(toldPass);
		changePassword.add(newPass);
		changePassword.add(tnewPass);
		changePassword.add(confirmNewPass);
		changePassword.add(tconfirmNewPass);

		JPanel changePasswordPanel = new JPanel(null);
		changePasswordBtn = new JButton("Update Password");
		changePasswordBtn.setBounds(114, 71, 151, 36);
		changePasswordBtn.setToolTipText("Update your password");
		changePasswordBtn.isFocusable();
		changePasswordBtn.addKeyListener(this);
		changePasswordBtn.addActionListener(this);
		changePasswordPanel.add(changePasswordBtn);
		updatePassword.add(changePasswordPanel);

		JLabel lblUpdateYourAccount = new JLabel(
				"Update Your account details here ....");
		lblUpdateYourAccount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUpdateYourAccount.setBounds(297, 70, 345, 36);
		container.add(lblUpdateYourAccount);
		
				errorMessage = new JLabel("");
				errorMessage.setHorizontalAlignment(SwingConstants.CENTER);
				errorMessage.setBounds(214, 401, 225, 23);
				container.add(errorMessage);
				errorMessage.setForeground(Color.RED);
				
				updatePasswordErrorMessage = new JLabel("");
				updatePasswordErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
				updatePasswordErrorMessage.setBounds(584, 401, 225, 23);
				container.add(updatePasswordErrorMessage);
				updatePasswordErrorMessage.setForeground(Color.RED);
				updatePasswordErrorMessage.setVisible(false);
				errorMessage.setVisible(true);
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
	public void errorCheckingForUpdateDetails(){
		if (isNumber(tfname.getText()) == false
				&& isNumber(tlname.getText()) == false
				&& validateEmail(temail.getText()) == true
				&& isNumber(tphone.getText()) == true 
				&& emptyFields(tfname.getText()) == true
				&& emptyFields(tlname.getText()) == true
				&& emptyFields(address.getText()) == true
				&& emptyFields(tphone.getText()) == true){
		
			CreateTables c = new CreateTables();
			Hotel h = c.getHotel();
			
			
			h.updateUsersDetails(usersID, tfname.getText(), tlname.getText(), address.getText(), temail.getText(), tphone.getText());
			JOptionPane.showMessageDialog(null, "Details have been updated Successfully","Details Updated",JOptionPane.INFORMATION_MESSAGE);
			tfname.setText("");
			tlname.setText("");
			address.setText("");
			temail.setText("");
			tphone.setText("");
			errorMessage.setText("");
		}
		
		else{
				if (emptyFields(tfname.getText()) == false
						|| emptyFields(tlname.getText()) == false
						|| emptyFields(address.getText()) == false
						|| emptyFields(tphone.getText()) == false) {
					errorMessage.setText("You cannot leave a field blank");
					errorMessage.setVisible(true);
				}
				else if (validateEmail(temail.getText()) == false) {
					errorMessage.setText("You must enter a valid email address");
					errorMessage.setVisible(true);
				} 
				else
				{
					errorMessage.setText("You must enter valid data for each field");
					errorMessage.setVisible(true);
				}
			}
		}
	public void errorCheckingForUpdatePassword(){
		for(int i = 0; i < users.size(); i++){
			
			if(users.get(i).getUserID().equals(usersID) && users.get(i).getPassword().equals(toldPass.getText()) && 
					tnewPass.getText().equals(tconfirmNewPass.getText()) && emptyFields(tnewPass.getText()) == true &&
							emptyFields(tconfirmNewPass.getText()) == true){
				
				users.get(i).setPassword(tnewPass.getText());
				CreateTables c = new CreateTables();
				Hotel h = c.getHotel();
				
				
				h.updateUsersPassword(usersID, tnewPass.getText());
				JOptionPane.showMessageDialog(null, "Password has been updated Successfully","Password Updated",JOptionPane.INFORMATION_MESSAGE);
				toldPass.setText("");
				tnewPass.setText("");
				tconfirmNewPass.setText("");				
				updatePasswordErrorMessage.setVisible(false);
				break;
			}
			
			else if(users.get(i).getUserID().equals(usersID) && users.get(i).getPassword() != toldPass.getText()
					&& emptyFields(tnewPass.getText()) == true &&
					emptyFields(tconfirmNewPass.getText()) == true)
				{
					updatePasswordErrorMessage.setText("Invalid Password entered");
					updatePasswordErrorMessage.setVisible(true);
				}
			
			 if(emptyFields(toldPass.getText()) == false 
					|| emptyFields(tnewPass.getText()) == false ||
					emptyFields(tconfirmNewPass.getText()) == false){
				updatePasswordErrorMessage.setText("You cannot leave a field blank");
			updatePasswordErrorMessage.setVisible(true);
			}
		}
		
		 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == changeDetailsBtn){
			errorCheckingForUpdateDetails();
		}
		
		else if(e.getSource() == changePasswordBtn){
			errorCheckingForUpdatePassword();
		}
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
