package RestApi;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
public class NewTest {
   @Test
   void verifyTestNg() {
      String c = "Automation Testing";

      //base URI with Rest Assured class
      RestAssured.baseURI = "https://run.mocky.io/v3";

      //input details
      RequestSpecification h = RestAssured.given();

      //get response
      Response r = h.get("/e3f5da9c-6692-48c5-8dfe-9c3348cfd5c7");

      //Response body
      ResponseBody bdy = r.getBody();

      //convert response body to string
      String b = bdy.asString();

      //JSON Representation from Response Body
      JsonPath j = r.jsonPath();

      //Get value of Location Key
      String l = j.get("Course");
      System.out.println("Course name: " + l);
      Assert.assertEquals(l, c);
   }
}