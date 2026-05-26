package apiTestingFiles;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;
import base.Payload;

public class FirstTest {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String place_id = PostRequest();

     String oldAddress =   getRequest(place_id);

        putRequest(place_id);
       String newAddress = getRequest2(place_id);
       Assert.assertEquals(oldAddress, newAddress); //Failing intentionally
    }

    public static String PostRequest() {

        String postResponse =
                given()
                        .queryParam("key", "qaclick123")
                        .header("content-type", "application/json")
                        .body(Payload.bodyForpost())

                .when()
                        .post("/maps/api/place/add/json")

                .then()
                        .assertThat()
                        .statusCode(200)
                        .extract()
                        .response()
                        .asPrettyString();
       

        System.out.println(postResponse);

        JsonPath js = new JsonPath(postResponse);
        
        String place_id = js.getString("place_id");

        System.out.println(place_id);

        return place_id;
    }

    public static String getRequest(String place_id) {

        System.out.println("Get Response " + place_id);

        String getResponse =
                given()
                        .queryParam("key", "qaclick123")
                        .queryParam("place_id", place_id)

                .when()
                        .get("/maps/api/place/get/json")

                .then()
                        .extract()
                        .response()
                        .asPrettyString();
        JsonPath js2 = new JsonPath(getResponse);
       String oldAddress = js2.getString("address");

        System.out.println(getResponse);

        System.out.println("get Response ends");
        return oldAddress;
    }

    public static void putRequest(String place_id) {

        System.out.println(place_id);

        String newAddress = "204, Purohit nagar";

        String putResponse =
                given()
                        .queryParam("place_id", place_id)
                        .queryParam("key", "qaclick123")
                        
                        .header("content-type", "application/json")
                        .body(Payload.bodyForPut(place_id, newAddress)).log().all()

                .when()
                        .put("/maps/api/place/update/json")

                .then().log().all()
                        .extract()
                        .response()
                        .asPrettyString();

        System.out.println(putResponse);
    }
    public static String getRequest2 (String place_id) {
    String getResponse2 =	given().when().queryParams("place_id", place_id, "key","qaclick123")
    	.when().get("/maps/api/place/get/json")
    	.then().log().all().extract().response().asPrettyString();
    JsonPath js3 = new JsonPath(getResponse2);
    String newAddress = js3.getString("address");
    return newAddress;
    }
}