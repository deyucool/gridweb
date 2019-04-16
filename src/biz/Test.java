package biz;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import net.sf.json.JSONObject;

public class Test {

	public static void main(String[] args) {
		Map<String,String> zMap =  new HashMap<String, String>();
		JSONObject o = new JSONObject();
		zMap.put("1", "2");
		zMap.put("3", "4");
		JSONObject.fromObject(zMap);
		o.put("1", "2");
		System.out.println(zMap.toString()+o.toString());
	}

}
