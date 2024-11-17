package ReqResGet_LombokAPI;

import org.testng.annotations.Test;

import ReqResGet_LombokAPI.User.Support;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static  io.restassured.RestAssured.*;

import java.util.Arrays;


public class getUserTest {
	
	@Test
	public void getUserDataTest() {
		 RestAssured.baseURI = "http://httpbin.org";
		
		User.UserData userData1 = new User.UserData(1, "abhi@g.com", "abhi", "anand", "https://reqres.in/img/faces/3-image.jpg");
		User.UserData userData2 = new User.UserData(2, "sonia@g.com", "sonia", "sharma", "https://reqres.in/img/faces/4-image.jpg");
		User.UserData userData3 = new User.UserData(3, "pooja@g.com", "pooja", "tiwari", "https://reqres.in/img/faces/5-image.jpg");
		User.UserData userData4 = new User.UserData(4, "surya@g.com", "surya", "arya", "https://reqres.in/img/faces/6-image.jpg");
		User.UserData userData5 = new User.UserData(5, "naveen@g.com", "naveen", "chutani", "https://reqres.in/img/faces/7-image.jpg");
		User.UserData userData6 = new User.UserData(6, "kavya@g.com", "kavya", "mehta", "https://reqres.in/img/faces/8-image.jpg");
		Support support = new Support("https://reqres.in/#support-heading", "To keep ReqRes free, contributions towards server costs are appreciated!");
		User user = new User(1, 6, 12, 2, Arrays.asList(userData1, userData2, userData3, userData4, userData5, userData6), support); 
	   
         given()
        .log().all()
        .contentType(ContentType.JSON)
        .body(user)
        .when()
        .post("/post")
         .then()
        .log().all()
        .assertThat()
        .statusCode(200);
}
		
		
		
	}


