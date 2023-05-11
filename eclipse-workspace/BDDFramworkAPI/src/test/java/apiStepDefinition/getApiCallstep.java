package apiStepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;


public class getApiCallstep {
	private RequestSpecification request;
    private Response response;
    
	@Given("I have the base URI {string}")
	public void i_have_the_base_uri(String baseURI) {
		RestAssured.baseURI = baseURI;
        request = RestAssured.given();	
	
		}

	@When("I send a GET request to {string}")
	public void i_send_a_get_request_to(String endpoint) {
		System.out.println("End pint is "+ endpoint);
		response = request.get(endpoint);
	}

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(int expectedStatusCode) {
		int actualStatusCode = response.getStatusCode();
		System.out.println("Actual response is---" +actualStatusCode);
        Assert.assertEquals(actualStatusCode,expectedStatusCode);
	}

	@Then("the response should contain {string}")
	public void the_response_should_contain(String expectedText) {
		String responseText = response.getBody().asString();
		System.out.println("Actual response Text----" +responseText);
	        Assert.assertTrue(responseText.contains(expectedText));
	}

}
