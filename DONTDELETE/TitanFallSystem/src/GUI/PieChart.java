package GUI;
//REferenceing Harvard Online Tutorial//JFREECHART.org
import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
 

public class PieChart extends JFrame {
	  // CREATE THE PIE CHART
	static String title = "";
	   public static JPanel createPiePanel() {
	        JFreeChart pieChart = createPieChart(createPieDataset());
	        return new ChartPanel(pieChart);
	    }
	   
	    // BUILD THE PIE CHART
	    private static JFreeChart createPieChart(PieDataset dataset) {
	 
	        JFreeChart chart = ChartFactory.createPieChart(
	            "Room Split Pie Chart",  // chart title
	            dataset,             // data
	            true,               // include legend
	            true,
	            false
	        );
	 
	        PiePlot plot = (PiePlot) chart.getPlot();
	        plot.setSectionOutlinesVisible(false);
	        plot.setNoDataMessage("OOoppppppsss");
	 
	        return chart;
	 
	    }
	   
	    // CREATE THE PIE CHART DATA
	    private static PieDataset createPieDataset() {
	        DefaultPieDataset dataset = new DefaultPieDataset();
	       
	        dataset.setValue("Single", new Double(33.333));
	        dataset.setValue("Twin", new Double(33.3333));
	        dataset.setValue("Double", new Double(33.5));
	    
	         return dataset;
	    }
}