package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import Database.CreateTables;
import Model.Hotel;
import Model.User;

public class AdminManageAccountGUI extends JPanel implements KeyListener, ActionListener {
	private JPanel container;
	private JTextField tfname,tlname, address, temail, tphone;
	private JLabel errorMessage, updatePasswordErrorMessage,updateYourAccount;
	private String usersID;
	private ArrayList<User> users;
	private JPasswordField toldPass,tnewPass,  tconfirmNewPass;
	private JButton changeDetailsBtn,changePasswordBtn;
	private Font fontBigger;
	private Color color = new Color(227,99,26);
	public AdminManageAccountGUI(String userID, ArrayList<User> users){
		usersID = userID;
		this.users = users;
		container = new JPanel();
		container.setLayout(null);
		container.setBounds(0, 79,1000, 450);
		JPanel manage_account = new JPanel();
		manage_account.setLayout(null);
		add(container);
		this.setLayout(null);

		fontBigger = new Font("Veranda", Font.PLAIN, 18);
		//contains all the elements neccessary to change your details
		JPanel updateDetailsOption = new JPanel(null);
		updateDetailsOption.setFont(fontBigger);
		updateDetailsOption.setBorder(new TitledBorder(null,
				"Update Personal Details", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		updateDetailsOption.setBounds(140, 131, 358, 259);
		container.add(updateDetailsOption);

		JPanel updateDetails = new JPanel(new GridLayout(5, 2));
		updateDetails.setBounds(10, 21, 338, 150);
		updateDetailsOption.add(updateDetails);

		JLabel fname = new JLabel("First Name:");
		fname.setFont(fontBigger);
		tfname = new JTextField();
		tfname.setToolTipText("Enter your first name");
		JLabel lname = new JLabel("Last Name:");
		lname.setFont(fontBigger);
		tlname = new JTextField();
		tlname.setToolTipText("Enter your last name");
		JLabel lHomeAddress = new JLabel("Home Address");
		lHomeAddress.setFont(fontBigger);
		address = new JTextField();
		address.setToolTipText("Enter your home address");
		JLabel email = new JLabel("Email Address:       ");
		email.setFont(fontBigger);
		temail = new JTextField();
		temail.setToolTipText("Enter your email address");
		JLabel phone = new JLabel("Telephone:");
		phone.setFont(fontBigger);
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
		changeDetailsBtn.setBackground(color);
		changeDetailsBtn.setFont(fontBigger);
		changeDetailsBtn.setBounds(119, 200, 185, 30);
		changeDetailsBtn.setToolTipText("Update your password");
		changeDetailsBtn.isFocusable();
		changeDetailsBtn.addKeyListener(this);
		changeDetailsBtn.addActionListener(this);
		updateDetailsOption.add(changeDetailsBtn);
		// contains all the elements neccessary to change your password
		JPanel updatePassword = new JPanel(new GridLayout(2, 0));
		updatePassword.setBounds(508, 131, 450, 259);
		updatePassword.setFont(fontBigger);
		container.add(updatePassword);
		updatePassword.setBorder(BorderFactory
				.createTitledBorder("Change Password"));

		JPanel changePassword = new JPanel(new GridLayout(3, 2));
		updatePassword.add(changePassword);

		JLabel oldPass = new JLabel("Old Password:");
		oldPass.setFont(fontBigger);
		toldPass = new JPasswordField();
		toldPass.setToolTipText("Enter your current password");
		JLabel newPass = new JLabel("New Password:");
		newPass.setFont(fontBigger);
		tnewPass = new JPasswordField();
		tnewPass.setToolTipText("Enter your new password");
		JLabel confirmNewPass = new JLabel("Confirm New Password:");
		confirmNewPass.setFont(fontBigger);
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
		changePasswordBtn.setBackground(color);
		changePasswordBtn.setFont(fontBigger);
		changePasswordBtn.setBounds(114, 71, 185, 30);
		changePasswordBtn.setToolTipText("Update your password");
		changePasswordBtn.isFocusable();
		changePasswordBtn.addKeyListener(this);
		changePasswordBtn.addActionListener(this);
		changePasswordPanel.add(changePasswordBtn);
		updatePassword.add(changePasswordPanel);

		 updateYourAccount = new JLabel(
				"Update Your account details here ....");
		updateYourAccount.setFont(fontBigger);
		updateYourAccount.setBounds(297, 90, 345, 36);
		container.add(updateYourAccount);
		
				errorMessage = new JLabel("");
				errorMessage.setFont(fontBigger);
				errorMessage.setHorizontalAlignment(SwingConstants.CENTER);
				errorMessage.setBounds(214, 401, 300, 30);
				container.add(errorMessage);
				errorMessage.setForeground(Color.RED);
				
				updatePasswordErrorMessage = new JLabel("");
				updatePasswordErrorMessage.setFont(fontBigger);
				updatePasswordErrorMessage.setHorizontalAlignment(SwingConstants.CENTER);
				updatePasswordErrorMessage.setBounds(584, 401, 300, 30);
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
			
			String oldPass = "";
			String newPass = "";
			String cNewPass = "";
			try {
				oldPass = Encryption.encrypt(toldPass.getText());
				newPass = Encryption.encrypt(tnewPass.getText());
				cNewPass = Encryption.encrypt(tconfirmNewPass.getText());
				
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (GeneralSecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(users.get(i).getUserID().equals(usersID) && users.get(i).getPassword().equals(oldPass) && 
					newPass.equals(cNewPass) && emptyFields(tnewPass.getText()) == true &&
							emptyFields(tconfirmNewPass.getText()) == true){
				
				users.get(i).setPassword(newPass);
				CreateTables c = new CreateTables();
				Hotel h = c.getHotel();
				
				
				h.updateUsersPassword(usersID, newPass);
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
