package api.endpoint;
import static io.restassured.RestAssured.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//Created to perform CRUD operation

public class UserEndPoints {
	

	public static Response createUser(User payload) {
		Response createUserResponse = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				
				.when()
				.post(Routes.post_url);

		return createUserResponse;

	}

	public static Response retriewUser(String userName) {
		Response retriewUserResponse = given()
				.pathParam("username", userName)

				.when()
				.get(Routes.get_url);

		return retriewUserResponse;

	}
	
	public static Response updateUser(String userName,User payload)
	{
		
		Response updateUserResponse = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
		        .pathParam("username", userName)
		        .body(payload)
		
		.when()
		    .put(Routes.put_url);
		
		return updateUserResponse;
	}
	
	public static Response deleteUser(String userName)
	{
		
		Response deleteUserResponse = given()
		    .pathParam("username", userName)
		
		.when()
		    .delete(Routes.delete_url);
		
		return deleteUserResponse;
	}
	
	
}
