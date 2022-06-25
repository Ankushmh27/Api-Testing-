package FirstAPI_PRoject;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_POST_Request {

	 
		@SuppressWarnings("unchecked")
		@Test
		void postweatherDetails()
		{
		   //specify base URI
			RestAssured.baseURI="https://reqres.in/api/users?page=2";
			//https://www.weatherapi.com/docs/#
			RequestSpecification httprequest=RestAssured.given();
			
			//response object create
		JSONObject requestparams=new JSONObject();	
        //this is post body 
         requestparams.put("id", 454);
         requestparams.put("email", "michael.lawson@reqres.in");
         requestparams.put("first_name", "Michael");
         requestparams.put("last_name", "Lawson");
         requestparams.put("avatar","https://reqres.in/img/faces/7-image.jpg");
         httprequest.header( "content_type","application/json");
         httprequest.body(requestparams.toJSONString());//attach above data to request
         
       
         Response response=httprequest.request(Method.POST ,"/users");
			
			//print response in console
			String responsebody=response.getBody().asString();
			System.out.println("response body is"+responsebody);
			//status code validation
			int statuscode=response.getStatusCode();
			System.out.println("status code"+statuscode);
			Assert.assertEquals(statuscode, 200);
			
			//success code validation
			String successcode=response.jsonPath().get("successcode");
			Assert.assertEquals(successcode,"operation_success");
	 
		}
}
