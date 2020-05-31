/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinsu.object.equipment;

import chinsu.ConnectionDB;
import chinsu.object.basic.BasicImpl;
import chinsu.object.equipment.EquipmentObject;
import java.sql.CallableStatement;
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
public class EquipmentImpl extends BasicImpl implements Equipment{
    Connection con = ConnectionDB.getConnection();
    
    private boolean isExistingname(EquipmentObject item){
        boolean flag = false;
        String sql = "SELECT * FROM tblequipment WHERE equipment_name = '" + item.getEquipment_name() + "'";
        ResultSet rs = this.gets(sql);
        if(rs !=null){
            try{
                if(rs.next()){
                    flag=true;
                }
                rs.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
        return flag;
    }
    private boolean isExistingid(EquipmentObject item){
        boolean flag = false;
        String sql = "SELECT * FROM tblequipment WHERE equipment_id = '" + item.getEquipment_id() + "'";
        ResultSet rs = this.gets(sql);
        if(rs !=null){
            try{
                if(rs.next()){
                    flag=true;
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
    public boolean addEquipment(EquipmentObject item) {
        try{
            if(isExistingname(item)){
                return false;
            }
            String sql = "INSERT INTO tblequipment(equipment_name,equipment_amount,equipment_type_id,equipment_imprice,equipment_exprice,equipment_imdate, equipment_image, equipment_barcode) VALUES (?,?,?,?,?,?,?,?)";
            
            PreparedStatement pre = this.con.prepareStatement(sql);
            pre.setString(1, item.getEquipment_name());
            pre.setInt(2,item.getEquipment_amount());
            pre.setInt(3, item.getEquipment_type_id());
            pre.setFloat(4,item.getEquipment_imprice());
            pre.setFloat(5, item.getEquipment_exprice());
            pre.setString(6,item.getEquipment_imdate());
            pre.setString(7, item.getEquipment_image());
            pre.setString(8, item.getEquipment_barcode());
            return this.add(pre);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean editEquipment(EquipmentObject item) {
        try{
            if(!isExistingid(item)){
                return false;
            }
            String sql = "UPDATE tblequipment SET ";
            sql+="equipment_name=?,equipment_amount=?,equipment_type_id=?,equipment_imprice=?,equipment_exprice=?, equipment_imdate=?, equipment_image=?, equipment_barcode=? ";
            sql+="WHERE equipment_id=?";
            
            PreparedStatement pre = this.con.prepareStatement(sql);
            
            pre.setString(1, item.getEquipment_name());
            pre.setInt(2, item.getEquipment_amount());
            pre.setInt(3, item.getEquipment_type_id());
            pre.setFloat(4, item.getEquipment_imprice());
            pre.setFloat(5, item.getEquipment_exprice());
            pre.setString(6, item.getEquipment_imdate());
            pre.setString(7, item.getEquipment_image());
            pre.setString(8, item.getEquipment_barcode());
            pre.setInt(9, item.getEquipment_id());
            
            return this.edit(pre);
        }
        catch(SQLException ex){
            Logger.getLogger(EquipmentImpl.class.getName()).log(Level.SEVERE,null,ex);
        }
        return false;
    }
    @Override
    public boolean delEquipment(EquipmentObject item) {
        try {
            if(!isExistingid(item)){
                return false;
            }
            String sql = "DELETE FROM tblequipment WHERE equipment_id = ?";     
            PreparedStatement pre = this.con.prepareCall(sql);
            pre.setInt(1,item.getEquipment_id());
            return this.del(pre);
        } catch (SQLException ex){
            Logger.getLogger(EquipmentImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    @Override
    public ResultSet getEquipment(int id) {
        String sql = "SELECT * FROM tblequipment WHERE equipment_id=?";
        return this.get(sql, id);
    }

    @Override
    public ResultSet getEquipments(String conds) {
        String sql = "SELECT * FROM tblequipment ";
        if(!conds.equalsIgnoreCase("")) {
            sql += "WHERE " + conds + " ";
        }
        sql += "ORDER BY equipment_name ASC ";
        return this.gets(sql);
    }
    
    public static void main(String[] args) {
        Equipment e =new EquipmentImpl();
        EquipmentObject ep = new EquipmentObject();
        ep.setEquipment_image("C:\\Users\\Windows 10\\Desktop\\btl_java\\src\\chinsu\\img\\1.jpg");
        ep.setEquipment_id(1);
        e.editEquipment(ep);
    }

    @Override
    public boolean updateAmount(int id, int amount) {
        try {
            String sql = "{call pr_updateAmoutEquipment(?, ?)}";
            CallableStatement st = con.prepareCall(sql);
            st.setInt(1, id);
            st.setInt(2, amount);
            st.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EquipmentImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
