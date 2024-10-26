package cs4421;

import cs4421.GetSysInfo.CpuInfo;
import org.knowm.xchart.AnnotationImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class TestSysInfo {
    private static BufferedImage resizeImage(BufferedImage originalImage) {
        BufferedImage resizedImage = new BufferedImage(150, 150, originalImage.getType());
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, 150, 150, null);
        g.dispose();
        return resizedImage;
    }

    public static void GraphCPUClockSpeed() throws InterruptedException {
        Graph chart = new Graph("CPU MHz", "Time", "MHz", "MHz", new double[2], new double[2]);
        chart.displayGraph();

        BufferedImage letsgoImage = null;
        BufferedImage overImage = null;

        try {
            letsgoImage = ImageIO.read(new URL("https://cdn.frankerfacez.com/emoticon/478862/4"));
            overImage = ImageIO.read(new URL("https://i.kym-cdn.com/photos/images/facebook/002/249/618/d1e.png"));

            // Resize images to desired width and height (e.g., 100x100 pixels)
            letsgoImage = resizeImage(letsgoImage);
            overImage = resizeImage(overImage);
        } catch (IOException e) {
            e.printStackTrace();
        }

        AnnotationImage letsGoAnnotationImage = new AnnotationImage(letsgoImage, 100, 100, true);
        AnnotationImage overAnnotationImage = new AnnotationImage(overImage, 100, 100, true);

        chart.chart.addAnnotation(letsGoAnnotationImage);
        chart.chart.addAnnotation(overAnnotationImage);

        letsGoAnnotationImage.setVisible(false);
        overAnnotationImage.setVisible(false);

        double startTime = System.currentTimeMillis();

        ArrayList<ArrayList<Double>> returnValue = new ArrayList<>(2);
        returnValue.add(new ArrayList<>());
        returnValue.add(new ArrayList<>());

        double previousValue = 0.0;

        while (true) {
            double currentTime = (System.currentTimeMillis() - startTime) / 1000;

            chart.chart.getStyler().setYAxisMin(0.0);
            chart.chart.getStyler().setYAxisMax(5500.0);

            Thread.sleep(100);

            double cpuMHz = CpuInfo.getCoreClockSpeed(0);

            returnValue.get(0).add(currentTime);
            returnValue.get(1).add(cpuMHz);

            if (returnValue.get(0).size() > 100) {
                returnValue.get(0).remove(0);
                returnValue.get(1).remove(0);
            }

            double[] returnX = returnValue.get(0).stream().mapToDouble(i -> i).toArray();
            double[] returnY = returnValue.get(1).stream().mapToDouble(i -> i).toArray();

            if (cpuMHz - previousValue > 0) {
                letsGoAnnotationImage.setVisible(true);
                overAnnotationImage.setVisible(false);
            } else {
                letsGoAnnotationImage.setVisible(false);
                overAnnotationImage.setVisible(true);
            }

            previousValue = cpuMHz;

            chart.updateGraph(returnX, returnY);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        TestSysInfo.GraphCPUClockSpeed();
    }
}
