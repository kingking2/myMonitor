package cn.edu.dgut.monitor.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.dgut.monitor.sigar.CpuDao;
import cn.edu.dgut.monitor.sigar.HardwareDao;
import net.sf.json.JSONObject;

public class HardwareServlet extends  HttpServlet{
	

	  private static final long serialVersionUID=1L;
	  
	  
	  protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		  
		  doPost(request,response);
				
		  }
	  

	  protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		  
		    response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");

     		PrintWriter out=response.getWriter();
			JSONObject HardwareData;
			HardwareDao hard=new HardwareDao();
			try {
				
				out.write(hard.hardwareData().toString());
				out.close();
			}catch(Exception e) {
				throw new RuntimeException(e);
			}


		
}
	  

}
