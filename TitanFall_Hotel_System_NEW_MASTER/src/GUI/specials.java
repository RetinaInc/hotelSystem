package GUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class specials extends JPanel {
	
	public specials(){
		
		JPanel specCont = new JPanel(new BorderLayout());
		
		
		JCheckBox chckbxGolf = new JCheckBox("Golf");
		
		
		 JLabel lblAddSomethingExtra = new JLabel("Add something extra to your stay with us,"
		 		      + " by selecting from our range of available specials");
		
		 JCheckBox chckbxSpaTreatment = new JCheckBox("Spa Treatment");
		
		 JCheckBox chckbxBreakfast = new JCheckBox("Breakfast");
		
		 JCheckBox chckbxGokarting = new JCheckBox("Go-karting");
		
		 JLabel lblPrice = new JLabel("Price: \u20AC100.00");
		
		 JButton btnAddSpecials = new JButton("Add Specials");
	}

}
