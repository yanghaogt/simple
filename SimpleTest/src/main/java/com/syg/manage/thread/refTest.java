package com.syg.manage.thread;

public class refTest {

	String str = new String("good");
	char[] ch = {'a','b','c'};
	
	public static void main(String[] args) {
		refTest ex = new refTest();
		ex.change(ex.str, ex.ch);
		System.out.print(ex.str + " and ");
		System.out.print(ex.ch);
	}
	
	public void change(String str,char ch[]){
		str = "test.ok";
		ch[0] = 'g';
	}
}
