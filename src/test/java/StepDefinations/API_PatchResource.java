package StepDefinations;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import API_BaseClass.API_Calls;
import RequestBody.UpdateProduct;
import Utils.FrameworkConstants;
import Utils.FrameworkUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class API_PatchResource {

	  API_Calls baseclass= new API_Calls();
		UpdateProduct ReuestBody = new UpdateProduct();
		String endpoint_file_Path = "./Configuration/properties/EndPoint.properties";
		
		@Given("Create Device with product name as {string} and with below data")
		public void create_device_with_below_details(String product_name,DataTable Table) throws IOException {
			List<Map<String,String>> rows=Table.asMaps(String.class,String.class);
			String Post_Resource = FrameworkUtils.readpropertiesfile("Post_Device/getDevice");	
			String Body=ReuestBody.createproduct_requestBody(product_name,rows).toString();
			API_Calls.CurrentResponse=API_Calls.post(Body, Post_Resource);
		}
		
		@Then("Extract product id from response")
		public void extract_product_id_from_responsse() {
			FrameworkConstants.ID = API_Calls.CurrentResponse.then().extract().path("id");
		}

		@Given("Get newly device with {string} id")
		public void get_device_list_of_id(String value) throws IOException {
			String Get_Resource = FrameworkUtils.readpropertiesfile("Post_Device/getDevice");
			HashMap<String, String> QueryParam = new HashMap<>();
			QueryParam.put("id", FrameworkConstants.ID);		
			API_Calls.CurrentResponse = API_Calls.get(QueryParam, Get_Resource);
			//System.out.print(CurrentResponse);
		}
		@Given("update Device with product id as {string} and with below data")
		public void uodate_device_with_below_details(String ID,DataTable Table) throws IOException {
			List<Map<String,String>> rows=Table.asMaps(String.class,String.class);
			String Post_Resource;
			{
				if(ID.equalsIgnoreCase("valid"))
				{
					Post_Resource = FrameworkUtils.readpropertiesfile("Post_Device/getDevice")+"/"+FrameworkConstants.ID;
				}
				else
				{
					Post_Resource = FrameworkUtils.readpropertiesfile("Post_Device/getDevice")+"/"+ID;
				}
			}
				
			String Body=ReuestBody.UpdateProduct_requestBody(rows).toString();
			API_Calls.CurrentResponse=API_Calls.patch(Body, Post_Resource);
		}
		

}
