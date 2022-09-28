package com.file.demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class GoogleAPI  {

		//public static void main(String[] args) 
		@Test
		public void send()
		{			
			//given , when , then
	     RestAssured.baseURI="https://rahulshettyacademy.com";	    
	     Postapi p=new Postapi();
	     String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body(p).
	    		 when().log().all().post("/maps/api/place/add/json").
	    		 then().log().all().assertThat().statusCode(200).
	     header("server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
	     System.out.println(response);
	
			}

}
