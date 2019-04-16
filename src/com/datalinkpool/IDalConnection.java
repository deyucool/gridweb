package com.datalinkpool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IDalConnection {
    private static ConnectionsPool connPool = new ConnectionsPool();

    public static Connection getConnection() throws SQLException {
        return connPool.getConnection();
    }

    public static void CloseConnection(Connection conn, Statement st, ResultSet rs) throws SQLException{

        if(rs != null){
            rs.close();
        }
        if(st != null){
            st.close();
        }
        if(conn != null){
            conn.close();
        }
    }

}
