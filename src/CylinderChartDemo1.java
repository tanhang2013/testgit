/**
 * Created by 505 on 2016/4/30.
 */
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package demo;

import demo.CylinderRenderer;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Paint;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.StandardGradientPaintTransformer;

public class CylinderChartDemo1 extends ApplicationFrame {
    public CylinderChartDemo1(String var1) {
        super(var1);
        JPanel var2 = createDemoPanel();
        var2.setPreferredSize(new Dimension(500, 270));
        this.setContentPane(var2);
    }

    private static CategoryDataset createDataset() {
        DefaultCategoryDataset var0 = new DefaultCategoryDataset();
        var0.addValue(4.0D, "S1", "Monday");
        var0.addValue(5.0D, "S1", "Tuesday");
        var0.addValue(-7.0D, "S1", "Wednesday");
        var0.addValue(6.0D, "S1", "Thursday");
        var0.addValue(4.0D, "S1", "Friday");
        return var0;
    }

    private static JFreeChart createChart(CategoryDataset var0) {
        JFreeChart var1 = ChartFactory.createBarChart3D("Cylinder Chart Demo 1", "Category", "Value", var0, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot var2 = (CategoryPlot)var1.getPlot();
        var2.setRangePannable(true);
        Paint[] var3 = createPaint();
        CylinderChartDemo1.CustomCylinderRenderer var4 = new CylinderChartDemo1.CustomCylinderRenderer(var3);
        var4.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_HORIZONTAL));
        var4.setBaseOutlinePaint(Color.gray);
        var4.setBaseOutlineStroke(new BasicStroke(0.3F));
        var4.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        var2.setRenderer(var4);
        ChartUtilities.applyCurrentTheme(var1);
        return var1;
    }

    private static Paint[] createPaint() {
        Paint[] var0 = new Paint[]{new GradientPaint(0.0F, 0.0F, Color.red, 0.0F, 0.0F, Color.white), new GradientPaint(0.0F, 0.0F, Color.green, 0.0F, 0.0F, Color.white), new GradientPaint(0.0F, 0.0F, Color.blue, 0.0F, 0.0F, Color.white), new GradientPaint(0.0F, 0.0F, Color.orange, 0.0F, 0.0F, Color.white), new GradientPaint(0.0F, 0.0F, Color.magenta, 0.0F, 0.0F, Color.white)};
        return var0;
    }

    public static JPanel createDemoPanel() {
        JFreeChart var0 = createChart(createDataset());
        ChartPanel var1 = new ChartPanel(var0);
        var1.setMouseWheelEnabled(true);
        return var1;
    }

    public static void main(String[] var0) {
        CylinderChartDemo1 var1 = new CylinderChartDemo1("JFreeChart: CylinderChartDemo1.java");
        var1.pack();
        RefineryUtilities.centerFrameOnScreen(var1);
        var1.setVisible(true);
    }

    static class CustomCylinderRenderer extends CylinderRenderer {
        private Paint[] colors;

        public CustomCylinderRenderer(Paint[] var1) {
            this.colors = var1;
        }

        public Paint getItemPaint(int var1, int var2) {
            return this.colors[var2 % this.colors.length];
        }
    }
}
