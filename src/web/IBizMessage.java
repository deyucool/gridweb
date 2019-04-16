package web;

import javax.servlet.http.HttpServletRequest;
import net.sf.json.JSONObject;

public class IBizMessage {
	static HttpServletRequest request;
	static String MsgOutput;
	JSONObject json = new JSONObject();


	public String AsString(String key) {
		return request.getParameter(key);
	}
	
	
	public void setRequest(HttpServletRequest request) {
		IBizMessage.request = request;
	}
	
	public void setString(String k,String v) {
		json.put(k, v);
		IBizMessage.MsgOutput = json.toString();
	}
	
	public void setString(String v) {
		IBizMessage.MsgOutput = v;
	}
	
	public String getMsgOutput() {
		return MsgOutput;
	}
}
