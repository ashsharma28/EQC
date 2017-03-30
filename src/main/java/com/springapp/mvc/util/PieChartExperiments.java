package com.springapp.mvc.util;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class PieChartExperiments extends Application {

    PieChart pieChart;
    static HashMap<String, Double> map;
    static ArrayList<HashMap> listOfPieCharts;

    public void setMap(HashMap<String, Double> map) {
        PieChartExperiments.map = map;
    }

    public static void setListOfPieCharts(ArrayList<HashMap> listOfPieCharts) {
        PieChartExperiments.listOfPieCharts = listOfPieCharts;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Pie Chart Results");
        pieChart = new PieChart();


        if (map != null)
            map.forEach((x, y) -> {
                pieChart.getData().add(new PieChart.Data(x, y));
            });

        if (listOfPieCharts != null)
            listOfPieCharts.forEach((map1) ->
                    map1.forEach((x1, y1) -> {
                        pieChart.getData().add(new PieChart.Data((String) x1, (Double) y1));
                    })
            );

        VBox vbox = new VBox(pieChart);

        Scene scene = new Scene(vbox, 400, 200);

        primaryStage.setScene(scene);
        primaryStage.setHeight(300);
        primaryStage.setWidth(1200);

        primaryStage.show();
    }

}
