package cn.edu.dgut.monitor.sigar;

import java.util.HashMap;
import java.util.Map;

import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

import net.sf.json.JSONObject;



public class CpuDao {


	public static  JSONObject cpuData()throws Exception {
		    Sigar sigar=null;        
			CpuPerc cpuList[] = null;
			 JSONObject json=null;
			Cpu cpu=new Cpu();
			Map<String, Object> map=new HashMap<String, Object>();
			try {  
			    sigar=new Sigar();
			    int cpuLength = sigar.getCpuInfoList().length;  
			    cpu.setCpulength(cpuLength);
			    cpuList = sigar.getCpuPercList();  
			    for ( int i = 0; i < cpuList.length; i++) {  
			    	// 总的使用率
			    	String newStr = CpuPerc.format(cpuList[i].getCombined()).replace("%","");
			    	map.put("CPU"+i, newStr );
			    }
			    json = JSONObject.fromObject(map);
			} catch (SigarException e) {  
			    e.printStackTrace();  
			}  
			return json; 
		}
	
	public static int cpulength() {
		
		    Sigar sigar=null;        
		    int cpuLength=0;
		    try {
		    	 sigar=new Sigar();
				 cpuLength = sigar.getCpuInfoList().length;
				
			} catch (SigarException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		
		return cpuLength;
	}
	
	}
	
	

