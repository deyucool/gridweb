package web;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.datalinkpool.IDalConnection;

import biz.*;
@WebServlet("/comAction")
public class BaseAction extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		
		String methodName = request.getParameter("method");
		String serviceName = request.getParameter("service");
		IBizMessage bizMsg = new IBizMessage();
		bizMsg.setRequest(request);
		IBizMessage rMsgOutput = new IBizMessage();
		IBizMessage rMsgInput = new IBizMessage();
		IDalConnection zLink = new IDalConnection();
				
		try {
				Class<?> clazz = Class.forName("biz."+serviceName);
				Method method = clazz.getMethod(methodName,IBizMessage.class,IBizMessage.class,IDalConnection.class);
				method.invoke(clazz.newInstance(),rMsgInput,rMsgOutput,zLink);
				PrintWriter out = response.getWriter();
				out.write(bizMsg.getMsgOutput());
				
		}catch(NoSuchMethodException e) {
				e.printStackTrace();
		}catch(SecurityException e){
				e.printStackTrace();
		} catch (IllegalAccessException e) {
				e.printStackTrace();
		} catch (IllegalArgumentException e) {
				e.printStackTrace();
		} catch (InvocationTargetException e) {
				e.printStackTrace();
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
		} catch (InstantiationException e) {
				e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		doGet(request, response);
	}
	
}
