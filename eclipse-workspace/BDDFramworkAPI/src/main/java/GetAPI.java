import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class GetAPI {

	
	@Test
	public void getapi1() {
		
		given().
		when().get("https://jsonplaceholder.typicode.com/posts").
		then().assertThat().statusCode(200);
		
		
		
		
		
	}
	
	
	
}
