package api.endpoint;

/*  POST : https://petstore.swagger.io/v2/user
	GET  : https://petstore.swagger.io/v2/user/{{firstname}}
	PUT  : https://petstore.swagger.io/v2/user/{{firstname}}
	DELETE : https://petstore.swagger.io/v2/user/{{firstname}}*/

public class Routes {
	
	
	public static String base_url="https://petstore.swagger.io/v2";
	
	
	//User Module
	
	public static String post_url = base_url+"/user";
	public static String get_url= base_url+"/user/{username}";
	public static String put_url= base_url+"/user/{username}";
	public static String delete_url= base_url+"/user/{username}";
	
	
	//Pet Module
	
	public static String pet_post_url = base_url+"/pet";
	public static String pet_put_url = base_url+"/pet";
	public static String pet_get_url_ById = base_url+"/pet/{id}";
	public static String pet_delete_url_ById = base_url+"/pet/{id}";
	
	
	//Store Module
	
	public static String store_post_url = base_url+"/store/order";
	public static String store_get_url = base_url+"/store/order/{orderId}";
	public static String store_delete_url = base_url+"/store/order/{orderId}";
	public static String store_get_inventory_url = base_url+"/store/inventory";
	
	

}
