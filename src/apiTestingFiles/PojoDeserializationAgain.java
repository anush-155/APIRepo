package apiTestingFiles;

import static io.restassured.RestAssured.given;

import java.util.List;

import io.restassured.RestAssured;

public class PojoDeserializationAgain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		ResponseBody response = given().queryParam("access_token", "8+3T4uNKSUkrgjN58TtGLg==")
				.when()
				.get("/oauthapi/getCourseDetails").then().log().all().extract().response().as(ResponseBody.class);
   
		

		System.out.println(response.getUrl());
		
		
		System.out.println(response.getCourses()); 
		List <webAutomation> webCourses = response.getCourses().getWebAutomation();
		for(webAutomation s: webCourses) {
			System.out.println(s.getCourseTitle());
			System.out.println(s.getPrice());
			
		}
		System.out.println("Here is the course : "+response.getCourses().getWebAutomation().get(1).getCourseTitle());
		
	}}

	class ResponseBody {
		private String instructor;
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
		public coursesClass getCourses() {
			return courses;
		}
		public void setCourses(coursesClass courses) {
			this.courses = courses;
		}
		public String getLinkedIn() {
			return linkedIn;
		}
		public void setLinkedIn(String linkedIn) {
			this.linkedIn = linkedIn;
		}
		private String url;
		private String services;
		private String expertise;
		private coursesClass courses;
		private String linkedIn;

	}

class coursesClass {
	private List<webAutomation> webAutomation;
	public List<webAutomation> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<webAutomation> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<apii> getApi() {
		return api;
	}
	public void setApi(List<apii> api) {
		this.api = api;
	}
	public List<mobile> getMobile() {
		return mobile;
	}
	public void setMobile(List<mobile> mobile) {
		this.mobile = mobile;
	}
	private List<apii> api;
	private List<mobile> mobile;
}


class webAutomation{
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
class apii{
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
class mobile{
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
	private String courseTitle;
	private String price;
}

