package cn.edu.dgut.monitor.sigar;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Sigar;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class FileDao {
	


	public static JSONArray  FileRoot() throws Exception{
		Sigar sigar = new Sigar();
		 
	

        FileSystem [] fileSystemArray = sigar.getFileSystemList();
        JSONArray jsonList =null;
        List<File1> list = new ArrayList<File1>();
        JSON json =null;
        for ( FileSystem fileSystem:fileSystemArray ) {
        	File1 file=new File1();
        	
        	file.setId(fileSystem.getDirName());
        	file.setText(fileSystem.getDevName());
            File f = new File(fileSystem.getDirName());	
            if(f.isDirectory()) {
            	file.setState("closed");
            }else {
            	file.setState("open");
            }
                 
            list.add(file);
       
        }
        jsonList   = JSONArray.fromObject(list);

        return jsonList;

	}
	
	
	
	public static JSONArray FindFile(String id) throws Exception {
	
		 
	
		
		File file = new File(id);		//��ȡ��file����	
		File[] fs = file.listFiles();	//����path�µ��ļ���Ŀ¼������File������	
		
	       JSONArray jsonList =null;
	        List<File1> list = new ArrayList<File1>();
		
	        
		for(File f:fs){					//����File[]����		
			
			File1 file1=new File1();
        	file1.setId(f.getAbsolutePath());
        	file1.setText(f.getName());
        	
         
			
        	
			if(f.isDirectory())	{	  //����Ŀ¼(���ļ�)�����ӡ			
				
			file1.setState("closed");
			}else {
				file1.setState("open");
				
			}
	
		    list.add(file1);
		    
		}
		 jsonList   = JSONArray.fromObject(list);


    return jsonList;
	}
	
	
	

}












	
	
