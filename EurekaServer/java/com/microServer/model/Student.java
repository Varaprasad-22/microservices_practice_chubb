package com.microServer.model;

public class Student {
    private int id;
    private String name;
    private String course;
	public Student(int id2, String a, String b) {
		// TODO Auto-generated constructor stub
		this.course=b;
		this.id=id2;
		this.name=a;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}

}
