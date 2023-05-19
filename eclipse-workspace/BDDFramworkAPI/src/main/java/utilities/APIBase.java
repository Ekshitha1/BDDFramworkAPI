package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;





public class APIBase {
   JsonParser parser;
   JsonObject master;
   JsonObject header;
   JsonObject Payload;
   JsonPrimitive url;
   String keyName;
   String keyValue;
   Response response;
   
   RequestSpecification request;
	
	
	public void buildRequest(String requestname)
	{
		parser=new JsonParser();
		try {
			master = (JsonObject)parser.parse(new FileReader("src/test/Resources/APIpayload/"+requestname+".json"));
			header= (JsonObject)master.get("headers");
			url= (JsonPrimitive)master.get("Url").getAsJsonPrimitive();
			Payload= (JsonObject)master.get("payload");
			setPayload(Payload);
			RestAssured.baseURI = url.toString().trim().replace("\"", "");
	        RequestSpecification request = RestAssured.given();	
			if(header.keySet().size() > 0) {
				for(Object key:header.keySet()) {
					keyName=key.toString();
					keyValue=header.get(keyName).toString().replace("\"", "");
					request.header(keyName,keyValue);
				}
				setRequest(request);
				
			}
			
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	private void setRequest(RequestSpecification request) {
		this.request=request;
		
	}

	public void setPayload(JsonObject payload) {
		this.Payload=Payload;
	}
	
	public RequestSpecification getRequest() {
		return request;
	}
	
	public void requestType(String requestType) {
		if(requestType.equalsIgnoreCase("GET")) {
			response=getRequest().get();
			setResponse(response);
			
		}
		else if(requestType.equalsIgnoreCase("POST")) {
			response=getRequest().body(Payload.toString()).post();
			setResponse(response);
		}
	}

	public void setResponse(Response response) {
		this.response=response;
	}
	
	public Response getResponse() { return response;
		
	}
	

}
