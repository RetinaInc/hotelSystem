package GUI;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.Color;

public class AdminManageRooms extends JPanel {
	private JComboBox comboBoxFloors,comboBoxTypes,update_types;
	private String[] types = {"Single","Double","Suite"};
	public AdminManageRooms(){
	
		this.setLayout(null);
		
		//Panel used to welcome user
		JPanel greeting1 = new JPanel();
			greeting1.setBounds(320, 11, 360, 44);
			add(greeting1);
			
			JLabel lblTitanfallTowersHotel1 = new JLabel("TitanFall Towers Hotel");
			lblTitanfallTowersHotel1.setFont(new Font("Verdana", Font.ITALIC, 26));
			greeting1.add(lblTitanfallTowersHotel1);
		
		//Panel that hold the details used to add a room
		JPanel add_rooms = new JPanel();
			add_rooms.setBorder(new TitledBorder("Add Rooms"));
			add_rooms.setBounds(81, 104, 277, 180);
			add(add_rooms);
			add_rooms.setLayout(new GridLayout(2, 0));
			
			JPanel roomsDetails = new JPanel();
			add_rooms.add(roomsDetails);
			roomsDetails.setLayout(new GridLayout(3, 3));
			
			JLabel roomType = new JLabel("Room Type");
			roomType.setFont(new Font("Tahoma", Font.BOLD, 16));
			roomsDetails.add(roomType);
		
	
		comboBoxTypes = new JComboBox(types);
		comboBoxTypes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		roomsDetails.add(comboBoxTypes);
		
		 JLabel roomNumber1 = new JLabel("Room Number");
		 roomNumber1.setFont(new Font("Tahoma", Font.BOLD, 16));
		roomsDetails.add(roomNumber1);
		
		 JTextField roomNumberField = new JTextField();
		roomsDetails.add(roomNumberField);
		
		JPanel addbuttonPanel = new JPanel();
		add_rooms.add(addbuttonPanel);
		 addbuttonPanel.setLayout(null);
		 
		  JButton addbutton = new JButton("Add");
		  addbutton.setBounds(73, 30, 118, 26);
		  addbuttonPanel.add(addbutton);
		  addbutton.setForeground(Color.GREEN);
		  addbutton.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JPanel delete_rooms = new JPanel();
		delete_rooms.setBorder(new TitledBorder("Delete Rooms"));
		delete_rooms.setBounds(688, 104, 277, 180);
		delete_rooms.setLayout(null);
		add(delete_rooms);
		
		JLabel roomNumber2 = new JLabel("Room Number");
		roomNumber2.setFont(new Font("Tahoma", Font.BOLD, 16));
		roomNumber2.setBounds(10, 26, 135, 23);
		delete_rooms.add(roomNumber2);
		
		JTextField roomNumberT = new JTextField();
		roomNumberT.setBounds(155, 28, 86, 23);
		delete_rooms.add(roomNumberT);
		roomNumberT.setColumns(10);
		
		 JButton btnDelete = new JButton("Delete");
		 btnDelete.setBounds(79, 121, 118, 26);
		 delete_rooms.add(btnDelete);
		 btnDelete.setForeground(Color.RED);
		 btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JPanel update_rooms = new JPanel();
		update_rooms.setBorder(new TitledBorder("Update Rooms"));
		update_rooms.setBounds(382, 104, 298, 180);
		add(update_rooms);
		update_rooms.setLayout(null);
		
		 JButton btnUpdate = new JButton("Update");
		 btnUpdate.setForeground(Color.ORANGE);
		 btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnUpdate.setBounds(90, 123, 118, 26);
		update_rooms.add(btnUpdate);
		
		 JLabel lblRoomNumber = new JLabel("Room Number");
		 lblRoomNumber.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRoomNumber.setBounds(10, 27, 123, 23);
		update_rooms.add(lblRoomNumber);
		
		JTextField roomNumberT2 = new JTextField();
		roomNumberT2.setBounds(143, 27, 145, 23);
		update_rooms.add(roomNumberT2);
		roomNumberT2.setColumns(10);
		
		JLabel lblNewType = new JLabel("New Type");
		lblNewType.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewType.setBounds(20, 52, 111, 23);
		update_rooms.add(lblNewType);
		
		 update_types = new JComboBox(types);
		 update_types.setFont(new Font("Tahoma", Font.PLAIN, 16));
		update_types.setBounds(143, 54, 145, 23);
		update_rooms.add(update_types);
		
	}
}
