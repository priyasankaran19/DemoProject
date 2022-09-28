package com.file.demo;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;

public class Complexjsonparse {

	public static void main(String[] args)
	{
    JsonPath js1=new JsonPath(Payload.complexjson());
    int noofcourses=js1.getInt("courses.size()");
    int purchaseamount=js1.getInt("dashboard.purchaseAmount");
    String title=js1.getString("courses.title[0]");
    System.out.println("No of Courses "+noofcourses);
    System.out.println("Purchase Amount "+purchaseamount);
    System.out.println("Title of the first course "+title);
    for(int i=0;i<noofcourses;i++)
    {   	
    String ttitle=js1.getString("courses.title["+i+"]");
    String price=js1.getString("courses.price["+i+"]");
    System.out.println("All course title  = "+ttitle);
    System.out.println("All course price= "+price);
    }
    
    for(int j=0;j<noofcourses;j++)
    {
    String titlefile=js1.getString("courses.title["+j+"]");
    //System.out.println("RPA copies "+titlefile+"");
    if(titlefile.equalsIgnoreCase("RPA"))
    {
    	int copies=js1.getInt("courses.copies["+j+"]");
    	System.out.println("RPA copies "+titlefile+" "+copies);
    	
    }//300+160+450=  910
    else
    {
    	continue;
    }
	}
    int values=0;
    int temp=0;
    int calculate=0;
    //sum of purchaseamount
    for(int i=0;i<noofcourses;i++)
    {
    
    	int price=js1.getInt("courses.price["+i+"]");
    	int copy=js1.getInt("courses.copies["+i+"]");
    	System.out.println(price+" "+copy); 
    	values=temp;
    	calculate=values+price*copy;
        temp=calculate;
    	System.out.println("Calculate "+calculate);
    	System.out.println("Temp "+temp);
    	System.out.println("Values "+values);
    	
    }
    System.out.println("Calculate "+calculate);
    Assert.assertEquals(calculate,purchaseamount);
    
	}
}
