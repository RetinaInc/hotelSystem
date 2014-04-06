package GUI;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class AdminPrintReports extends JPanel {
	public AdminPrintReports(){
		setBorder(null);
		
		this.setLayout(null);
		
		JPanel greeting3 = new JPanel();
		greeting3.setBounds(320, 11, 360, 44);
		add(greeting3);

		JLabel lblTitanfallTowersHotel3 = new JLabel("TitanFall Towers Hotel");
		greeting3.add(lblTitanfallTowersHotel3);
		lblTitanfallTowersHotel3.setFont(new Font("Verdana", Font.ITALIC, 32));
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBounds(115, 98, 769, 224);
		add(panel);
		panel.setLayout(null);


		JLabel selectReport = new JLabel("Select the type of report you want to print:");
		selectReport.setBounds(0, 0, 397, 23);
		panel.add(selectReport);
		selectReport.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JComboBox reportOptions = new JComboBox();
		reportOptions.setFont(new Font("Tahoma", Font.PLAIN, 20));
		reportOptions.setBounds(418, 4, 346, 23);
		panel.add(reportOptions);
		reportOptions.setModel(new DefaultComboBoxModel(new String[] {"Total Income for Single Rooms", "Total Income for Double Rooms"}));

		JButton saveReportTo = new JButton("Save report to file");
		saveReportTo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		saveReportTo.setForeground(Color.ORANGE);
		saveReportTo.setBounds(171, 105, 210, 23);
		panel.add(saveReportTo);

		JButton openReport = new JButton("Open report");
		openReport.setFont(new Font("Tahoma", Font.PLAIN, 20));
		openReport.setForeground(Color.GREEN);
		openReport.setBounds(418, 105, 210, 23);
		panel.add(openReport);
	}
}
