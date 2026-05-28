package apiTestingFiles;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class Oauth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    RestAssured.baseURI = "https://rahulshettyacademy.com";
    
  String responseForToken =  given().formParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com", "client_secret", "erZOWM9g3UtwNRj340YYaK_W", "grant_type", "client_credentials", "scope", "trust").log().all().
    when().post("oauthapi/oauth2/resourceOwner/token").
    then().extract().response().asPrettyString();
	
      JsonPath js = new JsonPath(responseForToken);
    String token =  js.getString("access_token");
    System.out.println(token);
    
    
    
   given().queryParam("access_token", token).log().all()
   .when().get("/oauthapi/getCourseDetails")
   .then().log().all();
    
}}
