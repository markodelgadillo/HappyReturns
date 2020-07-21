package Challenge;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;

public class JsonREST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Perform a GET to the endpoint: 
		 * https://happyreturnsqatest.free.beeceptor.com/getProductVariants
		 */
		RestAssured.baseURI = "https://happyreturnsqatest.free.beeceptor.com";
		
		String payload = given().log().all()
		.when().get("/getProductVariants")
		
		.then().assertThat()
		.statusCode(200)
		.extract().response().asString();
		System.out.println("This is the payload: " + payload);
		
		/* Map a variant object from the variants array from the GET above */
		
		JsonPath js = new JsonPath(payload);
		String variant = js.getString("variants[0]");
		System.out.println("This is the variant object: " + variant);
		
		/* Perform a POST using the object from above as the request body
		 * for the endpoint: https://happyreturnsqatest.free.beeceptor.com/order
		 */
		
		String response =
				given().log().all()
				.header("Content-Type", "application/json")
		.body(payload) // created a new package and class for the payload
		
		/* When */
		.when().post("/order")
		
		/* Then */ // What to expect
		.then().log().all().assertThat()
		.statusCode(201)
		.body("text", equalTo("Good job!"))
		.extract().response().asString();

	}
}
