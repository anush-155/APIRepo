package apiTestingFiles;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.List;
public class POJODeserialization {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	RestAssured.baseURI = "https://rahulshettyacademy.com";
	POJOClasses response = given().queryParam("access_token", "u1uMNsnRkcw49re1dYpxYg==").
	when().get("/oauthapi/getCourseDetails")
	.then().extract().response().as(POJOClasses.class);
	
	
	System.out.println(response.getUrl());
			
	}}
	class POJOClasses {
		private String instructor;
		private String url;
		private String services;
		private String expertise;
		private POJOCourse courses;
		private String linkedIn;
		
		
		public String getInstructor() {
			return instructor;
		}
		public void setInstructor(String instructor) {
			this.instructor = instructor;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getServices() {
			return services;
		}
		public void setServices(String services) {
			this.services = services;
		}
		public String getExpertise() {
			return expertise;
		}
		public void setExpertise(String expertise) {
			this.expertise = expertise;
		}
		public POJOCourse getCourses() {
			return courses;
		}
		public void setCourses(POJOCourse courses) {
			this.courses = courses;
		}
		public String getLinkedIn() {
			return linkedIn;
		}
		public void setLinkedIn(String linkedIn) {
			this.linkedIn = linkedIn;
		}
	
		

}
	class POJOCourse {
		
		private List<api> api;
		
		
		
		public List<api> getApi() {
			return api;
		}
		public void setApi(List<apiTestingFiles.api> api) {
			this.api = api;
		}
		
		
	
	}
	class api{
	private String courseTitle;
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	private String price;
	}
						
