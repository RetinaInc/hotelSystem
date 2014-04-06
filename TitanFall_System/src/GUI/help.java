package GUI;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;

public class help extends JPanel {

	public help(){

		this.setLayout(null);
		JLabel welcome = new JLabel("Welcome to TitanFall Towers Hotel");
		welcome.setBounds(194, 33, 589, 26);
		add(welcome);
		welcome.setFont(new Font("Verdana", Font.ITALIC, 32));

		JLabel welcomeUser = new JLabel("Welcome " + "Thomas");
		welcomeUser.setForeground(new Color(50, 205, 50));
		welcomeUser.setFont(new Font("Tahoma", Font.ITALIC, 14));
		welcomeUser.setBounds(841, 11, 127, 23);
		add(welcomeUser);

		JLabel faq = new JLabel("FAQs");
		faq.setFont(new Font("Tahoma", Font.PLAIN, 26));
		faq.setHorizontalAlignment(SwingConstants.CENTER);
		faq.setBounds(413, 82, 182, 32);
		add(faq);

		JLabel lblAccountIssues = new JLabel("Account issues");
		lblAccountIssues.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAccountIssues.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountIssues.setBounds(160, 125, 135, 40);
		add(lblAccountIssues);

		JComboBox helpQscomboBox = new JComboBox();
		helpQscomboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		helpQscomboBox.setModel(new DefaultComboBoxModel(new String[] {"How do I change my username?", "How do I change my password?", "Changing personal info", "Delete my account"}));
		helpQscomboBox.setBounds(333, 125, 403, 40);
		add(helpQscomboBox);

		JLabel lblBookingIssues = new JLabel("Booking issues");
		lblBookingIssues.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBookingIssues.setHorizontalAlignment(SwingConstants.CENTER);
		lblBookingIssues.setBounds(160, 176, 135, 46);
		add(lblBookingIssues);

		JComboBox helpQscomboBox2 = new JComboBox();
		helpQscomboBox2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		helpQscomboBox2.setModel(new DefaultComboBoxModel(new String[] {"How do I make a booking?", "Can I change my booking details?", "Can I add extras to my booking?", "Deleting a booking", "Can I pay without using a credit card?"}));
		helpQscomboBox2.setBounds(333, 189, 403, 46);
		add(helpQscomboBox2);

		JLabel helpLabel = new JLabel("If your question isn't answered in the above FAQs, please see our user manual for more answers");
		helpLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		helpLabel.setHorizontalAlignment(SwingConstants.CENTER);
		helpLabel.setBounds(10, 354, 988, 32);
		add(helpLabel);

		JLabel lblOr = new JLabel("or");
		lblOr.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblOr.setBounds(468, 262, 72, 32);
		add(lblOr);

		JLabel contactUs = new JLabel("Contact us for personal assistance");
		contactUs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contactUs.setHorizontalAlignment(SwingConstants.CENTER);
		contactUs.setBounds(334, 329, 340, 25);
		add(contactUs);
	}
}
