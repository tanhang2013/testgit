/**
  * Created by 505 on 2016/4/30.
  */

import demo.CylinderRenderer
import java.awt.BasicStroke
import java.awt.Color
import java.awt.Dimension
import java.awt.GradientPaint
import java.awt.Paint
import javax.swing.JPanel

import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartPanel
import org.jfree.chart.ChartUtilities
import org.jfree.chart.JFreeChart
import org.jfree.chart.labels.StandardCategoryToolTipGenerator
import org.jfree.chart.plot.CategoryPlot
import org.jfree.chart.plot.PlotOrientation
import org.jfree.data.category.CategoryDataset
import org.jfree.data.category.DefaultCategoryDataset
import org.jfree.ui.ApplicationFrame
import org.jfree.ui.GradientPaintTransformType
import org.jfree.ui.RefineryUtilities
import org.jfree.ui.StandardGradientPaintTransformer

object test7 {
  private def createDataset: CategoryDataset = {
    val var0: DefaultCategoryDataset = new DefaultCategoryDataset
    var0.addValue(4.0D, "S1", "Monday")
    var0.addValue(5.0D, "S1", "Tuesday")
    var0.addValue(-7.0D, "S1", "Wednesday")
    var0.addValue(6.0D, "S1", "Thursday")
    var0.addValue(4.0D, "S1", "Friday")
    return var0
  }

  private def createChart(var0: CategoryDataset): JFreeChart = {
    val var1: JFreeChart = ChartFactory.createBarChart3D("Cylinder Chart from scala language", "Category", "Value", var0, PlotOrientation.VERTICAL, false, true, false)
    val var2: CategoryPlot = var1.getPlot.asInstanceOf[CategoryPlot]
    var2.setRangePannable(true)
    val var3: Array[Paint] = createPaint
    val var4: test7.CustomCylinderRenderer = new test7.CustomCylinderRenderer(var3)
    var4.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_HORIZONTAL))
    var4.setBaseOutlinePaint(Color.gray)
    var4.setBaseOutlineStroke(new BasicStroke(0.3F))
    var4.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator)
    var2.setRenderer(var4)
    ChartUtilities.applyCurrentTheme(var1)
    return var1
  }

  private def createPaint: Array[Paint] = {
    val var0: Array[Paint] = Array[Paint](new GradientPaint(0.0F, 0.0F, Color.red, 0.0F, 0.0F, Color.white), new GradientPaint(0.0F, 0.0F, Color.green, 0.0F, 0.0F, Color.white), new GradientPaint(0.0F, 0.0F, Color.blue, 0.0F, 0.0F, Color.white), new GradientPaint(0.0F, 0.0F, Color.orange, 0.0F, 0.0F, Color.white), new GradientPaint(0.0F, 0.0F, Color.magenta, 0.0F, 0.0F, Color.white))
    return var0
  }

  def createDemoPanel: JPanel = {
    val var0: JFreeChart = createChart(createDataset)
    val var1: ChartPanel = new ChartPanel(var0)
    var1.setMouseWheelEnabled(true)
    return var1
  }

  def main(var0: Array[String]) {
    val var1: test7 = new test7("scala for chart use JfreeChart jar package")
    var1.pack
    RefineryUtilities.centerFrameOnScreen(var1)
    var1.setVisible(true)
  }

  private  class CustomCylinderRenderer(var colors: Array[Paint]) extends CylinderRenderer {
    override def getItemPaint(var1: Int, var2: Int): Paint = {
      return this.colors(var2 % this.colors.length)
    }
  }

}

class test7(val var1: String) extends ApplicationFrame(var1) {
  val var2: JPanel = test7.createDemoPanel
  var2.setPreferredSize(new Dimension(500, 270))
  this.setContentPane(var2)
}

