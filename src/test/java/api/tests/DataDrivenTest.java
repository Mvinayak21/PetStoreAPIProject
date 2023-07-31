package api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoint.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTest {
	
	User userPayload = new User();
	
	@Test(priority = 1,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testPostUsers(String id, String uname, String fname, String lname, String email, String psw,String ph, String status)
	{
		
		userPayload.setId(Integer.parseInt(id));
		userPayload.setUsername(uname);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(email);
		userPayload.setPassword(psw);
		userPayload.setPhone(ph);
		userPayload.setUserStatus(Integer.parseInt(status));
		
		System.out.println(userPayload);
		
		 Response response =  UserEndPoints.createUser(userPayload);
			
			Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
	@Test(priority = 2,dataProvider = "userName",dataProviderClass=DataProviders.class)
	public void testGetUser(String userName)
	{
		System.out.println(userName);
		
        Response response = UserEndPoints.retriewUser(userName);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

	
	//@Test(priority = 2,dataProvider = "userName",dataProviderClass=DataProviders.class)
	public void testDeleteUser(String userName)
	{
		System.out.println(userName);
		
        Response response = UserEndPoints.deleteUser(userName);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}
