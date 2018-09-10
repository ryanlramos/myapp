package com.example.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@Controller
@SpringBootApplication
public class DemoApplication {

	static final String URL_API_AI = "https://api.dialogflow.com/v1/query?v=20170712&query=what is the update for ticket INC33333&lang=en&sessionId=9a944b5a-4339-114a-d5d7-71c8b7db5d33&timezone=Asia/Manila";

    @RequestMapping("/")
    @ResponseBody
    String home() {

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization","Bearer ba346baabcd44c11a8d9d34ad00998eb");
		//.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

		ResponseEntity<String> response = restTemplate.exchange(URL_API_AI, HttpMethod.POST, entity, String.class);

      return "Hello World!" + response.getBody();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}