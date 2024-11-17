package SeriExam2_Data;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateItemsTest {

    @Test
    public void createItemsTest() {
        RestAssured.baseURI = "https://fea4736d-a44c-4c89-9a18-ace03897fda8.mock.pstmn.io";

        // Create Item objects representing each element in the JSON array
        Itemm item1 = new Itemm("1000", "grains");
        Itemm item2 = new Itemm("1001", "beverage");

        // Add the items to a list (which will be sent as JSON array)
        Itemm[] items = { item1, item2 };

        // Send the POST request with the JSON array
        Response res = given()
                .header("Content-Type", "application/json")
                .body(items) // RestAssured automatically serializes the array to JSON
                .when()
                .post("/att13julypost");

        // Print the response in a pretty format
        System.out.println(res.asPrettyString());
    }
}

