package GUI;

import javax.swing.*;
import java.awt.*;

public class HelpGUI extends JPanel {
	
	private JPanel container;
	
	public HelpGUI(){
	
	this.setLayout(null);
	container = new JPanel();
	container.setBounds(10,191, 970, 288);
	add(container);
	container.setLayout(null);
	
	JLabel faq = new JLabel("FAQs");
	faq.setFont(new Font("Tahoma", Font.PLAIN, 26));
	faq.setHorizontalAlignment(SwingConstants.CENTER);
	faq.setBounds(450, 0, 60, 32);
	container.add(faq);
	
	JLabel lblAccountIssues = new JLabel("Account issues:");
	lblAccountIssues.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblAccountIssues.setHorizontalAlignment(SwingConstants.CENTER);
	lblAccountIssues.setBounds(285, 48, 157, 25);
	container.add(lblAccountIssues);
	
	JComboBox helpQscomboBox = new JComboBox();
	helpQscomboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
	helpQscomboBox.setModel(new DefaultComboBoxModel(new String[] {"How do I change my username?", "How do I change my password?", "Changing personal info", "Delete my account"}));
	helpQscomboBox.setBounds(520, 45, 323, 31);
	container.add(helpQscomboBox);
	
	JLabel lblBookingIssues = new JLabel("Booking issues: ");
	lblBookingIssues.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblBookingIssues.setHorizontalAlignment(SwingConstants.CENTER);
	lblBookingIssues.setBounds(295, 84, 147, 25);
	container.add(lblBookingIssues);
	
	JComboBox helpQscomboBox2 = new JComboBox();
	helpQscomboBox2.setFont(new Font("Tahoma", Font.PLAIN, 20));
	helpQscomboBox2.setModel(new DefaultComboBoxModel(new String[] {"How do I make a booking?", "Can I change my booking details?", "Can I add extras to my booking?", "Deleting a booking", "Can I pay without using a credit card?"}));
	helpQscomboBox2.setBounds(518, 87, 373, 31);
	container.add(helpQscomboBox2);
	
	JLabel helpLabel = new JLabel("If your question isn't answered in the above FAQs, please see our user manual for more answers");
	helpLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
	helpLabel.setHorizontalAlignment(SwingConstants.CENTER);
	helpLabel.setBounds(10, 138, 948, 27);
	container.add(helpLabel);
	
	JLabel lblOr = new JLabel("or");
	lblOr.setFont(new Font("Tahoma", Font.PLAIN, 20));
	lblOr.setHorizontalAlignment(SwingConstants.CENTER);
	lblOr.setBounds(470, 178, 18, 25);
	container.add(lblOr);
	
	JLabel contactUs = new JLabel("Contact us for personal assistance");
	contactUs.setFont(new Font("Tahoma", Font.PLAIN, 20));
	contactUs.setHorizontalAlignment(SwingConstants.CENTER);
	contactUs.setBounds(340, 214, 304, 25);
	container.add(contactUs);
	}
}
