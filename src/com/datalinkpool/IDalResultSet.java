package com.datalinkpool;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class IDalResultSet {
	 ResultSet rs;
	public void setResultSet(ResultSet resultset) {
		this.rs = resultset;
	}
	
	public String[] getColumnNames(){
		String[] cols = null;
		try {
			ResultSetMetaData data = rs.getMetaData();
			String[] colnames = new String[data.getColumnCount()];
			for (int i=1; i <= data.getColumnCount();i++){
				 colnames[i-1] = data.getColumnName(i);
			}
			cols = colnames;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cols;
	}
	
	public String[] getColumnTypeName(){
		String[] cols = null;
		try {
			ResultSetMetaData data = rs.getMetaData();
			String[] colnames = new String[data.getColumnCount()];
			for (int i=1; i <= data.getColumnCount();i++){
				 colnames[i-1] = data.getColumnTypeName(i);
			}
			cols = colnames;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cols;
	}
	
	public String getStringValue(String k) {
		String v = null;
		try {
			v = rs.getString(k);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
		
	}
	
	public double getBoubleValue(String k) {
		double v = 0.0;
		try {
			v = rs.getDouble(k);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}
	
	public double getIntValue(String k) {
		double v = 0.0;
		try {
			v = rs.getInt(k);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return v;
	}

	public boolean next() throws SQLException {
		boolean f = false;
		if(rs.next()) {
			f = true;
		}
		return f;
	}
	
	public int getColumnCount(){
		int c = 0;
		try {
			ResultSetMetaData data = rs.getMetaData();
				c = data.getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
}
