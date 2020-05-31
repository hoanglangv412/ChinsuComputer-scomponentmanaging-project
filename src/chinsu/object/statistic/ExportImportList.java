/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chinsu.object.statistic;

/**
 *
 * @author Windows 10
 */
public class ExportImportList {
    private String exDate;
    private float exTotal;

    public ExportImportList() {
    }

    public ExportImportList(String exDate, float exTotal) {
        this.exDate = exDate;
        this.exTotal = exTotal;
    }

    public String getExDate() {
        return exDate;
    }

    public void setExDate(String exDate) {
        this.exDate = exDate;
    }

    public float getExTotal() {
        return exTotal;
    }

    public void setExTotal(float exTotal) {
        this.exTotal = exTotal;
    }
    
    
}
