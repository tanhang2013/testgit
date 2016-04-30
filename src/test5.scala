/**
  * Created by 505 on 2016/4/30.
  */

import java.awt.Color
import java.awt.Dimension
import java.text.SimpleDateFormat
import javax.swing.JPanel

import demo.MovingAverageDemo1
import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartPanel
import org.jfree.chart.JFreeChart
import org.jfree.chart.axis.DateAxis
import org.jfree.chart.plot.XYPlot
import org.jfree.chart.renderer.xy.XYItemRenderer
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
import org.jfree.data.time.Month
import org.jfree.data.time.MovingAverage
import org.jfree.data.time.TimeSeries
import org.jfree.data.time.TimeSeriesCollection
import org.jfree.data.xy.XYDataset
import org.jfree.ui.ApplicationFrame
import org.jfree.ui.RefineryUtilities

object test5 {
  def createDataset: XYDataset = {
    val var0: TimeSeries = new TimeSeries("L&G European Index Trust")
    var0.add(new Month(2, 2001), 181.8D)
    var0.add(new Month(3, 2001), 167.3D)
    var0.add(new Month(4, 2001), 153.8D)
    var0.add(new Month(5, 2001), 167.6D)
    var0.add(new Month(6, 2001), 158.8D)
    var0.add(new Month(7, 2001), 148.3D)
    var0.add(new Month(8, 2001), 153.9D)
    var0.add(new Month(9, 2001), 142.7D)
    var0.add(new Month(10, 2001), 123.2D)
    var0.add(new Month(11, 2001), 131.8D)
    var0.add(new Month(12, 2001), 139.6D)
    var0.add(new Month(1, 2002), 142.9D)
    var0.add(new Month(2, 2002), 138.7D)
    var0.add(new Month(3, 2002), 137.3D)
    var0.add(new Month(4, 2002), 143.9D)
    var0.add(new Month(5, 2002), 139.8D)
    var0.add(new Month(6, 2002), 137.0D)
    var0.add(new Month(7, 2002), 132.8D)
    val var1: TimeSeries = MovingAverage.createMovingAverage(var0, "Six Month Moving Average", 6, 0)
    val var2: TimeSeriesCollection = new TimeSeriesCollection
    var2.addSeries(var0)
    var2.addSeries(var1)
    return var2
  }

  def createChart(var0: XYDataset): JFreeChart = {
    val var1: String = "Legal & General Unit Trust Prices"
    val var2: JFreeChart = ChartFactory.createTimeSeriesChart(var1, "Date", "Price Per Unit", var0, true, true, false)
    val var3: XYPlot = var2.getPlot.asInstanceOf[XYPlot]
    val var4: XYItemRenderer = var3.getRenderer
    if (var4.isInstanceOf[XYLineAndShapeRenderer]) {
      val var5: XYLineAndShapeRenderer = var4.asInstanceOf[XYLineAndShapeRenderer]
      var5.setBaseShapesVisible(false)
      var5.setSeriesShapesVisible(0, true)
      var5.setUseFillPaint(true)
      var5.setBaseFillPaint(Color.white)
    }
    val var6: DateAxis = var3.getDomainAxis.asInstanceOf[DateAxis]
    var6.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"))
    return var2
  }

  def createDemoPanel: JPanel = {
    val var0: JFreeChart = createChart(createDataset)
    val var1: ChartPanel = new ChartPanel(var0)
    var1.setMouseWheelEnabled(true)
    return var1
  }

  def main(var0: Array[String]) {
    val var1: MovingAverageDemo1 = new MovingAverageDemo1("Use JFreeChart for plot: MovingAverage.scala")
    var1.pack
    RefineryUtilities.centerFrameOnScreen(var1)
    var1.setVisible(true)
  }
}

class test5(val var1: String) extends ApplicationFrame(var1) {
  val var2: JPanel = MovingAverageDemo1.createDemoPanel
  var2.setPreferredSize(new Dimension(500, 270))
  this.setContentPane(var2)
}


