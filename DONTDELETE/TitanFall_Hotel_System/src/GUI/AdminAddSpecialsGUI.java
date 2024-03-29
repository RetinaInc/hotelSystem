package GUI;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Database.manageBookingOperations;
import Database.specialsOperations;
import Model.Special;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminAddSpecialsGUI extends JPanel implements ActionListener{
	private JLabel specialName,priceOfSpecial,currentSpecials;
	private JTextField specialsName,specialPrice;
	private DefaultTableModel model;
	private ArrayList<Object[]> specialList;
	private Object[][] array2d;
	private Object[] columnNames = { "Name", "Cost"};
	private JButton add,remove;
	private JTable specialsList;
	private JPanel container;
	private Font fontBigger;
	private Color color = new Color(227,99,26);
	public AdminAddSpecialsGUI(){
		this.setLayout(null);
		container = new JPanel();
		container.setLayout(null);
		container.setVisible(true);
		container.setBounds(20,120,798,420);
		add(container);
		
		fontBigger = new Font("Veranda", Font.PLAIN, 18);

		 specialName = new JLabel("Name of Special: ");
		specialName.setFont(fontBigger);
		specialName.setBounds(284, 69, 161, 23);
		container.add(specialName);

		 specialsName = new JTextField();
		specialsName.setBounds(455, 72, 126, 23);
		container.add(specialsName);
		specialsName.setColumns(10);

		 priceOfSpecial = new JLabel("Price of Special:    �");
		priceOfSpecial.setFont(fontBigger);
		priceOfSpecial.setBounds(284, 105, 170, 23);
		container.add(priceOfSpecial);

		 specialPrice = new JTextField();
		specialPrice.setBounds(455, 105, 126, 23);
		container.add(specialPrice);
		specialPrice.setColumns(10);

		 add = new JButton("Add to specials");
		 add.addActionListener(this);
		 add.setBackground(color);
		add.setFont(fontBigger);
		add.setBounds(284, 168, 190, 23);
		container.add(add);

		 remove = new JButton("Remove special");
		 remove.addActionListener(this);
		 remove.setBackground(color);
		 remove.setFont(fontBigger);
		 remove.setBounds(500, 168, 190, 23);
		container.add(remove);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(300, 230, 350, 120);
		container.add(scrollPane);
		fillTable();
		model = new DefaultTableModel(array2d, columnNames);

		specialsList = new JTable(model);
		specialsList.getTableHeader().setBackground(color);
		specialsList.setBorder(null);
		specialsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		specialsList.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(specialsList);
		//specialsList.setEnabled(false);

		currentSpecials = new JLabel("Current specials:");
		currentSpecials.setFont(fontBigger);
		currentSpecials.setBounds(147, 200, 154, 23);
		container.add(currentSpecials);

	}
	
	public boolean emptyFields(String e) {
		boolean valid = false;
		if (e.isEmpty() == true) {
			valid = false;
		} else {
			valid = true;
		}
		return valid;
	}
	
	private void fillTable() {
	// gets the specials in the system
		specialsOperations s = new specialsOperations();
		specialList = new ArrayList<Object[]>(s.getSpecials());
		array2d = specialList.toArray(new Object[specialList.size()][]);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == add){
			try
			{
				double price = Double.parseDouble(specialPrice.getText());
				specialsOperations s = new specialsOperations();
				int id = s.getLastRow();
				
				if(emptyFields(specialsName.getText()) == true){
					Special special = new Special((id + 11),specialsName.getText(),price);
					s.addSpecialsAdmin(special);
					JOptionPane.showMessageDialog(null, specialsName.getText() + " is now a special","Special added",
							JOptionPane.INFORMATION_MESSAGE);
					AdminAddSpecialsGUI a = new AdminAddSpecialsGUI();
					container.setVisible(false);
					a.setVisible(true);
					a.setBounds(0,0,798,500);
					add(a);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Name cannot be empty","Add special error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
			catch(Exception me){
				JOptionPane.showMessageDialog(null, "Please enter a number for the price field","Add special error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		
		else
		{
			try
			{
			//get the number of row the user selects 
			int row = specialsList.getSelectedRow();
			//column is always set to zero because we are looking for the special name
			String name = specialsList.getValueAt(row, 0).toString();
			
			specialsOperations s = new specialsOperations();
			s.removeSpecial(name);
			
			AdminAddSpecialsGUI a = new AdminAddSpecialsGUI();
			container.setVisible(false);
			a.setVisible(true);
			a.setBounds(0,0,798,500);
			add(a);
			}
			catch(Exception me){
				JOptionPane.showMessageDialog(null, "Please select a special you wish to remove","Remove Special",
						JOptionPane.WARNING_MESSAGE);
			}
		}
		
	}
}
