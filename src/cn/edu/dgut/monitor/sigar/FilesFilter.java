package cn.edu.dgut.monitor.sigar;

import java.io.File;
import java.io.FilenameFilter;

public class FilesFilter implements FilenameFilter{

	public FilesFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		
		//.sys
		//.ini
		//$开头
		//.开头
		
		if(dir.isHidden()) {
			return false;
		}else if(name.startsWith("$")||name.startsWith(".")) {
			return false;
		}else if(name.endsWith(".sys")||name.endsWith(".ini")) {
			return false;
		}
			
		
		return true;
	}
	

}
