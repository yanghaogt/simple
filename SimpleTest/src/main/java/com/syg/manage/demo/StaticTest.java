package com.syg.manage.demo;

public class StaticTest {

	public static void main(String[] args) {
		
//		StaticMethod.addPkgHandle(1,"你好");
		
		try {
			PackHandle packHandle = new PackHandle(1, "apk", 1);
			PackPool.addPkgHandle(packHandle);
			Thread.sleep(5000);
			PackOrgHandle orgHandle = new PackOrgHandle(2, "org", 2);
			PackPool.addOrgHandle(orgHandle);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
