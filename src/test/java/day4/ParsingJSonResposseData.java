package day4;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class ParsingJSonResposseData {

	@Test
	void testJsonResponse() {
		
		//Approach 1
		/*given()
			.contentType("ContentType.JSON")
		.when()
			.get("http://localhost:3000/people")
		.then()
			.statusCode(200)
			.header("ContentType", "application/json; charset=utf-8")
			.body("x.people[2].firstName", equalTo("Emily"));
		*/
		
		//Approach 2
		
		Response res=given()
										.contentType("ContentType.JSON")
								.when()
										.get("http://localhost:3000/people");
		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.header("Content-Type"), "application/json; charset=utf-8");
		
		String firstname=res.jsonPath().get("x.people[2].firstName").toString();
		Assert.assertEquals(firstname,"Emily");
	
	
	}
}
