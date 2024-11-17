package JsonPath;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FakeStoreAPI {

	@Test
	public void fetchUserData() {
		RestAssured.baseURI="https://fakestoreapi.com";
     Response res = given()
		.when()
		.get("/products")
		.then()
		.extract()
		.response();
     //System.out.println(res.asPrettyString());
     //    JsonPath jp = res.jsonPath();
         
         String responseBody = res.asString();
         System.out.println(responseBody);
         
         
//         //============IDS==========================
//         List<Integer> ids = jp.getList("id");
//         System.out.println(ids);
//         //===============price======================
//         List<Float> price = jp.getList("price");
//         System.out.println(price);
//         //=============rating.rate==================
//         List<Float> ratelist = jp.getList("rating.rate");
//         System.out.println(ratelist);
//         //===============rating.count===============
//         List<Integer> counts = jp.getList("rating.count");
//         System.out.println(counts);
//         //====================================
//         int lenArrays = ids.size();
//         for (int i = 0; i < lenArrays; i++) {
//             Integer id = ids.get(i);
//             Number prices = price.get(i);
//             Number rate = ratelist.get(i);
//             Integer count = counts.get(i);
//             System.out.println("ID:" + id + " price:" + prices + " rate:" + rate + " count:" + count);
//         }
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
}}
