package day3;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Cookie;
import io.restassured.response.Response;



public class CookiesDemo {

//	@Test
	void testCookies(){
		given()
		
		.when()
			.get("https://www.google.co.in/")
		.then()
		.cookie("AEC","Ackid1RxGZ7U5rwDmBdcpeLYfAsSPubdsAv8AC0hwhdCt62d0VWZX0Szxg")
			.log().all();
		
	}
	
	@Test(priority = 2)
	void getCookiesInfo() {
		Response res= given()
		
		.when()
			.get("https://www.google.co.in/");
		
		// get single cookie info
		//String cookie_value =res.getCookie("AEC");
		//System.out.println("The value of cookie is===>"+cookie_value);
		Map<String, String>cookie_values =res.getCookies();
		//System.out.println(cookie_values.keySet());
		
		for(String k: cookie_values.keySet()) {
			String cookie_value =res.getCookie(k);
			System.out.println(k+"            "+cookie_value);
		}
	}
}
