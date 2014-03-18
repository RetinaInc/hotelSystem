package GUI;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class CC extends JFrame implements ActionListener{

	private GridBagConstraints gc;
	private JLabel cardNum,cardtype,expire,ccv,name;
	private JTextField cardnum,exp,ccvn,tname;
	private JComboBox<String> cardtypes;
	private JButton back,continueb;
	
	public CC(){
		super("Credit Card Details");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());
		setSize(700,400);
		
		gc = new GridBagConstraints();
		
		
		JPanel greeting = new JPanel();
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 5;
		gc.gridheight = 1;
		gc.weightx = 10;
		gc.weighty = 10;
		add(greeting,gc);
		
		JLabel lblTitanfallTowersHotel = new JLabel("TitanFall Towers Hotel");
		lblTitanfallTowersHotel.setFont(new Font("Verdana", Font.ITALIC, 20));
		greeting.add(lblTitanfallTowersHotel);
		
		cardtype = new JLabel("Card Type");
		gc.fill = GridBagConstraints.CENTER;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 10;
		gc.weighty = 10;
		add(cardtype,gc);
		
		cardtypes = new JComboBox<String>();
		cardtypes.addItem("Visa");
		cardtypes.addItem("Mastercard");
		cardtypes.addItem("aaaaaaaaaaaaa");
		gc.gridx = 1;
		gc.gridy = 1;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 10;
		gc.weighty = 10;
		add(cardtypes,gc);
		
		cardNum = new JLabel("Card Number");
		gc.gridx = 0;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 10;
		gc.weighty = 10;
		add(cardNum,gc);
		
		cardnum = new JTextField(10);
		gc.gridx = 1;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 10;
		gc.weighty = 10;
		add(cardnum,gc);
		
		expire = new JLabel("Expiration Date: (DD-MM-YY)");
		gc.gridx = 3;
		gc.gridy = 1;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 10;
		gc.weighty = 10;
		add(expire,gc);
		
		exp = new JTextField(10);
		gc.gridx = 4;
		gc.gridy = 1;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 10;
		gc.weighty = 10;
		add(exp,gc);
		
		ccv = new JLabel("CCV Number");
		gc.gridx = 3;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 10;
		gc.weighty = 10;
		add(ccv,gc);
		
		ccvn = new JTextField(4);
		gc.gridx = 4;
		gc.gridy = 2;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 10;
		gc.weighty = 10;
		add(ccvn,gc);
		
		name = new JLabel("Card Holder's Name");
		gc.gridx = 0;
		gc.gridy = 3;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 10;
		gc.weighty = 10;
		add(name,gc);
		
		tname = new JTextField(10);
		gc.gridx = 1;
		gc.gridy = 3;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 10;
		gc.weighty = 10;
		add(tname,gc);
		
		back = new JButton("Back");
		back.addActionListener(this);
		gc.gridx = 0;
		gc.gridy = 4;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 10;
		gc.weighty = 10;
		add(back,gc);
		
		continueb = new JButton("Continue");
		continueb.addActionListener(this);
		gc.gridx = 4;
		gc.gridy = 4;
		gc.gridwidth = 1;
		gc.gridheight = 1;
		gc.weightx = 10;
		gc.weighty = 10;
		add(continueb,gc);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == back){
			Availability a = new Availability();
			this.setVisible(false);
			a.setVisible(true);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Booking successful","Booking Successful",JOptionPane.INFORMATION_MESSAGE);
			
		}
		
	}

}
