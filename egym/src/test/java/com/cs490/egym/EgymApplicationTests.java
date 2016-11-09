package com.cs490.egym;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.HashMap;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestClientException;

import com.cs490.egym.beans.security.JwtAuthenticationRequest;
import com.cs490.egym.beans.security.JwtUser;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.DEFINED_PORT)
public class EgymApplicationTests {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void userSecurityTest() {
		//Send username & password (u: user, p: password)
		@SuppressWarnings("unchecked")
		HashMap<String, String> response = this.restTemplate.postForObject("/auth", new JwtAuthenticationRequest("user","password"), HashMap.class);
		Assert.assertThat("Response token is null", response.get("token"), CoreMatchers.is(CoreMatchers.notNullValue()));
		//Make request to /user
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", response.get("token"));
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		HttpEntity<HttpHeaders> entity = new HttpEntity<HttpHeaders>(headers);
		ResponseEntity<JwtUser> user;
		try {
			user = this.restTemplate.exchange(new URI("http://localhost:8080/user"), HttpMethod.GET, entity, JwtUser.class);
			JwtUser userResponse = user.getBody();
			Assert.assertThat("Response is not authenticated", userResponse.getUsername(), CoreMatchers.containsString("user"));
		} catch (RestClientException | URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
