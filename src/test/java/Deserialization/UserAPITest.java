package Deserialization;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UserAPITest {

	@Test
	public void CreateAPITest_withLombok() {
		RestAssured.baseURI = "https://gorest.co.in";

		User user = new User(1, "Roshan", "roxshaddnwww1@gmail.com", "male", "active");

		Response res = given().contentType(ContentType.JSON)
				.header("Authorization", "Bearer dcc5853cf8d8beb15bbfcc87e50077219d73170466bc39571a8aeacbb561deba")
				.body(user) // serialization
				.when()
				.post("/public/v2/users")
				.then().extract()
				.response();
		System.out.println(res.asPrettyString());
		JsonPath jp = res.jsonPath();
		int userId = jp.getInt("id");
		System.out.println("userid====>" + userId);

		// get a user using the userId :GET

		Response getres = given().contentType(ContentType.JSON)
				.header("Authorization", "Bearer dcc5853cf8d8beb15bbfcc87e50077219d73170466bc39571a8aeacbb561deba")
				.when()
				.get("/public/v2/users/" + userId)
				.then()
				.extract()
				.response();
		System.out.println(res.asPrettyString());

		// Deserialzation --Json to pojo
		ObjectMapper mapper = new ObjectMapper();
		try {
			User userRes = mapper.readValue(getres.getBody().asString(), User.class);
			System.out.println(userRes.getId() + " " + userRes.getName() + " " + userRes.getGender() + "  "
					+ userRes.getStatus() + " " + userRes.getEmail());
			Assert.assertEquals(userRes.getId(), userId);
			Assert.assertEquals(userRes.getEmail(), user.getEmail());
			Assert.assertEquals(userRes.getGender(), user.getGender());
			Assert.assertEquals(userRes.getStatus(), user.getStatus());
			Assert.assertEquals(userRes.getName(), user.getName());

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
