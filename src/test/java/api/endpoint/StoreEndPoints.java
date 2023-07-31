package api.endpoint;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import api.payload.Store;
import io.restassured.http.ContentType;

public class StoreEndPoints {
	
	public static Response postOrder(Store payload)
	{
		Response postOrderResponse = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				
				.when()
				.post(Routes.store_post_url);

		return postOrderResponse;
	}
	
	
	
	public static Response getOrder(int orderID)
	{
		Response getOrderResponse = given()
				.pathParam("orderID", orderID)

				.when()
				.get(Routes.store_get_url);

		return getOrderResponse;
	}
	
	
	
	public static Response deleteOrder(int orderID)
	{
		Response deleteOrderResponse = given()
				.pathParam("orderID", orderID)

				.when()
				.get(Routes.store_delete_url);

		return deleteOrderResponse;
	}
	
	
	public static Response getOrderInventory()
	{
		
		Response getOrderResponse = given()
				//.pathParam("orderID", orderID)

				.when()
				.get(Routes.store_get_inventory_url);

		return getOrderResponse;
	}
	

}
