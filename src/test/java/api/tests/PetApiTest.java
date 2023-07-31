package api.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoint.PetEndPoints;
import api.payload.Pet;
import io.restassured.response.Response;

public class PetApiTest {
	
	Faker faker;
	Pet petPayload;
	
	@BeforeClass
	public void setUp()
	{
		faker = new Faker();
		petPayload = new Pet();
		
		//JSON SCHEMA
		/*{
			  "id": 0,
			  "category": {
			    "id": 0,
			    "name": "string"
			  },
			  "name": "doggie",
			  "photoUrls": [
			    "string"
			  ],
			  "tags": [
			    {
			      "id": 0,
			      "name": "string"
			    }
			  ],
			  "status": "available"
			}*/
		
		//Set Category
		Pet.Category category = new Pet.Category();
		
		category.setId(faker.idNumber().hashCode());
		category.setName(faker.name().name());
		
		//Set Photo Url's
		 List<String> photoUrls = new ArrayList<String>();
		 
		 photoUrls.add("URL1");
		 photoUrls.add("URL2");
		 photoUrls.add("URL3");
		 
		 //Set Tags
		 List<Pet.Tag> tags = new ArrayList<Pet.Tag>();
		    
		   
		// Creating a Tag object for the first tag
		    Pet.Tag tag1 = new Pet.Tag();
		    tag1.setId(1); // Set the ID of the first tag
		    tag1.setName("tag1"); // Set the name of the first tag
		    tags.add(tag1); // Add the first tag to the list 
		    
            Pet.Tag tag2 = new Pet.Tag();
		    
		    tag1.setId(2); 
		    tag1.setName("tag2"); 
		    
		    tags.add(tag2);
		 
		 
		
		petPayload.setId(faker.idNumber().hashCode());
		petPayload.setCategory(category);
		petPayload.setName(faker.name().name());
		petPayload.setPhotoUrls(photoUrls);
		petPayload.setTags(tags);
		petPayload.setStatus("Available");
		
	}
	
	@Test(priority=1)
	public void testPostPet()
	{
	
		Response response = PetEndPoints.createPet(petPayload);
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2)
	public void testGetPet()
	{
		Response response = PetEndPoints.getPet(this.petPayload.getId());
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	@Test(priority=3)
	public void testUpdatePet()
	{
		
		petPayload.setName("Dudu");
		
		Response response = PetEndPoints.updatePet(petPayload);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//Get Updated data
		
        Response response1 = PetEndPoints.getPet(this.petPayload.getId());
        
        response1.then().log().all();
		
		Assert.assertEquals(response1.getStatusCode(), 200);
		
		//System.out.println(response1);
		
	}
	
	@Test(priority = 4)
	public void testDeletePet()
	{
		Response response = PetEndPoints.deletePet(this.petPayload.getId());
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
