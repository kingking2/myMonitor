package cn.edu.dgut.monitor.sigar;
import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.hyperic.*;
import org.hyperic.sigar.*;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Cpu {

	 private double cpuUse;
	 private int  cpulength;
	 
	
	
    public double getCpuUse() {
		return cpuUse;
	}


	public void setCpuUse(double cpuUse) {
		this.cpuUse = cpuUse;
	}


	public int getCpulength() {
		return cpulength;
	}


	public void setCpulength(int cpulength) {
		this.cpulength = cpulength;
	}


}
