package com.datalinkpool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Iterator;

import biz.GridService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Test {

    public static void main(String[] args) throws Exception {

    	/*IDalConnection conn = new IDalConnection();
    	TBizUtils re = new TBizUtils();
    	IDalResultSet rs = re.QueryPreparedSql(conn,"select * from p_user where username = ? ","U00001");

		while(rs.next()){
				System.out.println(rs.getStringValue("pwd"));

		}*/
    	
    	JSONArray arr = JSONArray.fromObject("[{\"password\":\"Zara\",\"id\":\"1\",\"username\":\"Ali\"},{\"password\":\"Zara1\",\"id\":\"2\",\"username\":\"Ali\"}]");
		GridService grid = new GridService();
		StringBuffer col =new StringBuffer();
		StringBuffer value =new StringBuffer();
		JSONObject coln = arr.getJSONObject(0);
		  System.out.println(arr.toString()) ;
		Iterator<String> sIterator = coln.keySet().iterator();
		  while (sIterator.hasNext()) {
			  String key = sIterator.next();
			  col.append(key);
			  col.append(",");
			  
		  }
		  System.out.println(col.toString()) ;
		String[] colArr = col.toString().split(",");
		if(arr.size()>0){
			  for(int i=0;i<arr.size();i++){
				  JSONObject job = arr.getJSONObject(i);
				  for(int j=0;j<colArr.length;j++){
					  value.append(job.getString(colArr[j]));
					  value.append(",");
				  }
			  }
		}
		System.out.println(value);
		value.toString().split(",");
    
    }
}
