/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chinsu.object.export;

import chinsu.ConnectionDB;
import chinsu.object.export_detail.ExportDetail;
import chinsu.object.export_detail.ExportDetailImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows 10
 */
public class ExportImpl extends ExportDetailImpl implements Export{

    Connection con = ConnectionDB.getConnection();

    @Override
    public boolean addExport(ExportObject item) {
        try {        
            String sql = "INSERT INTO tblExport(export_id, export_user_id, export_total, export_date, export_customer_name, export_customer_phone) VALUES(?, ?, ?, ?, ?, ?)";
            
            PreparedStatement pre = this.con.prepareStatement(sql); //Mẫu
            
            pre.setString(1, item.getExport_id());
            pre.setInt(2, item.getExport_user_id());
            pre.setFloat(3, item.getExport_total());
            pre.setString(4, item.getExport_date());
            pre.setString(5, item.getExport_customer_name());
            pre.setString(6, item.getExport_customer_phone());
            return this.add(pre);
        } catch (SQLException ex) {
            Logger.getLogger(ExportImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    @Override
    public ResultSet getExport(int id) { //Lấy theo id
        String sql = "SELECT * FROM tblexport LEFT JOIN tblexport_detail "
                + "ON export_id = export_detail_export_id "
                + "WHERE export_id=?";
        return this.get(sql, id);
    }


    @Override
    public ResultSet getExports(String conds) {
        String sql = "SELECT * FROM tblexport LEFT JOIN tblexport_detail "
                + "ON export_id = export_detail_export_id ";
        if(!conds.equalsIgnoreCase("")) {
            sql += "WHERE " + conds + " ";
        }
        sql += "ORDER BY export_id ASC ";
        return this.gets(sql);
    }
    
    public static void main(String[] args) {
        ExportDetailImpl ed = new ExportDetailImpl();       
        ResultSet rs = ed.getExportDetaila("104202022158");
        try {
            while(rs.next()) {
                System.out.print(rs.getInt("export_detail_equipment_id") + "\t");
                System.out.print(rs.getString("equipment_name") + "\t");
                System.out.println(rs.getInt("equipment_amount"));
                System.out.println("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ExportImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
}
