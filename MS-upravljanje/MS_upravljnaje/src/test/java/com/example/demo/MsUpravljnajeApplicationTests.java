package com.example.demo;

import java.io.IOException;


import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MsUpravljnajeApplicationTests {

	@Test
	public void testDajSveKosnice() throws ClientProtocolException, IOException
	{
		/*String port = "8083";
		String baseUrl = "http://localhost:" + port + "/DajSveKosnice";

		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(baseUrl);
	 
		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.addTextBody("username", "asd");
		builder.addTextBody("password", "asd");
	 
		HttpEntity multipart = builder.build();
    	httpPost.setEntity(multipart);
 
		CloseableHttpResponse response = client.execute(httpPost);
		Assert.assertEquals(200, response.getStatusLine().getStatusCode());
		client.close();
	}

	@Test
	public void testPoruka() throws ClientProtocolException, IOException {
		String port = "8083";
		String baseUrl = "http://localhost:" + port + "/poruka";
		
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(baseUrl);

		MultipartEntityBuilder builder = MultipartEntityBuilder.create();
		builder.addTextBody("message", "Neka poruka");

		HttpEntity multipart = builder.build();
		httpPost.setEntity(multipart);
		
		CloseableHttpResponse response = client.execute(httpPost);
		Assert.assertEquals(200, response.getStatusLine().getStatusCode());
		client.close();*/
	}

}
