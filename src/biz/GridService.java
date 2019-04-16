package biz;

import java.sql.SQLException;

import com.datalinkpool.IDalResultSet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GridService {
	
   public JSONObject getGridJson(IDalResultSet rs) throws SQLException {
	   JSONObject json = new JSONObject();
		JSONObject json1 = new JSONObject();
		JSONArray arr = new JSONArray();
		String[] colnames = rs.getColumnNames();
		String[] val = new String[colnames.length];
			
		while(rs.next()){			
			json1.put("id",rs.getStringValue("id"));			
			for(int j=0;j<colnames.length;j++) {
				val[j] = rs.getStringValue(colnames[j]);
			}			
			json1.put("cell",val);
			arr.add(json1);
		}
		json.put("rows",arr);
		
		return json;
   }
}
