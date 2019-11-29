package cn.edu.dgut.monitor.sigar;

import net.sf.json.JSONObject;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     HardwareDao hard=new HardwareDao();
	      try {
	    	  JSONObject json;
			  json=hard.hardwareData();
			  System.out.println(json.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
