package com.pedro.springfun;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BasicInfoService {

  public UserInfo getUserInfo() {
    RestTemplate restTemplate = new RestTemplate();

    URI uri = URI.create("https://api.github.com/user");

    ResponseEntity<UserInfo> result =
        restTemplate.exchange(uri, HttpMethod.GET, new HttpEntity<String>(createHeaders(System.getProperty("githubUser"), System.getProperty("githubToken"))), UserInfo.class);


    return result.getBody();
  }

  HttpHeaders createHeaders(String username, String password){
    return new HttpHeaders() {{
      String auth = username + ":" + password;
      byte[] encodedAuth = Base64.encodeBase64(
          auth.getBytes(StandardCharsets.US_ASCII) );
      String authHeader = "Basic " + new String( encodedAuth );
      set( "Authorization", authHeader );
      setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
      add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
    }};
  }
}
