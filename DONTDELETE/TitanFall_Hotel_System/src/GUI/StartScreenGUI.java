package GUI;
import javax.swing.*;

import Model.Booking;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Calendar;
import java.util.Date;

public class StartScreenGUI extends JFrame {
	private JLabel welcome, background;
	private JPanel startPanel1;
	private static boolean loggedIn;
	private Font font;


	public StartScreenGUI() {
		super("TitanFall Towers");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 600);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		this.setResizable(false);
		this.setBackground(Color.gray);
		setLoggedIn(false); // user is not logged in
		
		ImageIcon icon = new ImageIcon("TitanfallImages/TitanFallLogo.png");  //welcome to titanfall header logo
		welcome = new JLabel(icon);
		welcome.setBounds(150, 11, 700, 196);
		getContentPane().add(welcome);
		font = new Font("Veranda", font.ITALIC, 20);
		ImageIcon backgroundImage = new ImageIcon("TitanfallImages/titanfallBackground.png");
		background = new JLabel(backgroundImage);
		background.setBounds(0, 280, 1000,300 );
		getContentPane().add(background);
		startPanel1 = new StartPanelGUI();
		startPanel1.setBounds(150, 216, 1000, 384);
		getContentPane().add(startPanel1);
	}
	// getter and setter to set the loggedIn value to true or false throughout
	// the system
	public static boolean isLoggedIn() {
		return loggedIn;
	}

	public static void setLoggedIn(boolean loggedIna) {
		loggedIn = loggedIna;
	}
}
