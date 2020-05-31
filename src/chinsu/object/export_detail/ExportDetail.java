/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chinsu.object.export_detail;

import java.sql.ResultSet;

/**
 *
 * @author Windows 10
 */
public interface ExportDetail {
	public boolean addExportDetail (ExportDetailObject item);
	
	//Các chức năng lấy dữ liệu
	public ResultSet getExportDetail (int id);
        public ResultSet getExportDetails (String conds);
}
