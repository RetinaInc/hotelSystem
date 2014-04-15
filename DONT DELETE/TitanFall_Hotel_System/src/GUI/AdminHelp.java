package GUI;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class AdminHelp extends JPanel {
	private JPanel container;
	public AdminHelp(){
		this.setLayout(null);

		this.setLayout(null);
		container = new JPanel();
		container.setLayout(null);
		container.setVisible(true);
		container.setBounds(12,86,976,422);
		add(container);
		
		JLabel faq = new JLabel("FAQs");
		faq.setFont(new Font("Tahoma", Font.PLAIN, 26));
		faq.setHorizontalAlignment(SwingConstants.CENTER);
		faq.setBounds(466, 77, 79, 23);
		container.add(faq);
		
		JPanel panel = new JPanel();
		panel.setBounds(147, 169, 734, 71);
		container.add(panel);
		panel.setLayout(null);
		
		JLabel lblAccountIssues = new JLabel("Account issues");
		lblAccountIssues.setBounds(85, 0, 149, 23);
		panel.add(lblAccountIssues);
		lblAccountIssues.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAccountIssues.setHorizontalAlignment(SwingConstants.CENTER);
		
		JComboBox helpQscomboBox = new JComboBox();
		helpQscomboBox.setBounds(0, 34, 335, 23);
		panel.add(helpQscomboBox);
		helpQscomboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		helpQscomboBox.setModel(new DefaultComboBoxModel(new String[] {"How do I change my username?", "How do I change my password?", "Changing personal info", "Delete my account"}));
		
		JLabel lblBookingIssues = new JLabel("Booking issues");
		lblBookingIssues.setBounds(410, 0, 149, 23);
		panel.add(lblBookingIssues);
		lblBookingIssues.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBookingIssues.setHorizontalAlignment(SwingConstants.CENTER);
		
		JComboBox helpQscomboBox2 = new JComboBox();
		helpQscomboBox2.setBounds(387, 34, 335, 23);
		panel.add(helpQscomboBox2);
		helpQscomboBox2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		helpQscomboBox2.setModel(new DefaultComboBoxModel(new String[] {"How do I make a booking?", "Can I change my booking details?", "Can I add extras to my booking?", "Deleting a booking", "Can I pay without using a credit card?"}));
		
		JLabel helpLabel = new JLabel("If your question isn't answered in the above FAQs, please see our user manual for more answers");
		helpLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		helpLabel.setHorizontalAlignment(SwingConstants.CENTER);
		helpLabel.setBounds(92, 288, 789, 23);
		container.add(helpLabel);
		
		JLabel lblOr = new JLabel("or");
		lblOr.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOr.setBounds(489, 336, 22, 23);
		container.add(lblOr);
		
		JLabel contactUs = new JLabel("Contact us for personal assistance");
		contactUs.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contactUs.setHorizontalAlignment(SwingConstants.CENTER);
		contactUs.setBounds(363, 382, 284, 23);
		container.add(contactUs);
	}

}
