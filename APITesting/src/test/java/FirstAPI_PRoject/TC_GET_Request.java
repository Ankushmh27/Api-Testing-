package FirstAPI_PRoject;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_GET_Request {
    
	@Test
	void getUserDetails()
	{
	   //specify base URI to restfull web services
		RestAssured.baseURI="https://openweathermap.org/api";
		//https://www.weatherapi.com/docs/#
		RequestSpecification httprequest=RestAssured.given();
		//response object create
		Response response=httprequest.request(Method.GET,"/Amravati");
		
		//print response in console
		String responsebody=response.getBody().asString();
		System.out.println("response body is"+responsebody);
		
		//status code validation
		int statuscode=response.getStatusCode();
		System.out.println("status code"+statuscode);
		Assert.assertEquals(statuscode , "201");
		
		//status line verification
		int statusline=response.getStatusCode();
		System.out.println("statusline"+statusline);
		Assert.assertEquals(statusline, 201);
		
	}
	

}
