package com.syg.manage.util;

import com.syg.manage.util.IPSeekerBase;

public class IPSeeker extends IPSeekerBase {

	@Override
	protected String getClassPathFileName() {
		return "QQWry.Dat";
	}
	
	
	private static IPSeeker instance;
	public static IPSeeker getInstance(){
		if (instance==null) {
			instance = new IPSeeker();
		}
		return instance;
	}
}
