package day1;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OpenWeatherAPI {
  @Test
  public void getWeatherInfo() {
  
  RestAssured.given()
  	.when()
  	.get("http://api.openweathermap.org/data/2.5/weather?q=mumbai&appid=65600594cfcd4415915b8139795ecbd7")
  	.then()
  	 .log()
  	 .body()
  	 .statusCode(200);
  }
  @Test(enabled=false, description="Getting weather API information Generally")
  public void getWeatherInfo2() {
	  Response res = RestAssured.given()
	              .when()
	                .get("http://api.openweathermap.org/data/2.5/weather?q=Mumbai&appid=41d3c841453b4c71cd7abdd93c6fb62e");
	   System.out.println(res.prettyPrint());
	   System.out.println(res.getTime());
	   System.out.println(res.getStatusCode());
	   System.out.println(res.getContentType());	   
  } 
  
  @Test(enabled=true, description="Getting weather API information Generally")
  public void getWeatherInfo3() {
	  Map<String, String> param=new HashMap<String, String>();
	  param.put("q", "Mumbai");
      param.put("appid","41d3c841453b4c71cd7abdd93c6fb62e" );
	  RestAssured.given()
	               // .queryParam("q", "Mumbai")
	               // .queryParam("appid","41d3c841453b4c71cd7abdd93c6fb62e" )
	              .params(param)
	                .get("http://api.openweathermap.org/data/2.5/weather")
	              .then()
	                 .log() //Print the body
	                 .body()
	                 .statusCode(200); 
}
  
  
}
