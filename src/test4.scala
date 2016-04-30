/**
  * Created by 505 on 2016/4/30.
  */

import demo.DemoPanel
import java.awt.Color
import java.awt.Dimension
import java.awt.GradientPaint
import java.awt.GridLayout
import javax.swing.JPanel
import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartPanel
import org.jfree.chart.JFreeChart
import org.jfree.chart.axis.NumberAxis
import org.jfree.chart.plot.CategoryPlot
import org.jfree.chart.renderer.category.BarRenderer
import org.jfree.data.category.CategoryDataset
import org.jfree.data.category.DefaultCategoryDataset
import org.jfree.ui.ApplicationFrame
import org.jfree.ui.RectangleInsets
import org.jfree.ui.RefineryUtilities

object test4 {
  private def createDataset: CategoryDataset = {
    val var0: String = "S1"
    val var1: String = "S2"
    val var2: String = "S3"
    val var3: String = "C1"
    val var4: String = "C2"
    val var5: String = "C3"
    val var6: String = "C4"
    val var7: String = "C5"
    val var8: DefaultCategoryDataset = new DefaultCategoryDataset
    var8.addValue(1.0D, var0, var3)
    var8.addValue(4.0D, var0, var4)
    var8.addValue(3.0D, var0, var5)
    var8.addValue(5.0D, var0, var6)
    var8.addValue(5.0D, var0, var7)
    var8.addValue(5.0D, var1, var3)
    var8.addValue(7.0D, var1, var4)
    var8.addValue(6.0D, var1, var5)
    var8.addValue(8.0D, var1, var6)
    var8.addValue(4.0D, var1, var7)
    var8.addValue(4.0D, var2, var3)
    var8.addValue(3.0D, var2, var4)
    var8.addValue(2.0D, var2, var5)
    var8.addValue(3.0D, var2, var6)
    var8.addValue(6.0D, var2, var7)
    return var8
  }

  private def createChart(var0: String, var1: CategoryDataset): JFreeChart = {
    val var2: JFreeChart = ChartFactory.createBarChart(var0, "Category", "Value", var1)
    var2.removeLegend
    val var3: CategoryPlot = var2.getPlot.asInstanceOf[CategoryPlot]
    var3.setDomainGridlinesVisible(true)
    val var4: NumberAxis = var3.getRangeAxis.asInstanceOf[NumberAxis]
    var4.setStandardTickUnits(NumberAxis.createIntegerTickUnits)
    val var5: BarRenderer = var3.getRenderer.asInstanceOf[BarRenderer]
    var5.setDrawBarOutline(false)
    val var6: GradientPaint = new GradientPaint(0.0F, 0.0F, Color.BLUE, 0.0F, 0.0F, new Color(0, 0, 64))
    val var7: GradientPaint = new GradientPaint(0.0F, 0.0F, Color.GREEN, 0.0F, 0.0F, new Color(0, 64, 0))
    val var8: GradientPaint = new GradientPaint(0.0F, 0.0F, Color.RED, 0.0F, 0.0F, new Color(64, 0, 0))
    var5.setSeriesPaint(0, var6)
    var5.setSeriesPaint(1, var7)
    var5.setSeriesPaint(2, var8)
    return var2
  }

  def createDemoPanel: JPanel = {
    val var0: JFreeChart = createChart("Axis Offsets: 0", createDataset)
    val var1: CategoryPlot = var0.getPlot.asInstanceOf[CategoryPlot]
    var1.setAxisOffset(RectangleInsets.ZERO_INSETS)
    val var2: ChartPanel = new ChartPanel(var0)
   // var2.setMinimumDrawWidth(0)
   // var2.setMinimumDrawHeight(0)
    var2.setMouseWheelEnabled(true)
    //var2.setMouseZoomable(true)
    val var3: JFreeChart = createChart("Axis Offsets: 5", createDataset)
    val var4: ChartPanel = new ChartPanel(var3)
    var4.setMinimumDrawWidth(0)
    var4.setMinimumDrawHeight(0)
    val var5: CategoryPlot = var3.getPlot.asInstanceOf[CategoryPlot]
    var5.setAxisOffset(new RectangleInsets(5.0D, 5.0D, 5.0D, 5.0D))
    val var6: DemoPanel = new DemoPanel(new GridLayout(2, 1))
    var6.add(var2)
    var6.add(var4)
    var6.addChart(var0)
    var6.addChart(var3)

    return var6
  }

  def main(var0: Array[String]) {
    val var1: AxisOffsetsDemo1 = new AxisOffsetsDemo1("JFreeChart: AxisOffsetsDemo1.java")
    var1.pack
    RefineryUtilities.centerFrameOnScreen(var1)
    var1.setVisible(true)
  }
}

class test4(val var1: String) extends ApplicationFrame(var1) {
  val var2: JPanel = test4.createDemoPanel
  var2.setPreferredSize(new Dimension(500, 270))
  this.setContentPane(var2)
}
