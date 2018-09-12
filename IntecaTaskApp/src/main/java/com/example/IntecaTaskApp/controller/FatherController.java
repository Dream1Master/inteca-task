package com.example.IntecaTaskApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.IntecaTaskApp.entity.Child;
import com.example.IntecaTaskApp.entity.Father;
import com.example.IntecaTaskApp.service.IChildService;
import com.example.IntecaTaskApp.service.IFatherService;

@Controller
@RequestMapping("api")
public class FatherController {

	@Autowired
	private IFatherService fatherService;

	@GetMapping("father/{id}")
	public ResponseEntity<Father> getFatherById(@PathVariable("id") Integer id) {
		Father father = fatherService.getFatherById(id);
		return new ResponseEntity<Father>(father, HttpStatus.OK);
	}

	@GetMapping("fathers")
	public ResponseEntity<List<Father>> getAllFathers() {
		List<Father> list = fatherService.getAllFathers();
		return new ResponseEntity<List<Father>>(list, HttpStatus.OK);
	}
	
	@GetMapping("childs/{familyId}")
	public ResponseEntity<List<Child>> getChilds(@PathVariable("familyId") Integer familyId) {
		List<Child> list = fatherService.getChilds(familyId);
		return new ResponseEntity<List<Child>>(list, HttpStatus.OK);
	}

	@PostMapping("father")
	public ResponseEntity<Void> addFather(@RequestBody Father father, UriComponentsBuilder builder) {
		System.out.println(
				"Id:" + father.getID() + ", PESEL:" + father.getPESEL() + ", First Name:" + father.getFirstName()
						+ ", Second Name:" + father.getSecondName() + ", Birth Day:" + father.getBirthDay());
		boolean flag = fatherService.addFather(father);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("api/father/{id}").buildAndExpand(father.getID()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@PutMapping("father")
	public ResponseEntity<Father> updateFather(@RequestBody Father father) {
		fatherService.updateFather(father);
		return new ResponseEntity<Father>(father, HttpStatus.OK);
	}

	@DeleteMapping("father/{id}")
	public ResponseEntity<Void> deleteFather(@PathVariable("id") Integer id) {
		fatherService.deleteFather(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
