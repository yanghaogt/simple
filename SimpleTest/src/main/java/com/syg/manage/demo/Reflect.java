package com.syg.manage.demo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.syg.manage.model.entity.Heros;
import com.syg.manage.model.entity.Student;
import com.syg.manage.model.entity.Student2;

/**
 * 反射
 * @author yanghao
 */
public class Reflect{
	
	public static void invokeMethod(){
        try {
        	Class<?> herosClass = Heros.class;
            Method[] methods = herosClass.getMethods();
            //遍历方法
            for (Method method : methods) {
                System.out.print(method.getName()+",");
            }
            Method m1 = herosClass.getMethod("setName",String.class);
            Method m2 = herosClass.getMethod("getName");
            Object userInfo = herosClass.newInstance();
            m1.invoke(userInfo,"影魔");
            System.out.println("\n调用set方法："+userInfo);
            System.out.println("调用get方法："+m2.invoke(userInfo));
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public static void transferMethod(Object obj,String method){
		try {
			Method me = obj.getClass().getDeclaredMethod(method);
			String name = (String) me.invoke(obj);
			System.out.println(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
    public static void setField(Object obj,String field,Object obj2,String field2){
    	if (obj != null) {
			try {
				Field f = obj.getClass().getDeclaredField(field);
				f.setAccessible(true);
				Field f2 = obj2.getClass().getDeclaredField(field2);
				f2.setAccessible(true);
				f.set(obj, f2.get(obj2));
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
    }
    
    public static void setValue(Student obj,Object obj2,String method1,String method2){
    	if (obj != null) {
			try {
				Method age = obj2.getClass().getDeclaredMethod(method1);
				Method name = obj2.getClass().getDeclaredMethod(method2);
				obj.setAge((Integer)age.invoke(obj2));
				obj.setName((String)name.invoke(obj2));
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
    }
    
    // 对象的属性一定要是公共的，否则无法操作该属性的值 
    public static void changeStringValue(Object obj){  
        Field[] fields = obj.getClass().getDeclaredFields();
        //遍历属性 
        for(Field field : fields){
        	//用来解决属性 private
        	field.setAccessible(true);
            //字节码只有一份，所以用==比较
            if(field.getType() == String.class){  
                try {//取当前属性的值
					String odlStr = (String)field.get(obj);
					String newValue = odlStr.replace('b', 'a');
					field.set(obj, newValue);
				} catch (Exception e) {
					e.printStackTrace();
				}  
            }  
        }  
    }
    
    public static void main(String[] args) {
	    //1.获得一个类中的方法
    	invokeMethod();
        //2.调用类中的方法
        Student ss = new Student(1,"暗夜");
        transferMethod(ss, "getName");
        //3.通过属性获取值
        Student s1 = new Student();
        Student2 s2 = new Student2(1, "s1");
        setField(s1,"name",s2,"name");
        setField(s1,"age",s2,"age");
        System.out.println(s1);
        //4.通过方法获取值
        Student st1 = new Student();
        Student2 st2 = new Student2(2, "s2");
        setValue(st1, st2, "getAge", "getName");
        System.out.println(st1);
        //5.替换一个对象中所有属性值
        Student s3 = new Student(3,"bbb");
        changeStringValue(s3);
        System.out.println(s3);
	}
	
}