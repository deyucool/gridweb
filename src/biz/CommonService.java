package biz;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Iterator;

import com.datalinkpool.IDalConnection;
import com.datalinkpool.IDalResultSet;
import com.datalinkpool.TBizUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import web.IBizMessage;

public class CommonService{
	TBizUtils util = new TBizUtils();
	
	public boolean doMet(IBizMessage pMsgInput,IBizMessage pMsgOutput,IDalConnection zLink){
		String v = pMsgInput.AsString("F_BY01");

		String p = null;
		
		IDalResultSet zRs = util.QueryPreparedSql(zLink,"select * from p_user where username = ? ","U00001");
		
		 try {
			while(zRs.next()){
			      p =  zRs.getStringValue("pwd");
			    }
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
		pMsgOutput.setString("RET_CODE", "0");
		pMsgOutput.setString("F_BY01", p);
		
		return true;
	}
	
	@SuppressWarnings("static-access")
	public boolean doGridMsg(IBizMessage pMsgInput,IBizMessage pMsgOutput,IDalConnection zLink) throws SQLException{
		String v = pMsgInput.AsString("F_BY01");
		JSONObject json1 = new JSONObject();
		GridService grid = new GridService();
		
		IDalResultSet rs = util.QueryPreparedSql(zLink," select * from user_data ");
		json1 = grid.getGridJson(rs);		
						
		pMsgOutput.setString(json1.toString());
		
		return true;
	}
	
	public boolean gridSaveService(IBizMessage pMsgInput,IBizMessage pMsgOutput,IDalConnection zLink) throws SQLException{
		
		String v = pMsgInput.AsString("F_BY01");
								
		pMsgOutput.setString(v);
		
		return true;
	}

}
