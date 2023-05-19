import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class GetAPI {

	
	@Test
	public void getapi1() {
		
		given().body(" ").
		post("http://jsonplaceholder.typicode.com/users").
		then().assertThat().statusCode(201);
		
		
		
		
		
	}
	
	
	
}
