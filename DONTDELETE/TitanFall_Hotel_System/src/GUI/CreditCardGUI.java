package GUI;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.*;

import Model.*;
import Database.*;

public class CreditCardGUI extends JPanel implements ActionListener,MouseListener {
	
	private JTextField cardNum, expiry, ccv;
	private JComboBox<String> combo, expCombo1, expCombo2;
	private JButton btnBack, btnPayNow;
	private JLabel securityCode, creditCardNumber, cardholderName, creditCardType, titanfallTowersHotel, ccvNumber;
	private JPanel container;
	private String userID,arrivalDate,departureDate;
	private double total;
	private int numRooms,numNights,numGuests;
	private ArrayList<User> users;
	private ArrayList<Integer> roomChoice;
	private Calendar calDate;
	private ResultSet rs;
	private JPanel panel;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private Color color = new Color(227,99,26);
	
	public CreditCardGUI(Calendar dc,String user, ArrayList<User> users, double total, int numRooms, int numNights, int numGuests, String arrivalD, String departureD, ArrayList<Integer> roomChoice) {
		setSize(575,600);
		container = new JPanel();
		container.setLocation(150, 11);
		setLayout(null);
		container.setSize(384,300);
		add(container);
		
		this.roomChoice = roomChoice;
		this.calDate = dc;
		userID = user;
		this.users = users;
		this.total = total;
		this.numRooms = numRooms;
		this.numNights = numNights;
		this.numGuests = numGuests;
		this.arrivalDate = arrivalD;
		this.departureDate = departureD;
		container.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel = new JPanel();
		container.add(panel);
		
		creditCardType = new JLabel("Card Type:");
		creditCardType.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(creditCardType);
		creditCardType.setBounds(82, 59, 127, 14);
		
		combo = new JComboBox<String>();
		combo.setBackground(SystemColor.text);
		panel.add(combo);
		combo.setBackground(new Color(240, 240, 240));
		combo.addItem("Select");
		combo.addItem("Visa");
		combo.addItem("Mastercard");
		combo.addItem("Laser");
		combo.setBounds(219, 56, 144, 20);
		
		JPanel panel_1 = new JPanel();
		container.add(panel_1);
		
		creditCardNumber = new JLabel("Card Number:");
		panel_1.add(creditCardNumber);
		
				cardNum = new JTextField();
				panel_1.add(cardNum);
				cardNum.setColumns(10);
		
		panel_2 = new JPanel();
		container.add(panel_2);
		
		ccvNumber = new JLabel("                  Security Code:");
		panel_2.add(ccvNumber);
		
		ccv = new JTextField(3);
		panel_2.add(ccv);
		
		securityCode = new JLabel("(About security code)");
		panel_2.add(securityCode);
		securityCode.setForeground(Color.RED);
		securityCode.addMouseListener(this);
		
		panel_3 = new JPanel();
		container.add(panel_3);
		
		JLabel lblExpiryDate = new JLabel("     Expiry Date: ");
		panel_3.add(lblExpiryDate);
		
		expCombo1 = new JComboBox();
		panel_3.add(expCombo1);
		expCombo1.setBackground(SystemColor.text);
		expCombo1.setEditable(false);
		
		expCombo2 = new JComboBox();
		panel_3.add(expCombo2);
		expCombo2.setBackground(SystemColor.text);
		expCombo2.setEditable(false);
		expCombo2.addItem("");
		expCombo2.addItem("2014");
		expCombo2.addItem("2015");
		expCombo2.addItem("2016");
		expCombo2.addItem("2017");
		expCombo2.addItem("2018");
		expCombo2.addItem("2019");
		expCombo1.addItem("");
		expCombo1.addItem("01-Jan");
		expCombo1.addItem("02-Feb");
		expCombo1.addItem("03-Mar");
		expCombo1.addItem("04-Apr");
		expCombo1.addItem("05-May");
		expCombo1.addItem("06-Jun");
		expCombo1.addItem("07-Jul");
		expCombo1.addItem("08-Aug");
		expCombo1.addItem("09-Sep");
		expCombo1.addItem("10-Oct");
		expCombo1.addItem("11-Nov");
		expCombo1.addItem("12-Dec");
		
		panel_4 = new JPanel();
		container.add(panel_4);
		
		cardholderName = new JLabel("       Cardholder Name:");
		panel_4.add(cardholderName);
		
		
		expiry = new JTextField();
		panel_4.add(expiry);
		expiry.setColumns(10);
		
		panel_5 = new JPanel();
		container.add(panel_5);
		
		
		btnBack = new JButton("Cancel");
		btnBack.setBackground(color);
		panel_5.add(btnBack);
		
		btnPayNow = new JButton("Pay Now");
		panel_5.add(btnPayNow);
		btnPayNow.setBackground(color);;
		btnPayNow.addActionListener(this);
		btnBack.addActionListener(this);
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
	public static boolean isNumber(String string) {
		try {
			Long.parseLong(string);
			// int a = Integer.parseInt(string);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	public boolean luhnAlgorithm(String ccnum){
		if(ccnum.length() != 16){
			return false;
		}
		int s1 = 0, s2 = 0;
        String reverse = new StringBuffer(ccnum).reverse().toString();
        for(int i = 0 ;i < reverse.length();i++){
            int digit = Character.digit(reverse.charAt(i), 10);
            if(i % 2 == 0){//this is for odd digits, they are 1-indexed in the algorithm
                s1 += digit;
            }else{//add 2 * digit for 0-4, add 2 * digit - 9 for 5-9
                s2 += 2 * digit;
                if(digit >= 5){
                    s2 -= 9;
                }
            }
        }
        return (s1 + s2) % 10 == 0;
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btnBack){
			if(JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel? Booking has not been saved","Cancel Booking",JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION) {
					UserTabbedScreenGUI uts = new UserTabbedScreenGUI(userID, users);
					uts.setVisible(true);
					getTopLevelAncestor().setVisible(false);

			} else {
			    
			}

		}
		else {
			//i think we have to go to the database to the the sequence id then send it to the gui
			if(emptyFields(cardNum.getText()) == true && emptyFields(expiry.getText()) == true && emptyFields(ccv.getText()) == true){
				if(isNumber(cardNum.getText()) == true && isNumber(ccv.getText()) == true){
				if(luhnAlgorithm(cardNum.getText()) == true){
				CreateTables c = new CreateTables();
				int bookingID = c.getLastRow();
				Booking b = new Booking(bookingID, numGuests,numNights,numRooms,total,arrivalDate,departureDate,userID);
				c.addBooking(b,roomChoice);
				
				JOptionPane.showMessageDialog(null, "Booking successful","Booking successful",JOptionPane.INFORMATION_MESSAGE);
				
				
				UserTabbedScreenGUI us = new UserTabbedScreenGUI(userID, users);
				getTopLevelAncestor().setVisible(false);
				us.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(null, "Card number/CCV must be a valid number","Booking error",JOptionPane.INFORMATION_MESSAGE);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "You cannot leave a field blank","Warning",JOptionPane.WARNING_MESSAGE);
			}
			}
			
		}
	}
	
	public void mouseClicked(MouseEvent me) {
		JOptionPane.showMessageDialog(null, "The security code is a three-digit value printed on the card. It is typically printed on the back of the card","The Security Code",JOptionPane.INFORMATION_MESSAGE);	
	}
	
	public void mouseEntered(MouseEvent e) {
		securityCode.setForeground(new Color(0,0,255)); 
		
	}
	public void mouseExited(MouseEvent e) {
		securityCode.setForeground(new Color(255,0,0)); 
		
	}
	public void mousePressed(MouseEvent e) {
		securityCode.setForeground(new Color(0,0,255)); 
		
	}
	public void mouseReleased(MouseEvent e) {
		securityCode.setForeground(new Color(255,0,0)); 
	}
}
