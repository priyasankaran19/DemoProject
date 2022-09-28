package com.file.democom.file.auth;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import com.file.demo.Reusablemethods;

public class Gettoken
{

    static String clientid = "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com";
	static String redirect_uri="https://rahulshettyacademy.com/getCourse.php";
	static String client_secret="erZOWM9g3UtwNRj340YYaK_W";
    static String url="https://rahulshettyacademy.com/getCourse.php?code=4%2F0AdQt8qjckDvn6lZpST9V8nqUMWl22j4kx7_7J7DgH1NeDWEKQAa_apV8HINRkNwEs3qdfA&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=none#";
    static String partialcode=url.split("code=")[1];
	static String code=partialcode.split("&scope")[0];
	
	public static String gettoken()
	{		
		
		String res=given().queryParam("code", code).queryParam("client_id", clientid).queryParam("client_secret", client_secret).
		queryParam("redirect_uri", redirect_uri).queryParam("grant_type", "authorization_code").urlEncodingEnabled(false).log().all().post("https://www.googleapis.com/oauth2/v4/token").then().log().all().extract().response().asString();
		JsonPath js=Reusablemethods.rawtojason(res);
		String accesstoken=js.getString("access_token");
		System.out.println(js.getString("access_token")+accesstoken);
		return accesstoken;		
	}

}
