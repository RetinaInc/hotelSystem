package GUI;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;

public class AdminAddSpecials extends JPanel {
	private JLabel lblDescriptionOfSpecial_1;
	private JPanel container;
	public AdminAddSpecials(){
		this.setLayout(null);
		container = new JPanel();
		container.setLayout(null);
		container.setVisible(true);
		container.setBounds(20,120,798,420);
		add(container);

		JLabel specialName = new JLabel("Name of Special: ");
		specialName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		specialName.setBounds(284, 69, 161, 23);
		container.add(specialName);

		JTextField specialNameT = new JTextField();
		specialNameT.setBounds(455, 72, 126, 23);
		container.add(specialNameT);
		specialNameT.setColumns(10);

		JLabel lblPriceOfSpecial = new JLabel("Price of Special:    \u20AC");
		lblPriceOfSpecial.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPriceOfSpecial.setBounds(284, 105, 170, 23);
		container.add(lblPriceOfSpecial);

		JTextField specialPrice = new JTextField();
		specialPrice.setBounds(455, 109, 126, 20);
		container.add(specialPrice);
		specialPrice.setColumns(10);


		JLabel lblDescriptionOfSpecial = new JLabel("Description: ");
		lblDescriptionOfSpecial.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDescriptionOfSpecial.setBounds(284, 134, 126, 23);
		container.add(lblDescriptionOfSpecial);

		JButton btnAddToSpecials = new JButton("Add to specials");
		btnAddToSpecials.setForeground(Color.GREEN);
		btnAddToSpecials.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddToSpecials.setBounds(353, 168, 154, 23);
		container.add(btnAddToSpecials);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setForeground(Color.RED);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancel.setBounds(517, 168, 156, 23);
		container.add(btnCancel);

		JTable specialsList = new JTable();
		specialsList.setFont(new Font("Tahoma", Font.PLAIN, 20));
		specialsList.setModel(new DefaultTableModel(
				new Object[][] {
						{"Golf", "1 round of an 18 hole golf course", "40"},
						{"Dinner for 2", "3 course dinner for 2 in our 4 star restaurant", "29.99"},
						{"Beauty Treatment", "2 hour session in our spa", "15"},
						{"Go-Karting for 4", "1 hour session for the whole family", "30"},
				},
				new String[] {
						"Name", "Description", "Price (\u20AC)"
				}
				));
		specialsList.getColumnModel().getColumn(0).setPreferredWidth(101);
		specialsList.getColumnModel().getColumn(1).setPreferredWidth(227);
		specialsList.setBounds(136, 240, 602, 64);
		container.add(specialsList);

		lblDescriptionOfSpecial_1 = new JLabel("Current specials:");
		lblDescriptionOfSpecial_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDescriptionOfSpecial_1.setBounds(147, 168, 154, 23);
		container.add(lblDescriptionOfSpecial_1);

		lblDescriptionOfSpecial = new JLabel("Name");
		lblDescriptionOfSpecial.setBounds(147, 215, 46, 23);
		container.add(lblDescriptionOfSpecial);

		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(316, 215, 89, 23);
		container.add(lblDescription);

		JLabel lblPrice = new JLabel("Price (\u20AC)");
		lblPrice.setBounds(608, 215, 65, 23);
		container.add(lblPrice);

		JTextField priceField = new JTextField();
		priceField.setBounds(455, 139, 267, 23);
		container.add(priceField);
		priceField.setColumns(10);

	}
}
