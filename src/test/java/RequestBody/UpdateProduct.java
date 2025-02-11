package RequestBody;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
public class UpdateProduct {
	
	public JSONObject createproduct_requestBody(String product_name, List<Map<String, String>> rows) {
		JSONObject object = new JSONObject();
		JSONObject object_inner = new JSONObject();
		object.put("name", product_name);
		for (Map<String, String> columns : rows) {
			object_inner.put(columns.get("Attribute"), columns.get("Value"));
		}
		object.put("data", object_inner);
		return object;
	}
	
	public JSONObject UpdateProduct_requestBody( List<Map<String, String>> rows) {
		JSONObject object = new JSONObject();
		JSONObject object_inner = new JSONObject();
		for (Map<String, String> columns : rows) {
			object_inner.put(columns.get("Attribute"), columns.get("Value"));
		}
		object.put("data", object_inner);
		return object;
	}

}
