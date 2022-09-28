package com.file.demo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Basics {
	//public static void main(String[] args) 
	@Test
	public void send()
	{		
		//given , when , then
     RestAssured.baseURI="https://rahulshettyacademy.com";
     //postplace
     String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body(Payload.Addplace()).
    		 when().log().all().post("/maps/api/place/add/json").then().assertThat().statusCode(200).
     header("server", "Apache/2.4.41 (Ubuntu)").body("scope",equalTo("APP")).body("status", equalTo("OK")).extract().response().asString();
	System.out.println("Response is = "+response);
	JsonPath js=new JsonPath(response);
	String place_id=js.getString("place_id");
	System.out.println("Placeid is = "+place_id);	
	//updateplace
	System.out.println("updateplace");
	String value=given().log().all().queryParam("key", "qclick123").queryParam("place_id",place_id).
			header("Content-Type","application/json").body("{\n"
			+ "\"place_id\":\""+place_id+"\",\n"
			+ "\"address\":\"1934 winter walk, USA\",\n"
			+ "\"key\":\"qaclick123\"\n"
			+ "}").when().put("/maps/api/place/update/json").then().assertThat().body("msg",equalTo("Address successfully updated")).extract().response().asString();
	System.out.println(value);
	System.out.println("getplace");
	String response1=given().log().all().
			   queryParam("key", "qaclick123").queryParam("place_id",place_id).
			   when().
			   get("maps/api/place/get/json").then().assertThat().statusCode(200).
			   extract().response().asString(); //body("address",equalTo("1734 winter walk, USA"))
	JsonPath js1=Reusablemethods.rawtojason(response1);
	String address=js1.getString("address");
	System.out.println("Actual address = "+address);
	//  System.out.println("Response is = "+response1);
	Assert.assertEquals(address, "1934 winter walk, USA");	
	}
}
