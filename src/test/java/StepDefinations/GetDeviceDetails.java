package StepDefinations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import API_BaseClass.API_Calls;
import Utils.FrameworkUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GetDeviceDetails {
	String endpoint_file_Path = "./Configuration/properties/EndPoint.properties";

	@Given("Get device list of id {int}")
	public void get_device_list_of_id(int value) throws IOException {

		//String Get_Resource = FrameworkUtility.readConfigurationFile(endpoint_file_Path, "Post_Device/getDevice");
		Map<String, Integer> QueryParam = new HashMap<String, Integer>();
	    QueryParam.put("id", value);
	    String Post_Resource = FrameworkUtils.readpropertiesfile("Post_Device/getDevice");
	    API_Calls.CurrentResponse = API_Calls.get(QueryParam, Post_Resource);
		//System.out.print(CurrentResponse);
	}
	@Then("Verify response code is {int}")
	public void verify_Response_code(int Expected_Value) {
		int Actual_Value = API_Calls.CurrentResponse.getStatusCode();
		assertEquals(Actual_Value, Expected_Value);
	}
	@Then("Verify response property {string} is {int}")
	public void verify_Response_Key_Value(String JsonPath, int Expected_Value) {
		int Actual_Value = API_Calls.CurrentResponse.then().extract().path(JsonPath);
		assertEquals(Actual_Value, Expected_Value);
	}
	
	@SuppressWarnings("deprecation")
	@Then("Verify response property {string} is float {float}")
	public void verify_Response_Key_Value(String JsonPath, float Expected_Value) {
		float Actual_Value = API_Calls.CurrentResponse.then().extract().path(JsonPath);
		assertEquals(Actual_Value, Expected_Value);
	}

	@Then("Verify response property {string} is {string}")
	public void verify_Response_Key_Value(String JsonPath, String Expected_Value) {

		String Actual_Value = API_Calls.CurrentResponse.then().extract().path(JsonPath);
		if (Actual_Value != null) {
			assertEquals(Actual_Value, Expected_Value);
		} else {
			assertNotNull(Actual_Value);
		}
	}

}
