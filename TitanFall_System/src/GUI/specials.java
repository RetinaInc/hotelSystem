package GUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.border.EtchedBorder;

public class specials extends JPanel {
	
	public specials(){
		setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		setBackground(new Color(192, 192, 192));
		setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 245, 245));
		panel_1.setBounds(219, 36, 556, 37);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel welcome = new JLabel("Welcome to Titanfall Towers Hotel");
		welcome.setBounds(0, 0, 556, 37);
		panel_1.add(welcome);
		welcome.setBackground(new Color(245, 245, 245));
		welcome.setBorder(new SoftBevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, new Color(135, 206, 235)));
		welcome.setFont(new Font("Verdana", Font.PLAIN, 32));
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 128, 0), null, new Color(0, 0, 0), null));
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(125, 81, 743, 288);
		add(panel);
		panel.setLayout(null);

		
		JCheckBox chckbxGolf = new JCheckBox("Golf");
		chckbxGolf.setBackground(new Color(245, 245, 245));
		chckbxGolf.setBounds(323, 165, 139, 23);
		panel.add(chckbxGolf);
		chckbxGolf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		 JLabel lblAddSomethingExtra = new JLabel("Add something extra to your stay with us,"
		 		      + " by selecting from our range of available specials");
		 lblAddSomethingExtra.setBounds(10, 0, 743, 36);
		 panel.add(lblAddSomethingExtra);
		 lblAddSomethingExtra.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		 JCheckBox chckbxSpaTreatment = new JCheckBox("Spa Treatment");
		 chckbxSpaTreatment.setBackground(new Color(245, 245, 245));
		 chckbxSpaTreatment.setBounds(323, 87, 139, 23);
		 panel.add(chckbxSpaTreatment);
		 chckbxSpaTreatment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		 JCheckBox chckbxBreakfast = new JCheckBox("Breakfast");
		 chckbxBreakfast.setBackground(new Color(245, 245, 245));
		 chckbxBreakfast.setBounds(323, 139, 126, 23);
		 panel.add(chckbxBreakfast);
		 chckbxBreakfast.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		 JCheckBox chckbxGokarting = new JCheckBox("Go-karting");
		 chckbxGokarting.setBackground(new Color(245, 245, 245));
		 chckbxGokarting.setBounds(323, 113, 128, 23);
		 panel.add(chckbxGokarting);
		 chckbxGokarting.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JLabel lblPrice = new JLabel("Price: \u20AC100.00");
		lblPrice.setBounds(317, 225, 110, 14);
		panel.add(lblPrice);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		
		JButton btnAddSpecials = new JButton("Add Specials");
		btnAddSpecials.setBackground(new Color(0, 255, 0));
		btnAddSpecials.setBounds(296, 250, 151, 23);
		panel.add(btnAddSpecials);
		btnAddSpecials.setFont(new Font("Tahoma", Font.PLAIN, 14));
	}

}
