/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chinsu.object.sql;

import chinsu.object.distributor.DistributorObject;
import chinsu.object.equipment.EquipmentObject;
import chinsu.object.user.UserObject;

/**
 *
 * @author Windows 10
 */
public class Conditions {
    public static String getUserByIdOrName(UserObject u) {
        return "(user_id='"+u.getUser_id()+"') OR (user_name='"+u.getUser_name()+"')";
    }
    
     public static String getDistributorByNameOrAddressOrPhone(DistributorObject d){
        return "(distributor_name = '"+d.getDistributor_name()+"') OR (distributor_address = '"+d.getDistributor_address()+"') OR (distributor_phone = '"+d.getDistributor_phone()+"')";
    }
    public static String getEquipmentByNameOrByEquipmentTypeId(EquipmentObject e){
        return "(equipment_name = '"+e.getEquipment_name()+"') OR (equipment_type_id = '"+e.getEquipment_type_id()+"')";
    }
}
