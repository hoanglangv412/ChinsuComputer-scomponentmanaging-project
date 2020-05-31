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
public class EquipmentImportList {

    private String importDay;
    private int amount;

    public EquipmentImportList() {
    }

    public EquipmentImportList(String importDay, int amount) {
        this.importDay = importDay;
        this.amount = amount;
    }

    public String getImportDay() {
        return importDay;
    }

    public void setImportDay(String importDay) {
        this.importDay = importDay;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
