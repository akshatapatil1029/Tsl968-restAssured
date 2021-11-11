package day1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class PositiveTest {
	String id;
	  @Test(enabled=false,description="Getting all contact list")
	  public void getAllContactList() {
		  given()
		  .when()
		       .get("http://3.13.86.142:3000/contacts")
		  .then()
	           .log()
	           .body()
	           .statusCode(200);
	  }
	  @Test(enabled=true,description="adding contact")
	  public void addContact() {
		  JSONObject loc=new JSONObject();
		  loc.put("city", "Pune");
		  loc.put("country", "India");
		  JSONObject emp=new JSONObject();
		  loc.put("jobTitle", "Software Tester");
		  loc.put("company", "Microsoft");
		  JSONObject ob=new JSONObject();
		  ob.put("firstName","akshata");
		  ob.put("lastName", "patil");
		  ob.put("email", "akshata@123.com");
		  ob.put("location", loc);
		  loc.put("employer", emp);
		  id = given()
		    .header("Content-Type","application/json")
		    .body(ob.toJSONString())
		   .when()
		     .post("http://3.13.86.142:3000/contacts\n")
		   .then()
		     .log()
	         .body()
	         .statusCode(200)
	         .extract()
	         .jsonPath()
	         .get("_id");
	       System.out.println("ID is "+id);

		  
	  }
	  @Test(enabled=true,dependsOnMethods="addContact",description="Getting specific contact")
	  public void getSpecificContact() {
	  given()
	  .when()
	     .get("http://3.13.86.142:3000/contacts/"+id)
	  .then()
	     .log()
	     .body()
	     .statusCode(200);


	}
	  @Test(enabled=true,dependsOnMethods="getSpecificContact",description="updating all contact list")
	  public void updateContact() {
		  JSONObject loc=new JSONObject();
		  loc.put("city", "Pune");
		  loc.put("country", "India");
		  JSONObject emp=new JSONObject();
		  loc.put("jobTitle", "Software Tester");
		  loc.put("company", "Microsoft");
		  JSONObject ob=new JSONObject();
		  ob.put("firstName","Akshata");
		  ob.put("lastName", "patil");
		  ob.put("email", "akshata@78.com");
		  ob.put("location", loc);
		  loc.put("employer", emp);
		   given()
		    .header("Content-Type","application/json")
		    .body(ob.toJSONString())
		   .when()
		     .put("http://3.13.86.142:3000/contacts/"+id)
		   .then()
		     .log()
	         .body()
	         .statusCode(204);
	         
		  
	  }
	  @Test(enabled=true,dependsOnMethods="updateContact",description="deleting contact")
	  public void deleteSpecificContact() {
	  given()
	  .when()
	     .delete("http://3.13.86.142:3000/contacts/"+id)
	  .then()
	     .log()
	     .body()
	     .statusCode(204);
	}
	}