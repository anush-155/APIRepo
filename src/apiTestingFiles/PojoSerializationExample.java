package apiTestingFiles;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;


public class PojoSerializationExample {

	public static void main (String[] args) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		payloadForBody p = new payloadForBody();
		p.setAccuracy(50);
		p.setAddress("204, Purohit NAgar");
		p.setLanguage("Spanish");
		p.setPhoneNumber("42345671365");
		p.setWebsite("https://rahulshettyacademy.com");
		p.setName("Anush");
		
		List<String> list = new ArrayList<>();
		list.add("Shoe Park");
		list.add("shop");

		p.setTypes(list);
		
		
		LocationClass l = new LocationClass();
		l.setLat(-38.324436);
		l.setLng(33.5465567);
		
		
		p.setLocation(l);
		
		
		
		String response = 	given().queryParam("key", "qaclick123").body(p).log().all()
		.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response().asString();
		System.out.println(response);
	}

}
class payloadForBody{
	
	
	private LocationClass location;
	private int accuracy;
	private String name;
	private String phoneNumber;
	private String address;
	private List<String> types;
	private String website;
	private String language;
	
	
	public LocationClass getLocation() {
		return location;
	}
	public void setLocation(LocationClass location) {
		this.location = location;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
}
class LocationClass {
	private double lat;
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	private double lng;
}


