package API_BaseClass;

import java.io.IOException;
import java.util.Map;

import Utils.FrameworkUtils;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
public class API_Calls {

	
	public static Response CurrentResponse;
	

	
	
//	private static RequestSpecification requestspecification;
//
//	public static RequestSpecification Reqeust_FIlter() {
//		return requestspecification = (RequestSpecification) new RequestSpecBuilder().addHeader("Content-Type", "application/json").setAccept(ContentType.ANY)
//				.log(LogDetail.ALL);
//		
//	}

	public static Response get(Map<String, ?> QueryParams, String Resource) throws IOException {
		try {
			String URI=	FrameworkUtils.readpropertiesfile("API_BASE_URI");
			
		String URL=URI+Resource;
		CurrentResponse = given().queryParams(QueryParams).when().log().all().get(URL).then().log().all()
				.extract().response();
		return CurrentResponse;
		}
		finally {
			RestAssured.reset();
		}
	}
	
	public static Response post (String Body,String Resource) throws IOException {
		String URI=	FrameworkUtils.readpropertiesfile("API_BASE_URI");
		String URL=URI+Resource;
		System.out.println("URL????"+URL);
		CurrentResponse = given().body(Body).header("Content-Type","application/json").when().log().all().post(URL).then().log().all()
				.extract().response();
		return CurrentResponse;
	}
	public static Response patch (String Body,String Resource) throws IOException {
		String URI=	FrameworkUtils.readpropertiesfile("API_BASE_URI");
		String URL=URI+Resource;
		System.out.println("URL????"+URL);
		CurrentResponse = given().body(Body).header("Content-Type","application/json").when().log().all().patch(URL).then().log().all()
				.extract().response();
		return CurrentResponse;
	}
	
	
	
}
