package com.file.demo;

import io.restassured.path.json.JsonPath;

public class Reusablemethods
{
public static JsonPath rawtojason(String getplaceresponse)
		{
	JsonPath js1=new JsonPath(getplaceresponse);
	return js1;
		}
}
