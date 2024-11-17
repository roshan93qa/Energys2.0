package fakeUserAPI_LomBok;

import static io.restassured.RestAssured.DEFAULT_AUTH;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import fakeUserAPI_LomBok.User.Address;
import fakeUserAPI_LomBok.User.Name;
import fakeUserAPI_LomBok.User.Address.Geolocation;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateFakeUserTest {
	


	@Test
	public void createUserTest() {
		RestAssured.baseURI="https://fakestoreapi.com";
		
		User.Address.Geolocation geolocation=new User.Address.Geolocation("-98.900","987.999");
		User.Address address=new User.Address("Pune", "ShivajiNagar", 998, "441197", geolocation);
		User.Name name=new User.Name("Sonia", "Shanrma");
		User user=new User("roshan@gmail2.com", "roshan", "Test@123", "7741884705", name, address);
				
		Response res = given().log().all()
		.body(user)
		.when()
		.post("/users")
		.then().log().all()
		.extract()
		.response();
		System.out.println(res.asPrettyString());
		
	}

}
