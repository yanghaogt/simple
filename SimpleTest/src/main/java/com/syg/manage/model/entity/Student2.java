package com.syg.manage.model.entity;

public class Student2 {

	private Integer age;
	private String name;
	public Student2(Integer age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public Student2() {
		super();
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student2 [age=" + age + ", name=" + name + "]";
	}
	
}
