package com.Student.Fields;

public class StudentFields {
	private int age,salary;
	private String name,city;
	public StudentFields(String name, int age, String city, int salary) {
		super();
		this.age = age;
		this.salary = salary;
		this.name = name;
		this.city = city;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

}
