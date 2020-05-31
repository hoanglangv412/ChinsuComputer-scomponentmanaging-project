/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chinsu.object.type;

import java.sql.ResultSet;

/**
 *
 * @author Windows 10
 */
public interface Type {
    public boolean addType (TypeObject item);
	public boolean editType (TypeObject item);
	public boolean delType (TypeObject item);
	
	//Các chức năng lấy dữ liệu
	public ResultSet getType (int id);
        public ResultSet getTypes (String conds);
}
