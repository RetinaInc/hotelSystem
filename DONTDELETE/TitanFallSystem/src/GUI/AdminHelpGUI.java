package GUI;

import javax.swing.*;

import java.awt.*;

public class AdminHelpGUI extends JPanel {
		
	private JPanel container, panel1;
	private JLabel faq, accountIssues, bookingIssues, helpLabel, orLabel, contactLabel;
	private JComboBox helpQscomboBox, helpQscomboBox2;
	private Font fontBigger;
	public AdminHelpGUI() {
		
			this.setLayout(null);
	
			// Container panel
			container = new JPanel();
			container.setLayout(null);
			container.setVisible(true);
			container.setBounds(12,86,976,422);
			add(container);
			
			fontBigger = new Font("Veranda", Font.PLAIN, 18);
			
			faq = new JLabel("FAQs");
			faq.setFont(fontBigger);
			faq.setHorizontalAlignment(SwingConstants.CENTER);
			faq.setBounds(466, 130, 79, 23);
			container.add(faq);
			
			// Panel 1 
			panel1 = new JPanel();
			panel1.setBounds(147, 169, 734, 71);
			container.add(panel1);
			panel1.setLayout(null);
			
			accountIssues = new JLabel("Account issues");
			accountIssues.setBounds(85, 0, 149, 23);
			panel1.add(accountIssues);
			accountIssues.setFont(fontBigger);
			accountIssues.setHorizontalAlignment(SwingConstants.CENTER);
			
			helpQscomboBox = new JComboBox();
			helpQscomboBox.setBounds(0, 34, 335, 30);
			panel1.add(helpQscomboBox);
			helpQscomboBox.setFont(fontBigger);
			helpQscomboBox.setModel(new DefaultComboBoxModel(new String[] {"How do I change my username?", "How do I change my password?", "Changing personal info", "Delete my account"}));
			
			bookingIssues = new JLabel("Booking issues");
			bookingIssues.setBounds(410, 0, 149, 23);
			panel1.add(bookingIssues);
			bookingIssues.setFont(fontBigger);
			bookingIssues.setHorizontalAlignment(SwingConstants.CENTER);
			
			helpQscomboBox2 = new JComboBox();
			helpQscomboBox2.setBounds(387, 34, 335, 30);
			panel1.add(helpQscomboBox2);
			helpQscomboBox2.setFont(fontBigger);
			helpQscomboBox2.setModel(new DefaultComboBoxModel(new String[] {"How do I make a booking?", "Can I change my booking details?", "Can I add extras to my booking?", "Deleting a booking", "Can I pay without using a credit card?"}));
			
			helpLabel = new JLabel("If your question isn't answered in the above FAQs, please see our user manual for more answers");
			helpLabel.setFont(fontBigger);
			helpLabel.setHorizontalAlignment(SwingConstants.CENTER);
			helpLabel.setBounds(92, 288, 789, 23);
			container.add(helpLabel);
			
			orLabel = new JLabel("or");
			orLabel.setFont(fontBigger);
			orLabel.setHorizontalAlignment(SwingConstants.CENTER);
			orLabel.setBounds(489, 336, 22, 23);
			container.add(orLabel);
			
			contactLabel = new JLabel("Contact us for personal assistance");
			contactLabel.setFont(fontBigger);
			contactLabel.setHorizontalAlignment(SwingConstants.CENTER);
			contactLabel.setBounds(363, 382, 284, 23);
			container.add(contactLabel);
	}
}
