package com.syg.manage.demo;

public class StringTest {

	public static void main(String[] args) {
		String a = "hello";
		String b = "he"+new String("llo");
		System.out.println(a == b);
		System.out.println(a.equals(b));
	}
}
