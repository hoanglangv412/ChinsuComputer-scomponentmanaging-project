/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chinsu.object.statistic;

import chinsu.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows 10
 */
public class StatisticImpl implements Statistic{
   
    @Override
    public List<EquipmentImportList> getEquipmentImportList() {
        try {
            Connection conn = ConnectionDB.getConnection();
            String sql = "SELECT equipment_imdate, COUNT(*) AS amount FROM tblequipment GROUP BY equipment_imdate";
            List<EquipmentImportList> list = new ArrayList<>();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                EquipmentImportList e = new EquipmentImportList();
                e.setImportDay(rs.getString("equipment_imdate"));
                e.setAmount(rs.getInt("amount"));
                list.add(e);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(StatisticImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    

    @Override
    public List<ExportImportList> getExportImportList() {
        try {
            Connection conn = ConnectionDB.getConnection();
            String sql = "SELECT export_date, COUNT(export_total) AS total FROM tblexport GROUP BY export_date";
            List<ExportImportList> list = new ArrayList<>();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()) {
                ExportImportList e = new ExportImportList();
                e.setExDate(rs.getString("export_date"));
                e.setExTotal(rs.getFloat("total"));
                list.add(e);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(StatisticImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
