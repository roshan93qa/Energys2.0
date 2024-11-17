package UpdateUser;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateUserTest {
	UserLombok user;
	int userId ;
	
	public String getRandomEmailid() {
		return "apiAutomation"+System.currentTimeMillis()+"@gmail.com";
	}
	
	@Test
	public void creteuUserwith_lombok() {
		RestAssured.baseURI="https://gorest.co.in";
		user=new UserLombok("pooja sharma",getRandomEmailid(),"female","active");
		
		
		Response res = given()
		.header("Content-Type","application/json")
		.header("Authorization","Bearer dcc5853cf8d8beb15bbfcc87e50077219d73170466bc39571a8aeacbb561deba")
		.body(user)
		.when()
		.post("/public/v2/users")
		.then()
		.extract()
		.response();
	    System.out.println(res.asPrettyString());
	    JsonPath jp = res.jsonPath();
	    userId = jp.getInt("id");
	    System.out.println("userid==>"+userId);
	   }
	
	@Test
	public void getUserTest_lombok() {
		RestAssured.baseURI="https://gorest.co.in";
	
		Response res = given()
		.header("Content-Type","application/json")
		.header("Authorization","Bearer dcc5853cf8d8beb15bbfcc87e50077219d73170466bc39571a8aeacbb561deba")
		.when()
		.get("/public/v2/users/"+userId)
		.then()
		.extract()
		.response();
	    System.out.println(res.asPrettyString());
	    
	   
	   }
	
	@Test(dependsOnMethods = "creteuUserwith_lombok")
	public void UpdateUserTest_lombok() {
	    RestAssured.baseURI = "https://gorest.co.in";
	    
	   
	    user.setName("roshan sharma");
	    user.setStatus("Inactive");

	    Response res = given()
	        .header("Content-Type", "application/json")
	        .header("Authorization", "Bearer dcc5853cf8d8beb15bbfcc87e50077219d73170466bc39571a8aeacbb561deba")
	        .body(user)
	        .when()
	        .put("/public/v2/users/" + userId)
	        .then()
	        .extract()
	        .response();
	        System.out.println(res.asPrettyString());
	      // JsonPath jp = res.jsonPath();
	}

	
	
	
	}
	
	


