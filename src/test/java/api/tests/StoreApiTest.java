package api.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoint.StoreEndPoints;
import api.payload.Store;
import io.restassured.response.Response;

public class StoreApiTest {
	
	Faker faker;
	Store storePayload;
	
	@BeforeClass
	public void setup()
	{
		faker = new Faker();
		storePayload = new Store();
		
		storePayload.setId(faker.idNumber().hashCode());
		storePayload.setPetId(faker.idNumber().hashCode());
		storePayload.setQuantity(5);
		storePayload.setShipDate(faker.date().toString());
		storePayload.setStatus("Placed");
		storePayload.setComplete(true);
	}
	
	@Test
	public void testPostStoreApi()
	{
		Response postStoreResponse = StoreEndPoints.postOrder(storePayload);
		
		Assert.assertEquals(postStoreResponse.getStatusCode(), 200);
	}

	
}
