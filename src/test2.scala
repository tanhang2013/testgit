/**
  * Created by 505 on 2016/4/29.
  */
/**
  * Created by 505 on 2016/4/29.
  */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
//package demo;
import java.awt.Color
import javax.swing.JPanel
import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartPanel
import org.jfree.chart.ChartUtilities
import org.jfree.chart.JFreeChart
import org.jfree.chart.annotations.XYPointerAnnotation
import org.jfree.chart.axis.NumberAxis
import org.jfree.chart.block.BlockBorder
import org.jfree.chart.block.BlockContainer
import org.jfree.chart.block.BorderArrangement
import org.jfree.chart.block.EmptyBlock
import org.jfree.chart.labels.StandardXYToolTipGenerator
import org.jfree.chart.plot.XYPlot
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer
import org.jfree.chart.title.CompositeTitle
import org.jfree.chart.title.LegendTitle
import org.jfree.data.xy.XYDataset
import org.jfree.data.xy.XYSeries
import org.jfree.data.xy.XYSeriesCollection
import org.jfree.ui.ApplicationFrame
import org.jfree.ui.RectangleEdge
import org.jfree.ui.RefineryUtilities
import org.jfree.ui.TextAnchor
import java.lang.Math._

object test2 {
  private def createDataset1: XYDataset = {
    val var0: XYSeries = new XYSeries("Original data")
    val f0=100.0
    val T0=1/f0
    var t=0.0
    val deltat=T0/50.0

    while(t<0.02)
      {
          var0.add(t, 5*sin(2*PI*f0*t))
          t=t+deltat
      }

    //var0.add(2.0D, 167.3D)
    val var1: XYSeriesCollection = new XYSeriesCollection
    var1.addSeries(var0)
    return var1
  }


  private def createSample: XYDataset = {
    val var0: XYSeries = new XYSeries("Original data")
    val f0=100.0
    val T0=1/f0
    var t=0.0
    val deltat=T0/3.0

    while(t<0.1)
    {
      var0.add(t, 5*sin(2*PI*f0*t))
      t=t+deltat
     // println("t="+t)
    }

    //var0.add(2.0D, 167.3D)
    val var1: XYSeriesCollection = new XYSeriesCollection
    var1.addSeries(var0)
    return var1
  }


  private def createDataset2: XYDataset = {


    val  varsample:XYDataset =createSample

    val var0: XYSeries = new XYSeries("reconstruction data")


    val f0=100.0
    val T0=1/f0
    var t=0.0
    val deltat=T0/100.0
    val Ts=T0/3.0
    val  ws=2.0*PI/Ts;
    val wc=ws/2.0

    while(t<0.02)
    {
      var sum:Double=0



      for(i<-0 to varsample.getSeriesCount())
      {
//        sum=sum+ varsample.getYValue(i,1)*(sin(wc*(t-varsample.getXValue(i,1)))/(PI*(t-varsample.getXValue(i,1))))
      }
      sum=sum*Ts

      var0.add(t, sum)
      t=t+deltat
    }

    var0.add(0.01, 429.6D)
    var0.add(0.02, 323.2D)

    val var1: XYSeriesCollection = new XYSeriesCollection
    var1.addSeries(var0)
    return var1
  }

  private def createChart: JFreeChart = {
    val var0: XYDataset = createDataset1
    val var1: JFreeChart = ChartFactory.createXYLineChart("testscala Demo 1", "Date", "Price Per Unit", var0)
    var1.removeLegend
    val var2: XYPlot = var1.getPlot.asInstanceOf[XYPlot]
    var2.setDomainPannable(true)
    var2.setRangePannable(true)
    val var3: NumberAxis = var2.getRangeAxis.asInstanceOf[NumberAxis]
    var3.setAutoRangeIncludesZero(false)
    val var4: NumberAxis = new NumberAxis("Secondary")
    var4.setAutoRangeIncludesZero(false)
    var2.setRangeAxis(1, var4)
    var2.setDataset(1, createDataset2)
    var2.mapDatasetToRangeAxis(1, 1)
    val var5: XYLineAndShapeRenderer = var2.getRenderer.asInstanceOf[XYLineAndShapeRenderer]
    var5.setBaseToolTipGenerator(StandardXYToolTipGenerator.getTimeSeriesInstance)
    var5.setBaseShapesVisible(true)
    var5.setBaseShapesFilled(true)
    val var6: XYPointerAnnotation = new XYPointerAnnotation("shuju 1 (2.0, 167.3)", 2.0D, 167.3D, -0.7853981633974483D)
    var6.setTextAnchor(TextAnchor.BOTTOM_LEFT)
    var6.setPaint(Color.red)
    var6.setArrowPaint(Color.red)
    var5.addAnnotation(var6)
    val var7: XYLineAndShapeRenderer = new XYLineAndShapeRenderer(true, true)
    var7.setSeriesPaint(0, Color.black)
    var5.setBaseToolTipGenerator(StandardXYToolTipGenerator.getTimeSeriesInstance)
    val var8: XYPointerAnnotation = new XYPointerAnnotation("shuju 2 (15.0, 613.2)", 15.0D, 613.2D, 1.5707963267948966D)
    var8.setTextAnchor(TextAnchor.TOP_CENTER)
    var7.addAnnotation(var8)
    var2.setRenderer(1, var7)
    val var9: LegendTitle = new LegendTitle(var5)
    val var10: LegendTitle = new LegendTitle(var7)
    val var11: BlockContainer = new BlockContainer(new BorderArrangement)
    var11.add(var9, RectangleEdge.LEFT)
    var11.add(var10, RectangleEdge.RIGHT)
    var11.add(new EmptyBlock(2000.0D, 0.0D))
    val var12: CompositeTitle = new CompositeTitle(var11)
    var12.setFrame(new BlockBorder(Color.red))
    var12.setBackgroundPaint(Color.LIGHT_GRAY)
    var12.setPosition(RectangleEdge.BOTTOM)
    var1.addSubtitle(var12)
    ChartUtilities.applyCurrentTheme(var1)
    return var1
  }

  def createDemoPanel: JPanel = {
    val var0: JFreeChart = createChart
    val var1: ChartPanel = new ChartPanel(var0)
    var1.setMouseWheelEnabled(true)
    return var1
  }

  def main(var0: Array[String]) {
    val var1: test2 = new test2("采样定理实验来自scala")
    var1.pack
    RefineryUtilities.centerFrameOnScreen(var1)
    var1.setVisible(true)

    val  varsample:XYDataset =createSample
    println(varsample.getSeriesCount)
  }
}

class test2(val var1: String) extends ApplicationFrame(var1) {
  this.setContentPane(test2.createDemoPanel)
}

