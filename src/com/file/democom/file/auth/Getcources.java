package com.file.democom.file.auth;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;


import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;
public class Getcources {
	
@Test
	public void value() 
	{
	
	// RestAssured.baseURI="https://rahulshettyacademy.com/";	
	String token=Gettoken.gettoken();
	System.out.println(token);
	Response rs=given().queryParam("access_token",token).expect().defaultParser(Parser.JSON).
	 when().get("https://rahulshettyacademy.com/getCourse.php").as(Response.class);
	// JsonPath js=Reusablemethods.rawtojason(response);
	 System.out.println(rs.getInstructor());
	 rs.getCourses().getApi().get(1).getCourseTitle();
	 List<WebAutomation> wb=rs.getCourses().getWebAutomation();
	 for(int i=0;i<=wb.size();i++)
	 {
		 if(wb.get(i).getCourseTitle().equalsIgnoreCase("Cypress"))
		 {
		 System.out.println(((WebAutomation) wb).getPrice());
		 }
		 else
		 {
			 continue;
		 }
	 }
	 //System.out.println(js.getString("instructor"));
	// Assert.assertEquals("Rest Assured Automation using Java", js.getString("courses.api.courseTitle[0]"));
	}

}
