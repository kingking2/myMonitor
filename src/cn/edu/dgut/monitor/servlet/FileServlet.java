package cn.edu.dgut.monitor.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.dgut.monitor.sigar.CpuDao;
import cn.edu.dgut.monitor.sigar.FileDao;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class FileServlet extends HttpServlet {


	  private static final long serialVersionUID=1L;
	  
	  
	  protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		  
		  doPost(request,response);
				
		  }
	  

	  protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		  
		    response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");
			String id=request.getParameter("id");//获取参数
   		PrintWriter out=response.getWriter();
   		JSONArray json=new JSONArray(); 
   		  FileDao filedao =null;
   		  
   		try {
   			filedao=new FileDao();
   			if(id==null) {
   				json = filedao.FileRoot();
   			}else {
   				json=filedao.FindFile(id);
   			}
   			
	        System.out.println(json.toString());   
			out.write(json.toString());
			
			out.close();
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
				
}



}
