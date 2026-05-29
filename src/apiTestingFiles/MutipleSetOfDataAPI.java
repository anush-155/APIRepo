package apiTestingFiles;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class MutipleSetOfDataAPI {

	
	
@Test
	public void getData(){
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		
		
for (int i=1;i<10;i++) {		
	String getResponse =	given().when().get("/posts/i")
		.then().extract().response().asPrettyString();
	System.out.println(getResponse);
	JsonPath js = new JsonPath(getResponse);
int userId =	js.getInt("userId");
int id =	js.getInt("id");
	
	System.out.println(userId+", "+id);
	}}
	
	
	
	
	
}
