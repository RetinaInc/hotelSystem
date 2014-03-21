package GUI;
import javax.swing.*;

import Database.CreateTables;
import Database.Queries;
import Model.Hotel;
import Model.User;
import oracle.jdbc.pool.OracleDataSource;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class Login extends JFrame implements ActionListener,MouseListener,KeyListener{
	private JTextField username;
	private JPasswordField password;
	private JButton btnLogin;
	private JLabel lblCreateAccount;

	private Statement stmt;
	private ResultSet rset;
	Queries q = new Queries();
	
	
	public Login(){
		super("Login Screen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(520,325);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		JPanel greeting = new JPanel();
		getContentPane().add(greeting);
		greeting.setBounds(54,11,390,50);
		
		JLabel lblTitanfallTowersHotel = new JLabel("Welcome to TitanFall Towers Hotel");
		lblTitanfallTowersHotel.setFont(new Font("Verdana", Font.ITALIC, 20));
		greeting.add(lblTitanfallTowersHotel);
		
		JPanel login_panel = new JPanel();
		getContentPane().add(login_panel);
		login_panel.setLayout(new GridLayout(2,2));
		login_panel.setBounds(127, 84, 238, 92);
		
		JPanel login_details = new JPanel();
		login_panel.add(login_details);
		login_details.setLayout(new GridLayout(2,2));
		
		JLabel lblUsername = new JLabel("Username");
		login_details.add(lblUsername);
		
		username = new JTextField();
		login_details.add(username);
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		login_details.add(lblPassword);
		
		password = new JPasswordField();
		login_details.add(password);
		
		JPanel login_button = new JPanel();
		login_panel.add(login_button);
		login_button.setLayout(new GridLayout(2,0));
		
		 btnLogin = new JButton("Login");
		btnLogin.addActionListener(this);
		login_button.add(btnLogin);
		
		JPanel create_accountOption = new JPanel();
		login_button.add(create_accountOption);
		create_accountOption.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		 lblCreateAccount = new JLabel("Create Account");
		 lblCreateAccount.setForeground(new Color(0,160,255));
		 lblCreateAccount.addMouseListener(this);
		 create_accountOption.add(lblCreateAccount);

	}
	String type = "";
	String user = "";
	
	CreateTables c = new CreateTables();
	Hotel h = c.getHotel();
	ArrayList<User> users = c.getUsers();
	
	
	public boolean loginSuccessful(){
		boolean login = false;
		
		for(int i = 0; i < users.size(); i++){
			
			if(users.get(i).getUserID().equals(username.getText()) && users.get(i).getPassword().equals(password.getText())){
				login = true;
				type = users.get(i).getUserType();
				user = users.get(i).getUserID();
			}
		}
		
		return login;

	}


	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnLogin){
			try{
			
			if(loginSuccessful()){
				try{
				if(type.equals("A")){
					Admin a = new Admin();
					this.setVisible(false);
					a.setVisible(true);
				}
				else{
					UserScreen ab = new UserScreen(user,users);
					this.setVisible(false);
					ab.setVisible(true);
					
				}
				}
				catch(Exception ae){}
				
			
			}
			else
				JOptionPane.showMessageDialog(null, "Invalid username or password","Login Error",JOptionPane.ERROR_MESSAGE);
			}
			catch(NumberFormatException ae){}
			}
			
		}


	public void mouseClicked(MouseEvent e) {    
        	CreateAccount c = new CreateAccount();
        	setVisible(false);
        	c.setVisible(true);
		
	}


	
	public void mouseEntered(MouseEvent e) {
        	lblCreateAccount.setForeground(new Color(100,255,100));
        }


	
	public void mouseExited(MouseEvent e) {
		lblCreateAccount.setForeground(new Color(0,160,255)); 
	}


	
	public void mousePressed(MouseEvent e) {
        	lblCreateAccount.setForeground(Color.BLUE);
	}

	public void mouseReleased(MouseEvent e) {

        	lblCreateAccount.setForeground(Color.BLUE);
	}



	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}



