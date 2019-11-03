package Diagram;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

//http://zetcode.com/java/jfreechart/


public class Util {

    public static final int[][] coinSetups = new int[][]{
            {1, 2, 5},
            {1, 3, 5, 10},
            {1, 3, 5, 10, 25},
            {1, 4, 5},
            {1, 2, 5, 15, 50}
    };

    public static final Integer DEFAULT_SIZE = 1;
    public static final Integer INCREMENTION = 5;
    public static final Integer NUMBER_OF_ITERATION = 12;
    public static final Integer AVARAGING_COUNT = 25;


    /**
     * Egyenletes eloszlas alajan keszit parameterkent kapott darab egesz
     * szamot.
     */
    private static Random r = new Random(0);

    public static int[] generateSortedList(int n) {
        double sum = 0;
        double[] nums = new double[n];
        for (int i = 0; i < n; i++) {
            sum -= Math.log(r.nextDouble());
            nums[i] = sum;
        }

        for (int i = 0; i < n; i++) {
            nums[i] *= n * 2;
            nums[i] /= sum;
        }

        int[] intNums = new int[n];
        for (int i = 0; i < n; i++) {
            intNums[i] = (int) Math.floor(nums[i]);
        }

        return intNums;
    }

    private static double calcMedian(double[] vector) {
        Arrays.sort(vector);
        return vector[vector.length / 2];

    }

   /* public static double[][] createDataPoints() {
        double[] vector = new double[AVARAGING_COUNT];
        double[][] data = new double[2][NUMBER_OF_ITERATION];
        int inputSize = DEFAULT_SIZE;
        for (int i = 0; i < NUMBER_OF_ITERATION; i++) {
            // inputSize += Config.INCREMENTION;
            inputSize *= INCREMENTION;
            System.out.println(String.format("%d\t%d", i, inputSize));
            int[] input = generateSortedList(inputSize);
            // For assertion
            List<Integer> inputList = new ArrayList<>();
            for (int x:input) inputList.add(x);
            for (int j = 0; j < AVARAGING_COUNT; j++) {
                int key = r.nextInt(inputSize);
                long startTime = System.nanoTime();
                int index = Main.binarySearchWrapper(input, key);
                long endTime = System.nanoTime();
                // assertion that
                assert index == inputList.indexOf(key);
                vector[j] = endTime - startTime;
            }
            data[0][i] = inputSize;
            data[1][i] = calcMedian(vector);
        }
        return data;
    }
    public static boolean testAlgorithm() {
        boolean isSuccessed = true;
        if (Main.binarySearch(new int[]{3, 10, 14, 20, 31, 42}, 14, 0, 5) == 2) {
            System.out.println("1. teszt eset sikeres");
        } else {
            System.out.println("1. teszt eset sikertelen");
            isSuccessed = false;
        }
        if (Main.binarySearch(new int[]{4, 12, 33, 51, 72}, 21, 0, 4) == -1) {
            System.out.println("2. teszt eset sikeres");
        } else {
            System.out.println("2. teszt eset sikertelen");
            isSuccessed = false;
        }
        System.out.println();
        return isSuccessed;
    }*/

    public static void showChart(JFreeChart chart) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Charts");

                frame.setSize(600, 400);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

                ChartPanel cp = new ChartPanel(chart);

                frame.getContentPane().add(cp);
            }
        });
    }

    public static void drawDiagram(double[][] data) {
        // Diagram elkeszitese
        XYSeriesCollection dataset = new XYSeriesCollection();
        for (int j = 1; j < data.length; j++) {
            XYSeries series = new XYSeries("proba" + j);
            for (int i = 0; i < data[j].length; i++) {
                series.add(data[0][i], data[j][i]);
            }
            dataset.addSeries(series);
        }

        /*DefaultXYDataset ds = new DefaultXYDataset();
        ds.addSeries("Binary search", data);*/
        JFreeChart chart = ChartFactory.createXYLineChart("Binary search", "input size", "time", dataset,
                PlotOrientation.VERTICAL, true, true, false);

        LogarithmicAxis xAxis = new LogarithmicAxis("input size");

        XYPlot plot = chart.getXYPlot();
        plot.setDomainAxis(xAxis);

        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        //renderer.setSeriesShapesVisible(0, true);

        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesStroke(1, new BasicStroke(2.0f));
        renderer.setSeriesPaint(2, Color.GREEN);
        renderer.setSeriesStroke(2, new BasicStroke(2.0f));


        // Diagram megjelenitese
        showChart(chart);
    }


}
