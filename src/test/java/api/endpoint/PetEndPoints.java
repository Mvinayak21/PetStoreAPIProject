package api.endpoint;

import static io.restassured.RestAssured.*;

import api.payload.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndPoints {
	
	public static Response createPet(Pet payload)
	{
		Response createPetResponse =given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		
		
		.when()
		   .post(Routes.pet_put_url);
		
		return createPetResponse;
	}
	
	
	public static Response updatePet(Pet payload)
	{
		Response updatePetResponse = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		
		.when()
			.put(Routes.pet_put_url);
		
		return updatePetResponse;
			
	}
	
	public static Response getPet(long id)
	{
		Response getPetResponse = given()
			.pathParam("id", id)
			
			.when()
			.get(Routes.pet_get_url_ById);
		
		return getPetResponse;
		
	}
	
	public static Response deletePet(long id)
	{
		Response deletePetResponse = given()
				.pathParam("id", id)
				
				.when()
				.delete(Routes.pet_delete_url_ById);
			
			return deletePetResponse;
			
	}
	

}
