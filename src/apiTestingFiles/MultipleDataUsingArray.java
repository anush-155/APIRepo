package apiTestingFiles;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class MultipleDataUsingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	String[] arr = new String[5];

		
		
		
		//API nahi mill raha bc ; mill gaya
	RestAssured.baseURI = "https://jsonplaceholder.typicode.com";	
		given().body(arr)
		.when().post("/posts")
		.then().log().all();
	}

}
