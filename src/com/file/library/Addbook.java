package com.file.library;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.file.demo.Payload;
import com.file.demo.Reusablemethods;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class Addbook 	{
		
		@Test
		//(dataProvider="bookprovider")
		public void addbook() throws IOException
		{
	    String Path="//Users/m_priyadharsini/documents/file.json";
		RestAssured.baseURI="http://216.10.245.166";		
		String  response=given().log().all().
					headers("Content-Type","application/json").
					body(new String(Files.readAllBytes(Paths.get(Path)))).when().post("Library/Addbook.php").
					then().log().all().assertThat().statusCode(200).extract().
					response().asString();
		//Payload.Addbook(name,isbn,aisle,author)
		JsonPath js1=Reusablemethods.rawtojason(response);
		String output=js1.getString("Msg");
		System.out.println("value "+output);		
		}
		@DataProvider(name="bookprovider")
		public Object[][] getData()
		{
		String prefix="RS";
		String isbn="";
	
		  int max = 10000;
	        int min = 1;
	        int range = max - min + 1;
	 
	        // generate random numbers within 1 to 10
	        for (int i = 0; i < 10; i++) {
	            int random = (int)(Math.random() * range) + min;
	 
	            // Output is different everytime this code is executed
	           
	            isbn=prefix+random;
	        }
		
		 return new Object[][]{{"Priya",isbn,"23334","Sankar"},{"Priya",isbn+1,"2334","ADhvaith"}};
		}

	

}
