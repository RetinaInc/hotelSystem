package GUI;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import Database.CreateTables;
import Model.Booking;
import Model.Hotel;
import Model.User;

import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class UserScreen extends JFrame implements ActionListener,MouseListener,KeyListener{

	private String[] floors = {"1","2","3","4"};
	private String[] types = {"Single","Double","Suite"};
	
	private JComboBox numNights,numPeople,numRooms,helpQscomboBox,helpQscomboBox2;
	private JCheckBox chckbxGolf,chckbxSpaTreatment,chckbxBreakfast,chckbxGokarting;
	private JLabel signOut,welcome,welcome2,welcome3,lblAddSomethingExtra,lblPrice,faq,lblAccountIssues,lblBookingIssues,helpLabel,lblOr,contactUs,
	lblnumNights,lblnumPeople,lblnumRooms,arrivalDate,fname,lname,email,lHomeAddress,phone,oldPass,newPass,confirmNewPass
	,welcomeUser,errorMessage,updatePasswordErrorMessage;
	private JButton btnSearch,btnAddSpecials,updateDetailsBtn,changePasswordBtn;
	private Font font;
	private JTextField tfname,tlname,temail,tphone,address;
	private JPasswordField toldPass,tnewPass,tconfirmNewPass;

	private  String[] nights = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21"};
	private  String[] rooms = {"1","2","3","4","5","6","7","8","9","10"};
	private  String[] people = {"1","2","3","4","5","6","7","8","9","10"};
	
	private ArrayList<User> users;
	private String usersID = "";
	private String usersFirstName;
	
	private Calendar chosenDate;
	private Calendar cal = Calendar.getInstance();
	private JDateChooser dateChooser;
	private JYearChooser day, year;
	private JMonthChooser month;
	
	public UserScreen(String user, ArrayList<User> users){
		super("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		usersID = user;
		this.users = users;
		System.out.println(users.size());
		
		//if the users log in was successful then they are brought to this page and LoggedIn is set to true
		StartScreen.setLoggedIn(true);
		
		font = new Font("Verdana", Font.ITALIC, 20);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		//create booking tab
		JPanel create_booking = new JPanel();
		tabbedPane.addTab("Create Booking", null, create_booking, null);
		create_booking.setLayout(null);
		
		welcome = new JLabel("TitanFall Towers Hotel");
		welcome.setFont(font);
		welcome.setBounds(309, 11, 264, 44);
		create_booking.add(welcome);
		
		JPanel userInteraction = new JPanel();
		userInteraction.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		userInteraction.setLayout(new GridLayout(2, 0));
		userInteraction.setBounds(160, 66, 479, 167);
		create_booking.add(userInteraction);

		JPanel search = new JPanel();
		search.setLayout(new FlowLayout());

		lblnumNights = new JLabel("No. of Nights");
		search.add(lblnumNights);

		numNights = new JComboBox(nights);
		search.add(numNights);

		arrivalDate = new JLabel("Arrival Date");
		search.add(arrivalDate);

		day = new JYearChooser();
		day.setYear((cal.get(Calendar.DAY_OF_MONTH)));
		day.setMaximum(31);
		day.setMinimum(1);
		search.add(day);

		month = new JMonthChooser();
		month.setMonth(cal.get(Calendar.MONTH));
		month.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent e) {
				if (month.getMonth() == 3 || month.getMonth() == 5
						|| month.getMonth() == 8 || month.getMonth() == 10) {
					day.setMaximum(30);
					if (day.getYear() == 31) {
						day.setYear(30);
					}
				}
				else if (month.getMonth() == 1 && year.getYear() != 2016) {
					day.setMaximum(28);
					if (day.getYear() == 29 || day.getYear() == 30
							|| day.getYear() == 31) {
						day.setYear(28);
					}
				} else if (year.getYear() == 2016 && month.getMonth() == 1) {
					day.setMaximum(29);
					if (day.getYear() == 30 || day.getYear() == 31) {
						day.setYear(29);
					}
				} else {
					day.setMaximum(31);
				}
			}
		});
		search.add(month);

		year = new JYearChooser();
		year.setYear(cal.get(Calendar.YEAR));
		year.setMaximum(2016);
		year.setMinimum(2014);

		search.add(year);

		// ////////////////////////////////////////////////////////////////////////////////////////////////////
		// JDateChooser //
		// Sets date of comboBoxes to selected date //
		// for-loop needed, otherwise it looks for position 2014,2015 etc //
		// //
		// //
		// ////////////////////////////////////////////////////////////////////////////////////////////////////

		dateChooser = new JDateChooser();
		dateChooser.setMinSelectableDate(cal.getTime());
		cal.add(Calendar.YEAR, 2);
		dateChooser.setMaxSelectableDate(cal.getTime());
		dateChooser.getDateEditor().addPropertyChangeListener(
				new PropertyChangeListener() {
					@Override
					public void propertyChange(PropertyChangeEvent e) {
						if ("date".equals(e.getPropertyName())) {
							chosenDate = Calendar.getInstance();
							chosenDate.setTime((Date) e.getNewValue());
							day.setYear(chosenDate.get(Calendar.DAY_OF_MONTH));
							month.setMonth(chosenDate.get(Calendar.MONTH));
							year.setYear(chosenDate.get(Calendar.YEAR));

						}

					}
				});
		search.add(dateChooser);

		lblnumPeople = new JLabel("No. of People");
		search.add(lblnumPeople);

		numPeople = new JComboBox(people);
		search.add(numPeople);

		lblnumRooms = new JLabel("No. of Rooms");
		search.add(lblnumRooms);

		numRooms = new JComboBox(rooms);
		search.add(numRooms);

		userInteraction.add(search);
		
		JPanel buttons = new JPanel();
		buttons.setLayout(null);
		userInteraction.add(buttons);

		btnSearch = new JButton("Search");
		btnSearch.addActionListener(this);
		btnSearch.setBounds(376, 47, 89, 23);
		buttons.add(btnSearch);
		
		welcomeUser = new JLabel("Welcome " + getUsersFirstName());
		welcomeUser.setBounds(576, 11, 127, 23);
		create_booking.add(welcomeUser);
		
		signOut = new JLabel("Sign Out");
		signOut.setFocusable(true);
		signOut.addKeyListener(this);
		signOut.addMouseListener(this);
		signOut.setForeground(new Color(0,160,255));
		signOut.setBounds(701, 11, 68, 23);
		create_booking.add(signOut);
		
		//Manage booking tab
		JPanel manage_booking = new JPanel();
		tabbedPane.addTab("Manage Booking", null, manage_booking, null);
		manage_booking.setLayout(null);
		
		welcome2 = new JLabel("TitanFall Towers Hotel");
		welcome2.setFont(font);
		welcome2.setBounds(309, 11, 264, 44);
		manage_booking.add(welcome2);
		
		
		//calendar tab
		JPanel calendar_tab = new JPanel();
		tabbedPane.addTab("Calendar", null, calendar_tab, null);
	
		
		
		//specials panel
		JPanel specials_panel = new JPanel();
		tabbedPane.addTab("Specials", null, specials_panel, null);
		specials_panel.setLayout(null);
		
		 chckbxGolf = new JCheckBox("Golf");
		chckbxGolf.setBounds(163, 70, 97, 23);
		specials_panel.add(chckbxGolf);
		
		 lblAddSomethingExtra = new JLabel("Add something extra to your stay with us, by selecting from our range of available specials");
		lblAddSomethingExtra.setBounds(79, 49, 543, 14);
		specials_panel.add(lblAddSomethingExtra);
		
		 chckbxSpaTreatment = new JCheckBox("Spa Treatment");
		chckbxSpaTreatment.setBounds(163, 103, 136, 23);
		specials_panel.add(chckbxSpaTreatment);
		
		 chckbxBreakfast = new JCheckBox("Breakfast");
		chckbxBreakfast.setBounds(163, 137, 97, 23);
		specials_panel.add(chckbxBreakfast);
		
		 chckbxGokarting = new JCheckBox("Go-karting");
		chckbxGokarting.setBounds(163, 170, 97, 23);
		specials_panel.add(chckbxGokarting);
		
		 lblPrice = new JLabel("Price: \u20AC100.00");
		lblPrice.setBounds(79, 230, 97, 14);
		specials_panel.add(lblPrice);
		
		 btnAddSpecials = new JButton("Add Specials");
		btnAddSpecials.setBounds(370, 262, 108, 23);
		specials_panel.add(btnAddSpecials);
		
		
		//help panel
		JPanel help = new JPanel();
		tabbedPane.addTab("Help", null, help, null);
		help.setLayout(null);
		
		faq = new JLabel("FAQs");
		faq.setHorizontalAlignment(SwingConstants.CENTER);
		faq.setBounds(120, 25, 35, 23);
		help.add(faq);
		
		 lblAccountIssues = new JLabel("Account issues");
		lblAccountIssues.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountIssues.setBounds(130, 71, 116, 23);
		help.add(lblAccountIssues);
		
		 helpQscomboBox = new JComboBox();
		helpQscomboBox.setModel(new DefaultComboBoxModel(new String[] {"How do I change my username?", "How do I change my password?", "Changing personal info", "Delete my account"}));
		helpQscomboBox.setBounds(86, 105, 230, 23);
		help.add(helpQscomboBox);
		
		 lblBookingIssues = new JLabel("Booking issues");
		lblBookingIssues.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookingIssues.setBounds(488, 71, 116, 23);
		help.add(lblBookingIssues);
		
		 helpQscomboBox2 = new JComboBox();
		helpQscomboBox2.setModel(new DefaultComboBoxModel(new String[] {"How do I make a booking?", "Can I change my booking details?", "Can I add extras to my booking?", "Deleting a booking", "Can I pay without using a credit card?"}));
		helpQscomboBox2.setBounds(432, 105, 230, 23);
		help.add(helpQscomboBox2);
		
		 helpLabel = new JLabel("If your question isn't answered in the above FAQs, please see our user manual for more answers");
		helpLabel.setHorizontalAlignment(SwingConstants.CENTER);
		helpLabel.setBounds(130, 161, 591, 23);
		help.add(helpLabel);
		
		 lblOr = new JLabel("or");
		lblOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOr.setBounds(358, 208, 22, 23);
		help.add(lblOr);
		
		 contactUs = new JLabel("Contact us for personal assistance");
		contactUs.setHorizontalAlignment(SwingConstants.CENTER);
		contactUs.setBounds(279, 263, 215, 14);
		help.add(contactUs);
		
		
		//Manage account panel
		JPanel manage_account = new JPanel();
		manage_account.setLayout(null);
		tabbedPane.addTab("Manage Account", null, manage_account, null);
		
		welcome3 = new JLabel("TitanFall Towers Hotel");
		welcome3.setFont(font);
		welcome3.setBounds(309, 11, 264, 44);
		manage_account.add(welcome3);
		
		JPanel options = new JPanel(null);
		options.setBounds(10,66,759,221);
		manage_account.add(options);
		
		//contains all the elements neccessary to change your details
		JPanel updateDetailsOption = new JPanel(null);
		updateDetailsOption.setBounds(52, 19, 276, 183);
		
		JPanel updateDetails = new JPanel(new GridLayout(5,2));
		updateDetails.setBounds(10,0,256,128);
		updateDetailsOption.add(updateDetails);
		
		fname = new JLabel("First Name:");
		tfname = new JTextField();
		tfname.setToolTipText("Enter your first name");
		lname = new JLabel("Last Name:");
		tlname = new JTextField();
		tlname.setToolTipText("Enter your last name");
		lHomeAddress = new JLabel("Home Address");
		address = new JTextField();
		address.setToolTipText("Enter your home address");
		email = new JLabel("Email Address:       ");
		temail = new JTextField();
		temail.setToolTipText("Enter your email address");
		phone = new JLabel("Telephone:");
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
		
		JPanel updateButton = new JPanel(null);
		updateButton.setBounds(40,128,199,55);
		updateDetailsOption.add(updateButton);
		updateDetailsBtn = new JButton("Update Details");
		updateDetailsBtn.setBounds(32, 12, 140, 23);
		updateDetailsBtn.setToolTipText("Update your details");
		updateDetailsBtn.isFocusable();
		updateDetailsBtn.addKeyListener(this);
		updateDetailsBtn.addActionListener(this);
		updateButton.add(updateDetailsBtn);
		
		options.add(updateDetailsOption);
		
		//contains all the elements neccessary to change your password
		JPanel updatePassword = new JPanel(new GridLayout(2,0));
		updatePassword.setBounds(395, 11, 318, 191);
		options.add(updatePassword);
		updatePassword.setBorder(BorderFactory.createTitledBorder("Change Password"));
		
		JPanel changePassword = new JPanel(new GridLayout(3,2));
		updatePassword.add(changePassword);
		
		oldPass = new JLabel("Old Password:");
		toldPass = new JPasswordField();
		toldPass.setToolTipText("Enter your current password");
		newPass = new JLabel("New Password:");
		tnewPass = new JPasswordField();
		tnewPass.setToolTipText("Enter your new password");
		confirmNewPass = new JLabel("Confirm New Password:  ");
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
		changePasswordBtn.setBounds(88, 50, 140, 23);
		changePasswordBtn.setToolTipText("Update your password");
		changePasswordBtn.isFocusable();
		changePasswordBtn.addKeyListener(this);
		changePasswordBtn.addActionListener(this);
		changePasswordPanel.add(changePasswordBtn);
		updatePassword.add(changePasswordPanel);
		
		errorMessage = new JLabel("");
		errorMessage.setForeground(Color.RED);
		errorMessage.setBounds(91, 290, 225, 23);
		errorMessage.setVisible(false);
		manage_account.add(errorMessage);
		
		
		updatePasswordErrorMessage = new JLabel("");
		updatePasswordErrorMessage.setForeground(Color.RED);
		updatePasswordErrorMessage.setBounds(470, 290, 225, 23);
		updatePasswordErrorMessage.setVisible(false);
		manage_account.add(updatePasswordErrorMessage);
	}
	
	
	//gets the users first name using the array of users passed in 
	//by matching it against the user id of the user logged in
	public String getUsersFirstName(){		
		for(int i = 0; i < users.size(); i++){
			
			if(usersID.equals(users.get(i).getUserID())){
				usersFirstName = users.get(i).getfName();
			}
		}
		
		return usersFirstName;
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
		Calendar calDate = Calendar.getInstance();
		calDate.set(year.getYear(), (month.getMonth()), day.getYear());

		if(calDate.compareTo(Calendar.getInstance()) >= 0){
			Booking b = new Booking(day.getYear(), month.getMonth(), year.getYear() ,(numNights.getSelectedIndex()) + 1);
			Availability a = new Availability(usersID,users,calDate,((numNights.getSelectedIndex()) + 1), numRooms.getSelectedIndex() + 1,
					numPeople.getSelectedIndex() + 1);
			a.listContent(b.availability());
			this.setVisible(false);
			a.setVisible(true);
		}
		
		else if(e.getSource() == updateDetailsBtn){
			errorCheckingForUpdateDetails();
		}
		
		else if(e.getSource() == changePasswordBtn){
			errorCheckingForUpdatePassword();
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getSource() == signOut && e.getKeyCode() == KeyEvent.VK_ENTER){
			StartScreen s = new StartScreen();
			this.setVisible(false);
			s.setVisible(true);
		}
		
		else if(e.getSource() == updateDetailsBtn && e.getKeyCode() == KeyEvent.VK_ENTER){
			errorCheckingForUpdateDetails();
		}
		
		else if(e.getSource() == changePasswordBtn && e.getKeyCode() == KeyEvent.VK_ENTER){
			errorCheckingForUpdatePassword();
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
	
	public void errorCheckingForUpdatePassword(){
		for(int i = 0; i < users.size(); i++){
			
			if(users.get(i).getUserID().equals(usersID) && users.get(i).getPassword().equals(toldPass.getText()) && 
					tnewPass.getText().equals(tconfirmNewPass.getText()) && emptyFields(tnewPass.getText()) == true &&
							emptyFields(tconfirmNewPass.getText()) == true){
				
				CreateTables c = new CreateTables();
				users.get(i).setPassword(tnewPass.getText());
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
	
	public void mouseClicked(MouseEvent e) {
		
		StartScreen s = new StartScreen();
		this.setVisible(false);
		s.setVisible(true);
		
	}
	public void mouseEntered(MouseEvent e) {
		
		signOut.setForeground(Color.GREEN);
	}
	public void mouseExited(MouseEvent e) {
		
		signOut.setForeground(new Color(0,160,255));
	}
	public void mousePressed(MouseEvent e) {
		signOut.setForeground(Color.BLUE);
		
	}
	public void mouseReleased(MouseEvent arg0) {
		signOut.setForeground(Color.BLUE);
		
	}
}