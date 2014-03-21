package GUI;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import Model.User;

import java.awt.event.*;
import java.util.ArrayList;
public class UserScreen extends JFrame implements ActionListener,MouseListener,KeyListener{

	private String[] floors = {"1","2","3","4"};
	private String[] types = {"Single","Double","Suite"};
	
	private JComboBox numNights,numPeople,numRooms,day,month,year,helpQscomboBox,helpQscomboBox2;
	private JCheckBox chckbxGolf,chckbxSpaTreatment,chckbxBreakfast,chckbxGokarting;
	private JLabel signOut,welcome,welcome2,welcome3,lblAddSomethingExtra,lblPrice,faq,lblAccountIssues,lblBookingIssues,helpLabel,lblOr,contactUs,
	lblnumNights,lblnumPeople,lblnumRooms,arrivalDate,calendar,fname,lname,email,phone,oldPass,newPass,confirmNewPass
	,welcomeUser;
	private JButton btnSearch,btnAddSpecials,updateDetailsBtn,changePasswordBtn;
	private Font font;
	private JTextField tfname,tlname,temail,tphone;
	private JPasswordField toldPass,tnewPass,tconfirmNewPass;
	
	private  String[] days = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23"};
	private String[] months = {"January","Febuary","March","April","May","June","July","Augest","September","October","November","December"};
	private String[] years = {"2014","2015","2016","2017"};
	private  String[] nights = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21"};
	private  String[] rooms = {"1","2","3","4","5","6","7","8","9","10"};
	private  String[] people = {"1","2","3","4","5","6","7","8","9","10"};
	
	private ArrayList<User> users;
	private String usersID = "";
	private String usersFirstName;
	
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
		userInteraction.setLayout(new GridLayout(2,0));
		userInteraction.setBounds(164,66,479,221);
		create_booking.add(userInteraction);
		
		JPanel search = new JPanel();
		search.setLayout(new FlowLayout());
		
		lblnumNights = new JLabel("No. of Nights");
		search.add(lblnumNights);
		
		numNights = new JComboBox(nights);
		search.add(numNights);
		
		arrivalDate = new JLabel("Arrival Date");
		search.add(arrivalDate);
		
		day = new JComboBox(days);
		search.add(day);
		
		month = new JComboBox(months);
		search.add(month);
		
		year = new JComboBox(years);
		search.add(year);
		
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
		JPanel updateDetailsOption = new JPanel(new GridLayout(2,0));
		updateDetailsOption.setBounds(52, 19, 276, 183);
		
		JPanel updateDetails = new JPanel(new GridLayout(4,2));
		updateDetailsOption.add(updateDetails);
		
		fname = new JLabel("First Name:");
		tfname = new JTextField();
		lname = new JLabel("Last Name:");
		tlname = new JTextField();
		email = new JLabel("Email Address:       ");
		temail = new JTextField();
		phone = new JLabel("Telephone:");
		tphone = new JTextField();
		
		updateDetails.add(fname);
		updateDetails.add(tfname);
		updateDetails.add(lname);
		updateDetails.add(tlname);
		updateDetails.add(email);
		updateDetails.add(temail);
		updateDetails.add(phone);
		updateDetails.add(tphone);
		
		JPanel updateButton = new JPanel(new FlowLayout());
		updateDetailsBtn = new JButton("Update Details");
		updateButton.add(updateDetailsBtn);
		updateDetailsOption.add(updateButton);
		
		options.add(updateDetailsOption);
		
		//contains all the elements neccessary to change your password
		JPanel updatePassword = new JPanel(new GridLayout(2,0));
		updatePassword.setBounds(395, 11, 318, 183);
		options.add(updatePassword);
		updatePassword.setBorder(BorderFactory.createTitledBorder("Change Password"));
		
		JPanel changePassword = new JPanel(new GridLayout(3,2));
		updatePassword.add(changePassword);
		
		oldPass = new JLabel("Old Password:");
		toldPass = new JPasswordField();
		newPass = new JLabel("New Password:");
		tnewPass = new JPasswordField();
		confirmNewPass = new JLabel("Confirm New Password:  ");
		tconfirmNewPass = new JPasswordField();
		
		
		changePassword.add(oldPass);
		changePassword.add(toldPass);
		changePassword.add(newPass);
		changePassword.add(tnewPass);
		changePassword.add(confirmNewPass);
		changePassword.add(tconfirmNewPass);
		
		JPanel changePasswordPanel = new JPanel(new FlowLayout());
		changePasswordBtn = new JButton("Update Password");
		changePasswordPanel.add(changePasswordBtn);
		updatePassword.add(changePasswordPanel);
		
			
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
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnSearch){
			Availability a = new Availability();
			this.setVisible(false);
			a.setVisible(true);
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


	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getSource() == signOut && e.getKeyCode() == KeyEvent.VK_ENTER){
			StartScreen s = new StartScreen();
			this.setVisible(false);
			s.setVisible(true);
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