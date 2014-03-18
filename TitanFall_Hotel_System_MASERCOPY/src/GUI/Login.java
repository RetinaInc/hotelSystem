package GUI;
import javax.swing.*;

import Database.Queries;
import oracle.jdbc.pool.OracleDataSource;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Login extends JFrame implements ActionListener,MouseListener{
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
	
	public boolean loginSuccessful(){
		boolean login = false;
		String sqlStatement = "SELECT User_ID, UserPassword,UserType FROM Users";
		
		try {
			q.open("local");
			// Send the statement to the DBMS.
			stmt = q.getConn().createStatement();
			
			rset = stmt.executeQuery(sqlStatement);
			// Display the contents of the result set.
			// The result set will have three columns.
			while (rset.next()) {
				System.out.printf("%10s %10s %10s\n",
						rset.getString("User_ID"),
						rset.getString("UserPassword"),
						rset.getString("UserType"));
				
				if(username.getText().equals(rset.getString("User_ID")) && password.getText().equals(rset.getString("UserPassword")))
				{
					login = true;
					type = rset.getString("UserType");
				}
			}
			
		} catch (Exception ex) { 
			System.out.println("ERROR: " + ex.getMessage());
		}
		q.close();
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
					UserScreen ab = new UserScreen();
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
}



