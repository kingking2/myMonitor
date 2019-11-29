package cn.edu.dgut.monitor.servlet;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ScreenServlet
 */
@WebServlet("/ScreenServlet")
public class ScreenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScreenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/text;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
	/*	
		D:\TomCat\apache-tomcat-9.0.11\webapps\myMonitor\WEB-INF\classes\cn\edu\dgut\monitor\servlet
		D:\TomCat\apache-tomcat-9.0.11\webapps\myMonitor\screen*/
		String path =request.getServletContext().getRealPath("/screen");
		
		
		System.out.println(path);
		try {
			Robot robot=new Robot();
			Toolkit tool = Toolkit.getDefaultToolkit();    //获取屏幕大小
			Dimension size = tool.getScreenSize();
			Rectangle rect=new Rectangle(0,0,size.width,size.height);
			BufferedImage img = robot.createScreenCapture(rect);
			String uuid = UUID.randomUUID().toString();
			File f=new File(path,uuid+".png");
			ImageIO.write(img, "png", f);
			
			String a=uuid+".png";
			out.write("./screen/"+a);
			out.close();
			
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
