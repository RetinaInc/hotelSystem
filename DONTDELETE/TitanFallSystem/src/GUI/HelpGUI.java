package GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class HelpGUI extends JPanel implements ActionListener,MouseListener{
	
	private JPanel container;
	private Font fontBigger;
	private Color color = new Color(227,99,26);
	private JLabel accountIssues,bookingIssues,helpLabel,or,contactUs,usermanual;
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
	helpQscomboBox.setModel(new DefaultComboBoxModel(new String[] {"How do I change my password?", "Changing personal info"}));
	helpQscomboBox.setBounds(520, 45, 323, 31);
	helpQscomboBox.addItem("How do I sign out?");
	helpQscomboBox.addItem("Is my credit card information kept?");
	helpQscomboBox.addActionListener(this);
	container.add(helpQscomboBox);
	
	 bookingIssues = new JLabel("Booking issues: ");
	bookingIssues.setFont(fontBigger);
	bookingIssues.setHorizontalAlignment(SwingConstants.CENTER);
	bookingIssues.setBounds(295, 84, 147, 25);
	container.add(bookingIssues);
	
	 helpQscomboBox2 = new JComboBox();
	helpQscomboBox2.setFont(fontBigger);
	helpQscomboBox2.addActionListener(this);
	helpQscomboBox2.setModel(new DefaultComboBoxModel(new String[] {"How do I make a booking?", "Can I change my booking details?", "Can I add extras to my booking?", "Deleting a booking"}));
	helpQscomboBox2.setBounds(518, 87, 373, 31);
	container.add(helpQscomboBox2);
	 
	usermanual = new JLabel("<html><b>user manual<b></html>");
	usermanual.setFocusable(true);
	usermanual.addMouseListener(this);
	usermanual.setFont(fontBigger);
	usermanual.setBounds(627, 137, 948, 27);
	
	 helpLabel = new JLabel("If your question isn't answered in the above FAQs, please see our    ");
	helpLabel.setFont(fontBigger);
//	helpLabel.setHorizontalAlignment(SwingConstants.CENTER);
	helpLabel.setBounds(100, 138, 948, 27);
	JLabel helpLabel2 = new JLabel("for more answers");
	helpLabel2.setFont(fontBigger);
//	helpLabel2.setHorizontalAlignment(SwingConstants.CENTER);
	helpLabel2.setBounds(740, 138, 948, 27);
	container.add(helpLabel2);
	container.add(helpLabel);
	container.add(usermanual);
	
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
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(helpQscomboBox)){
			if(helpQscomboBox.getSelectedIndex() == 0){
		        try {
					java.awt.Desktop.getDesktop().open(new File("TitanfallWebsite/index.html"));
				} catch (IOException io) {
					// TODO Auto-generated catch block
					io.printStackTrace();
				}
			}
			else if(helpQscomboBox.getSelectedIndex() == 1){
				try {
					java.awt.Desktop.getDesktop().open(new File("TitanfallWebsite/login.html"));
				} catch (IOException io) {
					// TODO Auto-generated catch block
					io.printStackTrace();
				}
			}
			else if(helpQscomboBox.getSelectedIndex() == 2){
				try {
					java.awt.Desktop.getDesktop().open(new File("TitanfallWebsite/availability_screen.html"));
				} catch (IOException io) {
					// TODO Auto-generated catch block
					io.printStackTrace();
				}
			}
			else{
				try {
					java.awt.Desktop.getDesktop().open(new File("TitanfallWebsite/search_screen.html"));
				} catch (IOException io) {
					// TODO Auto-generated catch block
					io.printStackTrace();
				}
			}
		}
		else if(e.getSource().equals(helpQscomboBox2)){
			if(helpQscomboBox2.getSelectedIndex() == 0){
		        try {
					java.awt.Desktop.getDesktop().open(new File("TitanfallWebsite/user_homescreen.html"));
				} catch (IOException io) {
					// TODO Auto-generated catch block
					io.printStackTrace();
				}
			}
			else if(helpQscomboBox2.getSelectedIndex() == 1){
				try {
					java.awt.Desktop.getDesktop().open(new File("TitanfallWebsite/login.html"));
				} catch (IOException io) {
					// TODO Auto-generated catch block
					io.printStackTrace();
				}
			}
			else if(helpQscomboBox2.getSelectedIndex() == 2){
				try {
					java.awt.Desktop.getDesktop().open(new File("TitanfallWebsite/availability_screen.html"));
				} catch (IOException io) {
					// TODO Auto-generated catch block
					io.printStackTrace();
				}
			}
			else{
				try {
					java.awt.Desktop.getDesktop().open(new File("TitanfallWebsite/search_screen.html"));
				} catch (IOException io) {
					// TODO Auto-generated catch block
					io.printStackTrace();
				}
			}
		}
		
	}
	public void mouseClicked(MouseEvent e) {
		try {
			java.awt.Desktop.getDesktop().open(new File("TitanfallWebsite/index.html"));
		} catch (IOException io) {
			// TODO Auto-generated catch block
			io.printStackTrace();
		}
	}
	public void mouseEntered(MouseEvent e) {

		usermanual.setForeground(color);
	}

	public void mouseExited(MouseEvent e) {

		usermanual.setForeground(color.BLACK);
	}

	public void mousePressed(MouseEvent e) {
		usermanual.setForeground(Color.BLUE);

	}

	public void mouseReleased(MouseEvent arg0) {
		usermanual.setForeground(Color.BLUE);

	}
}
