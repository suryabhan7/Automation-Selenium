package api;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Test
public class Client {
    String pathUrl ="https://gorest.co.in/public/v1/users";

	
	@Test
	public void getMethod() throws  IOException, JSONException{
        
		         
		OkHttpClient httpClient= new OkHttpClient().newBuilder()
				  .build();	
		
		Request request = new Request.Builder()
				  .url(pathUrl)
				  .method("GET", null)
				  .addHeader("Content-Type", "application/json")
				  .build();
		Response response = httpClient.newCall(request).execute();
		int code = response.code();
	
		String responseBody = response.body().string();
		System.out.println("Response code is" + responseBody);
	
		
		Assert.assertEquals(200, code);
		
		
		 
	}
	
	@Test
	public void postMethod() throws  IOException, JSONException {
		
		
		 OkHttpClient httpClient= new OkHttpClient().newBuilder()
				  .build();
		
		 MediaType mediaType = MediaType.parse("text/plain");
		 
		 
		 JSONObject json=new JSONObject();
    	 json.put("id","101");
		 
    	 json.put("user_id",201);
		 json.put("title","neova");
		 json.put("body","active");
		 RequestBody body = RequestBody.create(json.toString(), mediaType);
		 Request request = new Request.Builder()
		   .url("https://gorest.co.in/public/v1/users")
		   .method("POST", body)
		   .build();
		 Response response = httpClient.newCall(request).execute();
		 int code = response.code();

		 System.out.println("Response code is" + code);
		
			
		 Assert.assertEquals(401, code);
			
	}
	
	
	@Test
	public void patchMethod() throws  IOException, JSONException {
		
		OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				MediaType mediaType = MediaType.parse("text/plain");
				 
				 JSONObject json=new JSONObject();
		    	 json.put("id","101");
				 
		    	 json.put("user_id",201);
				 json.put("title","neova");
				 json.put("body","active");
				 RequestBody body = RequestBody.create(json.toString(), mediaType);
				Request request = new Request.Builder()
				  .url("https://gorest.co.in/public/v1/users")
				  .method("PATCH", body)
				  .build();
				Response response = client.newCall(request).execute();
				 int code = response.code();

				 System.out.println("Response code is" + code);
				
					
				 Assert.assertEquals(200, code);
		
	}
	
	@Test
	public void deleteMethod() throws IOException ,JSONException {
		
		         OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
			   	MediaType mediaType = MediaType.parse("text/plain");
				RequestBody body = RequestBody.create(mediaType, "");
				Request request = new Request.Builder()
				  .url("https://gorest.co.in/public/v1/users/26")
				  .method("DELETE", body)
				  .addHeader("Authorization", "Bearer 3a319edad5387927771c3119e0d2960640c96800b2850deaf1e2b3faef1e34fb")
				  .build();
				Response response = client.newCall(request).execute();
				 int code = response.code();

				 System.out.println("Response code is" + code);
				
					
				 Assert.assertEquals(204, code);
	}

}