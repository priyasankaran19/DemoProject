package com.file.demo;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;

public class Postapi {

	public static void main(String[] args) {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		Googleapipost api= new Googleapipost();
		List<String> types=new ArrayList<String>();
		types.add("Shoe park");
		types.add("Shoe");
		api.setTypes(types);
		api.setAccuracy("50");
		api.setName("House");
		api.setPhone_number("(+91) 983 893 3937");
		api.setAddress("207 145 street");
		api.getTypes().set(0, "shoe park");
		api.getTypes().set(0, "shop");
		api.setWebsite("http://google.com");
		api.setLanguage("English");
		Location l =new Location();
		l.setLattitude(-38.383494);
		l.setLogntitude(33.427362);
		api.setLocation(l);
		 String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body(api).
	    		 when().log().all().post("/maps/api/place/add/json").
	    		 then().log().all().assertThat().statusCode(200).
	     header("server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();
	     System.out.println(response);

	}

}
