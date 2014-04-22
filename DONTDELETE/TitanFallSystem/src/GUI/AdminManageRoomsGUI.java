package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import Database.*;
import Model.*;

public class AdminManageRoomsGUI extends JPanel implements ActionListener {
	
	private JComboBox comboBoxRoomType,update_typeCombo;
	private String[] types = {"Single","Double","Twin"};
	private Hotel hotel;
	private RoomOperations ro;
	private JButton addbutton, updateButton, deleteRoom;
	private JTextField roomNumberField_ADD,roomNumberField_DELETE, roomNumberField_UPDATE;
	private JLabel roomNumber_ADD, roomType, roomNumberLabel_DELETE, updateRoomNumberLabel, newTypeLabel_UPDATE;
	private JPanel roomsDetails, addbuttonPanel, addRooms, container,deleteRooms, updateRooms;
	
	public AdminManageRoomsGUI() {
		hotel = new Hotel();
		ro = new RoomOperations();
		this.setLayout(null);
		container = new JPanel();
		container.setLayout(null);
		container.setVisible(true);
		container.setBounds(10,119,998,420);
		add(container);


		//2nd Panel - ADD ROOM
		addRooms = new JPanel();
		addRooms.setBorder(new TitledBorder("Add Rooms"));
		addRooms.setBounds(50, 105, 277, 180);
		container.add(addRooms);
		addRooms.setLayout(new GridLayout(2, 0));

		roomsDetails = new JPanel();
		addRooms.add(roomsDetails);
		roomsDetails.setLayout(new GridLayout(3, 3));

		roomNumber_ADD = new JLabel("Room Number");
		roomNumber_ADD.setFont(new Font("Tahoma", Font.BOLD, 16));
		roomsDetails.add(roomNumber_ADD);

		roomNumberField_ADD = new JTextField();
		roomsDetails.add(roomNumberField_ADD);
		
		roomType = new JLabel("Room Type");
		roomType.setFont(new Font("Tahoma", Font.BOLD, 16));
		roomsDetails.add(roomType);

		comboBoxRoomType = new JComboBox(types);
		comboBoxRoomType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		roomsDetails.add(comboBoxRoomType);

		

		addbuttonPanel = new JPanel();
		addRooms.add(addbuttonPanel);
		addbuttonPanel.setLayout(null);

		addbutton = new JButton("Add");
		addbutton.setBounds(73, 30, 118, 26);
		addbutton.setFont(new Font("Tahoma", Font.BOLD, 16));
		addbutton.setForeground(Color.GREEN);
		addbuttonPanel.add(addbutton);
		addbutton.addActionListener(this);

		//3rd Panel - DELETE ROOM
		deleteRooms = new JPanel();
		deleteRooms.setBorder(new TitledBorder("Delete Rooms"));
		deleteRooms.setBounds(690, 105, 265, 180);
		deleteRooms.setLayout(null);
		container.add(deleteRooms);

		roomNumberLabel_DELETE = new JLabel("Room Number");
		roomNumberLabel_DELETE.setFont(new Font("Tahoma", Font.BOLD, 16));
		roomNumberLabel_DELETE.setBounds(10, 26, 135, 23);
		deleteRooms.add(roomNumberLabel_DELETE);

		roomNumberField_DELETE = new JTextField();
		roomNumberField_DELETE.setBounds(155, 28, 86, 23);
		deleteRooms.add(roomNumberField_DELETE);
		roomNumberField_DELETE.setColumns(10);

		deleteRoom = new JButton("Delete");
		deleteRoom.setBounds(79, 121, 118, 26);
		deleteRooms.add(deleteRoom);
		deleteRoom.addActionListener(this);
		deleteRoom.setForeground(Color.RED);
		deleteRoom.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		//4th Panel - UPDATE ROOM
				updateRooms = new JPanel();
				updateRooms.setBorder(new TitledBorder("Update Room"));
				updateRooms.setBounds(351, 105, 316, 180);
				container.add(updateRooms);
				updateRooms.setLayout(null);

				updateButton = new JButton("Update");
				updateButton.setForeground(Color.ORANGE);
				updateButton.setFont(new Font("Tahoma", Font.BOLD, 16));
				updateButton.setBounds(90, 123, 118, 26);
				updateRooms.add(updateButton);
				updateButton.addActionListener(this);

				updateRoomNumberLabel = new JLabel("Room Number");
				updateRoomNumberLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
				updateRoomNumberLabel.setBounds(10, 25, 123, 23);
				updateRooms.add(updateRoomNumberLabel);

				roomNumberField_UPDATE = new JTextField();
				roomNumberField_UPDATE.setBounds(153, 27, 145, 23);
				roomNumberField_UPDATE.setColumns(10);
				updateRooms.add(roomNumberField_UPDATE);

				newTypeLabel_UPDATE = new JLabel("New Room Type");
				newTypeLabel_UPDATE.setFont(new Font("Tahoma", Font.BOLD, 16));
				newTypeLabel_UPDATE.setBounds(10, 52, 133, 23);
				updateRooms.add(newTypeLabel_UPDATE);

				update_typeCombo = new JComboBox(types);
				update_typeCombo.setFont(new Font("Tahoma", Font.PLAIN, 16));
				update_typeCombo.setBounds(153, 52, 145, 23);
				updateRooms.add(update_typeCombo);
			}
			
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == addbutton) {
					int roomNumber = Integer.parseInt(roomNumberField_ADD.getText());
					char roomAvailability = 'T';
					int roomTypeID = comboBoxRoomType.getSelectedIndex();
					
					if(comboBoxRoomType.getSelectedIndex() == 0)
						roomTypeID = 900;
					if(comboBoxRoomType.getSelectedIndex() == 1)
						roomTypeID = 901;
					if(comboBoxRoomType.getSelectedIndex() == 2)
						roomTypeID = 902;
					
					hotel.addRoom();
					Room r = new Room(roomNumber, roomAvailability, roomTypeID);
					
					ro.addRoom(r);
					JOptionPane.showMessageDialog(null, "New Room added to the database");
				}
				else if(e.getSource() == updateButton) {
					int roomNumber = Integer.parseInt(roomNumberField_UPDATE.getText());
					int roomTypeID = update_typeCombo.getSelectedIndex();
					if(update_typeCombo.getSelectedIndex() == 0)
						roomTypeID = 900;
					else if(update_typeCombo.getSelectedIndex() == 1)
						roomTypeID = 901;
					else if(update_typeCombo.getSelectedIndex() == 2)
						roomTypeID = 902;
					ro.updateRoom(roomNumber, roomTypeID);
					JOptionPane.showMessageDialog(null, "Room updated");
				}
				else if(e.getSource() == deleteRoom){
					int roomNumber = Integer.parseInt(roomNumberField_DELETE.getText());
					ro.deleteRoom(roomNumber);
					JOptionPane.showMessageDialog(null, "Room deleted");
				}
			}
		}
