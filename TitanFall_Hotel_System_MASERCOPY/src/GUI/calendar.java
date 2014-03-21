package GUI;

import java.awt.*;

import javax.swing.*;

import com.toedter.calendar.JCalendar;

public class calendar extends JPanel {
	JLabel welcome,infoText;
	public calendar(){
		
		Font font = new Font("Verdana", Font.ITALIC, 20);
		JPanel calendarCont = new JPanel(new BorderLayout());
		
		JPanel title = new JPanel(new BorderLayout());
		
			welcome = new JLabel("   TitanFall Towers Hotel  ");
			welcome.setFont(font);
			title.add(welcome,BorderLayout.CENTER);
			calendarCont.add(title,BorderLayout.NORTH);
			
		JPanel bigCal = new JPanel(new BorderLayout());
		
			JCalendar bigCalendar = new JCalendar();
			bigCalendar.getDayChooser();
			bigCal.add(bigCalendar,BorderLayout.CENTER);
			calendarCont.add(bigCal,BorderLayout.CENTER);
			
		JPanel info = new JPanel(new BorderLayout());
		
		infoText = new JLabel("Click a date to see our special offers");
		infoText.setFont(font);
		info.add(infoText,BorderLayout.CENTER);
		calendarCont.add(info,BorderLayout.SOUTH);
			
		
			
		add(calendarCont);
	}
}
