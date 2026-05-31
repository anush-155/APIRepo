package apiTestingFiles;


import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

class JsonData{
	   private String message;
	  
	   
public String getKey() {
	 return message;
}
	 
public void setKey(String key) {
	this.message = key;
}	 
	 }

public class POJOSerialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
 JsonData param = new JsonData();
 param.setKey("Hello Helllo Hellllo");
	   
 RestAssured.baseURI = "https://httpbin.org";
 given().body(param)
 .when().post("/post")
 .then().log().all();
 
   }
	}



