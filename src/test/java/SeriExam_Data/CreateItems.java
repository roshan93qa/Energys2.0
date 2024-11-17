package SeriExam_Data;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Arrays;

public class CreateItems {
	
	@Test
	public void CreateItemsTest() {
		RestAssured.baseURI="https://fea4736d-a44c-4c89-9a18-ace03897fda8.mock.pstmn.io";
		
		
		Item.userData userdata1=new Item.userData("1000","grains");
		Item.userData userdata2=new Item.userData("10001","beverage");
		Item item=new Item(Arrays.asList(userdata1,userdata2));
		
		Response res = given()
		.header("Content-Type","application/json")
		.body("item")
		.when()
		.post("/att13julypost");
		System.out.println(res.asPrettyString());
		
		
	}

}
