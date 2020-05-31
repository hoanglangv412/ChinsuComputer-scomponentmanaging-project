/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinsu.gui_controller;

import chinsu.object.statistic.EquipmentImportList;
import chinsu.object.statistic.ExportImportList;
import chinsu.object.statistic.Statistic;
import chinsu.object.statistic.StatisticImpl;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Windows 10
 */
public class StatisticController {

    private Statistic st = null;

    public StatisticController() {
        st = new StatisticImpl();
    }
    
    public void setDataToChartEquiptment(JPanel jpnItem) {
        List<EquipmentImportList> listItem = st.getEquipmentImportList();
        if(listItem != null) {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for(EquipmentImportList item : listItem) {
                dataset.addValue(item.getAmount(), "Hàng", item.getImportDay());
            }
            
            JFreeChart chart = ChartFactory.createBarChart("THỐNG KÊ HÀNG NHẬP HÀNG NGÀY", "Ngày nhập", "Số lượng", dataset);
            ChartPanel charPanel = new ChartPanel(chart);
            charPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 300));
            
            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(charPanel);
            jpnItem.validate();
            jpnItem.repaint();
            System.out.println("here");
        }
    }
    
    public void setDataToChartExport(JPanel jpnItem) {
        List<ExportImportList> listItem = st.getExportImportList();
        if(listItem != null) {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for(ExportImportList item : listItem) {
                dataset.addValue(item.getExTotal(), "Số lượng hàng bán ra", item.getExDate());
            }
            
            JFreeChart chart = ChartFactory.createBarChart("THỐNG KÊ HÀNG BÁN RA HÀNG NGÀY", "Ngày bán", "Số lượng", dataset);
            ChartPanel charPanel = new ChartPanel(chart);
            charPanel.setPreferredSize(new Dimension(jpnItem.getWidth(), 300));
            
            jpnItem.removeAll();
            jpnItem.setLayout(new CardLayout());
            jpnItem.add(charPanel);
            jpnItem.validate();
            jpnItem.repaint();
        }
    }

}
