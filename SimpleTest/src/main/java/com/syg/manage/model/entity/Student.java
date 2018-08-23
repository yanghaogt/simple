package com.syg.manage.model.entity;

public class Student {

	private Integer age;
	private String name;
	public Student(Integer age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public Student() {
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
		return "Student [age=" + age + ", name=" + name + "]";
	}
	
}
