package rohini.com.test.service;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import rohini.com.service.Base;

public class WebServiceTest extends Base {

	@Test
	public void getMethodWebService() throws Exception {

		// Get the URL String url
		String url = "http://services.groupkt.com/state/get/IND/UP";
		
		// Create CLIENT using HttpClient 
		HttpClient client = HttpClientBuilder.create().build();
		
		// Create REQUEST for GET method
		HttpGet request = new HttpGet(url);
		
		// Get the RESPONSE back from server after sending the request
		HttpResponse response = client.execute(request);
		
		System.out.println("Hello"); 
		
		// Validation 
			// 1.	Status Code
		 	System.out.println(response.getStatusLine().getStatusCode()); //
		 	
		 	// 2.	Status Message
		 	System.out.println(response.getStatusLine().getReasonPhrase()); //
		 	
		 	// 3.	Complete Message 
		 	// 4.	Tags, Tags Repetitions, 
		 	// 5.	Data
		
		/* If the SERVICE produces the json data, then only we can consume the service in json format.		
		   Get the data in JSON format, we can use the Gson parser, OR toString() for HttpEntity response.
		*/
		
		// Get data in JSON, using GSON 
		/*Gson gson = new Gson(); 
		String jsonformat = gson.toJson(readingContentOfThePage(response)); 		
		System.out.println(jsonformat);*/
		
		// Get data in JSON, using HttpEntity
		HttpEntity entity = response.getEntity();
		String content = EntityUtils.toString(entity);
		System.out.println(content);

	}
}
