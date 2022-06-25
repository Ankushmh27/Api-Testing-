package RestApi;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestParam;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POST_API {

	@Test
	public void postUserDetails()
	{
		 //specify base URI
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		
		//request object
		RequestSpecification httprequest = RestAssured.given();
		
		//Response object must json format 
		JSONObject request = new JSONObject();
		request.put("name","Ankush");
		request.put("job", "leader");
		//RequestParam.put("job", "leader");
		httprequest.header("Cotent-type","users/json");
		httprequest.body(request.toJSONString());
		
		//Response object
		Response response = httprequest.request(Method.POST,"/user");
		
		//print response in console (json to string convert)
		String responsebody = response.getBody().asString();
		System.out.println("Response body is "+responsebody);
		
		//request status code validation
		
		int StatusCode = response.getStatusCode();
		System.out.println("StatusCode is  "+ StatusCode);
		//check the actual status code response
		Assert.assertEquals(StatusCode, 201);
		
//		//success code validation
//		String successcode = response.jsonPath().get("successcode");
//		Assert.assertEquals(successcode, "Operation_Success");
//		
//		dont required
//		//status line verification
//		String statusline = response.getStatusLine();
//		System.out.println("statusline is "+statusline);
//		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		
	}
		
}
