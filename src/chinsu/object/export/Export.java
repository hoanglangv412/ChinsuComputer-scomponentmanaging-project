/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chinsu.object.export;

import java.sql.ResultSet;

/**
 *
 * @author Windows 10
 */
public interface Export {

    public boolean addExport(ExportObject item);

    //Các chức năng lấy dữ liệu
    public ResultSet getExport(int id);

    public ResultSet getExports(String conds);
}
