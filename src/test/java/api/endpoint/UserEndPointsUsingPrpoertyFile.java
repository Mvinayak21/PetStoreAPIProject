package api.endpoint;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPointsUsingPrpoertyFile {
	
	public static ResourceBundle getURL()
	{
		ResourceBundle resource = ResourceBundle.getBundle("routes");
		
		return resource;
	}
	
	public static Response createUser(User payload) {
		
		String post_url = getURL().getString("post_url");
		
		Response createUserResponse = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				
				.when()
				.post(post_url);

		return createUserResponse;

	}

	public static Response retriewUser(String userName) {
		
		String get_url = getURL().getString("get_url");
		
		Response retriewUserResponse = given()
				.pathParam("username", userName)

				.when()
				.get(get_url);

		return retriewUserResponse;

	}
	
	public static Response updateUser(String userName,User payload)
	{
		String update_url = getURL().getString("put_url");
		
		Response updateUserResponse = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
		        .pathParam("username", userName)
		        .body(payload)
		
		.when()
		    .put(update_url);
		
		return updateUserResponse;
	}
	
	public static Response deleteUser(String userName)
	{
		String delete_url = getURL().getString("delete_url");
		
		Response deleteUserResponse = given()
		    .pathParam("username", userName)
		
		.when()
		    .delete(delete_url);
		
		return deleteUserResponse;
	}


}
