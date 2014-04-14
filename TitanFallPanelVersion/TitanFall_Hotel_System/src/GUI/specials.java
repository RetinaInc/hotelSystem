package GUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;

import java.awt.SystemColor;

import javax.swing.border.EtchedBorder;

import Database.Queries;

public class specials extends JPanel implements ActionListener{
	
	private JButton addSpecials;
	private JCheckBox golf,spa,breaky,karting;
	private Color color = new Color(227,99,26);
	private Font font;
	private JLabel addSomething,price;
	private Double priceField = 0.0;
	private int bookingid,numGolf,numBreaky,numSpa,numKarting;
	private Queries q = new Queries();
	private String usersID;
	private JPanel specials;
	public specials(String usersID,int bookingid){
		setLayout(null);	
		 specials = new JPanel();
		specials.setBounds(125,210, 743, 288);
		add(specials);
		specials.setLayout(null);
		font = new Font("Veranda", font.PLAIN, 18);
		this.bookingid = bookingid;
		this.usersID = usersID;
		
		addSomething = new JLabel("Add something extra to your stay with us,"
	 		      + " by selecting from our range of available specials");
	  addSomething.setFont(font);
	 addSomething.setBounds(10, 0, 760, 36);
	 specials.add(addSomething);
		
		 golf = new JCheckBox("Golf");
		 golf.setFont(font);
		golf.setBounds(323, 165, 160, 23);
		golf.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(golf.isSelected()){
					priceField = priceField + 100;
					price.setText("Price: €" + priceField);
					numGolf++;
				}
				else
				{
					priceField = priceField - 100;
					price.setText("Price: €" + priceField);
					numGolf--;
				}
			}
			});
		specials.add(golf);
		
		  spa = new JCheckBox("Spa Treatment");
		  spa.setFont(font);
		  spa.setBounds(323, 87, 160, 23);
		  spa.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(spa.isSelected()){
						priceField = priceField + 150;
						price.setText("Price: €" + priceField);
						numSpa++;
					}
					else
					{
						priceField = priceField - 150;
						price.setText("Price: €" + priceField);
						numSpa--;
					}
				}
				});
		  specials.add(spa);
		
		  breaky = new JCheckBox("Breakfast");
		  breaky.setFont(font);
		  breaky.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(breaky.isSelected()){
						priceField = priceField + 20;
						price.setText("Price: €" + priceField);
						numBreaky++;
					}
					else
					{
						priceField = priceField - 20;
						price.setText("Price: €" + priceField);
						numBreaky--;
					}
				}
				});
		  breaky.setBounds(323, 139, 160, 23);
		  specials.add(breaky);
		
		  karting = new JCheckBox("Go-karting");
		  karting.setFont(font);
		  karting.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(karting.isSelected()){
						priceField = priceField + 50;
						price.setText("Price: €" + priceField);
						numKarting++;
					}
					else
					{
						priceField = priceField - 50;
						price.setText("Price: €" + priceField);
						numKarting--;
					}
				}
				});
		  karting.setBounds(323, 113, 160, 23);
		  specials.add(karting);
		 
		 price = new JLabel("Price: €" + priceField);
		 price.setFont(font);
		price.setBounds(317, 225, 140, 14);
		specials.add(price);
		
		
		 addSpecials = new JButton("Add Specials");
		 addSpecials.setFont(font);
		addSpecials.setBackground(color);
		addSpecials.addActionListener(this);
		addSpecials.setBounds(296, 250, 150, 23);
		specials.add(addSpecials);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addSpecials){
			q.addSpecials(numGolf,numSpa,numBreaky,numKarting,bookingid,priceField);
			JOptionPane.showMessageDialog(null, "Special added to booking " + bookingid,"Special added",
					JOptionPane.INFORMATION_MESSAGE);
			
			manageBooking a = new manageBooking(usersID);
			specials.setVisible(false);
			a.setVisible(true);
			add(a);
		}
		
	}

}
