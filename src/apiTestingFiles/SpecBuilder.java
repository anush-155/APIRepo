package apiTestingFiles;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;

import base.EnumData2;
import base.Payload;
public class SpecBuilder {

	public static void main(String[] args) {
		
		RequestSpecification reqS = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key", "qaclick123").setBody(Payload.bodyForpost()).build();
		ResponseSpecification resS = new ResponseSpecBuilder().expectStatusCode(200).build();
				
 String Response = given().spec(reqS)
 .when().post(" /maps/api/place/add/json")
 .then().spec(resS).log().all().extract().response().asPrettyString();
 JsonPath js = new JsonPath(Response);
 String place_id = js.getString("place_id");
 
 
 given().spec(reqS).queryParam("place_id", place_id)
 .when().get("/maps/api/place/get/json")
 .then().log().all();
	
	
 
 
 System.out.println("Enum after this");
 System.out.println(Payload.EnumData.NAME.dataField);
 
 System.out.println(EnumData2.NAME2.dataField2);
	}
	
	

}
