/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinsu.object.equipment;

/**
 *
 * @author kieun
 */
public class EquipmentObject {
    private int equipment_id;
    private String equipment_name;
    private int equipment_amount;
    private int equipment_type_id;
    private float equipment_imprice;
    private float equipment_exprice;
    private String equipment_imdate;
    private String equipment_image;
    private String equipment_barcode;

    public EquipmentObject() {
    }

    public EquipmentObject(int equipment_id, String equipment_name, int equipment_amount, int equipment_type_id, float equipment_imprice, float equipment_exprice, String equipment_imdate, String equipment_image, String equipment_barcode) {
        this.equipment_id = equipment_id;
        this.equipment_name = equipment_name;
        this.equipment_amount = equipment_amount;
        this.equipment_type_id = equipment_type_id;
        this.equipment_imprice = equipment_imprice;
        this.equipment_exprice = equipment_exprice;
        this.equipment_imdate = equipment_imdate;
        this.equipment_image = equipment_image;
        this.equipment_barcode = equipment_barcode;
    }

    public int getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(int equipment_id) {
        this.equipment_id = equipment_id;
    }

    public String getEquipment_name() {
        return equipment_name;
    }

    public void setEquipment_name(String equipment_name) {
        this.equipment_name = equipment_name;
    }

    public int getEquipment_amount() {
        return equipment_amount;
    }

    public void setEquipment_amount(int equipment_amount) {
        this.equipment_amount = equipment_amount;
    }

    public int getEquipment_type_id() {
        return equipment_type_id;
    }

    public void setEquipment_type_id(int equipment_type_id) {
        this.equipment_type_id = equipment_type_id;
    }

    public float getEquipment_imprice() {
        return equipment_imprice;
    }

    public void setEquipment_imprice(float equipment_imprice) {
        this.equipment_imprice = equipment_imprice;
    }

    public float getEquipment_exprice() {
        return equipment_exprice;
    }

    public void setEquipment_exprice(float equipment_exprice) {
        this.equipment_exprice = equipment_exprice;
    }

    public String getEquipment_imdate() {
        return equipment_imdate;
    }

    public void setEquipment_imdate(String equipment_imdate) {
        this.equipment_imdate = equipment_imdate;
    }

    public String getEquipment_image() {
        return equipment_image;
    }

    public void setEquipment_image(String equipment_image) {
        this.equipment_image = equipment_image;
    }

    public String getEquipment_barcode() {
        return equipment_barcode;
    }

    public void setEquipment_barcode(String equipment_barcode) {
        this.equipment_barcode = equipment_barcode;
    }

  
    
}
