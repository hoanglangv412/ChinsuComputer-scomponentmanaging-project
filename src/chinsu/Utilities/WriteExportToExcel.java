/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinsu.Utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Windows 10
 */
public class WriteExportToExcel {

    public static void write(String date, String userName, String customerName, String customerPhone, Float totalPrice, List<String> arr) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(customerPhone);

        Object[][] info = {
            {"HÓA ĐƠN"},
            {"CÔNG TY CỔ PHẦN MÁY TÍNH CHINSU"},
            {"Địa chỉ: 87 Trần Hưng Đạo, Hoàn Kiếm, Hà Nội"},
            {"Điện thoại: 069 219 64 22"},
            {"Ngày xuất: " + date + ""},
            {"Nhân viên bán hàng: " + userName + ""},
            {"Họ tên người mua hàng: " + customerName + ""},
            {"Số điện thoại khách: " + customerPhone + ""},
            {"STT", "MÃ HÀNG" ,"TÊN HÀNG", "ĐƠN GIÁ", "SỐ LƯỢNG", "THÀNH TIỀN"},};
        
        Object[][] equipments = new Object[arr.size()][6];
        for (int i = 0; i < arr.size(); i++) {
            String[] temp = arr.get(i).split("  -  ");
            for (int j = 0; j < 6; j++) {
                equipments[i][0] = i;
                equipments[i][1] = temp[0];
                equipments[i][2] = temp[1];
                equipments[i][3] = temp[2];
                equipments[i][4] = temp[3];
                equipments[i][5] = temp[4];
            }
        }
        
        int rowCount = 0;
        
        for (Object[] item : info) {
            Row row = sheet.createRow(rowCount++);

            int columnCount = 0;

            for (Object field : item) {
                Cell cell = row.createCell(columnCount++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }

        }
        
        for (Object[] item : equipments) {
            Row row = sheet.createRow(rowCount++);

            int columnCount = 0;

            for (Object field : item) {
                Cell cell = row.createCell(columnCount++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }

        }
        Row row = sheet.createRow(rowCount);
        Cell cell = row.createCell(0);

        cell.setCellValue("TỔNG TIỀN");
        cell = row.createCell(5);
        cell.setCellValue(totalPrice);
        
        
        
        try (FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Windows 10\\Desktop\\Export.xlsx")) {
            workbook.write(outputStream);
            JOptionPane.showMessageDialog(null, "XUẤT THÀNH CÔNG!!!");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }

    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Java Books");

        Object[][] bookData = {
            {"Head First Java", "Kathy Serria", 79},
            {"Effective Java", "Joshua Bloch", 36},
            {"Clean Code", "Robert martin", 42},
            {"Thinking in Java", "Bruce Eckel", 35},};

        int rowCount = 0;

        for (Object[] aBook : bookData) {
            Row row = sheet.createRow(rowCount++);

            int columnCount = 0;

            for (Object field : aBook) {
                Cell cell = row.createCell(columnCount++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }

        }

        try (FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Windows 10\\Desktop\\JavaBooks.xlsx")) {
            workbook.write(outputStream);
        }
    }
}
