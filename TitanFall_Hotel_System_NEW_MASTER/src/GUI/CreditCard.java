package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import Model.*;
import Database.*;

public class CreditCard extends JFrame implements ActionListener,MouseListener {
	
	private JTextField cardNum, expiry, ccv;
	private JComboBox<String> combo, expCombo1, expCombo2;
	private JButton btnBack, btnPayNow;
	private JLabel securityCode, creditCardNumber, cardholderName, creditCardType, titanfallTowersHotel, ccvNumber;
	
	public CreditCard() {
		
		super("Credit Card Details");
		setLocationRelativeTo(null);
		this.setSize(500,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
				
		titanfallTowersHotel = new JLabel("TitanFall Towers Hotel");
		titanfallTowersHotel.setFont(new Font("Jokerman", Font.BOLD | Font.ITALIC, 19));
		titanfallTowersHotel.setHorizontalAlignment(SwingConstants.CENTER);
		titanfallTowersHotel.setBounds(82, 11, 267, 20);
		getContentPane().add(titanfallTowersHotel);
		
		
		cardNum = new JTextField();
		cardNum.setBounds(219, 87, 144, 20);
		getContentPane().add(cardNum);
		cardNum.setColumns(10);
		
		creditCardNumber = new JLabel("Card Number:");
		creditCardNumber.setBounds(82, 90, 127, 14);
		getContentPane().add(creditCardNumber);
		
		cardholderName = new JLabel("Cardholder Name:");
		cardholderName.setBounds(82, 191, 127, 14);
		getContentPane().add(cardholderName);
		
		creditCardType = new JLabel("Card Type:");
		creditCardType.setBounds(82, 59, 127, 14);
		getContentPane().add(creditCardType);
		
		
		btnBack = new JButton("Back");
		btnBack.setForeground(Color.RED);
		btnBack.setBounds(10, 227, 89, 23);
		btnBack.addActionListener(this);
		getContentPane().add(btnBack);
		
		btnPayNow = new JButton("Pay Now");
		btnPayNow.setForeground(new Color(0, 128, 0));
		btnPayNow.addActionListener(this);
		btnPayNow.setBounds(385, 227, 89, 23);
		getContentPane().add(btnPayNow);
		
		JLabel lblExpiryDate = new JLabel("Expiry Date: ");
		lblExpiryDate.setBounds(82, 155, 72, 14);
		getContentPane().add(lblExpiryDate);
		
		
		expiry = new JTextField();
		expiry.setBounds(219, 188, 144, 20);
		getContentPane().add(expiry);
		expiry.setColumns(10);
		
		ccvNumber = new JLabel("Security Code:");
		ccvNumber.setBounds(82, 121, 88, 14);
		getContentPane().add(ccvNumber);
		
		ccv = new JTextField(3);
		ccv.setBounds(219, 118, 39, 20);
		getContentPane().add(ccv);
		ccv.setColumns(10);
		
		combo = new JComboBox<String>();
		combo.setBackground(new Color(240, 240, 240));
		combo.addItem("Select");
		combo.addItem("Visa");
		combo.addItem("Mastercard");
		combo.addItem("Laser");
		combo.setBounds(219, 56, 144, 20);
		getContentPane().add(combo);
		
		expCombo1 = new JComboBox();
		expCombo1.setBackground(SystemColor.text);
		expCombo1.setEditable(false);
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
		expCombo1.setBounds(219, 152, 74, 20);
		getContentPane().add(expCombo1);
		
		expCombo2 = new JComboBox();
		expCombo2.setBackground(SystemColor.text);
		expCombo2.setEditable(false);
		expCombo2.addItem("");
		expCombo2.addItem("2014");
		expCombo2.addItem("2015");
		expCombo2.addItem("2016");
		expCombo2.addItem("2017");
		expCombo2.addItem("2018");
		expCombo2.addItem("2019");
		expCombo2.setBounds(303, 152, 60, 20);
		getContentPane().add(expCombo2);
		
		securityCode = new JLabel("(About security code)");
		securityCode.setForeground(Color.RED);
		securityCode.addMouseListener(this);
		securityCode.setBounds(268, 121, 123, 14);
		getContentPane().add(securityCode);
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btnBack){
			Availability a = new Availability();
			this.setVisible(false);
			a.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(null, "Booking successful","Booking successful",JOptionPane.INFORMATION_MESSAGE);
			UserScreen us = new UserScreen(null, null);
			this.setVisible(false);
			us.setVisible(true);
			
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
