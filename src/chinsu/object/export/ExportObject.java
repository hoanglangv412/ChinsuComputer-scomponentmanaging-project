/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinsu.object.export;

/**
 *
 * @author kieun
 */
public class ExportObject {

    
    private String export_id;
    private int export_user_id;
    private float export_total;
    private String export_date;
    private String export_customer_name;
    private String export_customer_phone;

    public ExportObject() {
    }

    public ExportObject(String export_id, int export_user_id, String export_date, String export_customer_name, String export_customer_phone) {
        this.export_id = export_id;
        this.export_user_id = export_user_id;
        this.export_date = export_date;
        this.export_customer_name = export_customer_name;
        this.export_customer_phone = export_customer_phone;
    }

    public String getExport_id() {
        return export_id;
    }

    public void setExport_id(String export_id) {
        this.export_id = export_id;
    }

    public int getExport_user_id() {
        return export_user_id;
    }

    public void setExport_user_id(int export_user_id) {
        this.export_user_id = export_user_id;
    }

    public String getExport_date() {
        return export_date;
    }

    public void setExport_date(String export_date) {
        this.export_date = export_date;
    }

    public String getExport_customer_name() {
        return export_customer_name;
    }

    public void setExport_customer_name(String export_customer_name) {
        this.export_customer_name = export_customer_name;
    }

    public String getExport_customer_phone() {
        return export_customer_phone;
    }

    public void setExport_customer_phone(String export_customer_phone) {
        this.export_customer_phone = export_customer_phone;
    }

    public float getExport_total() {
        return export_total;
    }

    public void setExport_total(float export_total) {
        this.export_total = export_total;
    }
    
    
}
