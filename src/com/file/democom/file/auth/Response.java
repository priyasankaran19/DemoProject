package com.file.democom.file.auth;
public class Response
{
	private String instructor;
	private String url;
	private String services;
	private String expertise;
	private Courses Courses;
	private String linkedIn;
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public com.file.democom.file.auth.Courses getCourses() {
		return Courses;
	}
	public void setCourses(com.file.democom.file.auth.Courses courses) {
		Courses = courses;
	}
}
