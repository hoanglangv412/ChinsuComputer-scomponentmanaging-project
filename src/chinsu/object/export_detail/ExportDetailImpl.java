/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chinsu.object.export_detail;

import chinsu.ConnectionDB;
import chinsu.object.basic.BasicImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Windows 10
 */
public class ExportDetailImpl extends BasicImpl implements ExportDetail{
    Connection con = ConnectionDB.getConnection();

    @Override
    public boolean addExportDetail(ExportDetailObject item) {
        try {          
            String sql = "INSERT INTO tblexport_detail(export_detail_export_id, export_detail_equipment_id, export_detail_amount, export_detail_total) VALUES(?, ?, ?, ?)";
            
            PreparedStatement pre = this.con.prepareStatement(sql); //Mẫu
            
            pre.setString(1, item.getExport_detail_export_id());
            pre.setInt(2, item.getExport_detail_equipment_id());
            pre.setInt(3, item.getExport_detail_amount());
            pre.setFloat(4, item.getExport_detail_total());
            return this.add(pre);
        } catch (SQLException ex) {
            Logger.getLogger(ExportDetailImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ResultSet getExportDetaila(String id) { //Lấy theo id
        String sql = "SELECT * FROM tblexport_detail "
                + "LEFT JOIN tblequipment ON export_detail_equipment_id=equipment_id "
                + "LEFT JOIN tblexport ON export_detail_export_id=export_id "
                + "WHERE export_detail_export_id=?";
        PreparedStatement pre;
        try {
            pre = this.con.prepareStatement(sql);
            pre.setString(1, id);
        return pre.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ExportDetailImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ResultSet getExportDetails(String conds) {
        String sql = "SELECT * FROM tblexport_detail "
                + "LEFT JOIN tblequipment ON export_detail_equipment_id=equipment_id "
                + "LEFT JOIN tblexport ON export_detail_export_id=export_id ";
        if(!conds.equalsIgnoreCase("")) {
            sql += "WHERE " + conds + " ";
        }
        sql += "ORDER BY export_detail_export_id ASC";
        return this.gets(sql);
    }

    @Override
    public ResultSet getExportDetail(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
