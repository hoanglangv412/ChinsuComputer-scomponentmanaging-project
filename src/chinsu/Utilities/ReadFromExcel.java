/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chinsu.Utilities;

import chinsu.object.distributor.DistributorObject;
import chinsu.object.equipment.EquipmentObject;
import chinsu.object.type.TypeObject;
import chinsu.object.user.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.formula.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




/**
 *
 * @author Windows 10
 */
public class ReadFromExcel {
    public static Vector readUserFromExcel(String url) throws FileNotFoundException, IOException {
        FileInputStream file = new FileInputStream(url);
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheetAt(0);
        Vector<UserObject> list = new Vector();
        DataFormatter dt = new DataFormatter();
        Row fisrtRow = sheet.getRow(0);
        sheet.removeRow(fisrtRow);
        for(Row row:sheet){
            UserObject us = new UserObject();
            us.setUser_name(dt.formatCellValue(row.getCell(0)));
            us.setUser_pass(dt.formatCellValue(row.getCell(1)));
            us.setUser_permission(Integer.parseInt(dt.formatCellValue(row.getCell(2))));
            list.add(us);
        }
        wb.close();
        file.close();
        return list;
    }
    
    public static Vector readDistributorFromExcel(String url) throws FileNotFoundException, IOException {
       FileInputStream file = new FileInputStream(url);
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheetAt(0);
        Vector<DistributorObject> list = new Vector();
        DataFormatter dt = new DataFormatter();
        Row firstRow = sheet.getRow(0);
        sheet.removeRow(firstRow);
        for(Row row:sheet){
            DistributorObject di = new DistributorObject();
            di.setDistributor_name(dt.formatCellValue(row.getCell(0)));
            di.setDistributor_address(dt.formatCellValue(row.getCell(1)));
            di.setDistributor_phone(dt.formatCellValue(row.getCell(2)));
            di.setDistributor_imamount(Integer.parseInt(dt.formatCellValue(row.getCell(3))));
            list.add(di);
        }
        wb.close();
        file.close();
        return list;
   }
   public static Vector readTypeFromExcel(String url) throws FileNotFoundException, IOException {
       FileInputStream file = new FileInputStream(url);
       XSSFWorkbook wb = new XSSFWorkbook(file);
       XSSFSheet sheet = wb.getSheetAt(0);
       Vector<TypeObject> list = new Vector();
       DataFormatter dt = new DataFormatter();
       Row firstRow = sheet.getRow(0);
       sheet.removeRow(firstRow);
       for(Row row:sheet){
           TypeObject ty = new TypeObject();
           ty.setType_name(dt.formatCellValue(row.getCell(0)));
           ty.setType_distributor_id(Integer.parseInt(dt.formatCellValue(row.getCell(1))));
           list.add(ty);
       }
       wb.close();
       file.close();
       return list;
   }
   public static Vector readEquipmentFromExcel(String url) throws FileNotFoundException, IOException {
       FileInputStream file = new FileInputStream(url);
       XSSFWorkbook wb = new XSSFWorkbook(file);
       XSSFSheet sheet = wb.getSheetAt(0);
       Vector<EquipmentObject> list = new Vector();
       DataFormatter dt = new DataFormatter();
       Row firstRow = sheet.getRow(0);
       sheet.removeRow(firstRow);
       for(Row row:sheet){
           EquipmentObject eq = new EquipmentObject();
           eq.setEquipment_name(dt.formatCellValue(row.getCell(0)));
           eq.setEquipment_amount(Integer.parseInt(dt.formatCellValue(row.getCell(1))));
           eq.setEquipment_type_id(Integer.parseInt(dt.formatCellValue(row.getCell(2))));
           eq.setEquipment_imprice(Integer.parseInt(dt.formatCellValue(row.getCell(3))));
           eq.setEquipment_exprice(Integer.parseInt(dt.formatCellValue(row.getCell(4))));
           eq.setEquipment_imdate(dt.formatCellValue(row.getCell(5)));
           eq.setEquipment_image(dt.formatCellValue(row.getCell(6)));
           eq.setEquipment_barcode(dt.formatCellValue(row.getCell(7)));
           list.add(eq);
       }
       wb.close();
       file.close();
       return list;
   }
    
}
