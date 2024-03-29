package GUI;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class XyChart extends JFrame{
	public XyChart(JFreeChart chart){
		this.setSize(600,600);
		
		JPanel jPanel1 = new JPanel();
		jPanel1.setLayout(new java.awt.BorderLayout());
	
		ChartPanel CP = new ChartPanel(chart);
	
		jPanel1.add(CP,BorderLayout.CENTER);
		jPanel1.validate();
		jPanel1.setVisible(true);
		add(jPanel1);
		}
	 public static void main(String[] args){		
	 // Create a simple XY chart
	 XYSeries series = new XYSeries("XYGraph");
	 series.add(1, 1);
	 series.add(2, 2);
	 series.add(3, 1);
	 series.add(4, 9);
	 series.add(5, 8);
	 series.add(6, 100);
	 series.add(7, 2);
	 series.add(8, 6);
	 series.add(9, 9);
	 series.add(10, 10);
	 series.add(9, 9);
	 series.add(10, 10);
	 // Add the series to your data set
	 XYSeriesCollection dataset = new XYSeriesCollection();
	 dataset.addSeries(series);
	 // Generate the graph
	 JFreeChart chart = ChartFactory.createXYLineChart(
	 "XY Chart", // Title
	 "Months of the Year", // x-axis Label
	 "No of bookings in the the particular month", // y-axis Label
	 dataset, // Dataset
	 PlotOrientation.VERTICAL, // Plot Orientation
	 true, // Show Legend
	 true, // Use tooltips
	 false // Configure chart to generate URLs?
	
	 );
	 XyChart a = new XyChart(chart);
	 a.setVisible(true);
	
	 }
	}
