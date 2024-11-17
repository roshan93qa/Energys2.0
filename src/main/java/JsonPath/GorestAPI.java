package JsonPath;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class GorestAPI {
	
	@Test
	public void fetchUserData() {
		RestAssured.baseURI="https://gorest.co.in";
     Response res = given()
		.header("Content-Type", "application/json")
		.header("Authorization", "Bearer dcc5853cf8d8beb15bbfcc87e50077219d73170466bc39571a8aeacbb561deba")
		.when()
		.get("/public/v2/users")
		.then()
		.extract()
		.response();
     System.out.println(res.asPrettyString());
         JsonPath jp = res.jsonPath();
         List<Integer> ids = jp.getList("id");
         System.out.println(ids);
         
		
	}

}
