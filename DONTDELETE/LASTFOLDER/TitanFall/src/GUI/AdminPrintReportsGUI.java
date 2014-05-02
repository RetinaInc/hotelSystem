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
		selectReport.setBounds(20, 100, 350, 23);
		container.add(selectReport);
		
		saveReportTo = new JButton("Save report");
		saveReportTo.setSize(150, 23);
		saveReportTo.setLocation(391, 199);
		saveReportTo.setFont(fontBigger);
		saveReportTo.setBackground(color);
		saveReportTo.addActionListener(this);
		container.add(saveReportTo);

		reportOptions = new JComboBox<String>();
		reportOptions.setModel(new DefaultComboBoxModel(new String[] {"Booking trends for a particular year", "Specials trends", 
				"Room Split Pie Chart", "Yearly Booking Trend XyGraph","Room Breakdown Report"}));
		reportOptions.setFont(fontBigger);
		reportOptions.setBounds(380, 98, 320, 30);
		container.add(reportOptions);

		openReport = new JButton("Open report");
		openReport.setFont(fontBigger);
		openReport.setBackground(color);
		openReport.addActionListener(this);
		openReport.setBounds(190, 199, 150, 23);
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
				String y = "";
				try {
					 y = JOptionPane
							.showInputDialog(
									null,
									"Please enter the number of year "
											+ "you wish to get the booking trends of (i.e. 14 for 2014)",
									"Choose Year", JOptionPane.PLAIN_MESSAGE);
					 if(y != null && y.length() == 2 && y.contains("-") == false){
						 year = Integer.parseInt(y);
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
					 else
					 {
						 if(y.equals("")){ //catches empty field
							 JOptionPane.showMessageDialog(null,
										"Please enter a valid number", "Choose Year",
										JOptionPane.OK_OPTION);
						 }
						 else if(y.length() < 2 || y.length() > 2){ //catches numbers too big or small
							 JOptionPane.showMessageDialog(null,
										"Please enter a valid number", "Choose Year",
										JOptionPane.OK_OPTION);
						 }
						 else //catches minus sign
						 {
							 JOptionPane.showMessageDialog(null,
										"Please enter a valid number", "Choose Year",
										JOptionPane.OK_OPTION);
						 }
					 }
					
				} catch (NumberFormatException me) {
					JOptionPane.showMessageDialog(null,
							"Please enter a valid number", "Choose Year",
							JOptionPane.OK_OPTION);
				}
				catch (NullPointerException me) {
					System.out.println("user pressed cancel or the x button");
				}
			}
			else if(reportOptions.getSelectedIndex() == 1){
				int year = 0;
				String y = "";
				try {
					 y = JOptionPane
							.showInputDialog(
									null,
									"Please enter the number of year "
											+ "you wish to get the booking trends of (i.e. 14 for 2014)",
									"Choose Year", JOptionPane.PLAIN_MESSAGE);
					 if(y != null && y.length() == 2 && y.contains("-") == false){
						 year = Integer.parseInt(y);
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
					 else
					 {
						 if(y.equals("")){ //catches empty field
							 JOptionPane.showMessageDialog(null,
										"Please enter a valid number", "Choose Year",
										JOptionPane.OK_OPTION);
						 }
						 else if(y.length() < 2 || y.length() > 2){ //catches numbers too big or small
							 JOptionPane.showMessageDialog(null,
										"Please enter a valid number", "Choose Year",
										JOptionPane.OK_OPTION);
						 }
						 else //catches minus sign
						 {
							 JOptionPane.showMessageDialog(null,
										"Please enter a valid number", "Choose Year",
										JOptionPane.OK_OPTION);
						 }
					 }
					
				} catch (NumberFormatException me) {
					JOptionPane.showMessageDialog(null,
							"Please enter a valid number", "Choose Year",
							JOptionPane.OK_OPTION);
				}
				catch (NullPointerException me) {
					System.out.println("user pressed cancel or the x button");
				}
			}
			else if (reportOptions.getSelectedIndex() == 2) {
				int year = 0;
				int month =0;
				String y="";
				String z ="";
				int monthEntered = 0;
				try {
					y = JOptionPane
							.showInputDialog(
									null,
									"Please enter the number of the Year "
											+ "you wish to get the booking trends of (i.e. 14 for 2014)",
									"Choose Year", JOptionPane.PLAIN_MESSAGE);
					if(y != null && y.length() == 2 && y.contains("-") == false){
						year = Integer.parseInt(y);
						 z = JOptionPane
								.showInputDialog(
										null,
										"Please enter the number of the month "
												+ "you wish to get the booking trends of (i.e. 1 for January)",
										"Choose Year", JOptionPane.PLAIN_MESSAGE);
						 try
						 {
						  monthEntered = Integer.parseInt(z);
						 }
						 catch(NumberFormatException b){
							 System.out.println("user exited");
						 }
						 if(z != null && z.length() == 1 || z.length() == 2 && z.contains("-") == false 
								 && monthEntered <= 12){
							 month = Integer.parseInt(z);
							 JFileChooser f = new JFileChooser();
								int returnVal = f.showSaveDialog(this);
								
								if (returnVal == JFileChooser.APPROVE_OPTION) {
									try{
										ReportQueries q = new ReportQueries();
										String saveLocale = f.getSelectedFile() + ".png";
										int[] a =q.getMonthSplit(year, month);
										PieChart pieChart = new PieChart(a[0], a[1], a[2], "Monthly Breakdown for "+month+"/"+year,saveLocale);
						 
										
									}catch(Exception ev){
									    ev.printStackTrace();
									}
								}
						 }
						 else
						 {
							 if(z.equals("")){ //catches empty field
								 JOptionPane.showMessageDialog(null,
											"Please enter a valid number", "Choose Year",
											JOptionPane.OK_OPTION);
							 }
							 else if(z.length() > 2){ //catches numbers too big
								 JOptionPane.showMessageDialog(null,
											"Please enter a valid number", "Choose Year",
											JOptionPane.OK_OPTION);
							 }
							 else //catches minus sign
							 {
								 JOptionPane.showMessageDialog(null,
											"Please enter a valid number", "Choose Year",
											JOptionPane.OK_OPTION);
							 }
						 }
						 
					}
					else
					{
						if(y.equals("")){ //catches empty field
							 JOptionPane.showMessageDialog(null,
										"Please enter a valid number", "Choose Year",
										JOptionPane.OK_OPTION);
						 }
						 else if(y.length() < 2 || y.length() > 2){ //catches numbers too big or small
							 JOptionPane.showMessageDialog(null,
										"Please enter a valid number", "Choose Year",
										JOptionPane.OK_OPTION);
						 }
						 else //catches minus sign
						 {
							 JOptionPane.showMessageDialog(null,
										"Please enter a valid number", "Choose Year",
										JOptionPane.OK_OPTION);
						 }
					}
				}catch(NumberFormatException ev){
					JOptionPane.showMessageDialog(null,
							"Please enter a valid number", "Choose Year",
							JOptionPane.OK_OPTION);
					ev.printStackTrace();
				}
				catch (NullPointerException me) {
					System.out.println("user pressed cancel or the x button");
				}
			}
			else if (reportOptions.getSelectedIndex() == 3) {
				int inputYear =0;
				String y = "";
				try {
					 y = JOptionPane
							.showInputDialog(null,"Please enter the number of the Year "
											+ "you wish to get the booking trends of (i.e. 14 for 2014)",
									"Choose Year", JOptionPane.PLAIN_MESSAGE);
					 if(y != null && y.length() == 2 && y.contains("-") == false){
						 inputYear = Integer.parseInt(y);
						 JFileChooser f = new JFileChooser();
							int returnVal = f.showSaveDialog(this);
							
							if (returnVal == JFileChooser.APPROVE_OPTION) {
								try{
									ReportQueries q = new ReportQueries();
									String saveLocale = f.getSelectedFile() + ".png";
									int[] bookingCount = q.getMonthlyBookingCount(inputYear);
									for (int i = 0; i < bookingCount.length; i++) {
										System.out.println(""+ bookingCount[i]);
									}
									XyChart xy = new XyChart(bookingCount,saveLocale);
									
					 
									
								}catch(Exception ev){
								    ev.printStackTrace();
								}
							}
					 }
					 else
					 {
						 if(y.equals("")){ //catches empty field
							 JOptionPane.showMessageDialog(null,
										"Please enter a valid number", "Choose Year",
										JOptionPane.OK_OPTION);
						 }
						 else if(y.length() < 2 || y.length() > 2){ //catches numbers too big or small
							 JOptionPane.showMessageDialog(null,
										"Please enter a valid number", "Choose Year",
										JOptionPane.OK_OPTION);
						 }
						 else //catches minus sign
						 {
							 JOptionPane.showMessageDialog(null,
										"Please enter a valid number", "Choose Year",
										JOptionPane.OK_OPTION);
						 }
					 }
					
				} catch (NumberFormatException me) {
					JOptionPane.showMessageDialog(null,
							"Please enter a valid number", "Choose Year",
							JOptionPane.OK_OPTION);
				}
				catch (NullPointerException me) {
					System.out.println("user pressed cancel or the x button");
				}
				
			}
			else
			{	
				JFileChooser f = new JFileChooser();
				int returnVal = f.showSaveDialog(this);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					try {
						BufferedWriter fw = new BufferedWriter(new FileWriter(
								f.getSelectedFile() + ".txt"));
						ReportQueries q = new ReportQueries();
						int[] roomCounts = q.getRoomCount();
						
						String fileOutput = "\t\t\t\t\t\t\t\tTITANFALL TOWERS Current Room Config \r\n\r\n"
								+ "\t\tRoomType \t\t\tAmount of this type"
								+ "\r\n\t\tSingle: \t\t\t"+roomCounts[0] 
								+"\r\n\t\tDouble: \t\t\t"  + roomCounts[1]
								+"\r\n\t\tTwin: \t\t\t\t" +roomCounts[2];
						
						
						
						fw.write(fileOutput);
						fw.close();
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		}	
	}
}

