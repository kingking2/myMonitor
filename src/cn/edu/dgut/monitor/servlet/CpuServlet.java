package cn.edu.dgut.monitor.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.dgut.monitor.sigar.Cpu;
import cn.edu.dgut.monitor.sigar.CpuDao;
import net.sf.json.JSONObject;
public class CpuServlet extends HttpServlet {
	private CpuDao dao=null;
	

	  private static final long serialVersionUID=1L;
	  
	  
	  protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		  
		  doPost(request,response);
				
		  }
	  

	  protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
		  
		    response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");
 
			PrintWriter out=response.getWriter();
			JSONObject cpuData;
			try {
				dao=new CpuDao();
				cpuData = dao.cpuData();
				out.write(cpuData.toString());
				out.close();
			}catch(Exception e) {
				throw new RuntimeException(e);
			}


		
}
	  
}