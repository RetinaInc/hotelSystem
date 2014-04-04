package GUI;

import java.awt.*;

import javax.swing.*;

import com.toedter.calendar.JCalendar;

public class calendar extends JPanel {
	JLabel welcome,infoText;
	public calendar(){
		
		Font font = new Font("Verdana", Font.ITALIC, 20);
			this.setLayout(new BorderLayout());
			welcome = new JLabel("                     TitanFall Towers Hotel  ");
			add(welcome,BorderLayout.NORTH);
			welcome.setFont(new Font("Verdana", Font.ITALIC, 32));
			
	
		
			JCalendar bigCalendar = new JCalendar();
			bigCalendar.setSize(800,300);
			
			bigCalendar.getDayChooser();
			add(bigCalendar,BorderLayout.CENTER);
		
		infoText = new JLabel("                             Click a date to see our special offers");
		add(infoText,BorderLayout.SOUTH);
		infoText.setFont(font);
	}
}
