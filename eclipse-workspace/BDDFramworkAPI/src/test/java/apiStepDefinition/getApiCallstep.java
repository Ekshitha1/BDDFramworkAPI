package apiStepDefinition;

import org.testng.Assert;

import groovy.json.JsonParser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.APIBase;

import static org.hamcrest.Matchers.*;


public class getApiCallstep extends APIBase{
	private RequestSpecification request;
    private Response response;
    
   
	@Given("I have the base URI {string}")
	public void i_have_the_base_uri(String baseURI) {
		RestAssured.baseURI = baseURI;
        request = RestAssured.given();	
	
		}
	
	@Given("Build the request {string}")
	public void build_the_request(String request){
		
		this.buildRequest(request);
	}

	@When("I send a GET request to {string}")
	public void i_send_a_get_request_to(String endpoint) {
		response = request.get(endpoint) ;
		setResponse(response);
	}
	
	
	@When("The resquest type is {string}")
	public void i_send_a_post_request_to(String requesttype) {
		
		this.requestType(requesttype);
		
		
	}

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(int expectedStatusCode) {
		Response response=this.getResponse();
		int actualStatusCode = response.getStatusCode();
		System.out.println("Actual response is---" +actualStatusCode);
        Assert.assertEquals(actualStatusCode,expectedStatusCode);
		//response.print();
	}

	@Then("the response should contain {string}")
	public void the_response_should_contain(String expectedText) {
		Response response=this.getResponse();
		JsonPath jsonpath=response.jsonPath();
		System.out.println("Actual text is " +jsonpath.get("name"));
		Assert.assertEquals(jsonpath.get("name"), expectedText);
	}

}
