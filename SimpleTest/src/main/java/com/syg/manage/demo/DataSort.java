package com.syg.manage.demo;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import com.syg.manage.model.entity.Student;

public class DataSort {

	public static void sortArray() {
		String[] a = {"4","1","3"};
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		//-------------------
		int[] b = {2,2,3,4};
		Arrays.sort(b);
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}
	
	public static void sortMapInteger() {
		System.out.println("-----------------");
        Map<Integer, String> map = new TreeMap<Integer, String>(
                new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						return o1.compareTo(o2);
					}
                });
        map.put(4, "ccccc");
        map.put(2, "aaaaa");
        map.put(1, "bbbbb");
        map.put(4, "ddddd");
        for (Integer key : map.keySet()) {
    		System.out.println(key +":"+ map.get(key));
    	}
	}
	
	public static void sortListInteger() {
		 List<Integer> a  = new ArrayList<Integer>();
		 a.add(4);a.add(1);a.add(3);
		 Collections.sort(a, new Comparator<Integer>() {
			 @Override
			 public int compare(Integer o1, Integer o2) {
				 return o1.compareTo(o2);
			 }
		 });
		 for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
		}
	 }
	
	public static void sortListObject() {
		List<Student> list = new ArrayList<Student>();  
        Student s1 = new Student(20,"成功");//c
        Student s2 = new Student(19,"逼格");//b
        Student s3 = new Student(21,"阿斯");//a
        list.add(s1);list.add(s2);list.add(s3);
        System.out.print("排序前：");
        for (Student st : list) {
			System.out.print(st.getAge()+""+st.getName()+"\t");
		}
        //根据首字母排序
        Collections.sort(list, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				String name1 = o1.getName();
				String name2 = o2.getName();
				return Collator.getInstance(Locale.CHINESE).compare(name1, name2); 
			}
        });
        System.out.print("\n排序后：");
        for (Student st : list) {
			System.out.print(st.getAge()+""+st.getName()+"\t");
		}
        //根据ID排序
        Collections.sort(list, new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				Integer a = o1.getAge();
				Integer b = o2.getAge();
				return a.compareTo(b);//升序
			}
        });
        System.out.print("\n排序后：");
        for (Student st : list) {
			System.out.print(st.getAge()+":"+st.getName()+"\t");
		}
	}
	
	public static void main(String[] args) {
		sortArray();
		sortMapInteger();
		sortListInteger();
		sortListObject();
	}
}
