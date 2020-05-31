/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chinsu.object.type;

import chinsu.ConnectionDB;
import chinsu.object.basic.BasicImpl;
import chinsu.object.distributor.DistributorImpl;
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
public class TypeImpl extends DistributorImpl implements Type{

    Connection con = ConnectionDB.getConnection();

    private boolean isExisting(TypeObject item) {
        boolean flag = false;
        String sql = "SELECT * FROM tbltype WHERE type_name='" + item.getType_name() + "' ";
        ResultSet rs = this.gets(sql);
        if (rs != null) {
            try {
                if (rs.next()) {
                    flag = true;
                }
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return flag;
    }

    @Override
    public boolean addType(TypeObject item) {
        try {
            if(isExisting(item)) {
                return false;
            }
            
            String sql = "INSERT INTO tbltype(type_name, type_distributor_id) VALUES(?, ?)";
            
            PreparedStatement pre = this.con.prepareStatement(sql); //Mẫu
            pre.setString(1, item.getType_name());
            pre.setInt(2, item.getType_distributor_id());
            return this.add(pre);
        } catch (SQLException ex) {
            Logger.getLogger(TypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean editType(TypeObject item) {
        try {
            String sql = "UPDATE tbltype SET ";
            sql += "type_name=?, type_distributor_id=? ";
            sql += "WHERE type_id=?";
            
            PreparedStatement pre = this.con.prepareStatement(sql);
            
            pre.setString(1, item.getType_name());
            pre.setInt(2, item.getType_distributor_id());
            pre.setInt(3, item.getType_id());
            return this.edit(pre);
        } catch (SQLException ex) {
            Logger.getLogger(TypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean delType(TypeObject item) {
        try {
            String sql = "DELETE FROM tbltype WHERE type_id=?";
            
            PreparedStatement pre = this.con.prepareStatement(sql);
            pre.setInt(1, item.getType_id());
            return this.del(pre);
        } catch (SQLException ex) {
            Logger.getLogger(TypeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ResultSet getType(int id) { //Lấy theo id
        String sql = "SELECT * FROM tbltype WHERE type_id=?";
        return this.get(sql, id);
    }

    @Override
    public ResultSet getTypes(String conds) {
        String sql = "SELECT * FROM tbltype LEFT JOIN tbldistributor "
                + " ON type_distributor_id=distributor_id ";
        if(!conds.equalsIgnoreCase("")) {
            sql += "WHERE " + conds + " ";
        }
        sql += "ORDER BY type_name ASC ";
        System.out.println(sql);
        return this.gets(sql);
    }
    
}
