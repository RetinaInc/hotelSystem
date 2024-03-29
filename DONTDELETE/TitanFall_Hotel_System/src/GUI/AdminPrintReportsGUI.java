package GUI;

import java.awt.Desktop;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import Database.ReportQueries;

public class AdminPrintReportsGUI extends JPanel implements ActionListener {
	private JPanel container;
	private JComboBox reportOptions;
	private JButton saveReportTo, openReport;
	private JLabel selectReport;
	private String usersFirstName;
	private Font fontBigger;
	private Color color = new Color(227,99,26);

	public AdminPrintReportsGUI(String usersFirstName) {
		setBorder(null);
		this.setLayout(null);
		this.usersFirstName = usersFirstName;
		container = new JPanel();
		container.setLayout(null);
		container.setVisible(true);
		container.setBounds(150, 200, 798, 420);
		add(container);

		fontBigger = new Font("Veranda", Font.PLAIN, 18);
		selectReport = new JLabel("Select the type of report you want to print:");
		selectReport.setFont(fontBigger);
		selectReport.setBounds(20, 98, 350, 23);
		container.add(selectReport);

		reportOptions = new JComboBox<String>();
		reportOptions.setFont(fontBigger);
		reportOptions.addItem("Booking trends for a particular year");
		reportOptions.addItem("Specials trends");
		reportOptions.setBounds(380, 98, 320, 23);
		container.add(reportOptions);

		saveReportTo = new JButton("Save report");
		saveReportTo.setFont(fontBigger);
		saveReportTo.setBackground(color);
		saveReportTo.addActionListener(this);
		saveReportTo.setBounds(181, 203, 150, 23);
		container.add(saveReportTo);

		openReport = new JButton("Open report");
		openReport.setFont(fontBigger);
		openReport.setBackground(color);
		openReport.addActionListener(this);
		openReport.setBounds(371, 203, 150, 23);
		container.add(openReport);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == openReport) {
			JFileChooser f = new JFileChooser();
			int returnVal = f.showOpenDialog(this);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = f.getSelectedFile();
				try {
					Desktop.getDesktop().open(file);
				} catch (Exception we) {
					System.out.println("could not open file" + e);
				}
			}
		} else if (e.getSource() == saveReportTo) {
			if (reportOptions.getSelectedIndex() == 0) {
				int year = 0;
				try {
					String y = JOptionPane
							.showInputDialog(
									null,
									"Please enter the number of year "
											+ "you wish to get the booking trends of (i.e. 14 for 2014)",
									"Choose Year", JOptionPane.PLAIN_MESSAGE);

					year = Integer.parseInt(y);
				} catch (NumberFormatException me) {
					JOptionPane.showInputDialog(null,
							"Please enter a valid number", "Choose Year",
							JOptionPane.OK_OPTION);
				}
				JFileChooser f = new JFileChooser();
				int returnVal = f.showSaveDialog(this);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					try {
						BufferedWriter fw = new BufferedWriter(new FileWriter(
								f.getSelectedFile() + ".txt"));
						ReportQueries q = new ReportQueries();
						
						fw.write(q.getBookingTrends(year) + usersFirstName);
						fw.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
			
			
			else if(reportOptions.getSelectedIndex() == 1){
				int year = 0;
				try {
					String y = JOptionPane
							.showInputDialog(
									null,
									"Please enter the number of year "
											+ "you wish to get the booking trends of (i.e. 14 for 2014)",
									"Choose Year", JOptionPane.PLAIN_MESSAGE);

					year = Integer.parseInt(y);
				} catch (NumberFormatException me) {
					JOptionPane.showInputDialog(null,
							"Please enter a valid number", "Choose Year",
							JOptionPane.OK_OPTION);
				}
				JFileChooser f = new JFileChooser();
				int returnVal = f.showSaveDialog(this);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					try {
						BufferedWriter fw = new BufferedWriter(new FileWriter(
								f.getSelectedFile() + ".txt"));
						ReportQueries q = new ReportQueries();
						
						fw.write(q.specialsTrends(year));
						fw.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		}

	}
}
