/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinsu.object.distributor;

import chinsu.ConnectionDB;
import chinsu.object.basic.BasicImpl;
import chinsu.object.distributor.DistributorObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kieun
 */
public class DistributorImpl extends BasicImpl implements Distributor{
    Connection con = ConnectionDB.getConnection();
    private boolean isExistingname(DistributorObject item){
        boolean flag = false;
        String sql = "SELECT * FROM tbldistributor WHERE distributor_name = '" + item.getDistributor_name() + "'";
        ResultSet rs = this.gets(sql);
        if(rs != null){
            try{
                if(rs.next()){
                    flag = true;
                }
                rs.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
        return flag;
    }
    
    private  boolean checkRoles(DistributorObject item) {
        boolean flag = false;
        
        String sql = "SELECT type_id FROM tbltype WHERE type_distributor_id = '"+item.getDistributor_id()+"'";
        
        ResultSet rs  = this.gets(sql);
        if(rs != null) {
            try {
                if(rs.next()) {
                    flag = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(DistributorImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return  flag;   
    }
    
    private boolean isExistingid(DistributorObject item){
        boolean flag = false;
        String sql = "SELECT * FROM tbldistributor WHERE distributor_id = '" + item.getDistributor_id() + "'";
        ResultSet rs = this.gets(sql);
        if(rs != null){
            try{
                if(rs.next()){
                    flag = true;
                }
                rs.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
        return flag;
    }
    @Override
    public boolean addDistributor(DistributorObject item) {
        try{
            if(isExistingname(item)){
                return false;
            }
            String sql = "INSERT INTO tbldistributor(distributor_name, ";
            sql+= "distributor_address,distributor_phone,distributor_imamount) ";
            sql+= "VALUES(?,?,?,?)";
            PreparedStatement pre = this.con.prepareStatement(sql);
            pre.setString(1, item.getDistributor_name());
            pre.setString(2, item.getDistributor_address());
            pre.setString(3, item.getDistributor_phone());
            pre.setInt(4, item.getDistributor_imamount());
            return this.add(pre);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean editDistributor(DistributorObject item) {
        if(!isExistingid(item)){
            return false;
        }
        try{
            String sql = "UPDATE tbldistributor SET ";
            sql += "distributor_name=?, distributor_address=?, distributor_phone=?, distributor_imamount=? ";
            sql += "WHERE distributor_id = ?";

            PreparedStatement pre = this.con.prepareStatement(sql);
            pre.setString(1, item.getDistributor_name());
            pre.setString(2, item.getDistributor_address());
            pre.setString(3, item.getDistributor_phone());
            pre.setInt(4, item.getDistributor_imamount());
            pre.setInt(5, item.getDistributor_id());
            return this.edit(pre);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delDistributor(DistributorObject item) {
        if(this.checkRoles(item)) {
            return false;
        }
        try{
            String sql = "DELETE FROM tbldistributor ";
            sql += "WHERE distributor_id = ?";
            PreparedStatement pre = this.con.prepareStatement(sql);
            pre.setInt(1, item.getDistributor_id());
            return this.del(pre);
        }
        catch(SQLException e){
             e.printStackTrace();
        }
        return false;
    }

    @Override
    public ResultSet getDistributor(int id) {
        String sql = "SELECT * FROM tbldistributor WHERE distributor_id = ?";
        return this.get(sql, id);
    }

    @Override
    public ResultSet getDistributors(String conds) {
       String sql = "SELECT * FROM tbldistributor ";
        if(!conds.equalsIgnoreCase("")) {
            sql += "WHERE " + conds + " ";
        }
        sql += "ORDER BY distributor_name ASC ";
        System.out.println(sql);
        return this.gets(sql);
    }
    
}
