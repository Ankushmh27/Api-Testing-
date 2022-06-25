package RestApi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_API {

	@Test
	public void GET_api() {
	    //specify base URI
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		
		//request object
		RequestSpecification httprequest = RestAssured.given();
		
		//Response object
		Response response = httprequest.request(Method.GET,"8");
		
		//print response in console (json to string convert)
		
		String responsebody = response.getBody().asString();
		System.out.println("Response body is "+responsebody);
		
		//request status code validation
		
		int StatusCode = response.getStatusCode();
		System.out.println("StatusCode is  "+ StatusCode);
		
		//check the actual status code response
		Assert.assertEquals(StatusCode, 200);
		
		//status line verification
		String statusline = response.getStatusLine();
		System.out.println("statusline is "+statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		
		
		
		
	}
}
