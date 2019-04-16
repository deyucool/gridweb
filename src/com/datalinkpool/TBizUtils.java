package com.datalinkpool;

import java.sql.*;

public class TBizUtils{
	
    @SuppressWarnings("static-access")
	public IDalResultSet QueryPreparedSql(IDalConnection aLink, String aSql, String data){
        ResultSet rs = null;
        IDalResultSet res = new IDalResultSet();
        StringBuffer Sql = new StringBuffer();
        Sql.append(aSql);
        try {
            Connection conn = aLink.getConnection();
            PreparedStatement pstmt=conn.prepareStatement(Sql.toString(),ResultSet.CONCUR_READ_ONLY);
            pstmt.setString(1, data);
            if(conn != null){
                rs = pstmt.executeQuery();
            }
            aLink.CloseConnection(conn, null, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        res.setResultSet(rs);
        return res;
    }

    @SuppressWarnings("static-access")
	public IDalResultSet QueryPreparedSql(IDalConnection aLink, String aSql, String[] data){
        ResultSet rs = null;
        IDalResultSet res = new IDalResultSet();
        StringBuffer Sql = new StringBuffer();
        Sql.append(aSql);
        Sql.toString();
        try {
            Connection conn = aLink.getConnection();
            Statement statement = conn.createStatement();
            PreparedStatement pstmt=conn.prepareStatement(Sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            pstmt.setString(1, "1");
            if(conn != null){
                rs = pstmt.executeQuery();
            }
            aLink.CloseConnection(conn, null, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        res.setResultSet(rs);
        return res;
    }
    
    @SuppressWarnings("static-access")
	public Boolean UpdatePreparedSql(IDalConnection aLink, String aSql, String[] data){
        try {
            Connection conn = aLink.getConnection();
            Statement statement = conn.createStatement();
            PreparedStatement pstmt=conn.prepareStatement(aSql,ResultSet.CONCUR_UPDATABLE);
            for(int i=0;i<data.length;i++){
                pstmt.setString(i+1, data[i]);
            }
            if(conn != null){
                pstmt.executeUpdate();
            }
            aLink.CloseConnection(conn, null, null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;

    }
    
    @SuppressWarnings("static-access")
   	public IDalResultSet QueryPreparedSql(IDalConnection aLink, String aSql){
           ResultSet rs = null;
           IDalResultSet res = new IDalResultSet();
           StringBuffer Sql = new StringBuffer();
           Sql.append(aSql);
           try {
               Connection conn = aLink.getConnection();
               PreparedStatement pstmt=conn.prepareStatement(Sql.toString(),ResultSet.CONCUR_READ_ONLY);
               if(conn != null){
                   rs = pstmt.executeQuery();
               }
               aLink.CloseConnection(conn, null, null);
           } catch (SQLException e) {
               e.printStackTrace();
           }
           res.setResultSet(rs);
           return res;
       }
}
