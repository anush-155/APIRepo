package apiTestingFiles;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class MultipleDataUsingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	RestAssured.baseURI = "http://216.10.245.166";	
		given().queryParam("AuthorName","John foe")
		.when().get("/Library/GetBook.php")
		.then().log().all();
	}

}
