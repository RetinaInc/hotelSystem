package GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class AdminHelpGUI extends JPanel implements ActionListener, MouseListener{
		
	private Color color = new Color(227,99,26);
	private JPanel container, panel1;
	private JLabel faq, accountIssues, bookingIssues, helpLabel, orLabel, contactLabel, usermanual;
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
			helpQscomboBox.addActionListener(this);
			helpQscomboBox.setModel(new DefaultComboBoxModel(new String[] {"How do I change my password?", "Changing personal info", "How do I add another administrator?"}));
			
			
			bookingIssues = new JLabel("System issues");
			bookingIssues.setBounds(410, 0, 149, 23);
			panel1.add(bookingIssues);
			bookingIssues.setFont(fontBigger);
			bookingIssues.setHorizontalAlignment(SwingConstants.CENTER);
			
			helpQscomboBox2 = new JComboBox();
			helpQscomboBox2.setBounds(387, 34, 335, 30);
			panel1.add(helpQscomboBox2);
			helpQscomboBox2.addActionListener(this);
			helpQscomboBox2.setFont(fontBigger);
			helpQscomboBox2.setModel(new DefaultComboBoxModel(new String[] {"How to delete a booking?","How to add a room?","How to update a room?","How to delete a room?"}));
			helpQscomboBox2.addItem("How to add a special?");
			helpQscomboBox2.addItem("How to delete a special?");
			helpQscomboBox2.addItem("How to print a report?");

			usermanual = new JLabel("<html><b>user manual<b></html>");
			usermanual.setFocusable(true);
			usermanual.addMouseListener(this);
			usermanual.setFont(fontBigger);
			usermanual.setBounds(627, 299, 948, 27);
			
			helpLabel = new JLabel("If your question isn't answered in the above FAQs, please see our    ");
			helpLabel.setFont(fontBigger);

			helpLabel.setBounds(100, 300, 948, 27);
			JLabel helpLabel2 = new JLabel("for more answers");
			helpLabel2.setFont(fontBigger);

			helpLabel2.setBounds(740, 300, 948, 27);
			container.add(helpLabel2);
			container.add(helpLabel);
			container.add(usermanual);
			
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
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() ==helpQscomboBox){
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
		else if(e.getSource() ==helpQscomboBox2){
			System.out.println(helpQscomboBox2.getSelectedIndex());
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
			else if(helpQscomboBox2.getSelectedIndex() == 3){
				try {
					java.awt.Desktop.getDesktop().open(new File("TitanfallWebsite/availability_screen.html"));
				} catch (IOException io) {
					// TODO Auto-generated catch block
					io.printStackTrace();
				}
			}
			else if(helpQscomboBox2.getSelectedIndex() == 4){
				try {
					java.awt.Desktop.getDesktop().open(new File("TitanfallWebsite/availability_screen.html"));
				} catch (IOException io) {
					// TODO Auto-generated catch block
					io.printStackTrace();
				}
			}
			else if(helpQscomboBox2.getSelectedIndex() == 5){
				try {
					java.awt.Desktop.getDesktop().open(new File("TitanfallWebsite/availability_screen.html"));
				} catch (IOException io) {
					// TODO Auto-generated catch block
					io.printStackTrace();
				}
			}
			else if(helpQscomboBox2.getSelectedIndex() == 6){
				try {
					java.awt.Desktop.getDesktop().open(new File("TitanfallWebsite/availability_screen.html"));
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
