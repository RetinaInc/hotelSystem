package GUI;

import javax.swing.*;

import java.awt.*;

public class HelpGUI extends JPanel {
	
	private JPanel container;
	private Font fontBigger;
	private Color color = new Color(227,99,26);
	private JLabel accountIssues,bookingIssues,helpLabel,or,contactUs;
	private JComboBox helpQscomboBox,helpQscomboBox2;
	public HelpGUI(){
	
	this.setLayout(null);
	container = new JPanel();
	container.setBounds(10,191, 970, 288);
	add(container);
	container.setLayout(null);
	fontBigger = new Font("Veranda", Font.PLAIN, 18);
	
	JLabel faq = new JLabel("FAQs");
	faq.setFont(fontBigger);
	faq.setHorizontalAlignment(SwingConstants.CENTER);
	faq.setBounds(450, 0, 60, 32);
	container.add(faq);
	
	 accountIssues = new JLabel("Account issues:");
	accountIssues.setFont(fontBigger);
	accountIssues.setHorizontalAlignment(SwingConstants.CENTER);
	accountIssues.setBounds(285, 48, 157, 25);
	container.add(accountIssues);
	
	 helpQscomboBox = new JComboBox();
	helpQscomboBox.setFont(fontBigger);
	helpQscomboBox.setModel(new DefaultComboBoxModel(new String[] {"How do I change my username?", "How do I change my password?", "Changing personal info", "Delete my account"}));
	helpQscomboBox.setBounds(520, 45, 323, 31);
	container.add(helpQscomboBox);
	
	 bookingIssues = new JLabel("Booking issues: ");
	bookingIssues.setFont(fontBigger);
	bookingIssues.setHorizontalAlignment(SwingConstants.CENTER);
	bookingIssues.setBounds(295, 84, 147, 25);
	container.add(bookingIssues);
	
	 helpQscomboBox2 = new JComboBox();
	helpQscomboBox2.setFont(fontBigger);
	helpQscomboBox2.setModel(new DefaultComboBoxModel(new String[] {"How do I make a booking?", "Can I change my booking details?", "Can I add extras to my booking?", "Deleting a booking", "Can I pay without using a credit card?"}));
	helpQscomboBox2.setBounds(518, 87, 373, 31);
	container.add(helpQscomboBox2);
	
	 helpLabel = new JLabel("If your question isn't answered in the above FAQs, please see our user manual for more answers");
	helpLabel.setFont(fontBigger);
	helpLabel.setHorizontalAlignment(SwingConstants.CENTER);
	helpLabel.setBounds(10, 138, 948, 27);
	container.add(helpLabel);
	
	 or = new JLabel("or");
	or.setFont(fontBigger);
	or.setHorizontalAlignment(SwingConstants.CENTER);
	or.setBounds(470, 178, 18, 25);
	container.add(or);
	
	 contactUs = new JLabel("Contact us for personal assistance");
	contactUs.setFont(fontBigger);
	contactUs.setHorizontalAlignment(SwingConstants.CENTER);
	contactUs.setBounds(340, 214, 304, 25);
	container.add(contactUs);
	}
}
