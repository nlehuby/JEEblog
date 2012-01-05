package edu.ecm.blog.http;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

public class HttpClientTest {
	   @Test
	   public void get() {
		   HttpClient httpclient = new DefaultHttpClient();
		   HttpGet httpget = new HttpGet("http://www.lemonde.fr");
	   }
	}