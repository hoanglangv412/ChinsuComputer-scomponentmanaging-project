/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinsu.id3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Windows 10
 */
public class ReadTxt {
    
    public static List<String> data(String url) {
        try {
            List<String> arr = new ArrayList();
            File f = new File(url);
            FileReader fr = new FileReader(f);
            //Bước 2: Đọc dữ liệu
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                arr.add(line);
            }

            fr.close();
            br.close();
            return arr;
        } catch (Exception ex) {
            System.out.println("Loi doc file: " + ex);
            return null;
        }
    }
}
