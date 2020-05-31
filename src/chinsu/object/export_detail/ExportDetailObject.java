/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chinsu.object.export_detail;

/**
 *
 * @author Windows 10
 */
public class ExportDetailObject {
    String export_detail_export_id;
    int export_detail_equipment_id;
    int export_detail_amount;
    float export_detail_total;

    public ExportDetailObject() {
    }

    public ExportDetailObject(String export_detail_export_id, int export_detail_equipment_id, int export_detail_amount, float export_detail_total) {
        this.export_detail_export_id = export_detail_export_id;
        this.export_detail_equipment_id = export_detail_equipment_id;
        this.export_detail_amount = export_detail_amount;
        this.export_detail_total = export_detail_total;
    }

    public String getExport_detail_export_id() {
        return export_detail_export_id;
    }

    public void setExport_detail_export_id(String export_detail_export_id) {
        this.export_detail_export_id = export_detail_export_id;
    }

    public int getExport_detail_equipment_id() {
        return export_detail_equipment_id;
    }

    public void setExport_detail_equipment_id(int export_detail_equipment_id) {
        this.export_detail_equipment_id = export_detail_equipment_id;
    }

    public int getExport_detail_amount() {
        return export_detail_amount;
    }

    public void setExport_detail_amount(int export_detail_amount) {
        this.export_detail_amount = export_detail_amount;
    }

    public float getExport_detail_total() {
        return export_detail_total;
    }

    public void setExport_detail_total(float export_detail_total) {
        this.export_detail_total = export_detail_total;
    }
}
