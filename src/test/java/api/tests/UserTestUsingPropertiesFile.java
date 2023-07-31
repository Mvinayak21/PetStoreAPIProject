package api.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoint.UserEndPointsUsingPrpoertyFile;
import api.payload.User;
import io.restassured.response.Response;

public class UserTestUsingPropertiesFile {
	
	Faker faker;
	User userPayload;
	
	public Logger logger;
	
	@BeforeClass
	public void setupData()
	{
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		userPayload.setUserStatus(0);
		
		//System.out.println(userPayload);
		
		logger = LogManager.getLogger(this.getClass());
	}
	
	
	
	@Test(priority = 1)
	public void testPostUser()
	{
		logger.info("******* Creating User  ***********");
		
		Response response =  UserEndPointsUsingPrpoertyFile.createUser(userPayload);
		
		response.then().log().all();
		
		
		Assert.assertEquals(response.getStatusCode(), 200);
		//Assert.assertEquals(response.header("Content-Type"), "application/xml; charset=utf-8");
		
		logger.info("**************  User Created  *************");
		
		
	}
	
	
	@Test(priority = 2)
	public void testGetUser()
	{
		logger.info("**************  Reading User  *************");
		
		Response response = UserEndPointsUsingPrpoertyFile.retriewUser(this.userPayload.getUsername());
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("**************  User Read  *************");
		
	}
	
	@Test(priority = 3)
	public void testUpdateUser() 
	{
		
		//update the data
		
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		logger.info("**************  Updating User  *************");
		
		Response response = UserEndPointsUsingPrpoertyFile.updateUser(this.userPayload.getUsername(), userPayload);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("**************  User Updated  *************");
		
		//After update  checking the response
		
		logger.info("**************  Reading Update USer  *************");
		
       Response AfterUpdateresponse = UserEndPointsUsingPrpoertyFile.retriewUser(this.userPayload.getUsername());
		
       //.AfterUpdateresponse.then().log().all();
		
		Assert.assertEquals(AfterUpdateresponse.getStatusCode(), 200);
		
		logger.info("**************  Updated User Read  *************");
		
	}
	
	
	@Test(priority = 4)
	public void testDeleteUser()
	{
		logger.info("**************  Deleting User  *************");
		
        Response response = UserEndPointsUsingPrpoertyFile.deleteUser(userPayload.getUsername());
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("**************  User Deleted  *************");
		
	}
	
	


}
