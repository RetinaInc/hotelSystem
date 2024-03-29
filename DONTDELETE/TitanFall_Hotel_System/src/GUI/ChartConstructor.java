package GUI;

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
 
/**
 * A simple demonstration application showing how to create a line chart using
 * data from an {@link XYDataset}.
 *
 */
public class ChartConstructor extends ApplicationFrame
{
 
        /**
         * Creates a new demo.
         *
         * @param title
         *            the frame title.
         */
        public ChartConstructor(final String title, int width, int hight)
        {
                super(title);
                final XYDataset dataset = createDataset();
                final JFreeChart chart = createChart(dataset);
                final ChartPanel chartPanel = new ChartPanel(chart);
                chartPanel.setPreferredSize(new java.awt.Dimension(width, hight));
                setContentPane(chartPanel);
 
        }
 
 
        private XYDataset createDataset()
        {
 
                final XYSeries series1 = new XYSeries("First");
                series1.add(0,5);
                series1.add(1,12);
                series1.add(2,7);
                final XYSeriesCollection dataset = new XYSeriesCollection();
                dataset.addSeries(series1);
 
                return dataset;
 
        }
 
        /**
         * Creates a chart.
         *
         * @param dataset
         *            the data for the chart.
         *
         * @return a chart.
         */
        private JFreeChart createChart(final XYDataset dataset)
        {
 
                // create the chart...
                final JFreeChart chart = ChartFactory.createXYLineChart(
                                "Line Chart Demo 6", // chart title
                                "Date", // x axis label
                                "Result", // y axis label
                                dataset, // data
                                PlotOrientation.VERTICAL, true, // include legend
                                true, // tooltips
                                false // urls
                                );
 
                // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
                chart.setBackgroundPaint(Color.white);
 
                // final StandardLegend legend = (StandardLegend) chart.getLegend();
                // legend.setDisplaySeriesShapes(true);
 
                // get a reference to the plot for further customisation...
                final XYPlot plot = chart.getXYPlot();
                plot.setBackgroundPaint(Color.lightGray);
                // plot.setAxisOffset(new Spacer(Spacer.ABSOLUTE, 5.0, 5.0, 5.0, 5.0));
                plot.setDomainGridlinePaint(Color.white);
                plot.setRangeGridlinePaint(Color.white);
 
                final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
                renderer.setSeriesLinesVisible(0, true);
                renderer.setSeriesShapesVisible(1, false);
                plot.setRenderer(renderer);
 
                // change the auto tick unit selection to integer units only...
                final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
                rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
                // OPTIONAL CUSTOMISATION COMPLETED.
 
                return chart;
 
        }
 
}