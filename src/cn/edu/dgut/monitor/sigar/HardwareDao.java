package cn.edu.dgut.monitor.sigar;

import java.util.HashMap;
import java.util.Map;

import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Sigar;

import net.sf.json.JSONObject;

public class HardwareDao {
	
	
	
	 public static JSONObject hardwareData() throws Exception{
		 
		 
		     Sigar sigar = new Sigar();  
	        FileSystem fslist[] = sigar.getFileSystemList();  
	           JSONObject json=null;
	        Map<String, Object> map=new HashMap<String, Object>();
	        for (int i = 0; i < fslist.length; i++) {  
	            FileSystem fs = fslist[i];  
	            // �������̷�����  
	         //   System.out.println("�̷�����:    " + fs.getDevName()); 
	            
	         
	            // �������̷�����  
	            FileSystemUsage usage = null;  
	            usage = sigar.getFileSystemUsage(fs.getDirName());  
	            
	            double usePercent = usage.getUsePercent() * 100D;  
	     //       System.out.println(fs.getDevName() + "��Դ��������:    " + usePercent + "%");
	            
	            map.put(fs.getDevName(),usePercent);
	            json = JSONObject.fromObject(map);
	        }  

		 
	        return  json;
	 } 

}
