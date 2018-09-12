package com.example.IntecaTaskApp.client;

import java.net.URI;
import java.sql.Date;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.IntecaTaskApp.entity.Father;

public class RestClientUtil {
	public void getFatherByIdDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/api/father/{id}";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Father> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Father.class,
				1);
		Father father = responseEntity.getBody();
		System.out.println(
				"Id:" + father.getID() + ", PESEL:" + father.getPESEL() + ", First Name:" + father.getFirstName()
						+ ", Second Name:" + father.getSecondName() + ", Birth Day:" + father.getBirthDay());
	}

	public void getAllFathersDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/api/fathers";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Father[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
				Father[].class);
		Father[] fathers = responseEntity.getBody();
		for (Father father : fathers) {
			System.out.println(
					"Id:" + father.getID() + ", PESEL:" + father.getPESEL() + ", First Name:" + father.getFirstName()
							+ ", Second Name:" + father.getSecondName() + ", Birth Day:" + father.getBirthDay());
		}
	}

	@SuppressWarnings("deprecation")
	public void addFatherDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/api/father";
		Father objFather = new Father();
		objFather.setPESEL("88888888888");
		objFather.setFirstName("adminN");
		objFather.setSecondName("adminS");
		objFather.setBirthDay(new Date(2000, 9, 20));
		HttpEntity<Father> requestEntity = new HttpEntity<Father>(objFather, headers);
		URI uri = restTemplate.postForLocation(url, requestEntity);
		System.out.println(uri.getPath());
	}

	public void updateFatherDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/api/father";
		Father objFather = new Father();
		objFather.setFirstName("adminN1");
		objFather.setSecondName("adminS1");
		HttpEntity<Father> requestEntity = new HttpEntity<Father>(objFather, headers);
		restTemplate.put(url, requestEntity);
	}

	public void deleteFatherDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/api/father/{id}";
		HttpEntity<Father> requestEntity = new HttpEntity<Father>(headers);
		restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 1);
	}

	public static void main(String args[]) {
		RestClientUtil util = new RestClientUtil();
		// util.getArticleByIdDemo();
		// util.addArticleDemo();
		// util.updateArticleDemo();
		// util.deleteArticleDemo();
		util.getAllFathersDemo();
	}
}
