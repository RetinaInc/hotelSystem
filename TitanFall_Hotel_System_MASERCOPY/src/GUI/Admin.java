package GUI;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Admin extends JFrame{

	private String[] floors = {"1","2","3","4"};
	private String[] types = {"Single","Double","Suite"};
	
	private JComboBox comboBoxFloors,comboBoxTypes,update_types,reportOptions,helpQscomboBox,helpQscomboBox2;
	private JTextField roomNumberField,deleteBooking,specialNameT,priceField,roomNumberT,roomNumberT2,specialPrice;
	private JButton addbutton,deleteBookingButton,btnDelete,btnUpdate,btnAddToSpecials,btnCancel,saveReportTo,openReport;
	private JTable bookings,specialsList;
	private JLabel roomFloor,roomType,roomNumber1,lblRoomNumber,roomNumber2,lblNewType,bookingId,specialName,lblPriceOfSpecial,lblDescriptionOfSpecial
					,lblCurrentSpecials,lblName,lblDescription,lblPrice,selectReport,faq,lblAccountIssues,lblBookingIssues
					,helpLabel,lblOr,contactUs;

	private String[] columnNames = {"Booking ID", "Room Number", "User ID"};
	private JLabel welcome3;
	private JLabel oldPass;
	private JPasswordField toldPass;
	private JLabel newPass;
	private JPasswordField tnewPass;
	private JLabel confirmNewPass;
	private JPasswordField tconfirmNewPass;
	private JButton changePasswordBtn;
	private JButton updateDetailsBtn;
	private JLabel fname;
	private JTextField tfname;
	private JLabel lname;
	private JTextField tlname;
	private JLabel email;
	private JTextField temail;
	private JLabel phone;
	private JTextField tphone;
	private Font font;
	
	
	public Admin() {
		
		super("Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		font = new Font("Veranda",font.ITALIC,20);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		//manage bookings tab
		JPanel manage_bookings = new JPanel();
		tabbedPane.addTab("Manage Bookings", null, manage_bookings, null);
		manage_bookings.setLayout(null);
		
		//Panel used to welcome the user
		JPanel greeting = new JPanel();
		greeting.setBounds(170, 11, 360, 44);
		manage_bookings.add(greeting);
		
		JLabel lblTitanfallTowersHotel = new JLabel("TitanFall Towers Hotel");
		lblTitanfallTowersHotel.setFont(new Font("Verdana", Font.ITALIC, 20));
		greeting.add(lblTitanfallTowersHotel);
		
		Object[][] data = {
				{1,127,"Robert"},
				{2,28,"Robert"},
				{3,200,"Mark"},
				{4,12,"Dell"},
				{5,15,"Thomas"}
		};
		
		bookings = new JTable(data,columnNames);
		
		bookings.setPreferredScrollableViewportSize(new Dimension(200,200));
		bookings.setFillsViewportHeight(true);
		bookings.setEnabled(false);
		bookings.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(bookings);
		scrollPane.setBounds(163, 85, 367, 98);
		manage_bookings.add(scrollPane);
		
		deleteBookingButton = new JButton("Delete");
		deleteBookingButton.setBounds(449, 222, 81, 23);
		manage_bookings.add(deleteBookingButton);
		
		bookingId = new JLabel("Booking ID");
		bookingId.setBounds(170, 222, 81, 23);
		manage_bookings.add(bookingId);
		
		deleteBooking = new JTextField();
		deleteBooking.setBounds(261, 223, 86, 20);
		manage_bookings.add(deleteBooking);
		deleteBooking.setColumns(10);
		
		//Manage rooms tab
		JPanel manage_rooms = new JPanel();
		tabbedPane.addTab("Manage Rooms", null, manage_rooms, null);
		manage_rooms.setLayout(null);
		
		//Panel used to welcome user
		JPanel greeting1 = new JPanel();
		greeting1.setBounds(170, 11, 360, 44);
		manage_rooms.add(greeting1);
		
		JLabel lblTitanfallTowersHotel1 = new JLabel("TitanFall Towers Hotel");
		lblTitanfallTowersHotel1.setFont(new Font("Verdana", Font.ITALIC, 20));
		greeting1.add(lblTitanfallTowersHotel1);
		
		//Panel that hold the details used to add a room
		JPanel add_rooms = new JPanel();
		add_rooms.setBorder(new TitledBorder("Add Rooms"));
		add_rooms.setBounds(20, 103, 219, 180);
		manage_rooms.add(add_rooms);
		add_rooms.setLayout(new GridLayout(2, 0));
		
		JPanel roomsDetails = new JPanel();
		add_rooms.add(roomsDetails);
		roomsDetails.setLayout(new GridLayout(3, 3));
		
		 roomFloor = new JLabel("Room Floor");
		 roomsDetails.add(roomFloor);
		
		comboBoxFloors = new JComboBox(floors);
		roomsDetails.add(comboBoxFloors);
		
		roomType = new JLabel("Room Type");
		roomsDetails.add(roomType);
		
		comboBoxTypes = new JComboBox(types);
		roomsDetails.add(comboBoxTypes);
		
		 roomNumber1 = new JLabel("Room Number");
		roomsDetails.add(roomNumber1);
		
		 roomNumberField = new JTextField();
		roomsDetails.add(roomNumberField);
		
		JPanel addbuttonPanel = new JPanel();
		add_rooms.add(addbuttonPanel);
		addbuttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 50));
		
		 addbutton = new JButton("Add");
		 addbuttonPanel.add(addbutton);
		
		JPanel delete_rooms = new JPanel();
		delete_rooms.setBorder(new TitledBorder("Delete Rooms"));
		delete_rooms.setBounds(249, 103, 250, 180);
		delete_rooms.setLayout(null);
		manage_rooms.add(delete_rooms);
		
		roomNumber2 = new JLabel("Room Number");
		roomNumber2.setBounds(10, 24, 95, 23);
		delete_rooms.add(roomNumber2);
		
		roomNumberT = new JTextField();
		roomNumberT.setBounds(120, 25, 86, 23);
		delete_rooms.add(roomNumberT);
		roomNumberT.setColumns(10);
		
		 btnDelete = new JButton("Delete");
		btnDelete.setBounds(85, 146, 89, 26);
		delete_rooms.add(btnDelete);
		
		JPanel update_rooms = new JPanel();
		update_rooms.setBorder(new TitledBorder("Update Rooms"));
		update_rooms.setBounds(509, 103, 239, 180);
		manage_rooms.add(update_rooms);
		update_rooms.setLayout(null);
		
		 btnUpdate = new JButton("Update");
		btnUpdate.setBounds(80, 146, 89, 26);
		update_rooms.add(btnUpdate);
		
		 lblRoomNumber = new JLabel("Room Number");
		lblRoomNumber.setBounds(10, 27, 89, 23);
		update_rooms.add(lblRoomNumber);
		
		roomNumberT2 = new JTextField();
		roomNumberT2.setBounds(131, 24, 86, 23);
		update_rooms.add(roomNumberT2);
		roomNumberT2.setColumns(10);
		
		lblNewType = new JLabel("New Type");
		lblNewType.setBounds(10, 52, 70, 23);
		update_rooms.add(lblNewType);
		
		 update_types = new JComboBox(types);
		update_types.setBounds(131, 49, 86, 23);
		update_rooms.add(update_types);
		
		
		//add specials tab
		JPanel add_specials = new JPanel();
		add_specials.setLayout(null);
		tabbedPane.addTab("Add Specials", null, add_specials, null);
		
		JPanel greeting2 = new JPanel();
		greeting2.setBounds(170, 11, 360, 44);
		add_specials.add(greeting2);
		
		JLabel lblTitanfallTowersHotel2 = new JLabel("TitanFall Towers Hotel");
		lblTitanfallTowersHotel2.setFont(new Font("Verdana", Font.ITALIC, 20));
		greeting2.add(lblTitanfallTowersHotel2);
		
		 specialName = new JLabel("Name of Special: ");
		specialName.setBounds(213, 72, 118, 23);
		add_specials.add(specialName);
		
		specialNameT = new JTextField();
		specialNameT.setBounds(341, 72, 126, 23);
		add_specials.add(specialNameT);
		specialNameT.setColumns(10);
		
		 lblPriceOfSpecial = new JLabel("Price of Special:       \u20AC");
		lblPriceOfSpecial.setBounds(213, 105, 126, 23);
		add_specials.add(lblPriceOfSpecial);
		
		specialPrice = new JTextField();
		specialPrice.setBounds(341, 103, 65, 23);
		add_specials.add(specialPrice);
		specialPrice.setColumns(10);
		
		
		 lblDescriptionOfSpecial = new JLabel("Description: ");
		lblDescriptionOfSpecial.setBounds(213, 133, 126, 23);
		add_specials.add(lblDescriptionOfSpecial);
		
		 btnAddToSpecials = new JButton("Add to specials");
		btnAddToSpecials.setBounds(239, 168, 126, 23);
		add_specials.add(btnAddToSpecials);
		
		 btnCancel = new JButton("Cancel");
		btnCancel.setBounds(375, 168, 89, 23);
		add_specials.add(btnCancel);
		
		specialsList = new JTable();
		specialsList.setModel(new DefaultTableModel(
			new Object[][] {
				{"Golf", "1 round of an 18 hole golf course", "40"},
				{"Dinner for 2", "3 course dinner for 2 in our 4 star restaurant", "29.99"},
				{"Beauty Treatment", "2 hour session in our spa", "15"},
				{"Go-Karting for 4", "1 hour session for the whole family", "30"},
			},
			new String[] {
				"Name", "Description", "Price (\u20AC)"
			}
		));
		specialsList.getColumnModel().getColumn(0).setPreferredWidth(101);
		specialsList.getColumnModel().getColumn(1).setPreferredWidth(227);
		specialsList.setBounds(33, 240, 602, 64);
		add_specials.add(specialsList);
		
		 lblCurrentSpecials = new JLabel("Current specials:");
		lblCurrentSpecials.setBounds(33, 165, 154, 23);
		add_specials.add(lblCurrentSpecials);
		
		 lblName = new JLabel("Name");
		lblName.setBounds(33, 215, 46, 23);
		add_specials.add(lblName);
		
		 lblDescription = new JLabel("Description");
		lblDescription.setBounds(202, 215, 89, 23);
		add_specials.add(lblDescription);
		
		 lblPrice = new JLabel("Price (\u20AC)");
		lblPrice.setBounds(494, 215, 65, 23);
		add_specials.add(lblPrice);
		
		priceField = new JTextField();
		priceField.setBounds(341, 128, 267, 23);
		add_specials.add(priceField);
		priceField.setColumns(10);
		
		//print reports panel
		JPanel print_reports = new JPanel();
		print_reports.setLayout(null);
		tabbedPane.addTab("Print Reports", null, print_reports, null);
		
		JPanel greeting3 = new JPanel();
		greeting3.setBounds(170, 11, 360, 44);
		print_reports.add(greeting3);
		
		JLabel lblTitanfallTowersHotel3 = new JLabel("TitanFall Towers Hotel");
		lblTitanfallTowersHotel3.setFont(new Font("Verdana", Font.ITALIC, 20));
		greeting3.add(lblTitanfallTowersHotel3);
		

		 selectReport = new JLabel("Select the type of report you want to print:");
		selectReport.setBounds(86, 98, 275, 23);
		print_reports.add(selectReport);
		
		 reportOptions = new JComboBox();
		reportOptions.setModel(new DefaultComboBoxModel(new String[] {"Total Income for Single Rooms", "Total Income for Double Rooms"}));
		reportOptions.setBounds(371, 98, 224, 23);
		print_reports.add(reportOptions);
		
		 saveReportTo = new JButton("Save report to file");
		saveReportTo.setBounds(181, 203, 141, 23);
		print_reports.add(saveReportTo);
		
		 openReport = new JButton("Open report");
		openReport.setBounds(371, 203, 141, 23);
		print_reports.add(openReport);
		
		//HELP PANEL
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
		
		//manage account panel
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

}
