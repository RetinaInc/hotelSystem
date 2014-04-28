package GUI;
//REferenceing Harvard Online Tutorial//JFREECHART.org
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
 

public class PieChart extends JFrame {
	  // CREATE THE PIE CHART
	static String title = "";
	public static JPanel createPiePanel(int single, int doubleRoom, int twin, String title) {      
		JFreeChart pieChart = createPieChart(createPieDataset(single, doubleRoom, twin), title); 
        try{
            saveToFile(pieChart,"c:/test.jpg",500,300,100);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ChartPanel(pieChart);
    }
	    // BUILD THE PIE CHART
	    private static JFreeChart createPieChart(PieDataset dataset, String title) {
	 
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
	    public static void saveToFile(JFreeChart chart,
	    	    String aFileName,
	    	    int width,
	    	    int height,
	    	    double quality)
	    	    throws FileNotFoundException, IOException
	    	    {
	    	        BufferedImage img = draw( chart, width, height );
	    	 
	    	        FileOutputStream fos = new FileOutputStream(aFileName);
	    	        JPEGImageEncoder encoder2 =
	    	        JPEGCodec.createJPEGEncoder(fos);
	    	        JPEGEncodeParam param2 =
	    	        encoder2.getDefaultJPEGEncodeParam(img);
	    	        param2.setQuality((float) quality, true);
	    	        encoder2.encode(img,param2);
	    	        fos.close();
	    	    }
	    
	    protected static BufferedImage draw(JFreeChart chart, int width, int height){
	        BufferedImage img =
	        new BufferedImage(width , height,
	        BufferedImage.TYPE_INT_RGB);
	        Graphics2D g2 = img.createGraphics();
	                       
	        chart.draw(g2, new Rectangle2D.Double(0, 0, width, height));
	 
	        g2.dispose();
	        return img;
	    }
		// CREATE THE PIE CHART DATA
	    private static PieDataset createPieDataset(int single, int doubleRoom, int twin) {
	    	int pie = 100;
	    	int wedgeOne = pie/single;
	    	int wedgeTwo = pie/doubleRoom;
	    	int wedgeThree = pie/twin;
	        DefaultPieDataset dataset = new DefaultPieDataset();
	       
	        dataset.setValue("Single", new Double(wedgeOne));
	        dataset.setValue("Twin", new Double(wedgeTwo));
	        dataset.setValue("Double", new Double(wedgeThree));
	    
	         return dataset;
	    }
}