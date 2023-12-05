package day3;

import static io.restassured.RestAssured.given;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import java.util.Iterator;

import static io.restassured.matcher.RestAssuredMatchers.*;
public class HeadersDemo {

	//	@Test
		void testHeaders(){
			given()
			
			.when()
				.get("https://www.google.co.in/")
			.then()
				.header("Content-Type", "text/html; charset=ISO-8859-1")
				.and()
				.header("Content-Encoding", "gzip")
				.and()
				.header("Server", "gws");		
		}
		
		@Test(priority = 2)
		void getHeaders() {
			Response res = given()
						.when()
							.get("https://www.google.co.in/");
			
			// to get header info
			//String headervalue = res.getHeader("Content-Type");
			//System.out.println("the value of Content is ==>"+headervalue);
			
			// to get all headers info
			Headers myheaders=res.getHeaders();
			for(Header hd:myheaders) {
				System.out.println(hd.getName()+"                            "+hd.getValue());
			}
							
		}
		
		
	}
