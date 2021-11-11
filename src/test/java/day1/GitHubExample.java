package day1;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;
public class GitHubExample {
  @Test (enabled=true,description="Getting all respositories")
  public void getAllRepo() {
	  given()
	  .auth()
	  .oauth2("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")
	 .when()
	  .get("https://api.github.com/user/repos")
	 .then()
	  .log()
	  .body()
	  .statusCode(200)
	  .time(Matchers.lessThan(2000L), TimeUnit.MILLISECONDS);
  }
  @Test (enabled=true,description="Adding respositories")
  public void addRepository() {
	  JSONObject js=new JSONObject();
	  js.put("name", "tsl986-restassured");
	  js.put("description", "i am creasted by restassured");
	  js.put("homepage", "https://github.com/akshatapatil1029");
	  given()
	  .auth()
	  .oauth2("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")
	 .when()
	  .get("https://api.github.com/user/repos")
	 .then()
	  .log()
	  .body()
	  .statusCode(200)
	  .time(Matchers.lessThan(2000L), TimeUnit.MILLISECONDS);
	  
  }
}
