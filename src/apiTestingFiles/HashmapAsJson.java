package apiTestingFiles;

import java.util.HashMap;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;


public class HashmapAsJson {
    
	public static void main(String[] args) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		HashMap<String, Object> json = new HashMap<>();
		HashMap<String, Object> location = new HashMap<>();
		location.put("lat", "-38.232");
		location.put("lng", "44.42456");
		
		
        json.put("location", location);
        json.put("accuracy", "60");
        json.put("name", "Anush House");
        json.put("phone_number", "123456789");
        json.put("address", "204, Purohit nagar");
        String[] types = {"Shoe Park", "ShopNew"}; 
        json.put("types", types);
        json.put("website", "https:google.com");
        json.put("language", "French-IN");
        
		
        HashmapAsJson obj = new HashmapAsJson();
        obj.post(json);
		
	}
	public void post(HashMap json) {
	String response =	given().queryParam("content-type", "application/json")
		.body(json).log().all()
		.when().post("/maps/api/place/add/json")
		.then().extract().response().asPrettyString();
	System.out.println(response);
	}

}
