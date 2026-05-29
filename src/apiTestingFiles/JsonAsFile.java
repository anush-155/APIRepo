package apiTestingFiles;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
public class JsonAsFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		
 // from system 		
		String response = given().queryParam("key", "qaclick123")
		.body(new String(Files.readAllBytes(Paths.get("C:\\Program Files\\Notepad++\\AddressForPostRequest.json"))))
		.when().post("/maps/api/place/add/json/")
		.then().log().all().extract().response().asString();
		JsonPath js = new JsonPath(response);
		String id = js.getString("place_id");
		
		String place11  = "place";
		
		given().queryParam("key", "qaclick123").queryParam("place_id", id)
	    .when().get("/maps/api/"+place11+"/get/json")
	    .then().log().all();
		
		
		
// from json file in package	
		System.out.println("Response 2");
		String response2 = given().queryParam("key", "qaclick123")
				.body(new File("src/base/Jsonfile.json")) //here
				.when().post("/maps/api/place/add/json/")
				.then().log().all().extract().response().asString();
				JsonPath js1 = new JsonPath(response2);
				String id2 = js1.getString("place_id");
				
				String place111  = "place";
				
				given().queryParam("key", "qaclick123").queryParam("place_id", id2)
			    .when().get("/maps/api/"+place111+"/get/json")
			    .then().log().all();
	}

}
