package day1;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class SoapXMLRquest {
	@Test
	public void validateSoapXMLrequest() throws IOException {
		File file = new File("./SoapRequest/Add.XML") ;
		
		if (file.exists())
			System.out.println("     >> File Exists");
		FileInputStream fileInputStream= new FileInputStream(file);
		String requestBody =IOUtils.toString(fileInputStream, "UTF-8");
		
		baseURI ="https://ecs.syr.edu/faculty/fawcett/Handouts/cse775/code/calcWebService/Calc.asmx";
		
		given().
		contentType("text/xml").
		accept(ContentType.XML).
		body(requestBody).
		when().
			post("/Calc.asmx").
		then().
		statusCode(200);
	}
		
}
